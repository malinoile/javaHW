package hwLes02;

import hwLes02.exceptions.MyArrayDataException;
import hwLes02.exceptions.MyArraySizeException;

public class Main {

    private static final int ARRAY_SIZE = 4;

    public static void main(String[] args) {

        String[][] array = new String[ARRAY_SIZE][ARRAY_SIZE];

        // Заполнение массива

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = String.valueOf((i + 1) * (j * 2));
            }
        }

        array[array.length - 1][0] = "abc";

        try {
            int sum = getSumElementsInArray(array);
            System.out.println("Сумма всех элементов массива равна " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int getSumElementsInArray(String[][] array) throws MyArraySizeException, MyArrayDataException {

        if(array.length != ARRAY_SIZE) {
            throw new MyArraySizeException("Размер массива не соответствует заявленным условиям");
        }

        for (int i = 0; i < array.length; i++) {
            if(array[i].length != ARRAY_SIZE) {
                throw new MyArraySizeException("Размер массива не соответствует заявленным условиям");
            }
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                   } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Значение ячейки ["+i+"]["+j+"] невозможно привести к целому числу");
                }
            }
        }

        return sum;
    }


}
