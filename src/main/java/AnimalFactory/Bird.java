package AnimalFactory;

public class Bird extends Animal{

    public Bird(int id, int age, AnimalSpecies species, HealthStatus healthStatus) {
        super(id, age, species, healthStatus);
    }

    /**
     * perform sad action.
     */
    @Override
    public void sadAction() {
        System.out.printf("%s the %s is in the %s state and \"chirps\" sadly.\n",
                getName(), getSpecies().name(), getShelterState());
    }

    /**
     * perform unique animal action.
     */
    @Override
    public void specialAction() {
        System.out.printf("%s the %s is in the %s state and flaps its wings.\n",
                getName(), getSpecies().name(), getShelterState());
    }

    /**
     * perform happy action.
     */
    @Override
    public void happyAction() {
        System.out.printf("%s the %s is in the %s state and \"chirps\" Excitedly!\n",
                getName(), getSpecies().name(), getShelterState());
    }
}
