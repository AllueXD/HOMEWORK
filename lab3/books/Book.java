package lab3.books;

public class Book {
    private String author;
    private String book_title;
    private int year;
    private int price;

    Book(String author, String book_title, int year, int price){
        this.author = author;
        this.book_title = book_title;
        this.year = year;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
    public int getYear() {
        return year;
    }
    public String getAuthor() {
        return author;
    }
    public String getBook_title() {
        return book_title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setYear(int year) {
        this.year = year;
    }
}
