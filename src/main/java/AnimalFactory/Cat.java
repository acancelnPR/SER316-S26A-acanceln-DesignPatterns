package AnimalFactory;

public class Cat extends Animal{

    public Cat(int id, int age, AnimalSpecies species, HealthStatus healthStatus) {
        super(id, age, species, healthStatus);
    }

    /**
     * perform sad action.
     */
    @Override
    void sadAction() {
        System.out.printf("%s the %s is in the %s and \"Purrs\" sadly.\n",
                getName(), getSpecies().name(), getShelterState());
    }

    /**
     * perform unique animal action.
     */
    @Override
    void specialAction() {
        System.out.printf("%s the %s is in the %s and cleans its body with its tongue.\n",
                getName(), getSpecies().name(), getShelterState());
    }

    /**
     * perform happy action.
     */
    @Override
    void happyAction() {
        System.out.printf("%s the %s is in the %s and \"Meows\" Excitedly!\n",
                getName(), getSpecies().name(), getShelterState());
    }
}
