import java.util.*;

public class Driver {
    public static void main(String[] args) {
        List<Book> books = DatasetReader.readBooksFromCSV("bestsellers with categories.csv");
        System.out.println("Loaded " + books.size() + " books.");
        BookService bookService = new BookService(books);
        for (Book b : bookService.getBooks()) {
            b.printDetails();
        }
        // Example usage:
        // bookService.printAllAuthors();
        // bookService.getBooksByAuthor("Author Name");
        // bookService.getBooksByRating(4.5);
        // bookService.getBooksAndPricesByAuthor("Author Name");
    }
}
