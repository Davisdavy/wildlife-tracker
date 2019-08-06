
import org.junit.Rule;
import org.junit.Test;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public  class AnimalTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();


    public Animal testAnimal= new Animal("Elephant");

    @Test
    public void Animal_instantiatesCorrectly_true() {

        assertEquals(true, testAnimal instanceof Animal);
    }

    @Test
    public void getAnimalName_animalInstantiatesWithName_string() {
        assertEquals("Elephant", testAnimal.getName());
    }

    @Test
    public void getAnimalThreatType_animalInstantiatesThreatType_string() {
        assertEquals("Non-Endangered", testAnimal.getThreatType());
    }
    @Test
    public void getAnimalId_animalInstantiatesWithId_int() {
        assertEquals(0,testAnimal.getId());
    }

    // Overriding equal()
    @Test
    public void equal_returnsTrueIfNameAndIdAreSame_true() {
        Animal firstAnimal = new Animal("Elephant");
        Animal anotherAnimal = new Animal("Elephant");
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
        Animal firstAnimal = new Animal("Elephant");
        firstAnimal.save();
        Animal secondAnimal = new Animal("Fox");
        secondAnimal.save();
        assertEquals(true, Animal.all().get(0).equals(firstAnimal));
        assertEquals(true, Animal.all().get(1).equals(secondAnimal));
    }

    //Find animal by id
//    @Test
//    public void find_returnsAnimalWithSameId_secondPerson() {
//        Animal firstAnimal= new Animal("Wolf");
//        firstAnimal.save();
//        Animal secondAnimal = new Animal("Fox");
//        secondAnimal.save();
//        assertEquals(testAnimal,Animal.find(testAnimal.getId()));
//    }

    //1-many r-ship (1 ranger to many animals)








}