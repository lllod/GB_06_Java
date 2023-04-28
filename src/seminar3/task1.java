/*
Пусть дан произвольный список целых чисел, удалить из него четные числа
 */


package seminar3;

import java.util.*;

public class task1 {
    public static void main(String[] args) {
        ArrayList<Integer> inList = randomList(20, 1, 20);
        System.out.println("Изначальный список: " + inList);
        deleteEvenNumbers(inList);
        System.out.println("Итоговый список: " + inList);
    }

    static ArrayList<Integer> randomList(int length, int min, int max) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            list.add(random.nextInt(min, max));
        }
        return list;
    }

    static void deleteEvenNumbers(ArrayList<Integer> list){
        list.removeIf(element -> element % 2 == 0);
    }
}
