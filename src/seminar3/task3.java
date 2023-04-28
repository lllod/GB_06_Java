/*
Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями.
Вывести название каждой планеты и количество его повторений в списке.
 */


package seminar3;

import java.util.*;

public class task3 {
    public static void main(String[] args) {
        ArrayList<String> planetsList = randomList(20);
        System.out.println(planetsList);
        printElemetsOfDict(planetsDictionary(planetsList));
    }


    static ArrayList<String> randomList(int length) {
        ArrayList<String> list = new ArrayList<String>();
        String[] planetsArray = new String[]
                {"Сатурн", "Земля", "Венера", "Марс", "Меркурий", "Юпитер", "Уран", "Нептун"};
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            list.add(planetsArray[random.nextInt(planetsArray.length)]);
        }
        return list;
    }


    static Hashtable<String, Integer> planetsDictionary(ArrayList<String> list){
        Hashtable<String, Integer> planetsDict = new Hashtable<String, Integer>();
        for (String el:list) {
            planetsDict.merge(el, 1, Integer::sum);
        }
        return planetsDict;
    }

    static void printElemetsOfDict(Hashtable<String, Integer> planetsDict){
        planetsDict.forEach((k, v) -> System.out.println("Планета " + k + " встречается " + v + " раз(а)."));
    }
}
