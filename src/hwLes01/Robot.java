package hwLes01;

public class Robot implements Member {
    private String name;
    private float runLimit;
    private float jumpLimit;

    private boolean fail;

    public Robot(String name, float runLimit, float jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
        this.fail = false;
    }

    @Override
    public boolean isFail() {
        return fail;
    }

    @Override
    public void setFail() {
        this.fail = true;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getRunLimit() {
        return runLimit;
    }

    @Override
    public float getJumpLimit() {
        return jumpLimit;
    }
}
