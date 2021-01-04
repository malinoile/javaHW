package homework.lesson05.animals;

public class Cat extends Animal {

    public Cat(float maxRunDistance, float maxJumpHeight, String name) {
        super(maxRunDistance, 0, maxJumpHeight, name);
    }
    public void swim(float distance) {
        System.out.println(name + ", к сожалению, утонул");
    }
}
