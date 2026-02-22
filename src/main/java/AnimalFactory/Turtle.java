package AnimalFactory;

public class Turtle extends Animal{

    public Turtle(int id, int age, AnimalSpecies species, HealthStatus healthStatus) {
        super(id, age, species, healthStatus);
    }

    /**
     * perform sad action.
     */
    @Override
    void sadAction() {
        System.out.printf("%s the %s is in the %s and does \"turtle\" stuff sadly.\n",
                getName(), getSpecies().name(), getShelterState());
    }

    /**
     * perform unique animal action.
     */
    @Override
    void specialAction() {
        System.out.printf("%s the %s is in the %s and hides its limbs inside the shell.\n",
                getName(), getSpecies().name(), getShelterState());
    }

    /**
     * perform happy action.
     */
    @Override
    void happyAction() {
        System.out.printf("%s the %s is in the %s and does \"turtle\" stuff Excitedly!\n",
                getName(), getSpecies().name(), getShelterState());
    }
}
