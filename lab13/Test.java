package lab13;

import java.util.Scanner;

public class Test {
    Student[] students;

    void fillStudents(){
        students = new Student[10];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++){
            students[i] = new Student(sc.next(), sc.nextInt(), sc.nextInt());
        }
    }

    void quickSortStudentsByID(int low, int high){
        if (students.length == 0){
            System.out.println("Empty array");
        }
        if (low >= high){
            System.out.println("Must be already sorted");
        }

        int middle = low + (high - low)/2;
        Student mid = students[middle];

        int i = low, j = high;
        while(i <=j){
            while(students[i].getiDNumber() < mid.getiDNumber()){
                i++;
            }
            while (students[j].getiDNumber() > mid.getiDNumber()){
                j--;
            }

            if (i <= j){
                Student buf = students[i];
                students[i] = students[j];
                students[j] = buf;
                i++;
                j--;
            }
            if (low < j){
                quickSortStudentsByID(low, j);
            }
            if (high > i){
                quickSortStudentsByID(i, high);
            }
        }




    }

    void showStudents(){
        for (int i = 0; i < 10; i++){
            System.out.println("");
        }
    }

    public Test(){
        fillStudents();
        quickSortStudentsByID(0, students.length -1);
    }
}
