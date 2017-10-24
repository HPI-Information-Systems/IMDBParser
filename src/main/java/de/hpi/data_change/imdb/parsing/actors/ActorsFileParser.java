package de.hpi.data_change.imdb.parsing.actors;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.data.Pair;
import de.hpi.data_change.data.Property;
import de.hpi.data_change.imdb.data.Actor;
import de.hpi.data_change.imdb.data.Director;
import de.hpi.data_change.imdb.parsing.IMDBFileParser;
import de.hpi.data_change.imdb.parsing.InfoExtractor;
import de.hpi.data_change.imdb.parsing.TitleEndRecognizer;
import org.apache.logging.log4j.core.util.Assert;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;
import java.util.zip.GZIPInputStream;

public class ActorsFileParser implements IMDBFileParser {

    private static final String ENDSIGNAL = "-----------------------------------------------------------------------------";
    private STATE state = STATE.LookingForStart;

    private static final String START_SIGNAL = "----\t\t\t------";
    private BufferedReader br;
    private String curActor;
    private ArrayList<Actor> actors = new ArrayList<>();

    @Override
    public void parseGZ(File source) throws IOException {
        GZIPInputStream is = new GZIPInputStream(new FileInputStream(source));
        parseFile(is);
    }

    @Override
    public void parseText(File source) throws IOException {
        FileInputStream is = new FileInputStream(source);
        parseFile(is);
    }

    private void parseFile(InputStream is) throws IOException {
        br = new BufferedReader(new InputStreamReader(is));
        String line = br.readLine();
        int linCount = 1;
        while(line != null && state!= STATE.FINSIHED) {
            if (linCount % 1000000 == 0) {
                System.out.println("Processed " + linCount + " lines");
            }
            switch (state) {
                case LookingForStart:
                    processLookingForStart(line);
                    break;
                case LOOK_FOR_ACTOR:
                    processLookForActor(line);
                    break;
                case lookingForMovies:
                    processLookForMovie(line);
                    break;
                case FINSIHED:
                    break;
                default:
                    assert false;
            }
            line = br.readLine();
            linCount++;
        }
        br.close();
    }

    private void processLookForMovie(String line) {
        if(!line.contains("\t")){
            assert line.equals("");
            state = STATE.LOOK_FOR_ACTOR;
        } else{
            int parsingStart = line.lastIndexOf("\t")+1;
            String rest = line.substring(parsingStart);
            addMovieInfo(rest);
        }
    }

    private void addMovieInfo(String rest) {
        Pair<String,String> splitted = TitleEndRecognizer.splitAfterTitle(rest);
        String title = splitted.getFirst();
        String additionalInfo = splitted.getSecond();
        actors.add(new Actor(curActor,title,additionalInfo));
    }

    private void processLookForActor(String line) {
        assert(!line.startsWith("\t"));
        if(line.equals(ENDSIGNAL)){
            state = STATE.FINSIHED;
            return;
        }
        String[] tokens = line.split("\\\t+");
        curActor = tokens[0];
        String firstMovie = tokens[1];
        addMovieInfo(firstMovie);
        state = STATE.lookingForMovies;
    }

    private void processLookingForStart(String line) {
        if(line.equals(START_SIGNAL)){
            state = STATE.LOOK_FOR_ACTOR;
        }
    }

    @Override
    public Stream<Entity> getEntities() {
        return actors.stream().map( actor -> actor.toEntity());
    }

    public List<Actor> getActors(){return actors;}
}
