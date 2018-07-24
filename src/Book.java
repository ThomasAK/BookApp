import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class Book {
    private String title;
    private String author;
    private int year;
    private static List<Book> books;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
    @Override
    public String toString(){
        return getTitle() + " By " + getAuthor() +" ("+getYear()+")";
    }
    public static List<Book> getList (String file){
        try {
            books = Files.readAllLines(new File(file).toPath()).stream()
                    .map(s -> s.split(","))
                    .filter(s ->{
                        boolean b = s.length == 3;
                        if (!b){
                                System.out.println((char)27 + "[31m" + "Problem reading in: \"" + Arrays.stream(s).collect(Collectors.joining(",")) +"\"");
                        }
                        return b;
                    })
                    .map(a -> new Book(a[0], a[1], Integer.valueOf(a[2])))
                    .collect(Collectors.toList());

            System.out.println((char)27 + "[39m" + "Number of books read in: " + books.size());

            return books;
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static String[] Function(String s){
       return s.split(",");
    }
}
