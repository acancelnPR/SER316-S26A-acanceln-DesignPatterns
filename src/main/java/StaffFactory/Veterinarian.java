package StaffFactory;

import AnimalFactory.Animal;
import AnimalFactory.HealthStatus;

/**
 * Create a Veterinarian.
 * Job: Takes animals that need treatment. after the animal is cured sends them to the counselor.
 * Does not change animal state, just hands them to counselor
 */
public class Veterinarian extends Staff {
    private String name;
    private String role;

    /** Create Veterinarian from Staff class
     *
     * @param id
     * @param role
     * @param name
     */
    public Veterinarian(int id, StaffRole role, String name) {
        super(id, role, name);
        this.name = name;
        this.role = role.name();
    }

    /**
     * Each staff has a different action. Interact with animal and/or change their state.
     */
    @Override
    public void staffAction(StaffManagement management) {
        int size = getSizeOfAssignedAnimals();
        Animal animal;
        HealthStatus animalHealth;

        Staff counselor = management.getActiveCounselor();

        System.out.println("\n//////////Veterinarian Working//////////\n");
        if (size == 0) {
            System.out.println("Veterinarian does not have any animals to work with. Shift ends early.\n");
            return;
        }

        //decrementing to accommodate for arraylist's remove shift functionality.
        for (int i = size - 1; i >= 0; i--) {
            animal = getAnimal(i);
            animalHealth = animal.getHealthStatus();
            String animalName = animal.getName();
            String animalSpecies = animal.getSpecies().name();

            if (animalHealth.equals(HealthStatus.SICK)) {
                System.out.printf("%s, the %s treats the animal %s the %s and assigns them to the Counselor on duty .\n"
                        , name, role, animalName, animalSpecies);

                animal.setHealthStatus(HealthStatus.HEALTHY);
                counselor.assignAnimal(animal);

                this.removeAnimal(i);
            } else {

                System.out.printf("%s, the %s assigns the Counselor on duty %s the %s.\n",
                        name, role, animalName, animalSpecies);
                counselor.assignAnimal(animal);

                this.removeAnimal(i);
            }
        }
    }
}
