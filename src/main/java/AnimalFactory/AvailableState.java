package AnimalFactory;

public class AvailableState implements AnimalState{
    /// get state current state name
    @Override
    public String stateName() {
        return "Available";
    }

    /**
     * transitions the animal to the next state.
     * @param animal
     */
    @Override
    public void nextState(Animal animal) {
        animal.setShelterState(new PendingState());
    }
}
