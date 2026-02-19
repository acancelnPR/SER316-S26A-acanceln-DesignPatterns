package AnimalFactory;

interface AnimalState {
    /// get state current state name
    String stateName();

    /**
     * transitions the animal to the next state.
     * @param animal
     */
    public void nextState(Animal animal);
}
