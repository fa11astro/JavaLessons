package converter;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("log.txt", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.setUseParentHandlers(false);
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка при сохранении данных", e);
        }
    }

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();/* из стандартной библиотеки, используется для
                                                                                     создания объектов, способных парсить XML-документы */

            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File("file.xml"));
            document.getDocumentElement().normalize(); // приводит к стандартному виду
            NodeList bookList = document.getElementsByTagName("book"); // объект, хранящий коллекцию книг
            StringBuilder jsonBuilder = new StringBuilder();
            jsonBuilder.append("{\n  \"books\": [\n");

            for (int i = 0; i < bookList.getLength(); i++) {
                Node bookNode = bookList.item(i);

                if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element bookElement = (Element) bookNode;

                    String id = bookElement.getAttribute("id");
                    String author = bookElement.getElementsByTagName("author").item(0).getTextContent();
                    String name = bookElement.getElementsByTagName("name").item(0).getTextContent();
                    String year = bookElement.getElementsByTagName("year").item(0).getTextContent();

                    jsonBuilder.append("    {\n");
                    jsonBuilder.append("      \"id\": \"").append(id).append("\",\n");
                    jsonBuilder.append("      \"author\": \"").append(author).append("\",\n");
                    jsonBuilder.append("      \"name\": \"").append(name).append("\",\n");
                    jsonBuilder.append("      \"year\": \"").append(year).append("\"\n");
                    jsonBuilder.append("    }");

                    if (i < bookList.getLength() - 1) {
                        jsonBuilder.append(",");
                    }
                    jsonBuilder.append("\n");
                }
            }

            jsonBuilder.append("  ]\n}");

            try (FileWriter file = new FileWriter("file.json")) {
                file.write(jsonBuilder.toString());
                logger.log(Level.INFO, "JSON файл успешно создан: file.json");
            }

        } catch (IOException | ParserConfigurationException | SAXException e) {
            logger.log(Level.SEVERE, "Ошибка при сохранении данных", e);
        }
    }
}