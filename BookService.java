
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class BookService {
    private List<Book> books;

    public BookService(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public int countBooksByAuthor(String author) {
        int count = 0;
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                count++;
            }
        }
        return count;
    }

    public void printAllAuthors() {
        Set<String> authors = new HashSet<>();
        for (Book b : books) {
            authors.add(b.getAuthor());
        }
        for (String a : authors) {
            System.out.println(a);
        }
    }

    public void getBooksByAuthor(String author) {
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(b.getTitle());
            }
        }
    }

    public void getBooksByRating(double rating) {
        for (Book b : books) {
            if (b.getUserRating() == rating) {
                System.out.println(b.getTitle() + " (" + b.getAuthor() + ")");
            }
        }
    }

    public void getBooksAndPricesByAuthor(String author) {
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(b.getTitle() + " - $" + b.getPrice());
            }
        }
    }
}
