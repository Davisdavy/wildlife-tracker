import java.util.List;

import org.sql2o.*;
public class Sighting {
    private String rangerName;
    private int badgeNo;
    private int id;


    public Sighting(String rangerName, int badgeNo){
        this.rangerName = rangerName;
        this.badgeNo = badgeNo;
    }
    public String getRangerName(){
        return rangerName;
    }
    public int getBadgeNo(){
        return badgeNo;
    }
    public int getId(){
        return id;
    }

    //Overriding
    @Override
    public boolean equals(Object otherSighting){
        if (!(otherSighting instanceof Sighting)) {
            return false;
        } else {
            Sighting newSighting = (Sighting) otherSighting;
            return this.getRangerName().equals(newSighting.getRangerName()) &&
                    this.getBadgeNo() == newSighting.getBadgeNo();
        }
    }

    //save method save()
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sighting (rangerName, badgeNo) VALUES (:rangerName, :badgeNo)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("rangerName", this.rangerName)
                    .addParameter("badgeNo", this.badgeNo)
                    .executeUpdate()
                    .getKey();
        }
    }
    //all
    public static List<Sighting> all() {
        String sql = "SELECT * FROM sighting";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Sighting.class);
        }
    }
    //find()
    public static Sighting find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sighting where id=:id";
            Sighting ranger = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sighting.class);
            return ranger;
        }
    }



}
