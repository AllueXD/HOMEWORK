package lab3.human;

public class Human {
    Human(){
        Head head = new Head();
        Hand hand1 = new Hand(1);
        Body body = new Body();
        Hand hand2 = new Hand(0);
        Legs legs = new Legs();
    }
    public static void main(String[] args) {
        Human human = new Human();
    }
}
