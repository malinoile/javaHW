package homework.lesson06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Search {

    public static boolean checkWord(FileInputStream fileInputStream, String word) throws IOException {
        StringBuilder sb = new StringBuilder();

        BufferedReader input = new BufferedReader(new InputStreamReader(fileInputStream));

        String s;
        while((s = input.readLine()) != null) {
            sb.append(s).append("\n");
        }

        input.close();
        return sb.toString().contains(word);
    }

}
