package StaffFactory;


abstract public class StaffFactory {

    //I want Ids
    private static int idCounter = 0;
    private final int id;

    public StaffFactory(){
        //Risk is that if factory is called at the same time the value might not be unique.
        id = idCounter++;
    }

    /**
     * Create object from the Staff class
     *
     * @return Staff
     */
    public abstract Staff createStaff();

    /// Get id
    protected int getId(){return id;}


    /**
     * Get random name
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
