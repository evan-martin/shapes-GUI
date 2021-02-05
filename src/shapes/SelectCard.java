package shapes;

import javax.swing.*;
import java.awt.*;

public class SelectCard extends JPanel {

    public SelectCard(JPanel contentPane) {

        //create radio buttons
        JRadioButton circleButton = new JRadioButton("Circle");
        circleButton.setSelected(true);
        JRadioButton squareButton = new JRadioButton("Square");
        JRadioButton rectangleButton = new JRadioButton("Rectangle");
        JRadioButton triangleButton = new JRadioButton("Triangle");

        //group radio buttons
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(circleButton);
        buttonGroup.add(squareButton);
        buttonGroup.add(rectangleButton);
        buttonGroup.add(triangleButton);

        //create radio panel and add to the card
        JPanel radioPanel = new JPanel(new GridLayout(0, 1));
        radioPanel.add(circleButton);
        radioPanel.add(squareButton);
        radioPanel.add(rectangleButton);
        radioPanel.add(triangleButton);
        add(radioPanel);

        //create and add build button
        JButton buildShapeButton = new JButton("Build Shape");
        add(buildShapeButton);

        //action listener for build button
        buildShapeButton.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.next(contentPane);
        });
    }
}
