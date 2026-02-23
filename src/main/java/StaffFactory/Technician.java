package StaffFactory;

import AnimalFactory.Animal;
import AnimalFactory.HealthStatus;
import AnimalFactory.States.IntakeState;

/**
 * Create a technician.
 * Job:Advances animal to the available state and transfers the animals to another staff.
 * To either the vet for treatment or counselor if healthy to process adoption.
 */
public class Technician extends Staff {
    private String name;
    private String role;

    /** Create Technician from Staff class
     *
     * @param id
     * @param role
     * @param name
     */
    public Technician(int id, StaffRole role, String name) {
        super(id, role, name);
        this.name = name;
        this.role = role.name();
    }

    /**
     * assign animal to staff
     *
     * @param animal
     * @return
     */
    @Override
    public boolean assignAnimal(Animal animal) {
        int size = getSizeOfAssignedAnimals();

        String animalName = animal.getName();
        String animalSpecies = animal.getSpecies().name();

        if (size <= getANIMALCAPACITY()) {
            assignedAnimals.add(animal);
            animal.setShelterState(new IntakeState(animal));

            System.out.printf("%s, the %s has %s the %s in custody.\n", name, role, animalName, animalSpecies);
            return true;
        } else {
            System.out.println("Animal Capacity is full. Remove animal to create space.");
        }
        return false;
    }


    /**
     * Each staff has a different action. Interact with animal and/or change their state.
     */
    @Override
    public void staffAction(StaffManagement management) {
        int size = getSizeOfAssignedAnimals();
        Animal animal;
        HealthStatus animalHealth;

        Staff vet = management.getActiveVeterinarian();
        Staff counselor = management.getActiveCounselor();

        System.out.println("\n//////////Technician Working//////////\n");

        if (size == 0) {
            System.out.println("Technician does not have any animals to work with. Shift ends early.\n");
            return;
        }

        //decrementing to accommodate for arraylist's remove shift functionality.
        for (int i = size - 1; i >= 0; i--) {
            animal = getAnimal(i);
            animalHealth = animal.getHealthStatus();
            String animalName = animal.getName();
            String animalSpecies = animal.getSpecies().name();

            if (animalHealth.equals(HealthStatus.SICK)) {
                System.out.printf("%s, the %s assigns the Veterinarian on duty %s the %s for treatment.\n",
                        name, role, animalName, animalSpecies);

                animal.nextShelterState();
                vet.assignAnimal(animal);

                this.removeAnimal(i);
            } else {
                System.out.printf("%s, the %s assigns the Counselor on duty %s the %s.\n",
                        name, role, animalName, animalSpecies);

                animal.nextShelterState();
                counselor.assignAnimal(animal);

                this.removeAnimal(i);
            }
        }
    }
}
