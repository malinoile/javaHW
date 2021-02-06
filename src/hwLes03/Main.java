package hwLes03;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] strings = {"one", "two", "three", "four", "five", "one", "six", "six", "seven", "two", "eight", "nine", "ten", "eleven", "string", "two", "six", "twenty", "five-five"};

        //Вывод уникальных значений
        Set<String> hashSet = new HashSet<>(Arrays.asList(strings));
        System.out.println("Уникальные слова из массива: " + hashSet);

        //Подсчет количества вхождений слов
        Map<String, Integer> map = new HashMap<>();
        for(String str : strings) {
            if(map.containsKey(str)) {
                Integer integer = map.get(str);
                map.put(str, ++integer);
            } else {
                map.put(str, 1);
            }
        }
        System.out.println("Подсчет вхождений каждого слова в массив: " + map);
        System.out.println();

        //Телефонный справочник
        PhoneLibrary phoneLibrary = new PhoneLibrary();
        phoneLibrary.addEntry("Иванов", "+7 (999) 912-12-35");
        phoneLibrary.addEntry("Петров", new ArrayList<>(Arrays.asList("+7 (923) 325-35-35", "+7 (495) 555-11-22")));
        phoneLibrary.addEntry("Иванов", new ArrayList<>(Arrays.asList("+7 (495) 002-25-21", "+7 (800) 800-00-22")));

        System.out.println(phoneLibrary.getInfo("Иванов"));
        System.out.println(phoneLibrary.getInfo("Михайлов"));

    }

}
