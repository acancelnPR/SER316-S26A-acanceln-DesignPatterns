package staff;

import animalfactory.Animal;

import java.util.ArrayList;

//TODO create staff factory
abstract public class Staff {

    private final int id;
    private String name;
    private boolean available; // staff availability
    private final StaffRole staffRole;

    private final int animalCAPACITY = 10; // Max assigned animal capacity for any staff member.
    protected ArrayList<Animal> assignedAnimals;

    /** create new Staff
     *
     * @param id
     * @param role
     * @param name
     */
    public Staff(int id, StaffRole role, String name) {
        this.id = id;
        staffRole = role;
        this.name = name;
        assignedAnimals = new ArrayList<>(animalCAPACITY);
    }

    //GETTERS
    public int getID() {
        return id;
    }

    /// get staff name
    public String getName() {
        return name;
    }

    /// is staff available?
    public boolean isAvailable() {
        return available;
    }

    /// get staff role
    public StaffRole getROLE() {
        return staffRole;
    }

    /// get animal capacity for staff
    public int getANIMALCAPACITY() {
        return animalCAPACITY;
    }

    /// get the assigned animals in array list
    public ArrayList<Animal> getAssignedAnimals() {
        return new ArrayList<>(assignedAnimals);
    }

    /** Get specific animal at index
     *
     * @param index
     * @return
     */
    public Animal getAnimal(int index) {
        return assignedAnimals.get(index);
    }

    /// get the current count of animals assigned
    public int getSizeOfAssignedAnimals() {
        return assignedAnimals.size();
    }


    /// Set availability
    public void setAvailable(boolean val) {
        available = val;
    }

    /**
     * assign animal to staff
     *
     * @param animal
     * @return
     */
    public boolean assignAnimal(Animal animal) {
        int size = getSizeOfAssignedAnimals();

        if (size <= animalCAPACITY) {
            return assignedAnimals.add(animal);
        } else {
            System.out.println("Animal Capacity is full. Remove animal to create space.");
        }
        return false;
    }

    /**
     * Remove Animal from the staff's map.
     *
     * @param index int
     * @return Animal or null if not found
     */
    public Animal removeAnimal(int index) {
        Animal removedAnimal = assignedAnimals.get(index);
        if (removedAnimal == null) {
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
