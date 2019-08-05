import java.util.List;

import org.sql2o.*;
public class Sighting {
    private String rangerName;
    private int id;
    private String animal;
    private String date;
    private String month;
    private String location;


    public Sighting(int id,String rangerName,String location,String animal,String date,String month){
        this.rangerName = rangerName;
        this.id=id;
        this.animal = animal;
        this.animal=animal;
        this.date=date;
        this.location=location;
        this.month=month;
    }
    public String getRangerName(){
        return rangerName;
    }
    public int getId(){
        return id;
    }
    public String getLocation() { return location;}
    public String getDate() { return date; }
    public String getAnimal() { return animal; }
    public String getMonth() { return month; }


    //save method save()

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sighting (rangerName, location,animal,date,month) VALUES (:rangerName, :location,:animal,:date,:month)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("rangerName", this.rangerName)
                    .addParameter("location",location)
                    .addParameter("animal",animal)
                    .addParameter("date",date)
                    .addParameter("month",month)
                    .executeUpdate()
                    .getKey();
        }
    }




}
