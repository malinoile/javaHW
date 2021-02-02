package hwLes01;

public interface Member {
    default void run() {
        System.out.println(" побежал по дорожке");
    }
    default void jump() {
        System.out.println(" прыгнул через стену");
    }
    default void fail() {
        setFail();
        System.out.println(getName() + ", к сожалению, сошел с дистанции");
    }
    boolean isFail();
    void setFail();
    String getName();
    float getRunLimit();
    float getJumpLimit();
}
