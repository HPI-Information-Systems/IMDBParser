package de.hpi.data_change.imdb.database;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.data.Pair;
import de.hpi.data_change.imdb.data.*;

import java.sql.*;
import java.util.List;

/**
 * Class to insert data into a postgresql database. Was only used to extract an interesting database for students to work on.
 */
public class PostgresInteractor {

    private final Connection connection;

    public PostgresInteractor(String url,String user,String pw) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(
                url,user, pw);
    }

    public void insertMovies(List<Pair<String,String>> movies) throws SQLException {
        PreparedStatement insert = connection.prepareStatement("INSERT INTO movies VALUES (?,?)");
        for(Pair<String,String> movie:movies){
            insert.setString(1,movie.getFirst());
            insert.setInt(2,Integer.parseInt(movie.getSecond()));
            insert.addBatch();
        }
        insert.executeBatch();
    }

    public void insertActors(List<List<String>> actors) throws SQLException {
        System.out.println("Beginning to insert " + actors.size() + " actors");
        PreparedStatement insert = connection.prepareStatement("INSERT INTO actors VALUES (?,?,?,?,?,?) ON Conflict (title,name) DO NOTHING");
        for(int i=0;i<actors.size();i++){
            List<String> actor = actors.get(i);
            insert.setString(1,actor.get(0));
            insert.setString(2,actor.get(1));
            insert.setString(3,actor.get(2)); //starring as
            insert.setString(4,actor.get(3)); //round bracket - additionalInfo
            if(actor.get(4) == null){
                insert.setObject(5,null);
            } else{
                insert.setInt(5,Integer.parseInt(actor.get(4)));
            }
            insert.setString(6,"male");
            insert.addBatch();
            if(i%100000 == 0 || i==actors.size()-1){
                System.out.println("Inserting new Batch");
                insert.executeBatch();
                insert = connection.prepareStatement("INSERT INTO actors VALUES (?,?,?,?,?,?) ON Conflict (title,name) DO NOTHING");
            }
        }
    }

    public void insertActresses(List<List<String>> actresses) throws SQLException {
        System.out.println("Beginning to insert " + actresses.size() + " actors");
        PreparedStatement insert = connection.prepareStatement("INSERT INTO actors VALUES (?,?,?,?,?,?) ON Conflict (title,name) DO NOTHING");
        for(int i=0;i<actresses.size();i++){
            List<String> actor = actresses.get(i);
            insert.setString(1,actor.get(0));
            insert.setString(2,actor.get(1));
            insert.setString(3,actor.get(2)); //starring as
            insert.setString(4,actor.get(3)); //round bracket - additionalInfo
            if(actor.get(4) == null){
                insert.setObject(5,null);
            } else{
                insert.setInt(5,Integer.parseInt(actor.get(4)));
            }
            insert.setString(6,"female");
            insert.addBatch();
            if(i%100000 == 0 || i==actresses.size()-1){
                System.out.println("Inserting new Batch");
                insert.executeBatch();
                insert = connection.prepareStatement("INSERT INTO actors VALUES (?,?,?,?,?,?) ON Conflict (title,name) DO NOTHING");

            }
        }
    }

    public void insertDirectors(List<Director> directors) throws SQLException {
        System.out.println("Beginning to insert " + directors.size() + " directors");
        PreparedStatement insert = connection.prepareStatement("INSERT INTO directors VALUES (?,?,?,?,?,?) ON Conflict (name,title) DO NOTHING");
        for(int i=0;i<directors.size();i++){
            Director director = directors.get(i);
            Entity entity = director.toEntity();
            insert.setString(1,director.getName());
            insert.setString(2,director.getTitle());
            if (entity.containsPropertyName("as")) {
                insert.setString(3,entity.getValue("as"));
            } else{
                insert.setObject(3,null); //starring as
            }
            if (entity.containsPropertyName("co-director")) {
                insert.setBoolean(4,true);
            } else{
                insert.setBoolean(4,false); //starring as
            }
            if (entity.containsPropertyName("segment")) {
                insert.setString(5,entity.getValue("segment"));
            } else{
                insert.setObject(5,null); //starring as
            }
            if (entity.containsPropertyName("uncredited")) {
                insert.setBoolean(6,true);
            } else{
                insert.setBoolean(6,false); //starring as
            }
            insert.addBatch();
            if(i%100000 == 0 || i==directors.size()-1){
                System.out.println("Inserting new Batch");
                insert.executeBatch();
                insert = insert = connection.prepareStatement("INSERT INTO directors VALUES (?,?,?,?,?,?) ON Conflict (title,name) DO NOTHING");
            }
        }
    }

    public void insertEditors(List<Editor> editors) throws SQLException {
        System.out.println("Beginning to insert " + editors.size() + " editors");
        PreparedStatement insert = connection.prepareStatement("INSERT INTO editors VALUES (?,?,?,?,?,?) ON Conflict (name,title) DO NOTHING");
        for(int i=0;i<editors.size();i++){
            Editor editor = editors.get(i);
            Entity entity = editor.toEntity();
            insert.setString(1,editor.getName());
            insert.setString(2,editor.getTitle());
            if (entity.containsPropertyName("as")) {
                insert.setString(3,entity.getValue("as"));
            } else{
                insert.setObject(3,null); //starring as
            }
            if (entity.containsPropertyName("co-editor")) {
                insert.setBoolean(4,true);
            } else{
                insert.setBoolean(4,false); //starring as
            }
            if (entity.containsPropertyName("segment")) {
                insert.setString(5,entity.getValue("segment"));
            } else{
                insert.setObject(5,null); //starring as
            }
            if (entity.containsPropertyName("uncredited")) {
                insert.setBoolean(6,true);
            } else{
                insert.setBoolean(6,false); //starring as
            }
            insert.addBatch();
            if(i%100000 == 0 || i==editors.size()-1){
                System.out.println("Inserting new Batch");
                insert.executeBatch();
                insert = insert = connection.prepareStatement("INSERT INTO editors VALUES (?,?,?,?,?,?) ON Conflict (title,name) DO NOTHING");
            }
        }
    }

    public void insertCountries(List<Country> editors) throws SQLException {
        System.out.println("Beginning to insert " + editors.size() + " editors");
        PreparedStatement insert = connection.prepareStatement("INSERT INTO countries VALUES (?,?) ON Conflict (name,title) DO NOTHING");
        for(int i=0;i<editors.size();i++){
            Country country = editors.get(i);
            insert.setString(1,country.getName());
            insert.setString(2,country.getTitle());
            insert.addBatch();
            if(i%100000 == 0 || i==editors.size()-1){
                System.out.println("Inserting new Batch");
                insert.executeBatch();
                insert = insert = connection.prepareStatement("INSERT INTO countries VALUES (?,?) ON Conflict (name,title) DO NOTHING");
            }
        }
    }

    public void insertRatings(List<Rating> ratings) throws SQLException {
        System.out.println("Beginning to insert " + ratings.size() + " editors");
        PreparedStatement insert = connection.prepareStatement("UPDATE movies SET rating_votes = ?, rating_rank= ? where title = ?");
        for(int i=0;i<ratings.size();i++){
            Rating rating = ratings.get(i);
            insert.setInt(1,rating.getVotes());
            insert.setDouble(2,rating.getRank());
            insert.setString(3,rating.getTitle());
            insert.addBatch();
            if(i%100000 == 0 || i==ratings.size()-1){
                System.out.println("Inserting new Batch");
                insert.executeBatch();
                insert = insert = connection.prepareStatement("UPDATE movies SET rating_votes = ?, rating_rank= ? where title = ?");
            }
        }
    }

    public void insertPlots(List<Plot> editors) throws SQLException {
        System.out.println("Beginning to insert " + editors.size() + " plots");
        PreparedStatement insert = connection.prepareStatement("INSERT INTO plots VALUES (?,?,?) ON Conflict (title,author) DO NOTHING");
        for(int i=0;i<editors.size();i++){
            Plot plot = editors.get(i);
            insert.setString(1,plot.getTitle());
            insert.setString(2,plot.getAuthor().substring(0,Math.min(150,plot.getAuthor().length())));
            insert.setString(3,plot.getDescription());
            insert.addBatch();
            if(i%100000 == 0 || i==editors.size()-1){
                System.out.println("Inserting new Batch");
                insert.executeBatch();
                insert = insert = connection.prepareStatement("INSERT INTO plots VALUES (?,?,?) ON Conflict (title,author) DO NOTHING");
            }
        }
    }
}
