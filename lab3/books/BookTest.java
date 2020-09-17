package lab3.books;

public class BookTest {
    static void showBook(Book book){
        System.out.println("Autor - " + book.getAuthor());
        System.out.println("Book title - " + book.getBook_title());
        System.out.println("Year - " + book.getYear());
        System.out.println("Price - " + book.getPrice());
    }

    public static void main(String[] args) {
        Book book = new Book("Lev Tolstoy", "War and Peace", 1869, 1500);
        showBook(book);
        book.setAuthor("Artur Conan Doyle");
        book.setBook_title("Sherlock Holmes");
        book.setYear(1892);
        book.setPrice(1600);
        showBook(book);
    }
}
