package de.hpi.data_change.imdb.main;

import de.hpi.data_change.data.Pair;
import de.hpi.data_change.data.Property;
import de.hpi.data_change.imdb.IOConstants;
import de.hpi.data_change.imdb.change_extraction.DiffApplyer;
import de.hpi.data_change.imdb.data.TableType;
import de.hpi.data_change.imdb.database.PostgresInteractor;
import de.hpi.data_change.imdb.parsing.IMDBFileANTLRGeneratedParser;
import de.hpi.data_change.imdb.parsing.IMDBFileParser;
import de.hpi.data_change.imdb.parsing.TitleEndRecognizer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;

import java.io.*;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SingleFileParsing {

    public static void main(String[] args) throws IOException, InterruptedException, SQLException, ClassNotFoundException {
        //System.out.println(TitleEndRecognizer.matchesCurly("{Tussen twee problemen in (#1.5)}"));
        //movies();
        //locationStuff();
        //File src = new File("C:\\Users\\Leon.Bornemann\\Documents\\Database Changes\\Data\\IMDB\\Database\\genres.list\\genres.list");
        //File src = new File("C:\\Users\\Leon.Bornemann\\Documents\\Database Changes\\Data\\IMDB\\Database\\actresses.list\\actresses.list");
        //System.out.println(IOConstants.getEncodingFromFileHeader(src));
        //otherstuff();
        actorstuff();
        //genrestuff();
    }

    private static void movies() throws IOException, SQLException, ClassNotFoundException {

        File src = new File("/home/leon/Documents/researchProjects/imdb/database/movies.list");
        IMDBFileParser parser = IMDBFileANTLRGeneratedParser.createParser(TableType.Movies);
        parser.parseText(src);
        System.out.println(parser.getEntities().filter(e -> e.getName().contains("|")).count());
        parser.getEntities().map(m -> m.getName()).map(title -> TitleEndRecognizer.splitAfterTitle(title))
                .filter(e -> !e.getSecond().equals(""))
                //.count());
                .limit(100)
                .forEach(e -> System.out.println(e));
        List<Pair<String, String>> movies = parser.getEntities().filter(e -> e.containsPropertyName("date") && isInteger(e.getValue("date"))).map(e -> new Pair<String, String>(e.getName(), e.getValue("date"))).collect(Collectors.toList());
        System.out.println(movies.size());
        System.out.println(movies.stream().map(m -> m.getFirst()).distinct().count());
        List<Pair<String, String>> moviesFiltered = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        for (Pair<String, String> movie : movies) {
            if(!seen.contains(movie.getFirst())){
                seen.add(movie.getFirst());
                moviesFiltered.add(movie);
            }
        }
        PostgresInteractor interactor = new PostgresInteractor();

        interactor.insertMovies(moviesFiltered);
//        File outFile = new File("/home/leon/Desktop/moviesInsert.sql");
//        PrintWriter outWriter = new PrintWriter(new FileWriter(outFile));
//        outWriter.println("INSERT into movies VALUES ");
//        for(int i=0;i<movies.size();i++){
//            outWriter.print("('" + movies.get(i).getFirst() + "'," + movies.get(i).getSecond() + ")");
//            if(i==movies.size()-1){
//                outWriter.println(";");
//            } else{
//                outWriter.println(",");
//            }
//        }
        //System.out.println("longest movie title: " + parser.getEntities().mapToInt(e -> e.getName().length()).max().getAsInt());
        //parser.getEntities().limit(100).forEach(e -> System.out.println(e));
//        List<Character> res = parser.getEntities().map(m -> m.getName().charAt(m.getName().length() - 1)).collect(Collectors.toList());
//        Map<Character, Integer> counts = count(res);
//        printAll(counts);

//        List<String> resNew = parser.getEntities().map(m -> m.getName()).filter(title -> title.endsWith(")"))
//                .map(title -> title.substring(title.lastIndexOf('('))).collect(Collectors.toList());
//        Map<String, Integer> countEnds = count(resNew);
//        printAll(countEnds);
//        System.out.println(countEnds.keySet().stream().allMatch(e -> TitleEndRecognizer.matches(e)));
//        countEnds.keySet().stream().filter(e -> !TitleEndRecognizer.matches(e)).forEach(e -> System.out.println(e));
//        System.out.println(parser.getEntities().map(m -> m.getName()).filter(title -> title.endsWith("}"))
//                .map(title -> title.substring(title.lastIndexOf('{'))).allMatch(e -> TitleEndRecognizer.matchesCurly(e)));
//        assert(parser.getEntities().map(m -> m.getName()).filter(title -> title.endsWith("}"))
//                .map(title -> title.substring(title.lastIndexOf('{'))).allMatch(e -> TitleEndRecognizer.matchesCurly(e)));
//        List<String> resNew = parser.getEntities().map(m -> m.getName()).filter(title -> title.endsWith("}"))
//                .map(title -> title.substring(title.lastIndexOf('{')))
//                .collect(Collectors.toList());
//        Map<String, Integer> resMap = count(resNew);
//        printAllWithMatch(resMap);
//        System.out.println(TitleEndRecognizer.matchesCurly("{(#1.1)}"));
        //System.out.println("total: " + resNew.size());
        //System.out.println("matching: " + resNew.stream().filter(e -> TitleEndRecognizer.matchesCurly(e)).count());
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

//    private static void printAllWithMatch(Map<String, Integer> resMap) {
//        resMap.entrySet().stream().sorted( (e1,e2) -> e1.getValue().compareTo(e2.getValue())).forEachOrdered(e -> System.out.println(e.getKey() + " " + e.getValue() + " " +TitleEndRecognizer.matchesCurly(e.getKey())));
//    }

    private static <R> void printAll(Map<R, Integer> counts) {
        counts.entrySet().stream().sorted( (e1,e2) -> e1.getValue().compareTo(e2.getValue())).forEachOrdered(e -> System.out.println(e.getKey() + " " + e.getValue()));
    }

    private static <R> Map<R, Integer> count(List<R> res) {
        Map<R,Integer> counts = new HashMap<>();
        for(R c : res){
            if(counts.containsKey(c)){
                counts.put(c,counts.get(c) +1);
            } else{
                counts.put(c,1);
            }
        }
        return counts;
    }

    private static void locationStuff() throws IOException {

        File src = new File("/home/leon/Documents/data/imdb/database/locations.list");
        IMDBFileParser parser = IMDBFileANTLRGeneratedParser.createParser(TableType.Location);
        parser.parseText(src);
        parser.getEntities().limit(100).forEach(e -> System.out.println(e));
    }

    private static void genrestuff() throws IOException {
        IMDBFileParser parser = IMDBFileANTLRGeneratedParser.createParser(TableType.Genre);
        File src = new File("C:\\Users\\Leon.Bornemann\\Documents\\Database Changes\\Data\\IMDB\\Database\\genres.list\\genres.list");
        parser.parseText(src);
        parser.getEntities().limit(100).forEach(e -> System.out.println(e));
    }


    private static void otherstuff() throws IOException {
        IMDBFileParser parser = IMDBFileANTLRGeneratedParser.createParser(TableType.Country);
        File src = new File("C:\\Users\\Leon.Bornemann\\Documents\\Database Changes\\Data\\IMDB\\Database\\countries.list\\countries.list");
        parser.parseText(src);
        parser.getEntities().limit(100).forEach(e -> System.out.println(e));
    }

    private static void actorstuff() throws IOException {
        System.out.println("Parsing single File");
        IMDBFileParser parser = IMDBFileANTLRGeneratedParser.createParser(TableType.Actor);
        //File src = new File("C:\\Users\\Leon.Bornemann\\Documents\\Database Changes\\Data\\IMDB\\Database\\actresses.list\\actresses.list");
        File src = new File("/home/leon/Documents/researchProjects/imdb/database/actresses.list");
        //printstuff1(src);
        //printStuff2(src);
        parser.parseText(src);
        parser.getEntities().limit(100).forEach(e -> System.out.println(e));
//        System.out.println("total" + parser.getEntities().count());
        System.out.println("maxLengthACtress" + parser.getEntities().mapToInt(e -> e.getName().length()).max());
        System.out.println("squareBracket_1" + parser.getEntities().filter(e-> e.containsPropertyName("squareBracket_1")).mapToInt(e -> e.getValue("squareBracket_1").length()).max());
        System.out.println("roundBracket_1" + parser.getEntities().filter(e-> e.containsPropertyName("roundBracket_1")).mapToInt(e -> e.getValue("roundBracket_1").length()).max());
//
        System.out.println("withAtLeastOneAttribute:" + parser.getEntities().filter( e -> containsNonMovie(e.getProperties())).count());
        Map<String, List<Property>> res = parser.getEntities().filter(e -> containsNonMovie(e.getProperties())).flatMap(e -> e.getProperties().stream())
                .filter(p -> !p.getName().equals("movie"))
                .collect(Collectors.groupingBy(p -> p.getName()));
        res.entrySet().stream().map( e -> buildUniqueVals(e)).forEach(
                v -> printV(v)
        );
    }

    private static void printV(List<String> v) {
        System.out.println(v.get(0));
        for(int i=1;i<Math.min(v.size(),100);i++){
            System.out.println("\t\t" + v.get(i));
        }
    }

    private static List<String> buildUniqueVals(Map.Entry<String, List<Property>> e) {
        List<String> vals = new ArrayList<>();
        vals.add(e.getKey());
        vals.addAll(e.getValue().stream().map(p -> p.getValue()).collect(Collectors.toSet()));
        return vals;
    }


    private static boolean containsNonMovie(List<Property> properties) {
        return properties.size()>1;
//        for(Property prop:properties){
//            if(!prop.getName().equals("movie")){
//                return true;
//            }
//        }
//        return false;
    }

    private static void printStuff2(File src) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(src), IOConstants.ENCODING));
        char[] buffer = new char[102400];
        br.read(buffer,0,102400);
        String res = IntStream.range(0, buffer.length).map(i -> buffer[i]).boxed()
                .map(i -> toLiteral((char) i.intValue()))
                .reduce((c1, c2) -> c1 + c2).get();
        System.out.println(res);
        br.close();
    }

    private static void printstuff1(File src) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(src), IOConstants.ENCODING));
        int lineNum = 1;
        String line = br.readLine();
        while(line != null){
            if(lineNum <=700){
                String myLine = line.chars().boxed().map(i -> toLiteral(i).toString()).reduce((c1, c2) -> c1 + c2).orElseGet(() ->"<empty line>");
                System.out.println(line);
                System.out.println(myLine);
                System.out.println("--------------------------------------------end---------------------------------------------------");
            }
            line = br.readLine();
            lineNum++;
        }
        br.close();
    }

    private static String toLiteral(int c) {
        switch (c) {
            case '\n':
                return "\\n";
            case '\t':
                return "\\t";
            case '\r':
                return "\\r";
            case '\f':
                return "\\f";
            case '\b':
                return "\\b";
            case '\'':
                return "\\\'";
            case '\"':
                return "\\\"";
            case '\\':
                return "\\\\";
            case ' ':
                return "\\s";
            default:
                return new String(Character.toChars(c));
        }
    }
}
