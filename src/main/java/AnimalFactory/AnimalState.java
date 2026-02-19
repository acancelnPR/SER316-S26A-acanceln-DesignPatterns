package AnimalFactory;

/// Common actions for the state the animal is in.
interface AnimalState {

    /// get state current state name
    String stateName();

    /**
     * transitions the animal to the next state.
     * @param animal
     */
    public void nextState(Animal animal);
}
