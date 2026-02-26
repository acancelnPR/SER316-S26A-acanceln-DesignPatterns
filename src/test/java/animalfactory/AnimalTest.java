package animalfactory;

import animalfactory.states.AdoptedState;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnimalTest {
    AnimalFactory dogFactory = new DogFactory();
    AnimalFactory catFactory = new CatFactory();
    AnimalFactory snakeFactory = new SnakeFactory();
    AnimalFactory birdFactory = new BirdFactory();
    AnimalFactory turtleFactory = new TurtleFactory();
    AnimalFactory hamsterFactory = new HamsterFactory();
    AnimalFactory fishFactory = new FishFactory();

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
     * AnimalTest- All animals are created properly by the factories
     */
    @Test
    @DisplayName("AnimalTest- All animals are created properly by the factories")
    public void testFactoriesCreateAnimal() {

        Animal dog = dogFactory.createAnimal();
        Animal cat = catFactory.createAnimal();
        Animal snake = snakeFactory.createAnimal();
        Animal turtle = turtleFactory.createAnimal();
        Animal bird = birdFactory.createAnimal();
        Animal hamster = hamsterFactory.createAnimal();
        Animal fish = fishFactory.createAnimal();

        assertEquals(AnimalSpecies.DOG, dog.getSpecies());
        assertEquals(AnimalSpecies.CAT, cat.getSpecies());
        assertEquals(AnimalSpecies.SNAKE, snake.getSpecies());
        assertEquals(AnimalSpecies.TURTLE, turtle.getSpecies());
        assertEquals(AnimalSpecies.BIRD, bird.getSpecies());
        assertEquals(AnimalSpecies.HAMSTER, hamster.getSpecies());
        assertEquals(AnimalSpecies.FISH, fish.getSpecies());

    }

    /**
     * test that all animals produce expected output
     * Kind of a god test, but I was running out of time
     */
    @Test
    @DisplayName("AnimalTest- All animals have the correct sadAction()")
    public void testConcreteAnimalActions() {
        Animal dog = dogFactory.createAnimal();
        Animal cat = catFactory.createAnimal();
        Animal snake = snakeFactory.createAnimal();
        Animal turtle = turtleFactory.createAnimal();
        Animal bird = birdFactory.createAnimal();
        Animal hamster = hamsterFactory.createAnimal();
        Animal fish = fishFactory.createAnimal();

        dog.setShelterState(new AdoptedState());
        cat.setShelterState(new AdoptedState());
        snake.setShelterState(new AdoptedState());
        turtle.setShelterState(new AdoptedState());
        bird.setShelterState(new AdoptedState());
        hamster.setShelterState(new AdoptedState());
        fish.setShelterState(new AdoptedState());

        dog.sadAction();
        assertTrue(outContent.toString().contains(" state and \"Ruffs\" sadly."));
        resetBuffer();

        cat.sadAction();
        assertTrue(outContent.toString().contains(" state and \"Purrs\" sadly."));
        resetBuffer();

        snake.sadAction();
        assertTrue(outContent.toString().contains(" state and \"hisses\"."));
        resetBuffer();

        turtle.sadAction();
        assertTrue(outContent.toString().contains(" state and does \"turtle\" stuff sadly."));
        resetBuffer();
        bird.sadAction();
        assertTrue(outContent.toString().contains(" state and \"chirps\" sadly."));
        resetBuffer();

        hamster.sadAction();
        assertTrue(outContent.toString().contains(" state and does hamster noises sadly."));
        resetBuffer();

        fish.sadAction();
        assertTrue(outContent.toString().contains(" state and \"swims\" sadly."));

    }

    /**
     * resets buffer so ByteArray can take in a fresh string
     */
    private void resetBuffer() {
        System.setOut(originalOut);
        originalOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }
}
