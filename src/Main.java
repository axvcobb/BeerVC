import java.io.File;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
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

        try {

            File inputFile = new File("recipes.xml");
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputFile);
            System.out.println("Root element: " + document.getRootElement().getName());
            Element recipesElement = document.getRootElement();

            List<Element> recipe = recipesElement.getChildren();

            List<Element> hops = recipesElement.getChildren().get(0).getChildren("HOPS").get(0).getChildren("HOP");

            System.out.println("----------------------------");

            parseRecipe(recipe);
            parseHops(hops);

        } catch (Exception e) {

            System.out.println("There is an issue with the XML");

        }

    }

    private static void parseRecipe(List<Element> recipe) {

        for (int temp = 0; temp < recipe.size(); temp++) {

            Element student = recipe.get(temp);
            System.out.println("Name: "
                    + student.getChild("NAME").getText() + "\n");
        }

    }

    private static void parseHops(List<Element> hops) {

        for (int temp = 0; temp < hops.size(); temp++) {

            Element student = hops.get(temp);
            System.out.println("Name: "
                    + student.getChild("NAME").getText());
            System.out.println("Time: "
                    + student.getChild("DISPLAY_TIME").getText() + "\n");
        }

    }

}
