import org.junit.*;
import static org.junit.Assert.*;

public class RangerTest {
    public Ranger testRanger = new Ranger("Henry", 33350,"henry2019@gmail.com");
    @Test
    public void Ranger_instantiatesCorrectly_true() {

        assertEquals(true, testRanger instanceof Ranger);
    }
    @Test
    public void getRangerName_rangerInstantiatesWithName_string(){
        assertEquals("Henry",testRanger.getRangerName());
    }
    @Test
    public void getRangerBadgeNo_rangerInstantiatesWithBadgeNo_int(){
        assertEquals(33350,testRanger.getRangerBadgeNo());
    }
    @Test
    public void getRangerEmail_rangerInstantiatesWithEmail_String(){
        assertEquals("henry2019@gmail.com",testRanger.getRangerEmail());
    }

}