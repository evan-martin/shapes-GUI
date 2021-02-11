// CMSC 335
// Project 2
// Evan Martin
// February 9, 2021

//ShapesGUI.java
// This class creates the main frame, a content pane, and a card layout.
// Each card contains a shape object and the visible card switched with a combo box.

//Reference: https://stackoverflow.com/questions/11648208/switch-panels-in-a-jframe
//Reference: https://stackoverflow.com/questions/34168628/gui-application-that-allows-the-user-to-choose-the-shape-and-color-of-a-drawing
//Reference: https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/layout/CardLayoutDemoProject/src/layout/CardLayoutDemo.java

package shapes;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ShapesGUI extends JFrame {

    final static String CIRCLE = "Circle";
    final static String RECTANGLE = "Rectangle";
    final static String SQUARE = "Square";
    final static String TRIANGLE = "Triangle";
    final static String SPHERE = "Sphere";
    final static String CUBE = "Cube";
    final static String CONE = "Cone";
    final static String CYLINDER = "Cylinder";
    final static String TORUS = "Torus";

    public ShapesGUI() {

        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }

            JFrame frame = new JFrame("Shape Builder");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new ContentPane());
            frame.setSize(600, 600);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    public static class ContentPane extends JPanel implements ItemListener {

        JPanel cards;

        public ContentPane() {

            setLayout(new BorderLayout());

            JPanel comboBoxPane = new JPanel();
            String[] comboBoxItems = {CIRCLE, RECTANGLE, SQUARE, TRIANGLE, SPHERE, CUBE, CONE, CYLINDER, TORUS};
            JComboBox<String> cb = new JComboBox<>(comboBoxItems);
            cb.setEditable(false);
            cb.addItemListener(this);
            comboBoxPane.add(cb);
            add(comboBoxPane, BorderLayout.PAGE_START);

            Circle circle = new Circle();
            Rectangle rectangle = new Rectangle();
            Square square = new Square();
            Triangle triangle = new Triangle();
            Sphere sphere = new Sphere();
            Cube cube = new Cube();
            Cone cone = new Cone();
            Cylinder cylinder = new Cylinder();
            Torus torus = new Torus();

            cards = new JPanel(new CardLayout());
            cards.add(circle, CIRCLE);
            cards.add(rectangle, RECTANGLE);
            cards.add(square, SQUARE);
            cards.add(triangle, TRIANGLE);
            cards.add(sphere, SPHERE);
            cards.add(cube, CUBE);
            cards.add(cone, CONE);
            cards.add(cylinder, CYLINDER);
            cards.add(torus, TORUS);

            add(cards);
        }

        public void itemStateChanged(ItemEvent e) {
            CardLayout cl = (CardLayout) (cards.getLayout());
            cl.show(cards, (String) e.getItem());
        }
    }

    public static void main(String[] args) {
        new ShapesGUI();
    }
}