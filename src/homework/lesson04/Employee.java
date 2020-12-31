package homework.lesson04;

public class Employee {

    private static int count = 0;

    private String fio;
    private String post;
    private String phone;
    private float salary;
    private int age;
    private int id;

    public Employee(String fio, String post, String phone, float salary, int age) {

        this.id = ++count;
        this.fio = fio;
        this.post = post;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public String getFio() {
        return fio;
    }

    public String getPost() {
        return post;
    }

    public String getPhone() {
        return phone;
    }

    public float getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public void upSalary() {
        if(age > 35) {
            salary += 10000f;
        }
    }
}
