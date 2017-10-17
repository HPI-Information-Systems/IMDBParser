package de.hpi.data_change.imdb.database;

import de.hpi.data_change.data.Entity;
import de.hpi.data_change.data.Pair;
import de.hpi.data_change.imdb.data.Director;
import de.hpi.data_change.imdb.data.Editor;

import java.sql.PreparedStatement;
import java.util.List;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class PostgresInteractor {

    private final Connection connection;

    public PostgresInteractor() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost/imdb","leon", "admin");
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
        PreparedStatement insert = connection.prepareStatement("INSERT INTO actors VALUES (?,?,?,?,?) ON Conflict (title,name) DO NOTHING");
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
            insert.addBatch();
            if(i%100000 == 0 || i==actors.size()-1){
                System.out.println("Inserting new Batch");
                insert.executeBatch();
                insert = insert = connection.prepareStatement("INSERT INTO actors VALUES (?,?,?,?,?) ON Conflict (title,name) DO NOTHING");
            }
        }
    }

    public void insertActresses(List<List<String>> actresses) throws SQLException {
        System.out.println("Beginning to insert " + actresses.size() + " actors");
        PreparedStatement insert = connection.prepareStatement("INSERT INTO actresses VALUES (?,?,?,?,?) ON Conflict (title,name) DO NOTHING");
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
            insert.addBatch();
            if(i%100000 == 0 || i==actresses.size()-1){
                System.out.println("Inserting new Batch");
                insert.executeBatch();
                insert = insert = connection.prepareStatement("INSERT INTO actresses VALUES (?,?,?,?,?) ON Conflict (title,name) DO NOTHING");
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
}
