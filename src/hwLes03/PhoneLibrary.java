package hwLes03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PhoneLibrary {

    private Map<String, ArrayList<String>> map = new HashMap<>();


    //Пара методов для добавления значений в Телефонную книгу
    public void addEntry(String key, ArrayList<String> phones) {
        if(map.containsKey(key)) {
            map.get(key).addAll(phones);
        } else {
            map.put(key, phones);
        }
    }

    public void addEntry(String key, String phone) {
        if(map.containsKey(key)) {
            map.get(key).add(phone);
        } else {
            map.put(key, new ArrayList<>(Arrays.asList(phone)));
        }
    }

    public String getInfo(String key) {
        if(map.containsKey(key)) {
            return "Номера телефона пользователя \"" + key + "\": " + map.get(key);
        }
        return "Пользователь \"" + key + "\" еще не был добавлен в телефонный справочник";
    }
}
