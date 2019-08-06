import org.junit.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class SightingTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    public Sighting testSighting= new Sighting("Zone X", "Davis",1,"Elephant");

    @Test
    public void sighting_instantiatesCorrectly_true() {

        assertEquals(true, testSighting instanceof Sighting);
    }
    @Test
    public void Sighting_instantiatesWithRangerName_String() {

        assertEquals("Davis", testSighting.getRangerName());
    }


    //Save() test to database

@Test
public void save_assignsIdToObject() {
    testSighting.save();
    Sighting savedSighting = Sighting.all().get(0);
    assertEquals(testSighting.getId(), savedSighting.getId());
}

//    //return all database entries all()
@Test
public void all_returnsAllInstancesOfSightings_true() {
    testSighting.save();
    Sighting testSighting2 = new Sighting("Zone X", "Davis",2,"Lion");
    testSighting2.save();
    assertEquals(Sighting.all().get(0), testSighting);
    assertEquals(Sighting.all().get(1), testSighting2);
}



//    //Find() by id
    @Test
    public void find_returnsSightingsWithSameId_secondSighting() {

        testSighting.save();
        assertEquals(testSighting, Sighting.find(testSighting.getId()));
    }

    @Test
    public void notInstanceOfSighting_false()
    {
        Animal animal = new Animal("Lion");
        assertNotEquals(testSighting, animal);
    }




}