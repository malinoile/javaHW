package lesson01;

public class Homework {

    public static void main(String[] args) {
        System.out.println(decisionExample(10, 15, 50, 25)); // 170.0
        System.out.println(checkTwoNumbers(10, 15)); // false
        System.out.println(checkNegative(-1)); // false
        System.out.println(helloMessage("Евгений")); //Привет, Евгений!

        isLeapYear(700); //не високосный
        isLeapYear(400); //високосный
        isLeapYear(1998); //не високосный
        isLeapYear(2005); //не високосный
        isLeapYear(1600); //високосный
    }

    public static float decisionExample(int a, int b, int c, int d) {
        return a * (b + ((float) c / d));
    }

    public static boolean checkTwoNumbers(int a, int b) {
        return (a + b) >= 10 && (a + b) <= 20;
    }

    public static boolean checkNegative(int a) {
        return a >= 0;
    }

    public static String helloMessage(String name) {
        return "Привет, " + name + "!";
    }

    public static void isLeapYear(int year) {
        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println("Год " + year + " является високосным");
        } else {
            System.out.println("Год " + year + " не високосный");
        }
    }
}
