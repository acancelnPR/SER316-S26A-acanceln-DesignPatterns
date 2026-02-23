package StaffFactory;

import java.util.ArrayList;

/**
 * Manages active staff and manages shift changes
 */
public class StaffManagement {

    private ArrayList<Staff> staffList;
    private Staff activeVeterinarian;
    private Staff activeCounselor;
    private Staff activeTechnician;

    /**
     * sets active staff
     * @param veterinarian
     * @param counselor
     * @param technician
     */
    public StaffManagement(Staff technician, Staff veterinarian, Staff counselor){
        activeTechnician = technician;
        activeVeterinarian = veterinarian;
        activeCounselor = counselor;
    }

    /// Adds staff to staff list
    public void addStaff(Staff staff){
        staffList.add(staff);
    }

    /// get active technician
    public Staff getActiveTechnician() {
        return activeTechnician;
    }

    /// set active technician
    public void setActiveTechnician(Staff activeTechnician) {
        this.activeTechnician = activeTechnician;
    }

    /// get active technician
    public Staff getActiveCounselor() {
        return activeCounselor;
    }

    /// set active technician
    public void setActiveCounselor(Staff activeCounselor) {
        this.activeCounselor = activeCounselor;
    }

    /// get active technician
    public Staff getActiveVeterinarian() {
        return activeVeterinarian;
    }

    /// set active technician
    public void setActiveVeterinarian(Staff activeVeterinarian) {
        this.activeVeterinarian = activeVeterinarian;
    }

    /**
     * Helps switch shifts, when a staff member is off.
     * @param retiring leaves the shelter.
     * @param starting returns to the shelter. set as active staff.
     */
    public void changeShift(Staff retiring, Staff starting){
        int size = retiring.getSizeOfAssignedAnimals();

        System.out.printf("%s the current %s is taking off work an transfers his animals to %s the %s.\n",
                retiring.getName(), retiring.getROLE().name(), starting.getName(), starting.getROLE().name());

        for (int i = size - 1; i >= 0; i--) {
            // get/remove animal from retiring staff and transfer to starting staff.
            starting.assignAnimal(retiring.removeAnimal(i));
        }

        retiring.setAvailable(false);
        starting.setAvailable(true);

    }
}
