package animalfactory;

public class Turtle extends Animal {
    /** Creates turtle object from animal class
     *
     * @param id
     * @param age
     * @param species
     * @param healthStatus
     */
    public Turtle(int id, int age, AnimalSpecies species, HealthStatus healthStatus) {
        super(id, age, species, healthStatus);
    }

    /**
     * perform sad action.
     *
     * @return
     */
    @Override
    public boolean sadAction() {
        System.out.printf("%s the %s is in the %s state and does \"turtle\" stuff sadly.%n",
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
        System.out.printf("%s the %s is in the %s state and hides its limbs inside the shell.%n",
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
        System.out.printf("%s the %s is in the %s state and does \"turtle\" stuff Excitedly!%n",
                getName(), getSpecies().name(), getShelterState());
        return true;
    }
}
