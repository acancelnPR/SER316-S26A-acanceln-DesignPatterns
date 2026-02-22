package AnimalFactory;

public class Snake extends Animal{

    public Snake(int id, int age, AnimalSpecies species, HealthStatus healthStatus) {
        super(id, age, species, healthStatus);
    }

    /**
     * perform sad action.
     */
    @Override
    void sadAction() {
        System.out.printf("%s the %s is in the %s and \"hisses\".\n",
                getName(), getSpecies().name(), getShelterState());
    }

    /**
     * perform unique animal action.
     */
    @Override
    void specialAction() {
        System.out.printf("%s the %s is in the %s and slithers around curiously.\n",
                getName(), getSpecies().name(), getShelterState());
    }

    /**
     * perform happy action.
     */
    @Override
    void happyAction() {
        System.out.printf("%s the %s is in the %s and \"scuttles\" excitedly!\n",
                getName(), getSpecies().name(), getShelterState());
    }
}
