/*
Вычислить n-ое треугольного число (сумма чисел от 1 до n)
 */

package seminar1;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner((System.in));
        System.out.println("Введите треугольное число, которое необходимо вычислить: ");
        int userNum = in.nextInt();
        System.out.println(triangularNumber(userNum));
    }


    static int triangularNumber(int inNumber) {
        if (inNumber < 1) {
            return 0;
        }
        return inNumber + triangularNumber(inNumber - 1);
    }
}
