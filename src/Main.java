import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.JDOMException;


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

        try {

            File inputFile = new File("recipes.xml");
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputFile);
            System.out.println("Root element: " + document.getRootElement().getName());
            Element recipesElement = document.getRootElement();

            List<Element> recipes = recipesElement.getChildren();

            List<Element> hops = recipesElement.getChildren().get(0).getChildren("HOPS").get(0).getChildren("HOP");

            List<Element> fermentables = recipesElement.getChildren().get(0).getChildren("FERMENTABLES").get(0).getChildren("FERMENTABLE");

            List<Element> miscs = recipesElement.getChildren().get(0).getChildren("MISCS").get(0).getChildren("MISC");

            List<Element> yeasts = recipesElement.getChildren().get(0).getChildren("YEASTS").get(0).getChildren("YEAST");

            System.out.println("----------------------------");

            parseRecipe(recipes);
            parseFermentables(fermentables);
            parseMiscs(miscs);
            parseHops(hops);
            parseYeasts(yeasts);

        } catch(JDOMException e) {

            e.printStackTrace();

        } catch(IOException ioe) {

            ioe.printStackTrace();

        }

    }

    private static void parseRecipe(List<Element> recipes) {

        for(Element recipe : recipes) {

            System.out.println("Recipe Name: "
                    + recipe.getChild("NAME").getText() + "\n");
        }

    }

    private static void parseFermentables(List<Element> fermentables) {

        for(Element fermentable : fermentables) {

            System.out.println("Name: "
                    + fermentable.getChild("NAME").getText());
            System.out.println("Amount: "
                    + fermentable.getChild("DISPLAY_AMOUNT").getText() + "\n");
        }

    }

    private static void parseMiscs(List<Element> miscs) {

        for(Element misc : miscs) {

            System.out.println("Name: "
                    + misc.getChild("NAME").getText());
            System.out.println("Type: "
                    + misc.getChild("TYPE").getText());
            System.out.println("Amount: "
                    + misc.getChild("DISPLAY_AMOUNT").getText() + "\n");
        }

    }

    private static void parseHops(List<Element> hops) {

        for(Element hop : hops) {

            System.out.println("Name: "
                    + hop.getChild("NAME").getText());
            System.out.println("Time: "
                    + hop.getChild("DISPLAY_TIME").getText() + "\n");
        }

    }

    private static void parseYeasts(List<Element> yeasts) {

        for(Element yeast : yeasts) {

            System.out.println("Laboratory: "
                    + yeast.getChild("LABORATORY").getText());
            System.out.println("Name: "
                    + yeast.getChild("NAME").getText() + "\n");
        }

    }

}
