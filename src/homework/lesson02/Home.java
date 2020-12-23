package homework.lesson02;

import java.util.Arrays;

public class Home {

    public static void main(String[] args) {
        System.out.println("---Задание 1---");
        int[] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Первоначальный массив: " + Arrays.toString(array1));
        System.out.println("Измененный массив: " + Arrays.toString(replacement(array1)));

        System.out.println("---Задание 2---");

        int[] array2 = new int[8];
        System.out.println("Массив для 2 задания: " + Arrays.toString(fillArray(array2)));

        System.out.println("---Задание 3---");

        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Первоначальный массив: " + Arrays.toString(array3));
        System.out.println("Измененный массив: " + Arrays.toString(multiplication(array3)));

        System.out.println("---Задание 4---");

        int[] array4 = {-1, 5, 3, -2, 11, 4, 0, -5, 2, 4, -8, 9, 1};
        System.out.println("Первоначальный массив: " + Arrays.toString(array4));
        System.out.println("Минимальное значение: " + minValue(array4));
        System.out.println("Максимальное значение: " + maxValue(array4));

        System.out.println("---Задание 5---");

        int[][] array5 = new int[9][9];
        array5 = fillDiagonalArray(array5);
        for (int i = 0; i < array5.length; i++) {
            for (int j = 0; j < array5[i].length; j++) {
                System.out.print(array5[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("---Задание 6---");
        int[] array6 = {2, 1, 1, 2, 1};
        System.out.println(Arrays.toString(array6) + " -> " + checkBalance(array6));

        System.out.println("---Задание 7---");
        int[] array7 = {8, 16, 32, 64, 128, 256, 512, 1024};
        System.out.println("Первоначальный массив: " + Arrays.toString(array7));
        System.out.println("Измененный массив: " + Arrays.toString(valueOffset1(array7, 2)));

        System.out.println("---Задание 8---");

        System.out.println("Первоначальный массив: " + Arrays.toString(array7));
        System.out.println("Измененный массив: " + Arrays.toString(valueOffset2(array7, -5)));
    }

    public static int[] replacement(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 1) ? 0 : 1;
        }
        return array;
    }

    public static int[] fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 3 + 1;
        }

        return array;
    }

    public static int[] multiplication(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] < 6) {
                array[i] *= 2;
            }
        }
        return array;
    }

    public static int minValue(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static int maxValue(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static int[][] fillDiagonalArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (i == j || j == array.length - 1 - i) ? 1 : 0;
            }
        }
        return array;
    }

    public static boolean checkBalance(int[] array) {
        int sum1 = 0, sum2 = 0;
        int i = 0, j = array.length - 1;

        while(i <= j) {

            if(sum1 == sum2 && i != j) {
                sum1 += array[i++];
                sum2 += array[j--];
            } else if(sum1 > sum2) {
                sum2 += array[j--];
            } else {
                sum1 += array[i++];
            }
        }

        return sum1 == sum2;
    }

    public static int[] valueOffset1(int[] array, int n) {
        if((n %= array.length) > 0) {
            n = -(array.length - n);
        }
        int[] tempArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if(i - n < array.length) {
                tempArray[i] = array[i - n];
            } else {
                tempArray[i] = array[i - (array.length + n)];
            }
        }
        return tempArray;
    }

    public static int[] valueOffset2(int[] array, int n) {
        if((n %= array.length) > 0) {
            n = -(n - array.length);
        } else {
            n = -n;
        }
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }

        return array;
    }
}
