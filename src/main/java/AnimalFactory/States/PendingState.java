package AnimalFactory.States;

import AnimalFactory.Animal;

public class PendingState implements AnimalState {


    /// get state current state name
    @Override
    public String stateName() {
        return "Pending";
    }

    /**
     * animal does an action and then transitions to the next state.
     *
     * @param animal
     */
    @Override
    public void nextState(Animal animal) {

        animal.setShelterState(new AdoptedState());

        animal.happyAction();
    }
}
