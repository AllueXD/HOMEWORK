package lab12;

public class Planet {
    int radius = 0; //km
   // int distanceToSun = 0;
    String name = "";
    double weight = 0; //* 10^24 kg
    double gravitation = 0; //m/c^2
    double density = 0; // Плотность kg/m^3


    Planet(int radius, double weight, String name){
        this.radius = radius;
        this.weight = weight;
        this.name = name;
    }
}
