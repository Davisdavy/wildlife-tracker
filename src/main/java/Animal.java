import java.util.Objects;
import org.sql2o.*;

import java.util.List;

public class Animal {
    private int animalId;
    private  String name;
    private int id;
    private String threatType;
    private String health;
    private String level;
    private String age;


    public Animal(String name, int animalId, String threatType){
        this.name = name;
        this.animalId = animalId;
        this.threatType = threatType;

//        this.health=health;
//        this.age=age;
//        this.id=id;
//        this.level=level;
    }

//    public String getHealth() {
//        return health;
//    }
//
//    public String getAge() {
//        return age;
//    }

//    public String getLevel(){ return this.level;}
    public String getName(){
        return name;
    }
    public int getAnimalId(){
        return animalId;
    }
    public int getId(){ return  id;}
    public String getThreatType(){ return  threatType;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return animalId == animal.animalId &&
                Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalId, name);
    }

    //save() saving to database

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name,animalId,threatType ) VALUES (:name, :animalId,  :threatType)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("animalId", this.animalId)
                    .addParameter("threatType", this.threatType)
//                    .addParameter("health",health)
//                    .addParameter("age",age)
//                    .addParameter("level",level)
                    .executeUpdate()
                    .getKey();
        }
    }
//    //all()
    public static List<Animal> all() {
        String sql = "SELECT * FROM animals";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Animal.class);
        }
    }
    //find()
    public static Animal find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            Animal animal = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Animal.class);
            return animal;
        }
    }
    //Return all Ranger objects belonging to animal

    public List<Ranger> getRangers() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM rangers where rangerBadge=:id";
            return con.createQuery(sql)
                    .addParameter("id", this.id)
                    .executeAndFetch(Ranger.class);
        }
    }

}
