import org.junit.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;

public class SightingTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    public Sighting testSighting= new Sighting(1, "Davis","near river","Wolf");
    public Animal testAnimal= new Animal("Wolf");
    @Test
    public void sighting_instantiatesCorrectly_true() {

        assertEquals(true, testSighting instanceof Sighting);
    }
    @Test
    public void Sighting_instantiatesWithRangerName_String() {

        assertEquals("Davis", testSighting.getRangerName());
    }

    //save date and month to database
    @Test
    public void save_recordsTimeOfCreationInDatabase() {
        testSighting.save();
        Timestamp savedSightingDate= Sighting.find(testSighting.getId()).getDate();
        Timestamp rightNow = new Timestamp(new Date().getTime());
        assertEquals(rightNow.getDay(), savedSightingDate.getDay() );
    }

    @Test
    public void month_recordMonthInDatabase(){
    testSighting.save();
    testSighting.month();
    Timestamp savedSightingMonth= Sighting.find(testSighting.getId()).getMonth();
    Timestamp rightNow = new Timestamp(new Date().getTime());
    assertEquals(DateFormat.getDateInstance().format(rightNow), DateFormat.getDateInstance().format(savedSightingMonth) );
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
//        Sighting firstSighting = new Sighting(1,"Davis", "near river","Wolf");;
//        firstSighting.save();
//        Sighting secondSighting= new Sighting(2,"Dan", "near park","Fox");
//        secondSighting.save();
//        assertEquals(true, Sighting.all().get(0).equals(firstSighting));
//        assertEquals(true, Sighting.all().get(1).equals(secondSighting));
//    }




//    //Find() by id
//    @Test
//    public void find_returnsSightingsWithSameId_secondSighting() {
//        Sighting firstSighting = new Sighting(1,"Davis", "near river","Wolf");
//        firstSighting.save();
//        Sighting secondSighting = new Sighting(2,"Dan", "near park","Fox");
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