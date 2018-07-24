import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookApp {
    public static void main(String[] args) {
        List<Book> books;
        books = Book.getList("./src/books.csv").stream().sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());

        System.out.println();
        System.out.println("Sorted book list:");

        for(int i=0;i<books.size()-1;i++) System.out.println(books.get(i));

        System.out.println();
        System.out.println("Reverse order:");

        for(int i=0;i<books.size();i++) System.out.println(books.get(books.size() - i -1));
    }
}
