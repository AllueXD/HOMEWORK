package lab10;

import java.util.Scanner;

public class Main {


    void checkNumbers(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter k: " );
        int k = sc.nextInt();
        int s = sc.nextInt();
        int count = 0;

        int number = (int) Math.pow(10, k-1);

        while (number < (int) Math.pow(10, k)){
            int sum = 0;
            int nNum = number;
            while (nNum > 0){
                sum += nNum % 10;
                nNum /= 10;
            }
            if (sum == s){
                count++;
            }
            System.out.println("1");
            number++;
        }
        System.out.println("count = " + count);
    }

    int checkDoubleZero(int o, int z){
        if (o < z){
            return 0;
        }
        if (o == z){
            return 1;
        }
        return (checkDoubleZero(o, z-1)+checkDoubleZero(o-1, z-1));
    }

    void printNumber(int number){

    }

    public static void main(String[] args) {
        Main main = new Main();
        main.checkNumbers();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число единиц: ");
        int o = sc.nextInt();
        System.out.println("Введите число нулей: ");
        int z = sc.nextInt();

        System.out.println("1, 0: " + main.checkDoubleZero(o,z));
    }
}
