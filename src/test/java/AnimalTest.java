
import org.junit.Rule;
import org.junit.Test;
import org.junit.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public  class AnimalTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    public Animal testAnimal= new Animal("Wolf", 33350,"Endangered");
    public Ranger testRanger = new Ranger("Davis", 1);

    @Test
    public void Animal_instantiatesCorrectly_true() {

        assertEquals(true, testAnimal instanceof Animal);
    }

    @Test
    public void getAnimalName_animalInstantiatesWithName_string() {
        assertEquals("Wolf", testAnimal.getName());
    }

    @Test
    public void getAnimalThreatType_animalInstantiatesThreatType_string() {
        assertEquals("Endangered", testAnimal.getThreatType());
    }
    @Test
    public void getAnimalId_animalInstantiatesWithId_int() {
        assertEquals(33350, testAnimal.getAnimalId());
    }

    // Overriding equal()
    @Test
    public void equal_returnsTrueIfNameAndIdAreSame_true() {
        Animal firstAnimal = new Animal("Wolf", 33350,"Endangered");
        Animal anotherAnimal = new Animal("Wolf", 33350,"Endangered");
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
        Animal firstAnimal = new Animal("Wolf", 33350,"Endangered");
        firstAnimal.save();
        Animal secondAnimal = new Animal("Fox", 33310,"Common");
        secondAnimal.save();
        assertEquals(true, Animal.all().get(0).equals(firstAnimal));
        assertEquals(true, Animal.all().get(1).equals(secondAnimal));
    }

    //Find animal by id
    @Test
    public void find_returnsAnimalWithSameId_secondPerson() {
        Animal firstAnimal= new Animal("Wolf", 33350,"Endangered");
        firstAnimal.save();
        Animal secondAnimal = new Animal("Fox", 33310,"Endangered");
        secondAnimal.save();
        assertEquals(Animal.find(secondAnimal.getId()), secondAnimal);
    }

    //1-many r-ship (1 ranger to many animals)
    @Test
    public void save_savesAnimalIdIntoDB_true() {

        testAnimal.save();
        Ranger testRanger = new Ranger("Davis", testAnimal.getId());
        testRanger.save();
        Ranger savedRanger = Ranger.find(testRanger.getId());
        assertEquals(savedRanger.getRangerBadge(), testAnimal.getId());
    }
    //Instantiating all new animals as okay;
    @Test
    public void animal_instantiatesWithHalfHealthLevel(){
        assertEquals(testAnimal.getHealthLevel(), (Animal.OKAY));
    }

    //Instantiating all new animals as young;
    @Test
    public void animal_instantiatesWithHalfAgeLevel(){
        assertEquals(testAnimal.getAgeLevel(), (Animal.YOUNG));
    }

    //Count the number of animals sighted

    @Test
    public void allAnimalCounts_increaseAnimalsSighting(){
        testAnimal.allAnimalCount();
        assertTrue(testAnimal.getAnimalCount() > (Animal.MIN_ANIMAL_COUNT));
    }










}