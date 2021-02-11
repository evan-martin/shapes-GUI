// CMSC 335
// Project 2
// Evan Martin
// February 9, 2021

//ThreeDimensionalShape.java
// The first class contains panels, fields, and labels common to three dimensional objects.
// The various shape classes define their respective shape.
// The final class defines a panel in which the various shapes are drawn.

package shapes;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Graphics;
import java.awt.Image;

public class ThreeDimensionalShape extends Shape {

    ThreeDimensionDrawPane drawPane = new ThreeDimensionDrawPane();
    JButton button = new JButton("Calculate Volume & Draw Shape");

    JLabel volumeLabel = new JLabel("Volume:", JLabel.CENTER);
    JTextField volumeField = new JTextField(20);
    JPanel volumePanel = new JPanel();

    public ThreeDimensionalShape() {

        volumeField.setEditable(false);
        volumePanel.add(volumeLabel);
        volumePanel.add(volumeField);
        resultPanel.add(button);
        resultPanel.add(volumePanel);

        add(drawPane);
    }
}

class Sphere extends ThreeDimensionalShape {

    private float radius;

    public Sphere() {

        inputPanel.add(radiusLabel);
        inputPanel.add(radiusText);
        inputPanel.add(spacerField);

        button.addActionListener(e -> {
            radius = Float.parseFloat(radiusText.getText());
            drawPane.setSphere();
            volumeField.setText(calculateVolume(radius));
        });
    }

    public String calculateVolume(float radius) {
        return (String.valueOf((4 / 3d) * (Math.PI * Math.pow(radius, 3))));
    }
}

class Cube extends ThreeDimensionalShape {

    private float length;

    public Cube() {

        inputPanel.add(lengthLabel);
        inputPanel.add(lengthText);
        inputPanel.add(spacerField);

        button.addActionListener(e -> {
            length = Float.parseFloat(lengthText.getText());
            drawPane.setCube();
            volumeField.setText(calculateVolume(length));
        });
    }

    public String calculateVolume(float length) {
        return String.valueOf(Math.pow(length, 3));
    }
}

class Cone extends ThreeDimensionalShape {

    private float radius;
    private float height;

    public Cone() {

        inputPanel.add(radiusLabel);
        inputPanel.add(radiusText);
        inputPanel.add(heightLabel);
        inputPanel.add(heightText);

        button.addActionListener(e -> {
            radius = Float.parseFloat(radiusText.getText());
            height = Float.parseFloat(heightText.getText());
            drawPane.setCone();
            volumeField.setText(calculateVolume(radius, height));
        });
    }

    public String calculateVolume(float radius, float height) {
        return String.valueOf(((1 / 3d) * (Math.PI * Math.pow(radius, 2)) * height));
    }
}

class Cylinder extends ThreeDimensionalShape {

    private float radius;
    private float height;

    public Cylinder() {

        inputPanel.add(radiusLabel);
        inputPanel.add(radiusText);
        inputPanel.add(heightLabel);
        inputPanel.add(heightText);

        button.addActionListener(e -> {
            radius = Float.parseFloat(radiusText.getText());
            height = Float.parseFloat(heightText.getText());
            drawPane.setCylinder();
            volumeField.setText(calculateVolume(radius, height));
        });
    }

    public String calculateVolume(float radius, float height) {
        return String.valueOf((Math.PI * Math.pow(radius, 2)) * height);
    }
}

class Torus extends ThreeDimensionalShape {

    private float radius;
    private float majorRadius;

    public Torus() {

        inputPanel.add(radiusLabel);
        inputPanel.add(radiusText);
        inputPanel.add(majorRadiusLabel);
        inputPanel.add(majorRadiusText);

        button.addActionListener(e -> {
            radius = Float.parseFloat(radiusText.getText());
            majorRadius = Float.parseFloat(majorRadiusText.getText());
            drawPane.setTorus();
            volumeField.setText(calculateVolume(radius, majorRadius));
        });
    }

    public String calculateVolume(float radius, float majorRadius) {
        return String.valueOf((Math.PI * Math.pow(radius, 2) * (2 * Math.PI * majorRadius)));
    }
}

class ThreeDimensionDrawPane extends JPanel {

    String shape = "";

    public void setSphere() {
        shape = "sphere";
        repaint();
    }

    public void setCube() {
        shape = "cube";
        repaint();
    }

    public void setCone() {
        shape = "cone";
        repaint();
    }

    public void setCylinder() {
        shape = "cylinder";
        repaint();
    }

    public void setTorus() {
        shape = "torus";
        repaint();
    }

    @Override
    public java.awt.Dimension getPreferredSize() {
        return new java.awt.Dimension(500, 500);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (shape.equals("sphere")) {
            Image image = getToolkit().getImage("src/images/sphere.png");
            g.drawImage(image, 50, 50, this);
        }

        if (shape.equals("cube")) {
            Image image = getToolkit().getImage("src/images/cube.png");
            g.drawImage(image, 50, 50, this);
        }

        if (shape.equals("cone")) {
            Image image = getToolkit().getImage("src/images/cone.png");
            g.drawImage(image, 50, 50, this);
        }

        if (shape.equals("cylinder")) {
            Image image = getToolkit().getImage("src/images/cylinder.png");
            g.drawImage(image, 50, 50, this);
        }

        if (shape.equals("torus")) {
            Image image = getToolkit().getImage("src/images/torus.png");
            g.drawImage(image, 50, 50, this);
        }
    }
}