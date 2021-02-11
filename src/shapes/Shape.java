// CMSC 335
// Project 2
// Evan Martin
// February 9, 2021

//Shape.java
// This class contains panels, fields, and labels common to both two dimensional
// and three dimensional shapes.

package shapes;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class Shape extends JPanel {

    JPanel inputPanel = new JPanel();
    JPanel resultPanel = new JPanel();
    JPanel spacerField = new JPanel();

    JLabel radiusLabel = new JLabel("Enter Radius", JLabel.CENTER);
    JTextField radiusText = new JTextField(20);

    JLabel majorRadiusLabel = new JLabel("Enter Major Radius", JLabel.CENTER);
    JTextField majorRadiusText = new JTextField(20);

    JLabel lengthLabel = new JLabel("Enter Length", JLabel.CENTER);
    JTextField lengthText = new JTextField(20);

    JLabel widthLabel = new JLabel("Enter Width", JLabel.CENTER);
    JTextField widthText = new JTextField(20);

    JLabel heightLabel = new JLabel("Enter Height", JLabel.CENTER);
    JTextField heightText = new JTextField(20);

    JLabel baseLabel = new JLabel("Enter Base", JLabel.CENTER);
    JTextField baseText = new JTextField(20);

    Shape() {

        inputPanel.setLayout(new GridLayout(2, 1));
        resultPanel.setLayout(new GridLayout(3, 1));
        add(inputPanel);
        add(resultPanel);
    }
}
