package StaffFactory;

public class CounselorFactory extends StaffFactory {

    /**
     * Create Counselor from the Staff class
     *
     * @return Staff
     */
    @Override
    Staff createStaff() {
        int id = getId();
        String name = getRandomName();

        return new Veterinarian(id, StaffRole.COUNSELOR, name);
    }
}
