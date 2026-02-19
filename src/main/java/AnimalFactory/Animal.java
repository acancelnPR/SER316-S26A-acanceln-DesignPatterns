package AnimalFactory;

public class Animal {

     private final int ID;
     private final int AGE;
     private String name;
     private AnimalSpecies species;
     private HealthStatus healthStatus;
     private AnimalState shelterState;

     public Animal(int id, int age, AnimalSpecies species, HealthStatus healthStatus) {
         ID = id;
         AGE = age;
         this.species = species;
         this.healthStatus = healthStatus;
         shelterState = new IntakeState();
     }

     void setShelterState(AnimalState state){shelterState = state;}

}
