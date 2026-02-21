package AnimalFactory;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * animal factory, with essential methods subclasses must implement
 */
abstract public class AnimalFactory {

    //I want Ids
    private static int idCounter = 0;
    private final int id;

    public AnimalFactory(){
        //Risk is that if factory is called at the same time the value might not be unique.
        id = idCounter++;
    }

    /**
     * Create object from the Animal class
     * @return Animal
     */
    abstract Animal createAnimal();

    /// Get id
    protected int getId(){return id;}

    //The following methods are to help implement the shelter simulation, since interactiveness is not allowed.
    //I left the methods as protected to help with testing

    /**
     * random age generator range: [1, 8]
     */
    protected int getAge(){
        final int MAX = 8;
        final int MIN = 1;
        return (int) (Math.random() * (MAX - MIN + 1) + MIN);
    }

    protected HealthStatus getHealthStatus (){
        final int MAX = 1;
        final int MIN = 0;
        int index = (int) (Math.random() * (MAX - MIN + 1) + MIN);

        if (index == 1) return HealthStatus.HEALTHY;

        return HealthStatus.SICK;
    }

    /**
     * Get random name for the animal
     * @return
     */
    protected String getRandomName(){
        String[] names = {"Bob", "Lucy", "Robert", "Moon", "Legacy", "Rattle", "Pop", "Copper", "Jax", "Lux"};
        final int size = 10;

        final int MAX = size - 1;
        final int MIN = 0;
        int index = (int) (Math.random() * (MAX - MIN + 1) + MIN);

        return names[index];
    }
}
