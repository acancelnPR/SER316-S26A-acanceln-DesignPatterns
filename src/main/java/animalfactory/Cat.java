package animalfactory;

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
     *
     * @return
     */
    @Override
    public boolean sadAction() {
        System.out.printf("%s the %s is in the %s state and \"Purrs\" sadly.%n",
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
        System.out.printf("%s the %s is in the %s state and cleans its body with its tongue.%n",
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
        System.out.printf("%s the %s is in the %s state and \"Meows\" Excitedly!%n",
                getName(), getSpecies().name(), getShelterState());
        return true;
    }
}
