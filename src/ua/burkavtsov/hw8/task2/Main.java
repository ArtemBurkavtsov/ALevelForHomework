package ua.burkavtsov.hw8.task2;

public class Main {
    public static void main(String[] args) {
        Animal dog = new Animal();
        Animal rabbit = new Animal();
        Animal cat = new Animal();
        dog.setHoursOfSleeping(8);
        dog.setKindOFood("Dog");
        rabbit.setHoursOfSleeping(10);
        rabbit.setKindOFood("Rabbit");
        cat.setHoursOfSleeping(12);
        cat.setKindOFood("Cat");

        Animal animalWithMostSleep = findAnimalWithMostSleep(dog, rabbit, cat);

        if (animalWithMostSleep != null) {
            System.out.println("Animal with the most hours of sleep eats: " + animalWithMostSleep.getKindOFood());
        }
    }

    public static Animal findAnimalWithMostSleep(Animal dog, Animal rabbit, Animal cat) {
        Animal animalWithMostSleep = dog;
        if (rabbit.getHoursOfSleeping() > animalWithMostSleep.getHoursOfSleeping()) {
            animalWithMostSleep = rabbit;
        }
        if (cat.getHoursOfSleeping() > animalWithMostSleep.getHoursOfSleeping()) {
            animalWithMostSleep = cat;
        }

        return animalWithMostSleep;
    }
}
