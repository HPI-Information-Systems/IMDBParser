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

public class RelationalDBExtractor {

    private static Set<String> allExistingMovies;

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        File moviesFile = new File("/home/leon/Documents/researchProjects/imdb/database/movies.list");
        MovieFileParser moviesParser = new MovieFileParser();
        moviesParser.parseText(moviesFile);
        allExistingMovies = moviesParser.getVideos().map(  v -> v.toEntity().getName()).collect(Collectors.toSet());
        Set<String> existingKeys = moviesParser.getVideos()
                .filter( v -> v instanceof Movie)
                .map(m -> m.toEntity())
                .filter(e -> isInteger(e.getValue("date")))
                .map(e -> e.getName()).collect(Collectors.toSet());
        //new
        PostgresInteractor interactor = new PostgresInteractor();
        //addActors(existingKeys,interactor);
        //addActresses(existingKeys, interactor);
        //addDirectors(existingKeys,interactor);
        //addEditors(existingKeys,interactor);
        //addCountries(existingKeys,interactor);
        //addComposers(existingKeys,interactor);
        //addGenres();
        //addLocations();
        //addRatings(existingKeys,interactor);
        addPlots(existingKeys,interactor);
    }

    private static void addPlots(Set<String> existingKeys, PostgresInteractor interactor) throws IOException, SQLException {
        PlotFileParser parser = new PlotFileParser();
        File src = new File("/home/leon/Documents/researchProjects/imdb/database/plot.list");
        FileInspector inspector = new FileInspector(src);
        int LineCount = 1;
//        while(true){
//            if(LineCount >= 761828) {
//                inspector.printDetailedLine();
//            } else{
//                inspector.nextLine();
//            }
//            LineCount++;
//        }
        parser.parseText(src);
        EntityCollection.checkDublicates(parser.getEntities().collect(Collectors.toList()));
        System.out.println("plots incorrectly referencing: " +parser.getPlots().stream().filter( e -> !allExistingMovies.contains(e.getTitle())).count());
        interactor.insertPlots(parser.getPlots().stream().filter( e -> existingKeys.contains(e.getTitle())).collect(Collectors.toList()));

    }

    private static void addRatings(Set<String> existingKeys, PostgresInteractor interactor) throws IOException, SQLException {
        RatingsFileParser parser = new RatingsFileParser();
        File src = new File("/home/leon/Documents/researchProjects/imdb/database/ratings.list");
        parser.parseText(src);
        interactor.insertRatings(parser.getRatings().stream().filter( e -> existingKeys.contains(e.getTitle())).collect(Collectors.toList()));

        //EntityCollection.checkDublicates(parser.getEntities().collect(Collectors.toList()));
        //System.out.println("countries incorrectly referencing: " +parser.getRatings().stream().filter( e -> !allExistingMovies.contains(e.getTitle())).count());
//        Map<String, List<Property>> res = parser.getRatings().stream().filter(d -> d.getRawProperties().size()!=0).flatMap(d -> d.getRawProperties().stream())
//                .collect(Collectors.groupingBy(p -> p.getName()));
//        printInfo(res, parser.getEntities().collect(Collectors.toList()));
    }

    private static void addLocations() throws IOException {
        LocationsFileParser parser = new LocationsFileParser();
        File src = new File("/home/leon/Documents/researchProjects/imdb/database/locations.list");
        parser.parseText(src);
        //EntityCollection.checkDublicates(parser.getEntities().collect(Collectors.toList()));
        Map<String, List<Property>> res = parser.getLocations().stream().filter(d -> d.getRawProperties().size()!=0).flatMap(d -> d.getRawProperties().stream())
                .collect(Collectors.groupingBy(p -> p.getName()));
        printInfo(res, parser.getEntities().collect(Collectors.toList()));
    }

    private static void addGenres() throws IOException {
        GenresFileParser parser = new GenresFileParser();
        File src = new File("/home/leon/Documents/researchProjects/imdb/database/genres.list");
        parser.parseText(src);
        EntityCollection.checkDublicates(parser.getEntities().collect(Collectors.toList()));
        Map<String, List<Property>> res = parser.getGenres().stream().filter(d -> d.getRawProperties().size()!=0).flatMap(d -> d.getRawProperties().stream())
                .collect(Collectors.groupingBy(p -> p.getName()));
        printInfo(res, parser.getEntities().collect(Collectors.toList()));
    }

    private static void addComposers(Set<String> existingKeys, PostgresInteractor interactor) throws IOException {
        ComposersFileParser parser = new ComposersFileParser();
        File src = new File("/home/leon/Documents/researchProjects/imdb/database/composers.list");
        parser.parseText(src);
        EntityCollection.checkDublicates(parser.getEntities().collect(Collectors.toList()));
        Map<String, List<Property>> res = parser.getComposers().stream().filter(d -> d.getRawProperties().size()!=0).flatMap(d -> d.getRawProperties().stream())
            .collect(Collectors.groupingBy(p -> p.getName()));
        printInfo(res, parser.getEntities().collect(Collectors.toList()));

    }

    private static void addCountries(Set<String> existingKeys, PostgresInteractor interactor) throws IOException, SQLException {
        CountriesFileParser parser = new CountriesFileParser();
        File src = new File("/home/leon/Documents/researchProjects/imdb/database/countries.list");
        parser.parseText(src);
        EntityCollection.checkDublicates(parser.getEntities().collect(Collectors.toList()));
        System.out.println("maxLengthDirector" + parser.getCountries().stream().mapToInt(e -> e.getName().length()).max());

        System.out.println("countries incorrectly referencing: " +parser.getCountries().stream().filter( e -> !allExistingMovies.contains(e.getTitle())).count());

        interactor.insertCountries(parser.getCountries().stream().filter( e -> existingKeys.contains(e.getTitle())).collect(Collectors.toList()));
//
    }

    private static void addEditors(Set<String> existingKeys, PostgresInteractor interactor) throws IOException, SQLException {
        EditorsFileParser parser = new EditorsFileParser();
        //File src = new File("C:\\Users\\Leon.Bornemann\\Documents\\Database Changes\\Data\\IMDB\\Database\\actresses.list\\actresses.list");
        File src = new File("/home/leon/Documents/researchProjects/imdb/database/editors.list");
        //printstuff1(src);
        //printStuff2(src);
        parser.parseText(src);
        //EntityCollection.checkDublicates(parser.getEntities().collect(Collectors.toList()));
        interactor.insertEditors(parser.getEditors().stream().filter( e -> existingKeys.contains(e.getTitle())).collect(Collectors.toList()));
//        System.out.println(parser.getEditors().size());
//
//        System.out.println("movie not present in movies: " + parser.getEditors().stream().filter( d -> !allExistingMovies.contains(d.getTitle())).count());
//        Map<String, List<Property>> res = parser.getEditors().stream().filter(d -> d.getRawProperties().size()!=0).flatMap(d -> d.getRawProperties().stream())
//                .collect(Collectors.groupingBy(p -> p.getName()));
//        printInfo(res);
//
//
//
//
//
//        System.out.println("total" + parser.getEntities().count());
//        System.out.println("maxLengthDirector" + parser.getEntities().mapToInt(e -> e.getName().length()).max());
//        //System.out.println("squareBracket_1" + parser.getEntities().filter(e-> e.containsPropertyName("squareBracket_1")).mapToInt(e -> e.getValue("squareBracket_1").length()).max());
//        //System.out.println("roundBracket_1" + parser.getEntities().filter(e-> e.containsPropertyName("roundBracket_1")).mapToInt(e -> e.getValue("roundBracket_1").length()).max());
//
//        System.out.println("withAtLeastOneAttribute:" + parser.getEntities().filter( e -> e.getProperties().size()>2).count());

    }

    private static void addDirectors(Set<String> existingKeys, PostgresInteractor interactor) throws IOException, SQLException {
        DirectorsFileParser parser = new DirectorsFileParser();
        //File src = new File("C:\\Users\\Leon.Bornemann\\Documents\\Database Changes\\Data\\IMDB\\Database\\actresses.list\\actresses.list");
        File src = new File("/home/leon/Documents/researchProjects/imdb/database/directors.list");
        //printstuff1(src);
        //printStuff2(src);
        parser.parseText(src);
        //EntityCollection.checkDublicates(parser.getEntities().collect(Collectors.toList()));
        interactor.insertDirectors(parser.getDirectors().stream().filter( d -> existingKeys.contains(d.getTitle())).collect(Collectors.toList()));
        //System.out.println(parser.getDirectors().size());
        //List<Director> asd = parser.getDirectors().stream().filter(d -> existingKeys.contains(d.getTitle())).collect(Collectors.toList());
        //System.out.println("movie not present in movies: " + parser.getDirectors().stream().filter( d -> !existingKeys.contains(d.getMovieTitle())).count());
        //Map<String, List<Property>> res = parser.getDirectors().stream().filter(e -> existingKeys.contains(e.getTitle())).filter(d -> d.getRawProperties().size()!=0).flatMap(d -> d.getRawProperties().stream())
        //        .collect(Collectors.groupingBy(p -> p.getName()));
        //printInfo(res);
    }

    private static void printInfo(Map<String, List<Property>> res, List<Entity> entities) {
        System.out.println("countries incorrectly referencing: " +entities.stream().filter( e -> !allExistingMovies.contains(e.getValue("title"))).count());
        System.out.println("Raw Properties By Property Name");
        res.entrySet().stream().map( e -> buildUniqueVals(e)).forEach(
                v -> printV(v)
        );
        System.out.println("===================================================");
        System.out.println("Raw properties with values");
        for (String key : res.keySet()) {
            System.out.println("processing " + key);
            List<Property> props = res.get(key);
            props.stream().map(e -> e.getValue()).map(s -> s.split("\\s")[0]).collect(Collectors.groupingBy(s -> s)).entrySet().stream().map(e -> new Pair<>(e.getKey(),e.getValue().size()))
                    .sorted( (p2,p1) -> p1.getSecond().compareTo(p2.getSecond())).limit(100).forEachOrdered(p -> System.out.println(p));
        }

        System.out.println("Value-Properties:");
        res.values().stream().flatMap( p -> p.stream()).map(p -> p.getValue()).filter(s -> s.contains(" ")).collect(Collectors.groupingBy(s -> s)).entrySet().stream().map(e -> new Pair<>(e.getKey(),e.getValue().size()))
                .sorted( (p2,p1) -> p1.getSecond().compareTo(p2.getSecond())).limit(100).forEachOrdered(p -> System.out.println("\t" + p));

        System.out.println("Boolean properties:");
        res.values().stream().flatMap( p -> p.stream()).map(p -> p.getValue()).filter(s -> !s.contains(" ")).collect(Collectors.groupingBy(s -> s)).entrySet().stream().map(e -> new Pair<>(e.getKey(),e.getValue().size()))
                .sorted( (p2,p1) -> p1.getSecond().compareTo(p2.getSecond())).limit(100).forEachOrdered(p -> System.out.println("\t" + p));

    }

    private static void addActors(Set<String> existingKeys, PostgresInteractor interactor) throws IOException, SQLException {
        ActorsFileParser parser = new ActorsFileParser();
        //File src = new File("C:\\Users\\Leon.Bornemann\\Documents\\Database Changes\\Data\\IMDB\\Database\\actresses.list\\actresses.list");
        File src = new File("/home/leon/Documents/researchProjects/imdb/database/actors.list");
        //printstuff1(src);
        //printStuff2(src);
        parser.parseText(src);
        List<List<String>> actors = parser.getActors().stream().filter(e -> existingKeys.contains(e.getTitle())).map(e -> toList(e.toEntity())).collect(Collectors.toList());
        parser = null;
        interactor.insertActors(actors);
    }

    private static void addActresses(Set<String> existingKeys, PostgresInteractor interactor) throws IOException, SQLException {
        ActorsFileParser parser = new ActorsFileParser();
        //File src = new File("C:\\Users\\Leon.Bornemann\\Documents\\Database Changes\\Data\\IMDB\\Database\\actresses.list\\actresses.list");
        File src = new File("/home/leon/Documents/researchProjects/imdb/database/actresses.list");
        //printstuff1(src);
        //printStuff2(src);
        parser.parseText(src);
        //EntityCollection.checkDublicates(parser.getEntities().collect(Collectors.toList()));
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

    private static List<String> buildUniqueVals(Map.Entry<String, List<Property>> e) {
        List<String> vals = new ArrayList<>();
        vals.add(e.getKey());
        vals.addAll(e.getValue().stream().map(p -> p.getValue()).collect(Collectors.toSet()));
        return vals;
    }

    private static void printV(List<String> v) {
        System.out.println(v.get(0));
        for(int i=1;i<Math.min(v.size(),100);i++){
            System.out.println("\t\t" + v.get(i));
        }
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
