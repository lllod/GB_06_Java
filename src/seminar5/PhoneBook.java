package seminar5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {
    private HashMap<String, ArrayList<String>> map = new HashMap<>();
    private StringBuilder stringBuilder = new StringBuilder();

    public void add(String name, String phone){
        if (map.containsKey(name)) {
            ArrayList<String> phones = map.get(name);
            phones.add(phone);
        } else {
            ArrayList<String> phones = new ArrayList<>();
            phones.add(phone);
            map.put(name, phones);
        }
    }

    public String searchName(String searchName) {
        if (map.isEmpty()){
            return stringBuilder.append("Телефонна книга пуста!\n").toString();
        } else if (map.containsKey(searchName)) {
            stringBuilder.append(searchName);
            stringBuilder.append(": ");
            stringBuilder.append(map.get(searchName));
            stringBuilder.append("\n");
            return stringBuilder.toString();
        }
        return stringBuilder.append("Такого человека в телефонной книге нет!\n").toString();
    }

    public String searchPhone(String searchPhone) {
        if (!map.isEmpty()){
            for (String key: map.keySet()) {
                ArrayList<String> listOfValues = map.get(key);
                if (listOfValues.contains(searchPhone)) {
                    stringBuilder.append(key);
                    stringBuilder.append(": ");
                    stringBuilder.append(map.get(key));
                    stringBuilder.append("\n");
                }
            }
            if (stringBuilder.isEmpty()){
                return stringBuilder.append("Такого номера в телефонной книге нет!").toString();
            }
            return stringBuilder.toString();
        }
        return stringBuilder.append("Телефонна книга пуста!").toString();
    }

    public String deleteName(String deleteName) {
        if (map.isEmpty()){
            return stringBuilder.append("Телефонна книга пуста!").toString();
        } else if (map.containsKey(deleteName)) {
            map.remove(deleteName);
            return stringBuilder.append("Данные успешно удалены!").toString();
        }
        return stringBuilder.append("Такого человека в телефонной книге нет!").toString();
    }


    public String deletePhone(String deletePhone){
        int count = 0;
        if (!map.isEmpty()){
            for (List<String> values: map.values()) {
                if (values.contains(deletePhone)){
                    values.remove(deletePhone);
                    count++;
                }
            }
            if (count == 0) {
                return stringBuilder.append("Такого номера в телефонной книге нет!").toString();
            } else {
                return stringBuilder.append("Данные успешно удалены!").toString();
            }
        }
        return stringBuilder.append("Телефонна книга пуста!").toString();
    }

    @Override
    public String toString(){
        return map.toString();
    }
}
