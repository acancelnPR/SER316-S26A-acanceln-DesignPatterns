package AnimalFactory;

public class Dog extends Animal{


    public Dog(int id, int age, AnimalSpecies species, HealthStatus healthStatus) {
        super(id, age, species, healthStatus);
    }

    /**
     * perform sad action.
     */
    @Override
    void sadAction() {
        System.out.printf("%s the %s is in the %s and \"Ruffs\" sadly.\n",
                getName(), getSpecies().name(), getShelterState());
    }

    /**
     * perform happy action.
     */
    @Override
    void happyAction() {
        System.out.printf("%s the %s is in the %s and \"Woofs\" Excitedly!\n",
                getName(), getSpecies().name(), getShelterState());
    }
}
