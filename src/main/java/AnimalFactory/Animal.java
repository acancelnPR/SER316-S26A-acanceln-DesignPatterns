package AnimalFactory;

abstract public class Animal {

     private final int ID;
     private final int AGE;
     private String name;
     private final AnimalSpecies species;
     private HealthStatus healthStatus;
     private AnimalState shelterState;//TODO maybe I should have protected visibility? Revisit.

     public Animal(int id, int age, AnimalSpecies species, HealthStatus healthStatus) {
         ID = id;
         AGE = age;
         this.species = species;
         this.healthStatus = healthStatus;
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
     * @return AnimalSpecies
     */
     public AnimalSpecies getSpecies() {
        return species;
     }

     /// get shelter state of the animal
     public String getShelterState(){
         return shelterState.stateName();
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

    //TODO create various methods for state design to interact with

    /**
     * perform sad action.
     */
    abstract void sadAction();

    /// Generic indifferent action
    public void indifferentAction(){
        System.out.printf("%s the %s is in the %s and acts indifferent.\n",
                name, species.name(), shelterState.stateName());
    }

    /**
     * perform happy action.
     */
    abstract void happyAction();

}
