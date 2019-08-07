import static org.junit.Assert.*;
import org.sql2o.*;
import org.junit.*;

import java.util.Arrays;

public class RangerTest {

    public Ranger testRanger = new Ranger("Davis", 1);
    public Sighting testSighting = new Sighting("Zone X", "Davis",1,"Elephant");
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void ranger_instantiatesCorrectly_true() {

        assertEquals(true, testRanger instanceof Ranger);
    }

    @Test
    public void ranger_instantiatesWithName_String() {
        assertEquals("Davis", testRanger.getRangerName());
    }

    @Test
    public void ranger_instantiatesWithRangerBadge_int() {
        assertEquals(1, testRanger.getRangerBadge());
    }

    @Test
    public void equals_returnsTrueIfNameAndPersonIdAreSame_true() {
        Ranger anotherRanger= new Ranger("Davis", 1);
        assertTrue(testRanger.equals(anotherRanger));
    }

    ///save to database save()
    @Test
    public void save_returnsTrueIfDescriptionsAreTheSame() {
        testRanger.save();
        assertTrue(Ranger.all().get(0).equals(testRanger));
    }

    @Test
    public void save_assignsIdRanger() {
        testRanger.save();
        Ranger savedRanger = Ranger.all().get(0);
        assertEquals(savedRanger.getId(), testRanger.getId());
    }
    //delete()
    @Test
    public void delete_deletesRanger_true() {
        testRanger.save();
        int newRangerId = testRanger.getId();
        testRanger.delete();
        assertNull(Ranger.find(newRangerId));
    }

    //Return all db entries
    @Test
    public void all_returnsAllInstancesOfRanger_true() {
        Ranger firstRanger = new Ranger("Davis", 1);
        firstRanger.save();
        Ranger secondRanger = new Ranger("Dan", 1);
        secondRanger.save();
        assertEquals(true, Ranger.all().get(0).equals(firstRanger));
        assertEquals(true, Ranger.all().get(1).equals(secondRanger));
    }

    //find ranger by id find()
    @Test
    public void find_returnsRangerWithSameId_secondRanger() {
        Ranger firstRanger = new Ranger("Davis", 1);
        firstRanger.save();
        Ranger secondRanger= new Ranger("Dan", 3);
        secondRanger.save();
        assertEquals(Ranger.find(secondRanger.getId()), secondRanger);
    }

    //return all ranger object belonging to animals

    @Test
    public void getSightings_retrievesAllSightingsFromDatabase_sightingList() {
        testRanger.save();
        testSighting.save();
        Sighting sighting2 = new Sighting("Zone B", "Dan",2,"Elephant");
        sighting2.save();
        Sighting[] sightings = new Sighting[]{testSighting, sighting2};
        assertTrue(testRanger.getSighting().containsAll(Arrays.asList(sightings)));
    }

    @Test
    public void equals_falseIfNotItsInstance_true()
    {
        Animal testAnimal = new Animal("Elephant");
        assertNotEquals(testRanger, testAnimal);
    }


}