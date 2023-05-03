/*
Найдите сумму всех элементов LinkedList, сохраняя все элементы в списке. Используйте итератор
 */


package seminar4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class task3 {
    public static void main(String[] args) {
        LinkedList<Integer> userList = randomList(10, 0, 20);
        System.out.println("Список: " + userList);
        System.out.println("Сумма всех элементов списка: " + sum(userList));
    }


    static int sum(LinkedList<Integer> inList){
        int elSum = 0;
        Iterator<Integer> iterator = inList.iterator();
        while (iterator.hasNext()){
            elSum += iterator.next();
        }
        return elSum;
    }


    static LinkedList<Integer> randomList(int length, int min, int max) {
        LinkedList<Integer> list = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            list.add(random.nextInt(min, max));
        }
        return list;
    }
}
