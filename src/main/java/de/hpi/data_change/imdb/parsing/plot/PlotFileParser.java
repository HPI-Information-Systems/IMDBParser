package de.hpi.data_change.imdb.parsing.plot;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.imdb.data.Plot;
import de.hpi.data_change.imdb.parsing.IMDBFileParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.zip.GZIPInputStream;

public class PlotFileParser implements IMDBFileParser {

    private static final String plotStartLine = "-------------------------------------------------------------------------------";
    private STATE state = STATE.LOOKING_FOR_START;

    private static final String START_SIGNAL = "===================";
    private BufferedReader br;
    private String curTitle;
    private ArrayList<Plot> plots = new ArrayList<>();
    private List<String> curPlotLines = new ArrayList<>();
    private String curAuthor;

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

        while (!line.equals(START_SIGNAL)) {
            line = br.readLine();
        }
        assert (br.readLine().equals(plotStartLine));
        int numTitlesProcessed = 0;
        boolean done = false;
        while (!done) {
            //parse movie title:
            readTitle();
            line = br.readLine();
            if(numTitlesProcessed % 10000 == 0){
                System.out.println("processed " + numTitlesProcessed + " titles");
            }
            while (true) {
                if (line.startsWith("PL: ")) {
                    curPlotLines.add(line.substring(4));
                    line = br.readLine();
                } else {
                    assert line.equals("");
                    //will there be an author?
                    line = br.readLine();
                    if (line.startsWith("BY: ")) {
                        //process author
                        String author = line.substring(4);
                        //process current:
                        plots.add(new Plot(curTitle, getCurrentDescription(), author));
                        curPlotLines.clear();
                        //look for next action
                        line = br.readLine();
                        assert line.equals("");
                        line = br.readLine();
                        if(line == null){
                            done = true;
                            break;
                        }
                        if (line.equals(plotStartLine)) {
                            break;
                        } else {
                            assert line.startsWith("PL: ");
                            continue;
                        }
                    } else {
                        plots.add(new Plot(curTitle, getCurrentDescription()));
                        curPlotLines.clear();
                        if (line.equals(plotStartLine)) {
                            break;
                        } else {
                            //not yet done with this descriptions for this movie
                            assert line.startsWith("PL: ");
                            continue;
                        }
                    }
                }

            }
            numTitlesProcessed++;
        }
        br.close();
    }

    private String readTitle() throws IOException {
        String curLine = br.readLine();
        assert (curLine.startsWith("MV: "));
        curTitle = curLine.substring(4);
        curLine = br.readLine();
        assert curLine.equals("");
        return curLine;
    }

    private void processLookingForTitle(String line) {
        assert(line.startsWith("MV: "));
        curTitle = line.substring(4);
        state = STATE.PARSE_BEGIN_PLOTDESCR;
    }

    private void processLookingForAuthor(String line) throws IOException {
        if(line.equals(plotStartLine)) {
            processPlotStartLine(line);
        } else{
            assert(line.startsWith("BY: "));
            curAuthor = line.substring(4);
            String nextLine = br.readLine();
            assert(nextLine.equals(""));
            state = STATE.EXPECT_PLOT_START_LINE_OR_PLOT;
        }
    }

    private void processPlotStartLine(String line) {
        if(!line.equals(plotStartLine)){
            System.out.println("ok");
        }
        assert(line.equals(plotStartLine));
        saveCurrentAndReset();
        state = STATE.PARSE_TITLE;
    }

    private void saveCurrentAndReset() {
        if(!curPlotLines.isEmpty()){
            String description = ";";
            if(curAuthor !=null) {
                plots.add(new Plot(curTitle, description, curAuthor));
            } else {
                plots.add(new Plot(curTitle,description));
            }
        }
        curPlotLines.clear();
        curAuthor = null;
    }

    private void processPlotDescription(String line) {
        if(line.equals("")){
            state = STATE.LOOK_FOR_AUTHOR_OR_PLOTBEGIN;
        } else{
            assert line.startsWith("PL: ");
            String curPlotLine = line.substring(4);
            curPlotLines.add(curPlotLine);
        }
    }

    private void processLookingForStart(String line) {
        if(line.equals(START_SIGNAL)){
            state = STATE.EXPECT_PLOT_START_LINE;
        }
    }

    @Override
    public Stream<Entity> getEntities() {
        return plots.stream().map( plot -> plot.toEntity());
    }

    public ArrayList<Plot> getPlots() {
        return plots;
    }

    private String getCurrentDescription() {
        return curPlotLines.stream().reduce( (l1,l2) -> l1 + " " + l2).get();
    }
}
