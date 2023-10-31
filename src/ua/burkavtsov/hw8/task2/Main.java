package ua.burkavtsov.hw8.task2;

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();
        Animal animal3 = new Animal();
        animal1.setHoursOfSleeping(8);
        animal1.setKindOFood("Dog");
        animal2.setHoursOfSleeping(10);
        animal2.setKindOFood("Rabbit");
        animal3.setHoursOfSleeping(12);
        animal3.setKindOFood("Cat");

        Animal animalWithMostSleep = findAnimalWithMostSleep(animal1, animal2, animal3);

        if (animalWithMostSleep != null) {
            System.out.println("Animal with the most hours of sleep eats: " + animalWithMostSleep.getKindOFood());
        }
    }

    public static Animal findAnimalWithMostSleep(Animal animal1, Animal animal2, Animal animal3) {
        Animal animalWithMostSleep = animal1;
        if (animal2.getHoursOfSleeping() > animalWithMostSleep.getHoursOfSleeping()) {
            animalWithMostSleep = animal2;
        }
        if (animal3.getHoursOfSleeping() > animalWithMostSleep.getHoursOfSleeping()) {
            animalWithMostSleep = animal3;
        }

        return animalWithMostSleep;
    }
}
