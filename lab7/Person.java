package lab7;

import java.util.Scanner;

public class Person {
    private Furniture[] cart = new Furniture[10]; // Максимум 10 предметов
    private int asize;

    void StartShopping() {
        boolean run = true;
        while (run) {
            if (asize != 10) {
                int key;
                System.out.println("Press [1] - buy Armchair");
                System.out.println("Press [2] - buy Bed");
                System.out.println("Press [3] - buy Table");
                System.out.println("Press [4] - exit");
                Scanner sc = new Scanner(System.in);
                key = sc.nextInt();

                if (key == 1) {
                    this.cart[this.asize] = new Armchair();
                    asize++;
                } else if (key == 2) {
                    this.cart[this.asize] = new Bed();
                    asize++;
                } else if (key == 3) {
                    this.cart[this.asize] = new Table();
                    asize++;
                } else if (key == 4) {
                    run = false;
                } else {
                    System.out.println("Wrong number, try again");
                    StartShopping();
                }
            } else {
                System.out.println("Cart is full");
                run = false;
            }
        }
    }
    void PrintCart(){
        for (int i = 0; i < this.asize; i++){
            System.out.println("Price: "+cart[i].getPrice());
        }
    }

        Person() {
            this.asize = 0;
            StartShopping();
            PrintCart();
        }

    public static void main(String[] args) {
        Person person = new Person();
    }
}
