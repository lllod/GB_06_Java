/*
Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
Постараться не обращаться к листу по индексам.
 */


package seminar4;

import java.util.LinkedList;
import java.util.Random;

public class task1 {
    public static void main(String[] args) {
        LinkedList<Integer> userList = randomList(10, 0, 20);
        System.out.println(reversedList(userList));
    }


    static LinkedList<Integer> randomList(int length, int min, int max) {
        LinkedList<Integer> list = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            list.add(random.nextInt(min, max));
        }
        return list;
    }


    static LinkedList<Integer> reversedList(LinkedList<Integer> inList) {
        LinkedList<Integer> outList = new LinkedList<>();
        while (inList.size() > 0) {
            outList.add((int) inList.getLast());
            inList.removeLast();
        }
        return outList;
    }
}
