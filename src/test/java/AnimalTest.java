import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public  class AnimalTest {
    public Animal testAnimal= new Animal("Wolf", 33350);

    @Test
    public void Animal_instantiatesCorrectly_true() {

        assertEquals(true, testAnimal instanceof Animal);
    }

    @Test
    public void getAnimalName_rangerInstantiatesWithName_string() {
        assertEquals("Wolf", testAnimal.getAnimalName());
    }


    @Test
    public void getAnimalId_rangerInstantiatesWithEmail_int() {
        assertEquals(33350, testAnimal.getAnimalId());
    }

    // Overriding equal()
    @Test
    public void equal_returnsTrueIfNameEmailBadgeNoAreSame_true() {
        Animal firstAnimal = new Animal("Wolf", 33350);
        Animal anotherAnimal = new Animal("Wolf", 33350);
        assertTrue(firstAnimal.equals(anotherAnimal));
    }

    //Database setup


}