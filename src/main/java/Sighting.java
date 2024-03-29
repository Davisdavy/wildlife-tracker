import java.sql.Time;
import java.util.List;
import java.sql.Timestamp;
import java.util.Objects;

import org.sql2o.*;
public class Sighting {
    private String rangerName;
    private int id;
    private String animal;
    private String location;

    private Timestamp date;
    private Timestamp month;


    public Sighting(String location,String rangerName,int id,String animal){
        this.rangerName = rangerName;
        this.id=id;
        this.animal = animal;
        this.animal=animal;
        this.location=location;

    }
    public String getRangerName(){
        return rangerName;
    }
    public int getId(){
        return id;
    }
    public String getLocation() { return location;}
    public Timestamp getDate() { return date; }
    public String getAnimal() { return animal; }
    public Timestamp getMonth() { return month; }


    //save method save()

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (location,rangerName,animal) VALUES (:rangerName, :location,:animal)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("rangerName", this.rangerName)
                    .addParameter("location",location)
                    .addParameter("animal",animal)
                    .executeUpdate()
                    .getKey();
        }
    }

    //find()
    public static Sighting find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings where id=:id";
            Sighting sighting = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sighting.class);
            return sighting;
        }
    }
    //all()
    public static List<Sighting> all() {
        String sql = "SELECT * FROM sightings";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Sighting.class);
        }
    }
    @Override
    public boolean equals(Object otherSighting){
        if (!(otherSighting instanceof Sighting)) {
            return false;
        } else {
            Sighting newSighting = (Sighting) otherSighting;
            return this.getId() == newSighting.id;
        }
    }



    public void month() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "UPDATE sightings SET month = now() WHERE id = :id";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }
}
