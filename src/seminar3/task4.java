/*
 *Реализовать алгоритм сортировки слиянием
 */


package seminar3;

import java.util.ArrayList;
import java.util.Random;

public class task4 {
    public static void main(String[] args) {
        ArrayList<Integer> inList = randomList(10, 1, 20);
        System.out.println("Изначальный список: " + inList);
        System.out.println("Отсортированный список: " + mergeSort(inList));
    }

    static ArrayList<Integer> randomList(int length, int min, int max) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            list.add(random.nextInt(min, max));
        }
        return list;
    }

    static ArrayList<Integer> mergeSort(ArrayList<Integer> list){
        if (list.size() <= 1){
            return list;
        }
        ArrayList<Integer> leftSide = new ArrayList<>();
        ArrayList<Integer> rightSide = new ArrayList<>();
        for (int i = 0; i < list.size() / 2; i++) {
            leftSide.add(list.get(i));
        }
        for (int i = list.size() / 2; i < list.size(); i++) {
            rightSide.add(list.get(i));
        }
        leftSide = mergeSort(leftSide);
        rightSide = mergeSort(rightSide);
        return mergeLists(leftSide, rightSide);
    }

    static ArrayList<Integer> mergeLists (ArrayList<Integer> listLeft, ArrayList<Integer> listRight){
        ArrayList<Integer> mergeList = new ArrayList<>();
        int i = 0, j = 0;
        while (i < listLeft.size() && j < listRight.size()) {
            if (listLeft.get(i) < listRight.get(j)) {
                mergeList.add(listLeft.get(i));
                i++;
            } else {
                mergeList.add((listRight.get(j)));
                j++;
            }
        }
        if (i < listLeft.size()) {
            for (int k = i; k < listLeft.size(); k++) {
                mergeList.add(listLeft.get(k));
            }
        }
        if (j < listRight.size()) {
            for (int k = j; k < listRight.size(); k++) {
                mergeList.add(listRight.get(k));
            }
        }
    return mergeList;
    }
}
