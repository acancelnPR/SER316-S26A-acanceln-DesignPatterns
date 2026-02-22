package AnimalFactory;

public class Hamster extends Animal{

    public Hamster(int id, int age, AnimalSpecies species, HealthStatus healthStatus) {
        super(id, age, species, healthStatus);
    }

    /**
     * perform sad action.
     */
    @Override
    void sadAction() {
        System.out.printf("%s the %s is in the %s and does hamster noises sadly.\n",
                getName(), getSpecies().name(), getShelterState());
    }

    /**
     * perform unique animal action.
     */
    @Override
    void specialAction() {
        System.out.printf("%s the %s is in the %s and wags its hamster butt.\n",
                getName(), getSpecies().name(), getShelterState());
    }

    /**
     * perform happy action.
     */
    @Override
    void happyAction() {
        System.out.printf("%s the %s is in the %s and does hamster noises happily!\n",
                getName(), getSpecies().name(), getShelterState());
    }
}
