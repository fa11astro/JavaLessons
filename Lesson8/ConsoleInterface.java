package converter_2;


import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ConsoleInterface {

    private static final Logger logger = Logger.getLogger(ConsoleInterface.class.getName());

    private final List<Book> books;

    public ConsoleInterface(List<Book> books) {
        this.books = books;
    }

    public void displayAll() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Что вывести?");
        System.out.println("1 - Список книг");
        System.out.println("2 - Список авторов");


        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Список книг:");
                books.stream()
                        .map(Book::name)
                        .forEach(System.out::println);
                break;
            case 2:
                System.out.println("Список авторов:");
                books.stream()
                        .map(Book::author)
                        .distinct()
                        .forEach(System.out::println);
                break;
            default:
                System.out.println("Некорректный выбор.");
                break;
        }

    }

    public void searchByAuthorOrYear(String input) {
        List<Book> result = books.stream()
                .filter(book -> book.author().equalsIgnoreCase(input) || book.year().equals(input))
                .toList();

        result.forEach(System.out::println);
    }

    public void sortAndDisplay(String mode) {
        List<Book> sortedBooks;
        if ("author".equalsIgnoreCase(mode)) {
            sortedBooks = books.stream()
                    .sorted(Comparator.comparing(Book::author))
                    .collect(Collectors.toList());
        } else {
            sortedBooks = books.stream()
                    .sorted(Comparator.comparing(Book::name))
                    .collect(Collectors.toList());
        }
        sortedBooks.forEach(System.out::println);
    }

    public void searchByYearRange(int startYear, int endYear) {
        List<Book> result = books.stream()
                .filter(book -> Integer.parseInt(book.year()) >= startYear && Integer.parseInt(book.year()) <= endYear)
                .toList();

        result.forEach(System.out::println);
    }

    public void start() {

        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {


                System.out.println("Выберите действие:");
                System.out.println("1 - Показать все книги");
                System.out.println("2 - Поиск по автору или году");
                System.out.println("3 - Сортировать и показать книги");
                System.out.println("4 - Поиск книг по диапазону годов");
                System.out.println("0 - Выход");

                int choice = scanner.nextInt();
                scanner.nextLine(); // очистка буфера


                switch (choice) {
                    case 1 -> displayAll();
                    case 2 -> { System.out.println("Введите автора или год:");
                                String input = scanner.nextLine();
                                searchByAuthorOrYear(input); }
                    case 3 -> { System.out.println("Сортировать по: author или name?");
                                String mode = scanner.nextLine();
                                sortAndDisplay(mode); }
                    case 4 -> { System.out.println("Введите начальный и конечный год:");
                                int startYear = scanner.nextInt();
                                int endYear = scanner.nextInt();
                                searchByYearRange(startYear, endYear); }
                    case 0 -> { System.out.println("Выход...");
                                scanner.close();
                                return; }
                    default -> System.out.println("Некорректный выбор");
                }
            }
        }
        catch (NumberFormatException | NoSuchElementException | ArrayIndexOutOfBoundsException | IllegalStateException e) {
            logger.severe("unable to operate with file: " + e.getMessage());
        }
    }
}
