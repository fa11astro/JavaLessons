package chesslab;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        if (args.length == 0)
        {
            return;
        }

        try (FileReader fr = new FileReader("Ласкер-Капабланка.txt");)
        {
            // Ищем имена
            System.out.println(args[0]);
            String[] names = args[0].replaceAll("\\..*", "").split("-");
            System.out.println("Игроки: " + names[0] + " " + names[1]);
            Scanner scanner = new Scanner(fr);
            while (scanner.hasNext())
            {
                String line = scanner.nextLine();
                if (line.matches("\\d\\. \\w{2,}.*"))
                {
                    System.out.println(line);
                }
                else if (line.matches("\\d-\\d"))
                {
                    System.out.println("Результат: " + line);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

// try (ресурсы) {
// } catch (...) {}
// implements AutoClosable