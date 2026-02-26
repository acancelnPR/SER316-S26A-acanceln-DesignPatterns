package staff;

public class TechnicianFactory extends StaffFactory {

    /**
     * Create TECHNICIAN from the Staff class
     *
     * @return Staff
     */
    @Override
    public Staff createStaff() {
        int id = getId();
        String name = getRandomName();

        return new Technician(id, StaffRole.TECHNICIAN, name);
    }
}
