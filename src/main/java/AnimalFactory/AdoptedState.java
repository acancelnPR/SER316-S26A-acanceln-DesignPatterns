package AnimalFactory;

public class AdoptedState implements AnimalState{
    /// get state current state name
    @Override
    public String stateName() {
        return "Adopted";
    }

    /**
     * transitions the animal to the next state.
     *
     * @param animal
     */
    @Override
    public void nextState(Animal animal) {
        throw new IllegalStateException("Once adopted, animal does not change states");
    }
}
