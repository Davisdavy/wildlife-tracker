import org.junit.*;
import static org.junit.Assert.*;

public class RangerTest {

    @Test
    public void person_instantiatesCorrectly_true() {
        Ranger testRanger = new Ranger("Henry", 33350,"henry2019@gmail.com");
        assertEquals(true, testRanger instanceof Ranger);
    }

}