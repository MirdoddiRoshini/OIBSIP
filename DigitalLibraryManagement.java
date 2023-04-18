import java.util.*;
class Book {
    private String title;
    private String author;
    private long isbn;

    public Book(String title, String author, long isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public long getISBN() {
        return isbn;
    }
}

class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Book> searchBooks(String query) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getTitle().contains(query) || book.getAuthor().contains(query)) {
                result.add(book);
            }
        }

        return result;
    }
}

public class DigitalLibraryManagement {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book("Mathematics", "S.CHAND", 9780132350884L));
        library.addBook(new Book("Signals", "RAMESH BABU",9780201657883L));
        library.addBook(new Book("introduction to C","REEMA",8131760308L));
        library.addBook(new Book("programming in C","PARTHA",9781118871645L));
        List<Book> results = library.searchBooks("clean code");
        System.out.println("Search results:");
        for (Book book : results) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }

        library.removeBook(new Book("The Pragmatic Programmer","A. Hunt & D. Thomas",9780201616224L));

        System.out.println("All books:");
        for (Book book : library.getBooks()){
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
    }
}