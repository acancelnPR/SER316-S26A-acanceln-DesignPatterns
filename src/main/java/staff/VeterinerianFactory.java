package staff;

public class VeterinerianFactory extends StaffFactory {

    /**
     * Create Veterinarian from the Staff class
     *
     * @return Staff
     */
    @Override
    public Staff createStaff() {
        int id = getId();
        String name = getRandomName();

        return new Veterinarian(id, StaffRole.VETERINARIAN, name);
    }
}
