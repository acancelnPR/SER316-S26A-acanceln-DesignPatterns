package AnimalFactory;

public class Cat extends Animal {
    /** Creates cat object from animal class
     *
     * @param id
     * @param age
     * @param species
     * @param healthStatus
     */
    public Cat(int id, int age, AnimalSpecies species, HealthStatus healthStatus) {
        super(id, age, species, healthStatus);
    }

    /**
     * perform sad action.
     */
    @Override
    public void sadAction() {
        System.out.printf("%s the %s is in the %s state and \"Purrs\" sadly.\n",
                getName(), getSpecies().name(), getShelterState());
    }

    /**
     * perform unique animal action.
     */
    @Override
    public void specialAction() {
        System.out.printf("%s the %s is in the %s state and cleans its body with its tongue.\n",
                getName(), getSpecies().name(), getShelterState());
    }

    /**
     * perform happy action.
     */
    @Override
    public void happyAction() {
        System.out.printf("%s the %s is in the %s state and \"Meows\" Excitedly!\n",
                getName(), getSpecies().name(), getShelterState());
    }
}
