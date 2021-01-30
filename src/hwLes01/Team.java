package hwLes01;

public class Team {

    private Member members[] = new Member[4];

    public Team() {
        members[0] = new People("Человек Олег", 250.0f, 1.75f);
        members[1] = new Cat("Кот Енот", 100.0f, 0.65f);
        members[2] = new Robot("Робот Бо-бот", 25.0f, 4.0f);
        members[3] = new People("Человек Петро", 150.0f, 1.2f);
    }

    public Member[] getMembers() {
        return members;
    }

    public void showResults() {
        int countFinished = 0;
        for (int i = 0; i < members.length; i++) {
            if(!members[i].isFail()) {
                countFinished++;
            }
        }
        System.out.println();
        System.out.println("Всего в забеге учавствовало " + members.length + " участников");
        if(countFinished > 0)
            System.out.println("Из них " + countFinished + " добрались до финиша");
        else
            System.out.println("Никто не добрался до финиша");
    }

}
