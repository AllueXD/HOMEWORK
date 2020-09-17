package lab1.random;

import java.util.Random;
import java.util.Arrays;

public class RandomArray {
    private int[] array = new int[30];
    public void fillArrayWithRandom(){
        Random random = new Random();
        for (int i = 0; i < this.array.length; i++){
            this.array[i] = random.nextInt(100);
        }
    }
    public void fillArrayWithMath(){
        for (int i = 0; i < this.array.length; i++){
            this.array[i] = (int)(Math.random() * 100);
        }
    }
    public void sortArray(){
        Arrays.sort(this.array);
    }
    public void showArray(){
        for (int i = 0; i < this.array.length; i++){
            System.out.print(this.array[i] + " ");
        }
        System.out.println();
    }
}
