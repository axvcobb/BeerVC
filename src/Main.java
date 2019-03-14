import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args){

        JFrame frame = new JFrame();

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
        });
    }
}
