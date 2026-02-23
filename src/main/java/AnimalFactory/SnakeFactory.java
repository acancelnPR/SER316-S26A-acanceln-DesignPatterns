package AnimalFactory;

public class SnakeFactory extends AnimalFactory {

    /**
     * Create object from the Animal class
     *
     * @return Animal
     */
    @Override
    public Animal createAnimal() {
        int id = getId();
        int age = getAge();
        HealthStatus health = getHealthStatus();
        AnimalSpecies species = AnimalSpecies.SNAKE;

        Animal animal = new Snake(id, age, species, health);

        //set default name
        animal.setName(getRandomName());

        return animal;
    }
}
