package AnimalFactory;

public class Animal {

     private final int ID;
     private final int AGE;
     private String name;
     private final AnimalSpecies species;
     private HealthStatus healthStatus;
     private AnimalState shelterState;

     public Animal(int id, int age, AnimalSpecies species, HealthStatus healthStatus) {
         ID = id;
         AGE = age;
         this.species = species;
         this.healthStatus = healthStatus;
         shelterState = new IntakeState();
     }

     public int getID() {
        return ID;
     }

     public int getAGE() {
        return AGE;
     }

     public String getName() {
            return name;
     }

     public HealthStatus getHealthStatus() {
        return healthStatus;
     }

    /**
     * get animal species
     * @param species AnimalSpecies
     * @return AnimalSpecies
     */
     public AnimalSpecies getSpecies(AnimalSpecies species) {
        return species;
     }

    /**
     * set animal name
     * @param name String
     */
    public void setName(String name) {
            this.name = name;
     }

    /**
     * Set health status for animal. (HEALTHY, SICK)
     * @param healthStatus HealthStatus
     */
    public void setHealthStatus(HealthStatus healthStatus) {
        this.healthStatus = healthStatus;
    }

    /** Set shelter state of the animal: IntakeState, AvailableState, PendingState, and AdoptedState
     *
     * @param state AnimalState
     */
    void setShelterState(AnimalState state){
         shelterState = state;
    }

}
