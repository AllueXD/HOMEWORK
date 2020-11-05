package lab3.Circle;

public class Circle {
    private int radius;
    private double D;
    private int diametr;

    public Circle(int rad){
        this.diametr = rad*2;
        this.radius = rad;
        this.D = 2*3.14*rad;
    }

    int getRadius(){return this.radius;}
    int getDiametr(){return this.diametr;}
    double getD(){return this.D;}

    void changeRadius(int rad){
        this.radius = rad;
        this.D = 2*3.14*rad;
        this.diametr = rad*2;
    }
}
