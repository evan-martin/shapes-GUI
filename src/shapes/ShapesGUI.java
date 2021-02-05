//CardLayout Reference: https://stackoverflow.com/questions/11648208/switch-panels-in-a-jframe

package shapes;

import java.awt.*;
import javax.swing.*;

public class ShapesGUI {

    private void shapesGUI() {

        JFrame frame = new JFrame("Shape Builder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 200);
        frame.setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new CardLayout());
        SelectCard selectCard = new SelectCard(contentPane);
        BuildCard buildCard = new BuildCard(contentPane);
        contentPane.add(selectCard);
        contentPane.add(buildCard);

        frame.setContentPane(contentPane);
        frame.setVisible(true);
    }

    public static void main(String... args) {
        new ShapesGUI().shapesGUI();
    }
}
