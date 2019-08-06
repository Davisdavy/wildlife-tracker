import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    public Endangered testEndangered = new Endangered("Elephant","Okay","Young");
    @Test
    public void animal_instantiatesCorrectly() {
        assertNotNull(testEndangered);
    }
    @Test
    public void getThreatType_Endangered()
    {
        assertEquals("Endangered" , Endangered.getThreatType());
    }
    @Test
    public void endanger_getName_Lion() {
        assertEquals("Elephant", testEndangered.getName());
    }
    @Test
    public void endangered_getHealth_Okay() {
        assertEquals("Okay", testEndangered.getHealth());
    }
    @Test
    public void endangered_getTheAge_Old() {
        assertEquals("Young", testEndangered.getAge());
    }
    @Test
    public void save_assignsIdToObject() {
        int originalid=testEndangered.getId();
        testEndangered.save();
        int savedid= testEndangered.getId();
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
        assertNotEquals(testEndangered, location);
    }





}