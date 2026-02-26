package animalfactory;

public class Dog extends Animal {
    /** Creates dog object from animal class
     *
     * @param id
     * @param age
     * @param species
     * @param healthStatus
     */
    public Dog(int id, int age, AnimalSpecies species, HealthStatus healthStatus) {
        super(id, age, species, healthStatus);
    }

    /**
     * perform sad action.
     *
     * @return
     */
    @Override
    public boolean sadAction() {
        System.out.printf("%s the %s is in the %s state and \"Ruffs\" sadly.\n",
                getName(), getSpecies().name(), getShelterState());
        return true;
    }

    /**
     * perform unique animal action.
     *
     * @return
     */
    @Override
    public boolean specialAction() {
        System.out.printf("%s the %s is in the %s state and is wagging its tail.\n",
                getName(), getSpecies().name(), getShelterState());
        return true;
    }

    /**
     * perform happy action.
     *
     * @return
     */
    @Override
    public boolean happyAction() {
        System.out.printf("%s the %s is in the %s state and \"Woofs\" Excitedly!\n",
                getName(), getSpecies().name(), getShelterState());
        return true;
    }
}
