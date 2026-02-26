package staff;


import animalfactory.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * tests functions from the staff package
 */
public class StaffTest {

    StaffFactory technicianFactory = new TechnicianFactory();
    StaffFactory veterinarianFactory = new VeterinerianFactory();
    StaffFactory counselorFactory = new CounselorFactory();


    /**
     * StaffTest- All Staff are created properly by the factories
     */
    @Test
    @DisplayName("StaffTest- All Staff are created properly by the factories")
    public void testFactoriesCreateAnimal() {

        Staff activeTechnician = technicianFactory.createStaff();
        Staff activeVeterinarian = veterinarianFactory.createStaff();
        Staff activeCounselor = counselorFactory.createStaff();

        assertEquals(StaffRole.TECHNICIAN, activeTechnician.getROLE());
        assertEquals(StaffRole.VETERINARIAN, activeVeterinarian.getROLE());
        assertEquals(StaffRole.COUNSELOR, activeCounselor.getROLE());
    }

    /**
     * StaffTest- StaffManagement helps change shifts when staff takes off work
     */
    @Test
    @DisplayName("StaffTest- StaffManagement helps change shifts when staff takes off work")
    public void testStaffManagement() {

        Staff activeTechnician = technicianFactory.createStaff();
        Staff activeVeterinarian = veterinarianFactory.createStaff();
        Staff activeCounselor = counselorFactory.createStaff();

        Staff spareTechnician = technicianFactory.createStaff();

        StaffManagement management = new StaffManagement(activeTechnician, activeVeterinarian, activeCounselor);
        ArrayList<Animal> originalAnimals = activeTechnician.getAssignedAnimals();

        management.changeShift(activeTechnician, spareTechnician);

        assertEquals(originalAnimals, spareTechnician.getAssignedAnimals());
        assertEquals(management.getActiveTechnician().getID(), spareTechnician.getID());

    }

    /**
     * StaffTest- Technician overrides assignsAnimal correctly
     */
    @Test
    @DisplayName("StaffTest- Technician overrides assignsAnimal correctly")
    public void testTechnicianAssignAnimal() {
        Staff activeTechnician = technicianFactory.createStaff();

        AnimalFactory dogFactory = new DogFactory();
        Animal dog = dogFactory.createAnimal();

        assertTrue(activeTechnician.assignAnimal(dog));
    }

    /**
     * StaffTest- Technician does staff action correctly
     */
    @Test
    @DisplayName("StaffTest- Technician does staff action correctly")
    public void testTechnicianStaffAction() {
        Staff activeTechnician = technicianFactory.createStaff();
        Staff activeVeterinarian = veterinarianFactory.createStaff();
        Staff activeCounselor = counselorFactory.createStaff();

        StaffManagement management = new StaffManagement(activeTechnician, activeVeterinarian, activeCounselor);

        final int age12 = 12;
        final int age15 = 15;

        Animal dogH = new Dog(1, age12, AnimalSpecies.DOG, HealthStatus.HEALTHY);
        Animal dogS = new Dog(2, age15, AnimalSpecies.DOG, HealthStatus.SICK);

        activeTechnician.assignAnimal(dogH);
        activeTechnician.assignAnimal(dogS);

        activeTechnician.staffAction(management);

        List<Animal> animals = activeTechnician.getAssignedAnimals();


        assertEquals(animals.size(), activeTechnician.getSizeOfAssignedAnimals());

        assertEquals(1, activeVeterinarian.getSizeOfAssignedAnimals());
        assertEquals(1, activeCounselor.getSizeOfAssignedAnimals());
    }

}
