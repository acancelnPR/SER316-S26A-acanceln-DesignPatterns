package StaffFactory;

import animalfactory.Animal;


/**
 * Create a Counselor.
 * Job: Takes animals and guides them through the proper steps to process adoption.
 */
public class Counselor extends Staff {
    private String name;
    private String role;

    /** Create Counselor from Staff class
     *
     * @param id
     * @param role
     * @param name
     */
    public Counselor(int id, StaffRole role, String name) {
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
        String animalState;


        System.out.println("\n//////////Counselor Working//////////\n");

        if (size == 0) {
            System.out.println("Counselor does not have any animals to work with. Shift ends early.\n");
            return;
        }

        //decrementing to accommodate for arraylist's remove shift functionality.
        for (int i = size - 1; i >= 0; i--) {
            animal = getAnimal(i);
            animalState = animal.getShelterState();

            String animalName = animal.getName();
            String animalSpecies = animal.getSpecies().name();

            if (animalState.equals("Adopted")) {

                System.out.printf("%s, the %s finished the adoption process for %s the %s.\n",
                        name, role, animalName, animalSpecies);
                System.out.printf("%s the %s no longer in the shelter.\n", animalName, animalSpecies);

                this.removeAnimal(i);
            } else {
                System.out.printf("%s, the %s on duty guides %s the %s through the adoption process.\n",
                        name, role, animalName, animalSpecies);

                animal.nextShelterState();


            }
        }
    }
}
