import java.util.Objects;
import org.sql2o.*;

import java.util.List;

public class Animal {
    private int animalId;
    private  String name;
    private int id;


    public Animal(String name, int animalId){
        this.name = name;
        this.animalId = animalId;
    }

    public String getName(){
        return name;
    }
    public int getAnimalId(){
        return animalId;
    }
    public int getId(){ return  id;}
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
            String sql = "INSERT INTO animals (name,animalId ) VALUES (:name, :animalId)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("animalId", this.animalId)
                    .executeUpdate()
                    .getKey();
        }
    }
    //all()
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
    public List<Sighting> getRanger() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings where badgeNo=:id";
            return con.createQuery(sql)
                    .addParameter("id", this.id)
                    .executeAndFetch(Sighting.class);
        }
    }

}
