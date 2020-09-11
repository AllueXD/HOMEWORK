package lab1;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        int size;
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();

        int[] array = new int[size];

        for (int i = 0; i < array.length; i++){
            array[i] = i + 1;
        }

        Calculator calc = new Calculator();
        calc.calcDoWhile(array);
        calc.calcFor(array);
        calc.calcWhile(array);
    }
}
