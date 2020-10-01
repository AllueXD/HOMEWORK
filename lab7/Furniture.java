package lab7;

public abstract class Furniture {
    private String type;
    private int price;

    public int getPrice() {
        return price;
    }
    public String getType() {
        return type;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setType(String type) {
        this.type = type;
    }
}
