package AnimalFactory.States;

import AnimalFactory.Animal;

/**
 * Available State: Animal in the available state is free to all adopters to inspect,
 * and begin the adoption process if desired. Next State: -> PendingState.
 */
public class AvailableState implements AnimalState{

    /// get state current state name
    @Override
    public String stateName() {
        return "Available";
    }

    /**
     * animal does an action and then transitions to the next state.
     * @param animal
     */
    @Override
    public void nextState(Animal animal) {

        animal.specialAction();



        animal.setShelterState(new PendingState());
    }
}
