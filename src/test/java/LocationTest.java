import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class LocationTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    public Location testLocation = new Location("Zone X");

    @Test
    public void location_instantiatesCorrectly() {
        assertNotNull(testLocation);
    }

    @Test
    public void location_InstantiateName_true() {
        assertEquals("Zone X", testLocation.getName());
    }
    @Test
    public void all_returnsAllInstancesOfLocations_true() {
        testLocation.save();
        Location testLocation2 = new Location("Zone B");
        testLocation2.save();
        assertEquals(Location.all().get(0), testLocation);
        assertEquals(Location.all().get(1), testLocation2);
    }
    @Test
    public void save_assignsIdToObject() {
        testLocation.save();
        Location savedLocation= Location.all().get(0);
        assertEquals(testLocation.getId(), savedLocation.getId());
    }
    //finds()
    @Test
    public void find_FindLocation_true() {
        testLocation.save();
        assertEquals(testLocation, Location.find(testLocation.getId()));
    }
    @Test
    public void false_NotInstance()
    {
        Animal testAnimal = new Animal("Elephant");
        assertNotEquals(testLocation,testAnimal);
    }


}