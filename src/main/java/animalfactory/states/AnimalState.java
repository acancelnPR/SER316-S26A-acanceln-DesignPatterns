package animalfactory.states;

import animalfactory.Animal;

/// Common actions for the state the animal is in.
public interface AnimalState {

    /** get state current state name
     *
     * @return String
     */
    public String stateName();

    /**
     * transitions the animal to the next state.
     *
     * @param animal
     */
    public void nextState(Animal animal);
}
