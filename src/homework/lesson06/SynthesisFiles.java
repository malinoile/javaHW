package homework.lesson06;

import java.io.*;

public class SynthesisFiles {

    public static void main(String[] args) {

        //Искомое слово
        String word = "угрюмый";

        try {
            FileInputStream fileInputStream = new FileInputStream("src/homework/lesson06/files/input1.txt");
            FileOutputStream fileOutputStream = new FileOutputStream("src/homework/lesson06/output.txt", true);
            int ch;
            while ((ch = fileInputStream.read()) != -1) {
                fileOutputStream.write(ch);
            }
            fileInputStream = new FileInputStream("src/homework/lesson06/files/input2.txt");
            while ((ch = fileInputStream.read()) != -1) {
                fileOutputStream.write(ch);
            }
            fileOutputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println("Произошла ошибка при работе с файлами: " + e.getMessage());
        }

        /*
            Поиск слова в файле, который был получен путем соединения двух файлов
        */

        try {
            FileInputStream fileInputStream = new FileInputStream("src/homework/lesson06/output.txt");
            System.out.println("Слово «" + word + "» присутствует в тексте? - " + (Search.checkWord(fileInputStream, word) ? "Да" : "Нет"));
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }

        File myFolder = new File("src/homework/lesson06/files");
        File[] files = myFolder.listFiles();

        if(files.length > 0) {

            //Изменяем слово для проверки
            word = "чащу";

            try {
                for (int i = 0; i < files.length; i++) {
                    FileInputStream fileInputStream = new FileInputStream(files[0]);
                    fileInputStream = new FileInputStream(files[i]);
                    if(Search.checkWord(fileInputStream, word)) {
                        System.out.println("Слово «" + word + "» впервые было найдено в файле " + files[i]);
                        fileInputStream.close();
                        break;
                    }
                    fileInputStream.close();
                }
            } catch (IOException e) {
                System.out.println("Произошла ошибка");
            }
        }
    }
}
