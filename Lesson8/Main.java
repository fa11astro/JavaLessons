package converter_2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookLoader loader = new BookLoader();
        List<Book> books = loader.loadBooks("file.xml");

        ConsoleInterface consoleInterface = new ConsoleInterface(books);
        consoleInterface.start();
    }
}
