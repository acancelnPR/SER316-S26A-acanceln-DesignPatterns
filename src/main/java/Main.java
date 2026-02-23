import AnimalFactory.*;
import StaffFactory.*;


public class Main {

    static private final int WEEK = 7;
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
    static StaffFactory veterinerianFactory = new VeterinerianFactory();
    static StaffFactory counselorFactory = new CounselorFactory();

    static StaffManagement staffManagement;
    static Staff activeTechnician;
    static Staff activeVeterinarian;
    static Staff activeCounselor;


    /**Runs a simulation about a pet shelter over a week.
     * Where each day is one interval.
     *
     * @param args
     */
    public static void main(String[] args) {
        final int WEEK = 7;
        //TODO(R1.a): create 5 animals w/ basic attributes

        setUp();


        //1-based index
        //Shelter Simulation Loop
        for (day = 1; day <= WEEK; day++) {
            System.out.printf("\n///Pet Shelter Day %d\\\\\\.\n", day);
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
        activeVeterinarian = veterinerianFactory.createStaff();
        activeCounselor = counselorFactory.createStaff();

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
        final int moduloVal = 8;
        day = day % moduloVal;

        final int MONDAY = 1;
        final int TUESDAY = 2;
        final int WEDNESDAY = 3;
        final int THURSDAY = 4;
        final int FRIDAY = 5;
        final int SATURDAY = 6;
        final int SUNDAY = 7;


        //add newline to make it easier to read the console.
        System.out.println();
        switch (day) {
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
