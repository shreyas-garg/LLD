import java.io.*;
import java.util.*;

public class DatasetReader {

    public static List<Book> readBooksFromCSV(String fileName) {
        List<Book> books = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean headerSkipped = false;

            while ((line = br.readLine()) != null) {

                if (!headerSkipped) {
                    headerSkipped = true;
                    continue;
                }

                String[] values = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1); 

                if (values.length == 7) {
                    try {
                        String title = values[0].replaceAll("\"", "");
                        String author = values[1].replaceAll("\"", "");
                        double userRating = Double.parseDouble(values[2]);
                        int reviews = Integer.parseInt(values[3]);
                        double price = Double.parseDouble(values[4]);
                        int year = Integer.parseInt(values[5]);
                        String genre = values[6].replaceAll("\"", "");

                        Book book = new Book(title, author, userRating, reviews, price, year, genre);
                        books.add(book);

                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid line: " + Arrays.toString(values));
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return books;
    }
}
