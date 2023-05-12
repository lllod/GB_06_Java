/*
Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин,
Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова,
Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов. Написать программу, которая найдет и выведет повторяющиеся
имена с количеством повторений. Отсортировать по убыванию популярности. Для сортировки использовать TreeMap.
 */


package seminar5;

import java.util.*;

public class task2 {
    public static void main(String[] args) {
        String userText = "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, " +
                "Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, " +
                "Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов";
        Map<String, Integer> map = nameRepeat(createArray(userText));
        System.out.println(map);
        System.out.println(printSortNames(sortByValues(map)));
    }

    static ArrayList<List<String>> createArray(String inText) {
        List<String> splitText = Arrays.asList(inText.split(", "));
        ArrayList<List<String>> subList = new ArrayList<>();
        for (String s : splitText) {
            subList.add(Arrays.asList(s.split(" ")));
        }
        return subList;
    }

    public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
        Comparator<K> valueComparator =  new Comparator<K>() {
            public int compare(K k1, K k2) {
                int compare = map.get(k2).compareTo(map.get(k1));
                if (compare == 0) return 1;
                else return compare;
            }
        };
        Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }

    static Map<String, Integer> nameRepeat(ArrayList<List<String>> inList){
        Map<String, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for (List<String> s: inList) {
            if (!map.containsKey(s.get(0))) {
                map.put(s.get(0), 1);
            } else {
                int count = map.get(s.get(0));
                map.put(s.get(0), count + 1);
            }
        }
        return map;
    }

    static String printSortNames(Map<String, Integer> inMap) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> s: inMap.entrySet()) {
            if (s.getValue() > 1) {
                stringBuilder.append(s.getKey());
                stringBuilder.append(": ");
                stringBuilder.append(s.getValue());
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

}
