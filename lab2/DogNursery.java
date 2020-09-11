package lab2;

public class DogNursery {
    private Dog[] dogs = new Dog[3];

    DogNursery(){
        dogs[0] = new Dog(10, "husky", "Bob");
        dogs[1] = new Dog(3, "unknown", "Dogg");
        dogs[2] = new Dog(13, "breed", "name");

        ShowDogs();
    }

    private void ShowDogs(){
        for (int i = 0; i < dogs.length; i++){
            System.out.println(dogs[i].toString());
        }
    }
}
