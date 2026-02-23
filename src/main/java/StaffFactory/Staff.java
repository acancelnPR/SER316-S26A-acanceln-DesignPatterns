package StaffFactory;

import AnimalFactory.Animal;

import java.util.ArrayList;

//TODO create staff factory
abstract public class Staff {

    private final int ID;
    private String name;
    private boolean available; // staff availability
    private final StaffRole ROLE;

    private final int ANIMALCAPACITY = 10; // Max assigned animal capacity for any staff member.
    private ArrayList<Animal> assignedAnimals;



    public Staff(int id, StaffRole role, String name) {
        ID = id;
        ROLE = role;
        this.name = name;
        assignedAnimals = new ArrayList<>(ANIMALCAPACITY);
    }

    //GETTERS
    public int getID() {
        return ID;
    }
    /// ghet staff name
    public String getName() {
        return name;
    }
    /// is staff available?
    public boolean isAvailable() {
        return available;
    }
    /// get staff role
    public StaffRole getROLE() {
        return ROLE;
    }
    /// get animal capacity for staff
    public int getANIMALCAPACITY() {
        return ANIMALCAPACITY;
    }
    ///get the assigned animals in array list
    public ArrayList<Animal> getAssignedAnimals() {
        return new ArrayList<>(assignedAnimals);
    }
    /// Get specific animal at index
    public Animal getAnimal(int index){return assignedAnimals.get(index);}
    /// get the current count of animals assigned
    public int getSizeOfAssignedAnimals() {
        return assignedAnimals.size();
    }


    /// Set availability
    public void setAvailable(boolean val){
        available = val;
    }

    /**assign animal to staff
     *
     * @param animal
     */
    public void assignAnimal(Animal animal){
        int size = getSizeOfAssignedAnimals();

        if (size <= ANIMALCAPACITY){
            assignedAnimals.add(animal);
        }
        System.out.println("Animal Capacity is full. Remove animal to create space.");
    }

    /**
     * Remove Animal from the staff's map.
     * @param index int
     * @return Animal or null if not found
     */
    public Animal removeAnimal(int index){
        Animal removedAnimal = assignedAnimals.get(index);
        if(removedAnimal == null) {
            System.out.println("Could not find animal at index.");
            return removedAnimal;
        }

        assignedAnimals.remove(index);

        return removedAnimal;
    }

    /**
     * Each staff has a different action. Interact with animal and/or change their state.
     */
    public abstract void staffAction(StaffManagement management);
}
