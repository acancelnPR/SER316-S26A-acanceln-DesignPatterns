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
        //TODO(R1.a): create 5 animals w/ basic attributes

        setUp();


        //1-based index
        //Shelter Simulation Loop
        for (day = 1; day <= 1; day++) {//TODO change limit to WEEK.
            activeTechnician.staffAction(staffManagement);
            activeVeterinarian.staffAction(staffManagement);
            activeCounselor.staffAction(staffManagement);
        }
    }

    /**
     * instantiates Staff variables
     * Creates the staring 5 Animals and assigns them to active technician.
     */
    static void setUp(){
        activeTechnician = technicianFactory.createStaff();
        activeVeterinarian = veterinerianFactory.createStaff();
        activeCounselor = counselorFactory.createStaff();

        staffManagement = new StaffManagement(activeTechnician, activeVeterinarian, activeCounselor);

        activeTechnician.assignAnimal(dogFactory.createAnimal());
    }


    /**Helper method to select which factory to use when creating the animal the will "arrive" to the shelter based on the day.
     *
     * @param day
     * @return
     */
    static Animal createAnimal(int day){
        day = day % 7;

        final int MONDAY = 1;
        final int TUESDAY = 2;
        final int WEDNESDAY = 3;
        final int THURSDAY = 4;
        final int FRIDAY = 5;
        final int SATURDAY = 6;
        final int SUNDAY = 7;

        switch (day) {
            case (MONDAY) -> {
                return dogFactory.createAnimal();
            }
            default -> {
                System.err.println("Expected a day of the week.");
                return null;
            }
        }
    }

    /// get day of the week or current interval of the simulation.
    /// @return int
    public int getDay() {return day;}


    String test_build(boolean val) {
        if (val){
            return "Hello World";
        }
        return "Bye World";
    }

}
