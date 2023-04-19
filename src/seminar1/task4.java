/*
Реализовать простой калькулятор (введите первое число, введите второе число, введите требуемую операцию, ответ)
 */

package seminar1;
import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        System.out.print("Введите первое число: ");
        double aNum = inputNumbers();
        System.out.print("Введите второе число: ");
        double bNum = inputNumbers();
        userChoise(aNum, bNum);
    }


    static double inputNumbers() {
        Scanner in = new Scanner((System.in));
        return in.nextDouble();
    }


    static void userChoise(double a, double b) {
        System.out.println("1. Сложение\n2. Вычитание\n3. Умножение\n4. Деление\n5. Выход");
        Scanner in = new Scanner((System.in));
        System.out.print("Введите номер операции: ");
        int userChoiceNum = in.nextInt();
        if (userChoiceNum == 1) {
            System.out.println(addition(a, b));
        } else if (userChoiceNum == 2) {
            System.out.println(subtraction(a, b));
        } else if (userChoiceNum == 3) {
            System.out.println(multiplication(a, b));
        } else if (userChoiceNum == 4) {
            System.out.println(division(a, b));
        }
    }


    static double addition(double a, double b) {
        return a + b;
    }


    static double subtraction(double a, double b) {
        return a - b;
    }


    static double multiplication(double a, double b) {
        return a * b;
    }


    static double division(double a, double b) {
        return a / b;
    }

}
