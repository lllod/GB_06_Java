/*
Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка.
Collections.max()
 */


package seminar3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class task2 {
    public static void main(String[] args) {
        ArrayList<Integer> inList = randomList(10, 1, 10);
        System.out.println("Изначальный список: " + inList);
        listMinMaxArihmeticMean(inList);
    }

    static ArrayList<Integer> randomList(int length, int min, int max) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            list.add(random.nextInt(min, max));
        }
        return list;
    }

    static Integer sumList(ArrayList<Integer> list){
        int sum = 0;
        for (int el:list) {
            sum += el;
        }
        return sum;
    }

    static void listMinMaxArihmeticMean(ArrayList<Integer> list){
        System.out.println("Минимальное значение: " + list.stream().min(Integer::compare).get());
        System.out.println("Максимальное значение: " + list.stream().max(Integer::compare).get());
        int sum = sumList(list);
        System.out.println("Среднее арифметическое: " + (double) sum / list.size());
    }

}
