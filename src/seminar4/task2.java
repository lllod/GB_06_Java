/*
Реализуйте очередь с помощью LinkedList со следующими методами: enqueue() - помещает элемент в конец очереди,
dequeue() - возвращает первый элемент из очереди и удаляет его, first() - возвращает первый элемент из очереди,
не удаляя.
 */


package seminar4;

import java.util.LinkedList;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        LinkedList<Integer> userList = new LinkedList<>();
        enqueue(userList, addElement());
        enqueue(userList, addElement());
        enqueue(userList, addElement());
        System.out.println(userList);
        System.out.println(dequeue(userList));
        System.out.println(userList);
        System.out.println(first(userList));
        System.out.println(userList);
    }


    static void enqueue(LinkedList<Integer> inList, int element){
        inList.addLast(element);
    }


    static int dequeue(LinkedList<Integer> inList){
        return inList.poll();
    }


    static int first(LinkedList<Integer> inList){
        return inList.getFirst();
    }


    static int addElement(){
        Scanner in = new Scanner((System.in));
        System.out.print("Введите элемент: ");
        return in.nextInt();
    }
}
