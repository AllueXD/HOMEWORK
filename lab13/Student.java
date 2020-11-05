package lab13;

public class Student {
    String name;
    int iDNumber;
    int gPA;
    public Student(String name, int iDNumber, int gPA){
        this.name = name;
        this.iDNumber = iDNumber;
        this.gPA = gPA;
    }

    public int getgPA() {
        return gPA;
    }

    public int getiDNumber() {
        return iDNumber;
    }

    public String getName() {
        return name;
    }
}
