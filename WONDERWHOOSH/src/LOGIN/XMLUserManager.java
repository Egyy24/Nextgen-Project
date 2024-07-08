package LOGIN;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLUserManager {
    private static final String FILE_NAME = "Register.xml";

    public void saveUser(String username, String email, String password) {
        try {
            File file = new File(FILE_NAME);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc;

            if (file.exists()) {
                doc = dBuilder.parse(file);
                doc.getDocumentElement().normalize();
            } else {
                doc = dBuilder.newDocument();
                Element rootElement = doc.createElement("users");
                doc.appendChild(rootElement);
            }

            Element userElement = doc.createElement("user");
            
            Element usernameElement = doc.createElement("username");
            usernameElement.appendChild(doc.createTextNode(username));
            userElement.appendChild(usernameElement);

            Element emailElement = doc.createElement("email");
            emailElement.appendChild(doc.createTextNode(email));
            userElement.appendChild(emailElement);

            Element passwordElement = doc.createElement("password");
            passwordElement.appendChild(doc.createTextNode(password));
            userElement.appendChild(passwordElement);

            doc.getDocumentElement().appendChild(userElement);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean authenticateUser(String username, String password) {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                return false;
            }

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList userList = doc.getElementsByTagName("user");

            for (int i = 0; i < userList.getLength(); i++) {
                Node userNode = userList.item(i);
                if (userNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element userElement = (Element) userNode;
                    String storedUsername = userElement.getElementsByTagName("username").item(0).getTextContent();
                    String storedPassword = userElement.getElementsByTagName("password").item(0).getTextContent();
                    if (username.equals(storedUsername) && password.equals(storedPassword)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

