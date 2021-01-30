package hwLes01;

public class Course {

    private Let lets[] = new Let[5];

    public Course() {
        lets[0] = new Wall(0.3f);
        lets[1] = new RunningTrack(25.0f);
        lets[2] = new RunningTrack(100.f);
        lets[3] = new Wall(1.2f);
        lets[4] = new RunningTrack(200.f);
    }

    public void doIt(Team team) {
        for (Member member : team.getMembers()) {
            for (int i = 0; i < lets.length; i++) {
                if(member.isFail()) {
                    break;
                }
                System.out.print(member.getName());
                if(lets[i] instanceof RunningTrack) {
                    member.run();
                    if(member.getRunLimit() < lets[i].getLetSize()) {
                        member.fail();
                        break;
                    }
                } else if(lets[i] instanceof Wall) {
                    member.jump();
                    if(member.getJumpLimit() < lets[i].getLetSize()) {
                        member.fail();
                        break;
                    }
                }

                if(i == lets.length - 1) {
                    System.out.println(member.getName() + " добрался до финиша. Поздравляем!");
                }
            }

        }
    }
}
