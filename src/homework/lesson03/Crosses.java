package homework.lesson03;

import java.util.Scanner;

public class Crosses {

    public static final char PERSON_DOT = 'X';
    public static final char PC_DOT = 'O';
    public static final int COUNT_WIN = 4;

    public static Scanner scanner = new Scanner(System.in);

    public static char[][] map;

    public static void initMap(int sizeX, int sizeY) {
        map = new char[sizeY][sizeX];
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                map[y][x] = '_';
            }
        }
    }

    public static void printMap() {
        System.out.println();
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                System.out.print("| " + map[y][x] + " ");
                if(x == map[y].length - 1) System.out.print("|");
            }
            System.out.println();
        }
    }

    public static boolean checkEmpty(int y, int x) {
        return map[y-1][x-1] == '_';
    }

    public static boolean checkBounds(int y, int x) {
        return (y > 0) && (y <= map.length) && (x > 0) && (x <= map[0].length);
    }

    public static void movePerson() {
        int y;
        int x;
        do {
            System.out.print("Введите y-координату: ");
            y = scanner.nextInt();
            System.out.print("Введите x-координату: ");
            x = scanner.nextInt();
        } while ((!checkBounds(y, x)) || !checkEmpty(y, x));

        map[y-1][x-1] = PERSON_DOT;
    }

    public static void movePC() {
        int y;
        int x;
        do {
            y = (int) (Math.random() * map.length) + 1;
            x = (int) (Math.random() * map[0].length) + 1;
        } while ((!checkBounds(y, x)) || !checkEmpty(y, x));
        System.out.println(y + "|" + x);

        map[y-1][x-1] = PC_DOT;
    }

    public static boolean isNobodyWin() {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if(map[y][x] != '_') return false;
            }
        }
        return true;
    }

    public static boolean isWin(char ch) {
        int count = 0;

        //Проверка по-горизонтали
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                count = (map[y][x] == ch) ? count + 1 : 0;
                if(count >= COUNT_WIN) return true;
            }
            count = 0;
        }

        //Проверка по-вертикали
        for (int x = 0; x < map[0].length; x++) {
            for (int y = 0; y < map.length - 1; y++) {
                count = (map[y][x] == ch) ? count + 1 : 0;
                if(count >= COUNT_WIN) return true;
            }
            count = 0;
        }

        for (int i = 0; i < map.length - COUNT_WIN + 1; i++) {
            for (int j = 0; j < map[0].length - COUNT_WIN + 1; j++) {
                for (int k = 0; k < COUNT_WIN; k++) {
                    count = (map[i + k][j + k] == ch) ? count + 1 : 0;
                    if(count >= COUNT_WIN) return true;
                }
                count = 0;
                for (int k = 0; k < COUNT_WIN; k++) {
                    count = (map[i + COUNT_WIN - k - 1][j + k] == ch) ? count + 1 : 0;
                    if(count >= COUNT_WIN) return true;
                }
                count = 0;
            }
            count = 0;
        }

        return false;
    }

    public static void main(String[] args) {
        initMap(5, 5);
        printMap();

        while(true) {
            movePerson();
            printMap();
            if(isNobodyWin()) {
                System.out.println("Ничья");
                break;
            } else if(isWin(PERSON_DOT)) {
                System.out.println("Человек победил");
                break;
            }
            movePC();
            printMap();
            if(isNobodyWin()) {
                System.out.println("Ничья");
                break;
            } else if(isWin(PC_DOT)) {
                System.out.println("Победил искусственный интелект");
                break;
            }
        }
    }

}
