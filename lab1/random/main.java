package lab1.random;

import lab1.random.RandomArray;

public class main {
    public static void main(String[] args) {
        RandomArray randomArray = new RandomArray();

        randomArray.fillArrayWithRandom(); // Заполняем массив первым способом
        randomArray.showArray();
        randomArray.sortArray();
        randomArray.showArray(); //Первый способ завершен

        randomArray.fillArrayWithMath(); //Заполняем вторым способоm
        randomArray.showArray();
        randomArray.sortArray();
        randomArray.showArray();
    }
}
