package converter_2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

class BookLoader {

    private static final Logger logger = Logger.getLogger(BookLoader.class.getName());

    public List<Book> loadBooks(String filepath) {
        List<Book> books = new ArrayList<>();
        try {
            File xmlFile = new File(filepath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("book");

            for (int i = 0; i < nList.getLength(); i++) {
                Element element = (Element) nList.item(i);
                String author = element.getElementsByTagName("author").item(0).getTextContent();
                String year = element.getElementsByTagName("year").item(0).getTextContent();
                String name = element.getElementsByTagName("name").item(0).getTextContent();
                books.add(new Book(author, year, name));
            }
        } catch (IOException | SAXException | ParserConfigurationException e) {
            logger.severe("unable to operate with file: " + e.getMessage());
        }
        return books;
    }
}