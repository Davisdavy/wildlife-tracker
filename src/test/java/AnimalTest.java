import org.junit.Rule;
import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public  class AnimalTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    public Animal testAnimal= new Animal("Wolf", 33350);

    @Test
    public void Animal_instantiatesCorrectly_true() {

        assertEquals(true, testAnimal instanceof Animal);
    }

    @Test
    public void getAnimalName_animalInstantiatesWithName_string() {
        assertEquals("Wolf", testAnimal.getName());
    }


    @Test
    public void getAnimalId_animalInstantiatesWithId_int() {
        assertEquals(33350, testAnimal.getAnimalId());
    }

    // Overriding equal()
    @Test
    public void equal_returnsTrueIfNameAndIdAreSame_true() {
        Animal firstAnimal = new Animal("Wolf", 33350);
        Animal anotherAnimal = new Animal("Wolf", 33350);
        assertTrue(firstAnimal.equals(anotherAnimal));
    }

    //Database setup
    @Test
    public void save_insertsObjectIntoDatabase_Animal(){
        testAnimal.save();
        assertTrue(Animal.all().get(0).equals(testAnimal));

    }
    //Returning all database entries
    @Test
    public void all_returnsAllInstancesOfAnimal_true() {
        Animal firstAnimal = new Animal("Wolf", 33350);
        firstAnimal.save();
        Animal secondAnimal = new Animal("Fox", 33310);
        secondAnimal.save();
        assertEquals(true, Animal.all().get(0).equals(firstAnimal));
        assertEquals(true, Animal.all().get(1).equals(secondAnimal));
    }


    @Test
    public void save_assignsIdToObject() {
        testAnimal.save();
        Animal savedPerson = Animal.all().get(0);
        assertEquals(testAnimal.getAnimalId(), savedPerson.getAnimalId());
    }
    //Test for finding animal by their id find()
    @Test
    public void find_returnsPersonWithSameId_secondPerson() {
        Animal firstAnimal = new Animal("Wolf", 33350);
        firstAnimal.save();
        Animal secondAnimal = new Animal("Harriet", 33350);
        secondAnimal.save();
        assertEquals(Animal.find(secondAnimal.getId()), secondAnimal);
    }



}