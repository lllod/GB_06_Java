/*
Вывести все простые числа от 1 до 1000 (числа, которые делятся только на 1 и на себя без остатка)
 */

package seminar1;

import static java.lang.Math.sqrt;


public class task3 {
    public static void main(String[] args) {
        primeNumber(1000);
    }

    static void primeNumber(int inNumber) {
        for (int i = 2; i < inNumber; i++) {
            boolean numSimple = true;
            for (int j = 2; j <= sqrt(i); j++) {
                if (i % j == 0) {
                    numSimple = false;
                    break;
                }
            }
            if (numSimple) {
                System.out.printf("%d ", i);
            }
        }
    }
}
