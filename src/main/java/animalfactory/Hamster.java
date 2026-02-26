package animalfactory;

public class Hamster extends Animal {
    /** Creates hamster object from animal class
     *
     * @param id
     * @param age
     * @param species
     * @param healthStatus
     */
    public Hamster(int id, int age, AnimalSpecies species, HealthStatus healthStatus) {
        super(id, age, species, healthStatus);
    }

    /**
     * perform sad action.
     *
     * @return
     */
    @Override
    public boolean sadAction() {
        System.out.printf("%s the %s is in the %s state and does hamster noises sadly.%n",
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
        System.out.printf("%s the %s is in the %s state and wags its hamster butt.%n",
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
        System.out.printf("%s the %s is in the %s state and does hamster noises happily!%n",
                getName(), getSpecies().name(), getShelterState());
        return true;
    }
}
