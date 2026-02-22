package AnimalFactory;

public class FishFactory extends AnimalFactory{

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
        AnimalSpecies species = AnimalSpecies.FISH;

        Animal animal = new Fish(id, age, species, health);

        //set default name
        animal.setName(getRandomName());

        return animal;
    }
}
