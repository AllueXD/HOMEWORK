package lab2;

public class Dog {
    private int age;
    private String breed;
    private String name;

    public int getAge() {
        return age;
    }
    public String getBreed() {
        return breed;
    }
    public String getName() {
        return name;
    }
    public int getHumanAge(){
        return (this.age*7);
    }

    Dog(int age, String breed, String name){
        this.age = age;
        this.breed = breed;
        this.name = name;
    }

    public String toString(){
        return "name: " + this.name + " age: " + this.age + " breed: " + this.breed;

    }
}
