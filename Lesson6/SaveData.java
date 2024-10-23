package ownLibraryPrototype;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SaveData {
    private static final Logger logger = Logger.getLogger(SaveData.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("log.txt", true); // true для добавления в файл
            fileHandler.setFormatter(new SimpleFormatter());
            logger.setUseParentHandlers(false);
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка при сохранении данных", e);
        }
    }

    private final Data data;
    private final int k;

    public SaveData(Data data, int k) {
        this.data = data;
        this.k = k;
    }

    public void saveToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("{\n");
            boolean firstField = true;

            for (Field field : data.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                int value = (int)(field.get(data));

                if (field.isAnnotationPresent(Ok.class)) {
                    if (!firstField) writer.write(",\n");
                    writer.write(String.format("  \"%s\": \"%d\"", field.getName(), value));
                    firstField = false;
                } else if (field.isAnnotationPresent(Ugly.class)) {
                    Random random = new Random();
                    int randomValue = random.nextInt(2 * k + 1) - k;
                    if (!firstField) writer.write(",\n");
                    writer.write(String.format("  \"%s\": \"%d\"", field.getName(), randomValue));
                    firstField = false;
                } else {
                    logger.log(Level.INFO, "Поле без аннотации: {0}, Значение: {1}", new Object[]{field.getName(), value});
                }

                field.setAccessible(false);
            }
            writer.write("\n}");
        } catch (IOException | IllegalAccessException e) {
            logger.log(Level.SEVERE, "Ошибка при сохранении данных", e);
        }
    }
}
