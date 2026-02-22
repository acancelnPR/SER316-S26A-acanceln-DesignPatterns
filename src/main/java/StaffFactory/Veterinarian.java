package StaffFactory;

public class Veterinarian extends Staff{

    public Veterinarian(int id, StaffRole role, String name) {
        super(id, role, name);
    }

    /**
     * Each staff has a different action. Interact with animal and/or change their state.
     */
    @Override
    void staffAction() {

    }
}
