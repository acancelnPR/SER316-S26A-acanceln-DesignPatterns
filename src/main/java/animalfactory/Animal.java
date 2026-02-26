package animalfactory;

import animalfactory.states.AnimalState;

/**
 * template for Animal object in the shelter simulation
 */
abstract public class Animal {

    private final int id;
    private final int age;
    private String name;
    private final AnimalSpecies species;
    private HealthStatus healthStatus;
    private AnimalState shelterState;

    /**Creates animal object
     *
     * @param id
     * @param age
     * @param species
     * @param healthStatus
     */
    public Animal(int id, int age, AnimalSpecies species, HealthStatus healthStatus) {
        this.id = id;
        this.age = age;
        this.species = species;
        this.healthStatus = healthStatus;
        shelterState = null;
    }

    public int getID() {
        return id;
    }

    public int getAGE() {
        return age;
    }

    public String getName() {
        return name;
    }

    public HealthStatus getHealthStatus() {
        return healthStatus;
    }

    /**
     * get animal species
     *
     * @return AnimalSpecies
     */
    public AnimalSpecies getSpecies() {
        return species;
    }

    /// get shelter state of the animal
    public String getShelterState() {
        return shelterState.stateName();
    }

    /**
     * set animal name
     *
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set health status for animal. (HEALTHY, SICK)
     *
     * @param healthStatus HealthStatus
     */
    public void setHealthStatus(HealthStatus healthStatus) {
        this.healthStatus = healthStatus;
    }

    /**
     * Set shelter state of the animal: IntakeState, AvailableState, PendingState, and AdoptedState
     *
     * @param state AnimalState
     */
    public void setShelterState(AnimalState state) {
        shelterState = state;
    }

    /**
     * Sets the next state automatically according to the order Intake -> Available -> Pending -> Adopted
     */
    public void nextShelterState() {
        shelterState.nextState(this);
    }

    /**
     * perform sad action.
     *
     * @return true if successful at printing action to console
     */
    public abstract boolean sadAction();

    /** Generic indifferent action
     *
     */
    public void indifferentAction() {
        System.out.printf("%s the %s is in the %s state and acts indifferent.\n",
                name, species.name(), shelterState.stateName());
    }

    /**
     * perform unique animal action.
     *
     * @return true if successful at printing action to console
     */
    public abstract boolean specialAction();

    /**
     * perform happy action.
     *
     * @return true if successful at printing action to console
     */
    public abstract boolean happyAction();

}
