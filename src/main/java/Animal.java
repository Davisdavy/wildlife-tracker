import java.util.Objects;

public class Animal {
    private int animalId;
    private  String animalName;


    public Animal(String animalName, int animalId){
        this.animalName = animalName;
        this.animalId = animalId;
    }

    public String getAnimalName(){
        return animalName;
    }
    public int getAnimalId(){
        return animalId;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return animalId == animal.animalId &&
                Objects.equals(animalName, animal.animalName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalId, animalName);
    }

}
