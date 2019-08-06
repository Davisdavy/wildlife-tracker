import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    public Endangereds testEndangereds = new Endangereds("Elephant","Okay","Young");
    @Test
    public void animal_instantiatesCorrectly() {
        assertNotNull(testEndangereds);
    }
    @Test
    public void getThreatType_Endangered()
    {
        assertEquals("Endangereds" , Endangereds.getThreatType());
    }
    @Test
    public void endanger_getName_Lion() {
        assertEquals("Elephant", testEndangereds.getName());
    }
    @Test
    public void endangered_getHealth_Okay() {
        assertEquals("Okay", testEndangereds.getHealth());
    }
    @Test
    public void endangered_getTheAge_Old() {
        assertEquals("Young", testEndangereds.getAge());
    }
    @Test
    public void save_assignsIdToObject() {
        int originalid= testEndangereds.getId();
        testEndangereds.save();
        int savedid= testEndangereds.getId();
        assertNotEquals(originalid,savedid);
    }
    @Test
    public void findEndangered_true()
    {

    }
    @Test
    public void return_falseNotInstance()
    {
        Location location = new Location("Zone X");
        assertNotEquals(testEndangereds, location);
    }





}