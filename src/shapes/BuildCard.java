package shapes;

import javax.swing.*;
import java.awt.*;

public class BuildCard extends JPanel {

    public BuildCard(JPanel contentPane) {

        JButton backButton = new JButton("Back");

        backButton.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.next(contentPane);
        });

        add(backButton);

        JTextField shapeName = new JTextField("build card");
        add(shapeName);


    }
}
