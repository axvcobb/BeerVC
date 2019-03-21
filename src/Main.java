/*import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.util.*;
import java.util.List;
import java.util.stream.Stream;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;*/


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


public class Main {

    public static void main(String[] args){

        /* JFrame frame = new JFrame();

        JButton upload = new JButton("Upload BeerXML");
        JTextField field = new JTextField(" ");
        upload.setBounds(130,100,150, 40);
        field.setBounds(130, 150, 150, 40);

        frame.add(upload);
        frame.add(field);

        frame.setSize(400,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(true);

        upload.doClick();

        upload.addActionListener((e) -> {
            field.setText("Clicked");
        }); */

        /*try {
            File inputFile = new File("recipes.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            parseRecipe(doc);
            parseHops(doc);
            parseFermentables(doc);
        } catch (Exception e){

        } */

        try {
            File inputFile = new File("recipes.xml");
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputFile);
            System.out.println("Root element: " + document.getRootElement().getName());
            Element recipesElement = document.getRootElement();

            List<Element> recipesList = recipesElement.getChildren().get(0).getChildren();

            System.out.println("----------------------------");

            List<Element> recipeList = recipesList.get(0).getChildren("HOPS");

            /* for (int temp = 0; temp < recipeList.size(); temp++) {

                Element student = recipeList.get(temp);
                System.out.println("\nCurrent Element: "
                        + student.getName());
            } */
            recipesList.forEach(System.out::println);
        } catch (Exception e) {

        }

    }

    /* private static void banana() {
         System.out.println("Banana");
    }

    private static void parseRecipe(Document doc){

        NodeList recipes = doc.getElementsByTagName("*");
        System.out.println("----------------------------");

        for (int temp = 0; temp < recipes.getLength(); temp++) {
            Node nNode = recipes.item(temp);
            System.out.println("\nCurrent Element: " + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Name: "
                        + eElement
                        .getElementsByTagName("NAME")
                        .item(0)
                        .getTextContent());
                System.out.println("Type: "
                        + eElement
                        .getElementsByTagName("TYPE")
                        .item(0)
                        .getTextContent());
                System.out.println("Brewer: "
                        + eElement
                        .getElementsByTagName("BREWER")
                        .item(0)
                        .getTextContent());
            }
        }
    }

    private static void parseHops(Document doc){

        NodeList hops = doc.getElementsByTagName("HOP");
        System.out.println("----------------------------");

        for (int temp = 0; temp < hops.getLength(); temp++) {
            Node nnNode = hops.item(temp);
            System.out.println("\nCurrent Element: " + nnNode.getNodeName());

            if (nnNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nnNode;
                System.out.println("Hop Name: "
                        + eElement
                        .getElementsByTagName("NAME")
                        .item(0)
                        .getTextContent());
                System.out.println("Hop Time: "
                        + eElement
                        .getElementsByTagName("DISPLAY_TIME")
                        .item(0)
                        .getTextContent());
            }
        }
    }

    private static void parseFermentables(Document doc){

        NodeList fermentable = doc.getElementsByTagName("FERMENTABLE");
        System.out.println("----------------------------");

        for (int temp = 0; temp < fermentable.getLength(); temp++) {
            Node nnNode = fermentable.item(temp);
            System.out.println("\nCurrent Element: " + nnNode.getNodeName());

            if (nnNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nnNode;
                System.out.println("Fermentable Name: "
                        + eElement
                        .getElementsByTagName("NAME")
                        .item(0)
                        .getTextContent());
                System.out.println("Amount: "
                        + eElement
                        .getElementsByTagName("DISPLAY_AMOUNT")
                        .item(0)
                        .getTextContent());
            }
        }
    } */
}
