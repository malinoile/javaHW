package hwLes01;

public class SteepleChase {
    public static void main(String[] args) {
        Course c = new Course();
        Team team = new Team();
        c.doIt(team);
        team.showResults();
    }
}
