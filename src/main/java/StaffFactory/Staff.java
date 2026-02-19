package StaffFactory;

import AnimalFactory.Animal;
import AnimalFactory.IntakeState;

import java.util.HashMap;


abstract public class Staff {

    private final int ID;
    private String name;
    private boolean available; // staff availability
    private final StaffRole ROLE;

    private final int ANIMALCAPACITY = 10; // Max assigned animal capacity for any staff member.
    private HashMap<Integer, Animal> assignedAnimals;



    public Staff(int id, StaffRole role) {
        ID = id;
        ROLE = role;
    }
    //GETTERS
    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return available;
    }

    public StaffRole getROLE() {
        return ROLE;
    }

    public int getANIMALCAPACITY() {
        return ANIMALCAPACITY;
    }

    public HashMap<Integer, Animal> getAssignedAnimals() {
        return new HashMap<>(assignedAnimals);
    }

    public int getSizeOfAssignedAnimals() {
        return assignedAnimals.size();
    }

    /**assign animal to staff
     *
     * @param animal
     */
    public void assignAnimal(Animal animal){
        int size = getSizeOfAssignedAnimals();

        if (size <= ANIMALCAPACITY){
            int key = animal.getID();

            assignedAnimals.put(key, animal);
        }
        System.out.println("Animal Capacity is full. Remove animal to create space.");
    }

    /**
     * Remove Animal from the staff's map.
     * @param id int
     * @return Animal or null if not found
     */
    public Animal removeAnimal(int id){
        Animal removedAnimal = assignedAnimals.get(id);
        if(removedAnimal == null) {
            System.out.println("Could not find animal ID.");
            return removedAnimal;
        }

        assignedAnimals.remove(id);

        return removedAnimal;
    }

    /**
     * Each staff ahs a different action. Interact with animal and change their state.
     */
    abstract void staffAction();
}
