package lab3.human;

public class Hand {
    Hand(int key){
        if (key == 1) {
            System.out.print(" /");
        } else {
            String hand = "\\ ";
            System.out.println(hand);
        }
    }
}
