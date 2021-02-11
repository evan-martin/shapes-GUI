//CardLayout Reference: https://stackoverflow.com/questions/11648208/switch-panels-in-a-jframe

package shapes;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class ShapesGUI extends JFrame{

    final static String CIRCLE = "Circle";
    final static String RECTANGLE = "Rectangle";
    final static String SQUARE = "Square";
    final static String TRIANGLE = "Triangle";
    final static String SPHERE = "Sphere";
    final static String CUBE = "Cube";
    final static String CONE = "Cone";
    final static String CYLINDER = "Cylinder";
    final static String TORUS = "Torus";

    public static void main(String[] args) {
        new ShapesGUI();
    }

    public ShapesGUI() {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }

            JFrame frame = new JFrame("Testing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new ControlPane());
            frame.setSize(600,600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    public static class ControlPane extends JPanel  implements ItemListener {

        JPanel cards;

        public ControlPane(){

            setLayout(new BorderLayout());

            JPanel comboBoxPane = new JPanel();
            String[] comboBoxItems = {CIRCLE, RECTANGLE, SQUARE, TRIANGLE, SPHERE, CUBE, CONE, CYLINDER, TORUS};
            JComboBox<String> cb = new JComboBox<>(comboBoxItems);
            cb.setEditable(false);
            cb.addItemListener( this);
            comboBoxPane.add(cb);
            add(comboBoxPane, BorderLayout.PAGE_START);


            Circle circle = new Circle();
            Rectangle rectangle = new Rectangle();
            Square square = new Square();
            Triangle triangle = new Triangle();

            cards = new JPanel(new CardLayout());

            cards.add(circle, CIRCLE);
            cards.add(rectangle, RECTANGLE);
            cards.add(square, SQUARE);
            cards.add(triangle, TRIANGLE);

            add(cards);

        }

        public void itemStateChanged(ItemEvent e) {
            CardLayout cl = (CardLayout)(cards.getLayout());
            cl.show(cards, (String)e.getItem());
        }
    }
}