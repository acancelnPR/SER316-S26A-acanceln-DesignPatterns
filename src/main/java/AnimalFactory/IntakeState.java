package AnimalFactory;

public class IntakeState implements AnimalState{
    /// get state current state name
    @Override
    public String stateName() {
        return "Intake";
    }

    /**
     * transitions the animal to the next state.
     * @param animal
     */
    @Override
    public void nextState(Animal animal) {
        animal.setShelterState(new AvailableState());
    }
}
