package homework.lesson05;

import homework.lesson05.animals.*;

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog(500, 10, 0.5f, "Песик");
        Cat cat = new Cat(200, 2, "Кот");
        Horse horse = new Horse(1500, 100, 3, "Конь");
        Bird bird = new Bird(5, 0.2f, "Птица");

        Animal[] animal = {dog, cat, horse, bird};

        for (int i = 0; i < animal.length; i++) {
            animal[i].run(250);
            animal[i].jump(0.45f);
            animal[i].swim(100);
        }

    }

}
