package hw;

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

public class Main {

    public static void main(String[] args) throws IOException, SAXException {
        File f = new File("email.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            Document doc = builder.parse(f);


            ArrayList<Object> emails = new ArrayList<>();
            NodeList emailElements = doc.getElementsByTagName("email");

            for (int i = 0; i < emailElements.getLength(); i++) {
                Element email = (Element) emailElements.item(i);
                emails.add(new Object(
                        Integer.parseInt(email.getElementsByTagName("id").item(0).getTextContent())
                        , email.getElementsByTagName("to").item(0).getTextContent()
                        , email.getElementsByTagName("from").item(0).getTextContent()
                        , email.getElementsByTagName("heading").item(0).getTextContent()
                        , email.getElementsByTagName("body").item(0).getTextContent()));
            }

            System.out.println(emails);
        }
    }
}

