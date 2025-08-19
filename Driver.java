import java.util.*;

public class Driver {
    public static void main(String[] args) {
        List<Book> books = DatasetReader.readBooksFromCSV("bestsellers with categories.csv");
        System.out.println("Loaded " + books.size() + " books.");
        for (Book b : books) {
            b.printDetails();
        }

    }

    public static int countBooksByAuthor(List<Book> books, String author) {
        int count = 0;
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                count++;
            }
        }
        return count;
    }

    public static void printAllAuthors(List<Book> books) {
        Set<String> authors = new HashSet<>();
        for (Book b : books) {
            authors.add(b.getAuthor());
        }
        for (String a : authors) {
            System.out.println(a);
        }
    }

    public static void getBooksByAuthor(List<Book> books, String author) {
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(b.getTitle());
            }
        }
    }

    public static void getBooksByRating(List<Book> books, double rating) {
        for (Book b : books) {
            if (b.getUserRating() == rating) {
                System.out.println(b.getTitle() + " (" + b.getAuthor() + ")");
            }
        }
    }

    public static void getBooksAndPricesByAuthor(List<Book> books, String author) {
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(b.getTitle() + " - $" + b.getPrice());
            }
        }
    }
}
