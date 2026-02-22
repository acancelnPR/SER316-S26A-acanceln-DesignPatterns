package StaffFactory;

public class TechnicianFactory extends StaffFactory {

    /**
     * Create TECHNICIAN from the Staff class
     *
     * @return Staff
     */
    @Override
    Staff createStaff() {
        int id = getId();
        String name = getRandomName();

        return new Veterinarian(id, StaffRole.TECHNICIAN, name);
    }
}
