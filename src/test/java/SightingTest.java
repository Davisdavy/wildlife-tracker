import org.junit.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

import java.util.Arrays;

public class SightingTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    public Sighting testSighting= new Sighting("Davis", 1);
    public Animal testAnimal = new Animal("Wolf", 33350);
    @Test
    public void ranger_instantiatesCorrectly_true() {

        assertEquals(true, testSighting instanceof Sighting);
    }
    @Test
    public void Ranger_instantiatesWithName_String() {

        assertEquals("Davis", testSighting.getRangerName());
    }
    @Test
    public void Ranger_instantiatesWithBadgeNo_int() {
        assertEquals(1, testSighting.getBadgeNo());
    }

    //Overriding equals()
    @Test
    public void equals_returnsTrueIfRangerNameAndBadgeNoAreSame_true() {
        Sighting anotherSighting = new Sighting("Davis", 1);
        assertTrue(testSighting.equals(anotherSighting));
    }

    //Save() test to database
    @Test
    public void save_returnsTrueIfDescriptionsAreTheSame() {
        testSighting.save();
        assertTrue(Sighting.all().get(0).equals(testSighting));
    }
    @Test
    public void save_assignsIdToRanger() {
        testSighting.save();
        Sighting savedSighting = Sighting.all().get(0);
        assertEquals(savedSighting.getId(), testSighting.getId());
    }

    //return all database entries all()

    @Test
    public void all_returnsAllInstancesOfRanger_true() {
        Sighting firstSighting = new Sighting("Davis", 1);
        firstSighting.save();
        Sighting secondSighting= new Sighting("Daniel", 1);
        secondSighting.save();
        assertEquals(true, Sighting.all().get(0).equals(firstSighting));
        assertEquals(true, Sighting.all().get(1).equals(secondSighting));
    }
    //Find() by id
    @Test
    public void find_returnsMonsterWithSameId_secondRanger() {
        Sighting firstSighting = new Sighting("Davis", 1);
        firstSighting.save();
        Sighting secondSighting = new Sighting("Daniel", 3);
        secondSighting.save();
        assertEquals(Sighting.find(secondSighting.getId()), secondSighting);
    }
    //Return all Ranger objects belonging to animal
    @Test
    public void getRanger_retrievesAllRangerFromDatabase_rangersList() {
        testAnimal.save();
        Sighting firstSighting = new Sighting("Davis", testAnimal.getId());
        firstSighting.save();
        Sighting secondSighting = new Sighting("Daniel", testAnimal.getId());
        secondSighting.save();
        Sighting[] sightings = new Sighting[] { firstSighting, secondSighting };
        assertTrue(testAnimal.getRanger().containsAll(Arrays.asList(sightings)));
    }




}