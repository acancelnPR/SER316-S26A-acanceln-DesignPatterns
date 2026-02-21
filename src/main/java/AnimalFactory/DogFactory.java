package AnimalFactory;

public class DogFactory extends AnimalFactory{

    /**
     * Create object from the Animal class
     *
     * @return Animal
     */
    @Override
    Animal createAnimal() {
        int id = getId();
        int age = getAge();
        HealthStatus health = getHealthStatus();
        AnimalSpecies species = AnimalSpecies.DOG;

        Animal animal = new Dog(id, age, species, health);

        //set default name
        animal.setName(getRandomName());

        return animal;
    }
}
