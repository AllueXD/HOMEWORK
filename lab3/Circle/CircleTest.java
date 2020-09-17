package lab3.Circle;

import lab3.Circle.Circle;

public class CircleTest {
    public static void main(String[] args){
        Circle circle = new Circle(2);
        System.out.println("Radius: " + circle.getRadius());
        System.out.println("Diametr: " + circle.getDiametr());
        System.out.println("D: " + circle.getD());

        circle.changeRadius(3);
        System.out.println("Radius: " + circle.getRadius());
        System.out.println("Diametr: " + circle.getDiametr());
        System.out.println("D: " + circle.getD());
    }
}
