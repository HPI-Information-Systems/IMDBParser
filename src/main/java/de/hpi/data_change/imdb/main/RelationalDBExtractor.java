package de.hpi.data_change.imdb.main;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.data.EntityCollection;
import de.hpi.data_change.data.Pair;
import de.hpi.data_change.data.Property;
import de.hpi.data_change.imdb.data.Plot;
import de.hpi.data_change.imdb.data.videos.Movie;
import de.hpi.data_change.imdb.database.PostgresInteractor;
import de.hpi.data_change.imdb.parsing.actors.ActorsFileParser;
import de.hpi.data_change.imdb.parsing.composers.ComposersFileParser;
import de.hpi.data_change.imdb.parsing.countries.CountriesFileParser;
import de.hpi.data_change.imdb.parsing.directors.DirectorsFileParser;
import de.hpi.data_change.imdb.parsing.editors.EditorsFileParser;
import de.hpi.data_change.imdb.parsing.genres.GenresFileParser;
import de.hpi.data_change.imdb.parsing.locations.LocationsFileParser;
import de.hpi.data_change.imdb.parsing.movies.MovieFileParser;
import de.hpi.data_change.imdb.parsing.plot.PlotFileParser;
import de.hpi.data_change.imdb.parsing.ratings.RatingsFileParser;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

/***
 * Class to extract data and save it to a local postgresql database. This only extracts the current state!
 * Was only used to extract an interesting database for students to work on.
 */
public class RelationalDBExtractor {

    private static Set<String> allExistingMovies;

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        String dataDir = args[0];
        String dburl = args[1];
        String dbuser = args[2];
        String dbpw = args[3];
        File moviesFile = new File(dataDir + "movies.list");
        MovieFileParser moviesParser = new MovieFileParser();
        moviesParser.parseText(moviesFile);
        allExistingMovies = moviesParser.getVideos().map(  v -> v.toEntity().getName()).collect(Collectors.toSet());
        Set<String> existingKeys = moviesParser.getVideos()
                .filter( v -> v instanceof Movie)
                .map(m -> m.toEntity())
                .filter(e -> isInteger(e.getValue("date")))
                .map(e -> e.getName()).collect(Collectors.toSet());
        //new
        PostgresInteractor interactor = new PostgresInteractor(dburl,dbuser,dbpw);
        addActors(dataDir,existingKeys,interactor);
        addActresses(dataDir,existingKeys, interactor);
        addDirectors(dataDir,existingKeys,interactor);
        addEditors(dataDir,existingKeys,interactor);
        addCountries(dataDir,existingKeys,interactor);
        addComposers(dataDir,existingKeys,interactor);
        addRatings(dataDir,existingKeys,interactor);
        addPlots(dataDir,existingKeys,interactor);
    }

    private static void addPlots(String dataDir, Set<String> existingKeys, PostgresInteractor interactor) throws IOException, SQLException {
        PlotFileParser parser = new PlotFileParser();
        File src = new File(dataDir + "plot.list");
        parser.parseText(src);
        EntityCollection.checkDublicates(parser.getEntities().collect(Collectors.toList()));
        interactor.insertPlots(parser.getPlots().stream().filter( e -> existingKeys.contains(e.getTitle())).collect(Collectors.toList()));

    }

    private static void addRatings(String dataDir, Set<String> existingKeys, PostgresInteractor interactor) throws IOException, SQLException {
        RatingsFileParser parser = new RatingsFileParser();
        File src = new File(dataDir + "ratings.list");
        parser.parseText(src);
        interactor.insertRatings(parser.getRatings().stream().filter( e -> existingKeys.contains(e.getTitle())).collect(Collectors.toList()));
    }

    private static void addLocations(String dataDir) throws IOException {
        LocationsFileParser parser = new LocationsFileParser();
        File src = new File(dataDir + "locations.list");
        parser.parseText(src);
        Map<String, List<Property>> res = parser.getLocations().stream().filter(d -> d.getRawProperties().size()!=0).flatMap(d -> d.getRawProperties().stream())
                .collect(Collectors.groupingBy(p -> p.getName()));
    }

    private static void addGenres(String dataDir) throws IOException {
        GenresFileParser parser = new GenresFileParser();
        File src = new File(dataDir + "genres.list");
        parser.parseText(src);
        Map<String, List<Property>> res = parser.getGenres().stream().filter(d -> d.getRawProperties().size()!=0).flatMap(d -> d.getRawProperties().stream())
                .collect(Collectors.groupingBy(p -> p.getName()));
    }

    private static void addComposers(String dataDir, Set<String> existingKeys, PostgresInteractor interactor) throws IOException {
        ComposersFileParser parser = new ComposersFileParser();
        File src = new File(dataDir + "composers.list");
        parser.parseText(src);
        Map<String, List<Property>> res = parser.getComposers().stream().filter(d -> d.getRawProperties().size()!=0).flatMap(d -> d.getRawProperties().stream())
            .collect(Collectors.groupingBy(p -> p.getName()));
    }

    private static void addCountries(String dataDir, Set<String> existingKeys, PostgresInteractor interactor) throws IOException, SQLException {
        CountriesFileParser parser = new CountriesFileParser();
        File src = new File(dataDir + "countries.list");
        parser.parseText(src);
        interactor.insertCountries(parser.getCountries().stream().filter( e -> existingKeys.contains(e.getTitle())).collect(Collectors.toList()));
//
    }

    private static void addEditors(String dataDir, Set<String> existingKeys, PostgresInteractor interactor) throws IOException, SQLException {
        EditorsFileParser parser = new EditorsFileParser();
        File src = new File(dataDir + "editors.list");
        parser.parseText(src);
        interactor.insertEditors(parser.getEditors().stream().filter( e -> existingKeys.contains(e.getTitle())).collect(Collectors.toList()));
    }

    private static void addDirectors(String dataDir, Set<String> existingKeys, PostgresInteractor interactor) throws IOException, SQLException {
        DirectorsFileParser parser = new DirectorsFileParser();
        File src = new File(dataDir + "directors.list");
        parser.parseText(src);
        interactor.insertDirectors(parser.getDirectors().stream().filter( d -> existingKeys.contains(d.getTitle())).collect(Collectors.toList()));
    }

    private static void addActors(String dataDir, Set<String> existingKeys, PostgresInteractor interactor) throws IOException, SQLException {
        ActorsFileParser parser = new ActorsFileParser();
        File src = new File(dataDir + "actors.list");
        parser.parseText(src);
        List<List<String>> actors = parser.getActors().stream().filter(e -> existingKeys.contains(e.getTitle())).map(e -> toList(e.toEntity())).collect(Collectors.toList());
        interactor.insertActors(actors);
    }

    private static void addActresses(String dataDir, Set<String> existingKeys, PostgresInteractor interactor) throws IOException, SQLException {
        ActorsFileParser parser = new ActorsFileParser();
        File src = new File(dataDir + "actresses.list");
        parser.parseText(src);
        List<List<String>> actresses = parser.getActors().stream().filter(e -> existingKeys.contains(e.getTitle())).map(e -> toList(e.toEntity())).collect(Collectors.toList());
        interactor.insertActresses(actresses);
    }

    private static List<String> toList(Entity e) {
        List<String> stuff = new ArrayList<>();
        stuff.add(e.getValue("name"));
        stuff.add(e.getValue("title"));
        stuff.add(e.containsPropertyName("role")? e.getValue("role") : null);
        stuff.add(e.containsPropertyName("as")? e.getValue("as") : null);
        stuff.add(e.containsPropertyName("positionInCredits")? e.getValue("positionInCredits") : null);
        return stuff;
    }

    private static boolean isInteger(String year) {
        if(year == null || year.length() == 0){
            return false;
        }
        for (int i=0; i < year.length(); i++) {
            char c = year.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
