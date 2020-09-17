package lab1;

import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your number: ");
        int n = scanner.nextInt();

        int fact = 1;
        for (int i = 2; i <= n; i++){
            fact *= i;
        }
        System.out.println(n + "! = " + fact);
    }
}
