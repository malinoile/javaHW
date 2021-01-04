package homework.lesson05.animals;

public class Bird extends Animal {

    public Bird(float maxRunDistance, float maxJumpHeight, String name) {
        super(maxRunDistance, 0, maxJumpHeight, name);
    }

    public void run(float distance) {
        System.out.println((maxRunDistance >= distance) ?
                name + " успешно пробежала " + distance + "м!" :
                name + " пробежала " + maxRunDistance + "м и упала от усталости");
    }
    public void swim(float distance) {
        System.out.println(name + ", к сожалению, утонула");
    }
    public void jump(float height) {
        System.out.println((maxJumpHeight >= height) ?
                name + " перепрыгнула преграду в " + height + "м!" :
                name + " не смогла перепрыгнуть препятствие");
    }
}
