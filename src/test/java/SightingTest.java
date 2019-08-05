import org.junit.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

import java.util.Arrays;

public class SightingTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    public Sighting testSighting= new Sighting(1, "Davis","near river","Wolf","","");
    public Animal testAnimal= new Animal("Wolf", 33350, "Endangered");
    @Test
    public void sighting_instantiatesCorrectly_true() {

        assertEquals(true, testSighting instanceof Sighting);
    }
    @Test
    public void Sighting_instantiatesWithRangerName_String() {

        assertEquals("Davis", testSighting.getRangerName());
    }


//    //Overriding equals()
//    @Test
//    public void equals_returnsTrueIfSightingNameAndIdAreSame_true() {
//        Sighting anotherSighting = new Sighting("Davis",1, "near river","Wolf","","");
//        assertTrue(testSighting.equals(anotherSighting));
//    }
//
//    //Save() test to database
//    @Test
//    public void save_returnsTrueIfDescriptionsAreTheSame() {
//        testSighting.save();
//        assertTrue(Sighting.all().get(0).equals(testSighting));
//    }
//    @Test
//    public void save_assignsIdToSighting() {
//        testSighting.save();
//        Sighting savedSighting = Sighting.all().get(0);
//        assertEquals(savedSighting.getId(), testSighting.getId());
//    }
//
//    //return all database entries all()
//
//    @Test
//    public void all_returnsAllInstancesOfSighting_true() {
//        Sighting firstSighting = new Sighting("Davis",1, "near river","Wolf","","");;
//        firstSighting.save();
//        Sighting secondSighting= new Sighting("Daniel",1, "near park","Wolf","","");
//        secondSighting.save();
//        assertEquals(true, Sighting.all().get(0).equals(firstSighting));
//        assertEquals(true, Sighting.all().get(1).equals(secondSighting));
//    }
//    //Find() by id
//    @Test
//    public void find_returnsMonsterWithSameId_secondSighting() {
//        Sighting firstSighting = new Sighting("Davis",1, "near river","Wolf","","");
//        firstSighting.save();
//        Sighting secondSighting = new Sighting("Daniel",2, "near park","Wolf","","");
//        secondSighting.save();
//        assertEquals(Sighting.find(secondSighting.getId()), secondSighting);
//    }
    //Return all Ranger objects belonging to animal
//    @Test
//    public void getRanger_retrievesAllRangerFromDatabase_rangersList() {
//        testAnimal.save();
//        Sighting firstSighting = new Sighting("Davis", testAnimal.getId());
//        firstSighting.save();
//        Sighting secondSighting = new Sighting("Daniel", testAnimal.getId());
//        secondSighting.save();
//        Sighting[] sightings = new Sighting[] { firstSighting, secondSighting };
//        assertTrue(testAnimal.getRanger().containsAll(Arrays.asList(sightings)));
//    }




}