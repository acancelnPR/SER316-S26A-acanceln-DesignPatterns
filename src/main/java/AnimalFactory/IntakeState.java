package AnimalFactory;

/**
 * Intake state: Animals in the Intake State have just arrived
 */
public class IntakeState implements AnimalState{

    /// get state current state name
    @Override
    public String stateName() {
        return "Intake";
    }

    /**
     * animal does an action and then transitions to the next state.
     * @param animal
     */
    @Override
    public void nextState(Animal animal) {
        HealthStatus health = animal.getHealthStatus();
        if (health.equals(HealthStatus.SICK)){
            animal.sadAction();
        } else if (health == HealthStatus.HEALTHY) {
            animal.indifferentAction();
        }

        animal.setShelterState(new AvailableState());
    }

    //TODO doaction()? if health is sick then display sadaction() else neutral action.
}
