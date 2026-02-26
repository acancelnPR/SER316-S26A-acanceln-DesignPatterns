package staff;

public class CounselorFactory extends StaffFactory {

    /**
     * Create Counselor from the Staff class
     *
     * @return Staff
     */
    @Override
    public Staff createStaff() {
        int id = getId();
        String name = getRandomName();

        return new Counselor(id, StaffRole.COUNSELOR, name);
    }
}
