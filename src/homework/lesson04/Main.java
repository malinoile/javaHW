package homework.lesson04;

public class Main {
    public static void main(String[] args) {
        System.out.println("---Задание 4---");
        Employee employee1 = new Employee("Иванов Иван Иванович", "менеджер по персоналу", "+79123456789", 25673.56f, 21);
        System.out.println("Первый сотрудник: " + employee1.getFio() + " - " + employee1.getPost());

        System.out.println();
        System.out.println("---Задание 5---");
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Иванов Иван Иванович", "менеджер по персоналу", "+79123456789", 25673.56f, 21);
        employees[1] = new Employee("Петров Петр Олегович", "руководитель отдела", "+79231456987", 56743.12f, 47);
        employees[2] = new Employee("Третьяков Олег Степанович", "генеральный директор", "+79369852147", 126000.00f, 56);
        employees[3] = new Employee("Степанов Константин Павлович", "оператор", "+79874563215", 41500.00f, 32);
        employees[4] = new Employee("Кольнев Павел Иванович", "системный администратор", "+79800800888", 47256.50f, 28);

        for (int i = 0; i < employees.length; i++) {
            if(employees[i].getAge() > 40) {
                System.out.println(employees[i].getFio() + " - " + employees[i].getPost() + ". Зарплата: " + employees[i].getSalary()
                        + ". Номер телефона: " + employees[i].getPhone() + ". Возраст: " + employees[i].getAge());
            }
        }

        System.out.println();
        System.out.println("---Задание 6---");
        for (int i = 0; i < employees.length; i++) {
            System.out.print("Сотрудник " + employees[i].getFio() + " | до: " + employees[i].getSalary() + " | ");
            employees[i].upSalary();
            System.out.println("после: " + employees[i].getSalary() + " | возраст: " + employees[i].getAge());
        }

        System.out.println();
        System.out.println("---Задание 7---");
        for (int i = 0; i < employees.length; i++) {
            System.out.println("Сотрудник " + employees[i].getFio() + " имеет id " + employees[i].getId());
        }
    }
}
