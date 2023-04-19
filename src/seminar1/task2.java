/*
Вычислить n! (произведение чисел от 1 до n)
 */

package seminar1;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner((System.in));
        System.out.println("Введите число, для которого необходимо вычислить факториал: ");
        int userNum = in.nextInt();
        System.out.println(factorialNumber(userNum));
    }


    static int factorialNumber(int inNumber) {
        if (inNumber <= 1) {
            return 1;
        }
        return inNumber * factorialNumber(inNumber - 1);
    }
}