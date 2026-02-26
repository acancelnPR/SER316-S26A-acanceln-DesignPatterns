import animalfactory.*;
import StaffFactory.*;


public class Main {

    static private final int week = 7;
    //number of day the simulation is running
    static private int day;

    //instantiate factories
    static AnimalFactory dogFactory = new DogFactory();
    static AnimalFactory catFactory = new CatFactory();
    static AnimalFactory snakeFactory = new SnakeFactory();
    static AnimalFactory birdFactory = new BirdFactory();
    static AnimalFactory turtleFactory = new TurtleFactory();
    static AnimalFactory hamsterFactory = new HamsterFactory();
    static AnimalFactory fishFactory = new FishFactory();

    static StaffFactory technicianFactory = new TechnicianFactory();
    static StaffFactory veterinarianFactory = new VeterinerianFactory();
    static StaffFactory counselorFactory = new CounselorFactory();

    static StaffManagement staffManagement;
    static Staff activeTechnician;
    static Staff activeVeterinarian;
    static Staff activeCounselor;
    static Staff backupTechnician;
    static Staff backupVeterinarian;
    static Staff backupCounselor;


    /**Runs a simulation about a pet shelter over a week.
     * Where each day is one interval.
     *
     * @param args
     */
    public static void main(String[] args) {
        final int moduloWeek = 8;
        final int wednesday = 3;
        final int thursday = 4;
        final int friday = 5;

        setUp();


        //1-based index
        //Shelter Simulation Loop
        for (day = 1; day <= week; day++) {
            System.out.printf("\n///Pet Shelter Day %d\\\\\\\n", day);

            //on Wednesday Technicians change shifts.
            if ((day % moduloWeek) == wednesday) {
                staffManagement.changeShift(activeTechnician, backupTechnician);
            } else if ((day % moduloWeek) == thursday) {
                //on Thursdays veterinarians change shifts.
                staffManagement.changeShift(activeVeterinarian, backupVeterinarian);
            } else if ((day % moduloWeek) == friday) {
                //on Fridays Counselors change shifts.
                staffManagement.changeShift(activeCounselor, backupCounselor);
            }

            activeCounselor.staffAction(staffManagement);
            activeVeterinarian.staffAction(staffManagement);
            activeTechnician.staffAction(staffManagement);

            //Animal arrives to the shelter
            activeTechnician.assignAnimal(createAnimal(day));
        }
    }

    /**
     * instantiates Staff variables
     * Creates the staring 5 Animals and assigns them to active technician.
     */
    static void setUp() {
        activeTechnician = technicianFactory.createStaff();
        activeVeterinarian = veterinarianFactory.createStaff();
        activeCounselor = counselorFactory.createStaff();
        backupTechnician = technicianFactory.createStaff();
        backupVeterinarian = veterinarianFactory.createStaff();
        backupCounselor = counselorFactory.createStaff();

        staffManagement = new StaffManagement(activeTechnician, activeVeterinarian, activeCounselor);

        activeTechnician.assignAnimal(dogFactory.createAnimal());
    }


    /**Helper method to select which factory to use when
     *  creating the animal the will "arrive" to the shelter based on the day.
     *
     * @param day
     * @return
     */
    static Animal createAnimal(int day) {
        final int moduloWeek = 7;
        final int dayOfTheWeek = day % moduloWeek;
        System.out.println();

        final int MONDAY = 0;
        final int TUESDAY = 1;
        final int WEDNESDAY = 2;
        final int THURSDAY = 3;
        final int FRIDAY = 4;
        final int SATURDAY = 5;
        final int SUNDAY = 6;


        //add newline to make it easier to read the console.
        System.out.println();
        switch (dayOfTheWeek) {
            case (MONDAY) -> {
                return dogFactory.createAnimal();
            }
            case (TUESDAY) -> {
                return catFactory.createAnimal();
            }
            case (WEDNESDAY) -> {
                return hamsterFactory.createAnimal();
            }
            case (THURSDAY) -> {
                return fishFactory.createAnimal();
            }
            case (FRIDAY) -> {
                return snakeFactory.createAnimal();
            }
            case (SATURDAY) -> {
                return turtleFactory.createAnimal();
            }
            case (SUNDAY) -> {
                return birdFactory.createAnimal();
            }
            default -> {
                System.err.println("Expected a day of the week.");
                return null;
            }
        }
    }

    /// get day of the week or current interval of the simulation.
    /// @return int
    public int getDay() {
        return day;
    }


    String testBuild(boolean val) {
        if (val) {
            return "Hello World";
        }
        return "Bye World";
    }

}
