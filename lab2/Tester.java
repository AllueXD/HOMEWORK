package lab2;

public class Tester {
    public static void main(String[] args) {
        Shape rectangle = new Shape("Rectangle", 0, 12, 3, 4);
        Shape circle = new Shape("Circle", 5, 0, 0,0);
        Shape round = new Shape("Round", 5,25*3,0,0); //25*3 = r^2*pi // значение в классе инт, так что оставил 3
        rectangle.showShape();
        circle.showShape();
        round.showShape();
    }
}
