package animalfactory.states;

import animalfactory.Animal;
import animalfactory.AnimalSpecies;
import animalfactory.Dog;
import animalfactory.HealthStatus;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnimalStateTest {

    private PrintStream originalOut;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        originalOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }


    @Test
    @DisplayName("AnimalStateTest- State prints to console")
    public void testStatePrints(){

        Animal animal = new Dog(1, 12, AnimalSpecies.DOG, HealthStatus.HEALTHY);
        animal.setShelterState(new IntakeState(animal));
        assertTrue(outContent.toString().contains("the DOG has entered the shelter, so it is in the Intake state.\n"));

    }

    @Test
    @DisplayName("AnimalStateTest- animal state can cycle until the adopted state")
    public void testNextStatesAccurate(){

        Animal animal = new Dog(1, 12, AnimalSpecies.DOG, HealthStatus.HEALTHY);
        animal.setShelterState(new IntakeState(animal));
        assertEquals("Intake", animal.getShelterState());
        animal.nextShelterState();
        assertEquals("Available", animal.getShelterState());
        animal.nextShelterState();
        assertEquals("Pending", animal.getShelterState());
        animal.nextShelterState();
        assertEquals("Adopted", animal.getShelterState());

    }
}
