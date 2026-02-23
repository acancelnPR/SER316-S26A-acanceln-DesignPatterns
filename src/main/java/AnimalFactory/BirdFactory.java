package AnimalFactory;

public class BirdFactory extends AnimalFactory {

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
        AnimalSpecies species = AnimalSpecies.BIRD;

        Animal animal = new Bird(id, age, species, health);

        //set default name
        animal.setName(getRandomName());

        return animal;
    }
}
