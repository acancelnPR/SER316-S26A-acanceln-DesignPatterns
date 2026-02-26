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

/**
 * tests that state actions print properly to the console
 */
public class AnimalStateTest {

    //create buffer to for System to write to.
    private PrintStream originalOut;
    private ByteArrayOutputStream outContent;

    /**
     * sets up the mock console to catch the outputs produced by the methods
     */
    @BeforeEach
    void setUp() {
        originalOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    /**
     * resets the buffer
     */
    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    /**
     * AnimalStateTest- State prints to console
     */
    @Test
    @DisplayName("AnimalStateTest- State prints to console")
    public void testStatePrints() {
        final int age12 = 12;

        Animal animal = new Dog(1, age12, AnimalSpecies.DOG, HealthStatus.HEALTHY);
        animal.setShelterState(new IntakeState(animal));
        assertTrue(outContent.toString().contains("the DOG has entered the shelter, so it is in the Intake state."));

    }

    /**
     * AnimalStateTest- animal state can cycle until the adopted state
     */
    @Test
    @DisplayName("AnimalStateTest- animal state can cycle until the adopted state")
    public void testNextStatesAccurate() {

        final int age12 = 12;

        Animal animal = new Dog(1, age12, AnimalSpecies.DOG, HealthStatus.HEALTHY);
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
