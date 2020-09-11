package lab1;

public class Calculator {
    public void calcFor(int[] array){
        int sum = 0;
        for (int i = 0; i < array.length; i++){
            sum += array[i];
        }
        System.out.println(sum);
    }
    public void calcWhile(int[] array){
        int sum = 0;
        int i = 0;
        while (i != array.length){
            sum += array[i];
            i++;
        }
        System.out.println(sum);
    }
    public void calcDoWhile(int[] array){
        int sum = 0;
        int i = 0;
        do{
            sum += array[i];
            i++;
        } while (i < array.length);
        System.out.println(sum);
    }
}
