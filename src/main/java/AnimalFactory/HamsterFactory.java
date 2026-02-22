package AnimalFactory;

public class HamsterFactory extends AnimalFactory{

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
        AnimalSpecies species = AnimalSpecies.HAMSTER;

        Animal animal = new Hamster(id, age, species, health);

        //set default name
        animal.setName(getRandomName());

        return animal;
    }
}
