package animalfactory.states;

import animalfactory.Animal;
import animalfactory.HealthStatus;

/**
 * Intake state: Animals in the Intake State have just arrived
 */
public class IntakeState implements AnimalState {
    Animal animal;

    /** Create Intake state
     *
     * @param animal
     */
    public IntakeState(Animal animal) {
        this.animal = animal;
        String animalName = animal.getName();
        String animalSpecies = animal.getSpecies().name();

        System.out.printf("%s the %s has entered the shelter, so it is in the Intake state.\n",
                animalName, animalSpecies);
    }

    /// get state current state name
    @Override
    public String stateName() {
        return "Intake";
    }

    /**
     * animal does an action and then transitions to the next state.
     *
     * @param animal
     */
    @Override
    public void nextState(Animal animal) {
        animal.setShelterState(new AvailableState());

        HealthStatus health = animal.getHealthStatus();
        if (health.equals(HealthStatus.SICK)) {
            animal.sadAction();
        } else if (health == HealthStatus.HEALTHY) {
            animal.indifferentAction();
        }
    }

    //TODO doaction()? if health is sick then display sadaction() else neutral action.
}
