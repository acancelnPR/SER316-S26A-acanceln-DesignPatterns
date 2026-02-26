package animalfactory;

public class Snake extends Animal {
    /** Creates snake object from animal class
     *
     * @param id
     * @param age
     * @param species
     * @param healthStatus
     */
    public Snake(int id, int age, AnimalSpecies species, HealthStatus healthStatus) {
        super(id, age, species, healthStatus);
    }

    /**
     * perform sad action.
     *
     * @return
     */
    @Override
    public boolean sadAction() {
        System.out.printf("%s the %s is in the %s state and \"hisses\".%n",
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
        System.out.printf("%s the %s is in the %s state and slithers around curiously.%n",
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
        System.out.printf("%s the %s is in the %s state and \"scuttles\" excitedly!%n",
                getName(), getSpecies().name(), getShelterState());
        return true;
    }
}
