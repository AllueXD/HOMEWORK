package lab2.shapes;

public class Shape {
    private String type;
    private int radius; //для окружностей, кругов и тп.
    private int square;
    private int a;
    private int b;

    public void showShape(){
        System.out.println("Shape - " + type);
        if (this.radius != 0){
            System.out.println("Radius - " + radius);
        }
        if (this.square != 0){
            System.out.println("Square - " + this.square);
        }
        if (this.a != 0){
            System.out.println("A = " + a);
        }
        if (this.b != 0){
            System.out.println("B = " + b);
        }
    }

    Shape(String type, int radius, int square, int a, int b){
        this.type = type;
        this.radius = radius;
        this.square = square;
        this.a = a;
        this.b = b;
    }
    public int getA() {
        return a;
    }
    public int getB() {
        return b;
    }
    public int getRadius() {
        return radius;
    }
    public int getSquare() {
        return square;
    }
    public String getType() {
        return type;
    }
}
