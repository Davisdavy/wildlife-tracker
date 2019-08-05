import java.util.Objects;
import org.sql2o.*;

import java.util.List;

public class Animal {
    private int animalId;
    private  String name;
    private int id;


    //Constants

    public static final String  THREATTYPE ="Non-Endangered";
    //constructor

    public Animal(String name){
        this.name = name;

    }

    //getters

    public String getName(){ return name; }
    public int getAnimalId(){ return animalId; }
    public int getId(){ return  id;}
    public static String getThreatType(){ return  THREATTYPE ;}




    //override

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return animalId == animal.animalId &&
                id == animal.id &&
                Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalId, name, id);
    }


    //save() saving to database

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name,threattype) VALUES (:name,:threattype)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("threattype", THREATTYPE)
                    .executeUpdate()
                    .getKey();
        }
    }
//    //all()
    public static List<Animal> all() {
        String sql = "SELECT * FROM animals where threattype = 'Non-Endangered'";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Animal.class);
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

//    public List<Ranger> getRangers() {
//        try(Connection con = DB.sql2o.open()) {
//            String sql = "SELECT * FROM rangers where rangerBadge=:id";
//            return con.createQuery(sql)
//                    .addParameter("id", this.id)
//                    .executeAndFetch(Ranger.class);
//        }
//    }






}
