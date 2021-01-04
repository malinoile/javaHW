package homework.lesson05.animals;

public abstract class Animal {

    protected float maxRunDistance;
    protected float maxSwimDistance;
    protected float maxJumpHeight;
    protected String name;

    public Animal(float maxRunDistance, float maxSwimDistance, float maxJumpHeight, String name) {
        this.maxRunDistance = (float) Math.round(maxRunDistance + (Math.random() * 2 - 1) * maxRunDistance * 0.5f);
        this.maxSwimDistance = (float) Math.round(maxSwimDistance + (Math.random() * 2 - 1) * maxSwimDistance * 0.5f);
        this.maxJumpHeight = (float) Math.round(maxJumpHeight + (Math.random() * 2 - 1) * maxJumpHeight * 0.5f);
        this.name = name;
    }

    public void run(float distance) {
        System.out.println((maxRunDistance >= distance) ?
                name + " успешно пробежал " + distance + "м!" :
                name + " пробежал " + maxRunDistance + "м и упал от усталости");
    }
    public void swim(float distance) {
        System.out.println((maxSwimDistance >= distance) ?
                name + " успешно проплыл " + distance + "м!" :
                name + " проплыл " + maxSwimDistance + "м и, к сожалению, утонул");
    }
    public void jump(float height) {
        System.out.println((maxJumpHeight >= height) ?
                name + " перепрыгнул преграду в " + height + "м!" :
                name + " не смог перепрыгнуть препятствие");
    }
}
