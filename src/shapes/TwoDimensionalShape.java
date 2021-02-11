// CMSC 335
// Project 2
// Evan Martin
// February 9, 2021

//TwoDimensionalShape.java
// The first class contains panels, fields, and labels common to two dimensional objects.
// The various shape classes define their respective shape.
// The final class defines a panel in which the various shapes are drawn.

package shapes;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

public class TwoDimensionalShape extends Shape {

    TwoDimensionDrawPane drawPane = new TwoDimensionDrawPane();
    JButton button = new JButton("Calculate Area & Draw Shape");

    JLabel areaLabel = new JLabel("Area:", JLabel.CENTER);
    JTextField areaField = new JTextField(20);
    JPanel areaPanel = new JPanel();

    public TwoDimensionalShape() {

        areaField.setEditable(false);
        areaPanel.add(areaLabel);
        areaPanel.add(areaField);
        resultPanel.add(button);
        resultPanel.add(areaPanel);

        add(drawPane);
    }
}

class Circle extends TwoDimensionalShape {

    private float radius;

    public Circle() {

        inputPanel.add(radiusLabel);
        inputPanel.add(radiusText);
        inputPanel.add(spacerField);

        button.addActionListener(e -> {
            radius = Float.parseFloat(radiusText.getText());
            drawPane.setCircle(radius);
            areaField.setText(calculateArea(radius));
        });
    }

    private String calculateArea(float radius) {
        return (String.valueOf((Math.PI * Math.pow(radius, 2))));
    }
}

class Rectangle extends TwoDimensionalShape {

    private float length;
    private float width;

    public Rectangle() {

        inputPanel.add(lengthLabel);
        inputPanel.add(lengthText);
        inputPanel.add(widthLabel);
        inputPanel.add(widthText);

        button.addActionListener(e -> {
            length = Float.parseFloat(lengthText.getText());
            width = Float.parseFloat(widthText.getText());
            drawPane.setRectangle(length, width);
            areaField.setText(calculateArea(length, width));
        });
    }

    private String calculateArea(float length, float width) {
        return String.valueOf(((length * width)));
    }
}

class Square extends TwoDimensionalShape {

    private float length;

    public Square() {

        inputPanel.add(lengthLabel);
        inputPanel.add(lengthText);
        inputPanel.add(spacerField);

        button.addActionListener(e -> {
            length = Integer.parseInt(lengthText.getText());
            drawPane.setSquare(length);
            areaField.setText(calculateArea(length));
        });
    }

    private String calculateArea(float length) {
        return String.valueOf(((length * length)));
    }
}

class Triangle extends TwoDimensionalShape {

    private float base;
    private float height;

    public Triangle() {

        inputPanel.add(heightLabel);
        inputPanel.add(heightText);
        inputPanel.add(baseLabel);
        inputPanel.add(baseText);

        button.addActionListener(e -> {
            base = Float.parseFloat(baseText.getText());
            height = Float.parseFloat(heightText.getText());
            drawPane.setTriangle(base, height);
            areaField.setText(calculateArea(base, height));
        });
    }

    private String calculateArea(float base, float height) {
        return String.valueOf(.5 * (base) * (height));
    }
}

class TwoDimensionDrawPane extends JPanel {

    private int x = 0;
    private int y = 0;
    String shape = "";

    public void setCircle(float radius) {
        shape = "circle";
        x = (int) radius;
        y = (int) radius;
        repaint();
    }

    public void setRectangle(float length, float width) {
        shape = "rectangle";
        x = (int) width;
        y = (int) length;
        repaint();
    }

    public void setSquare(float length) {
        shape = "square";
        x = (int) length;
        y = (int) length;
        repaint();
    }

    public void setTriangle(float base, float height) {
        shape = "triangle";
        x = (int) base;
        y = (int) height;
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        if (shape.equals("circle")) {
            g2d.drawOval(50, 50, x, y);
        }

        if (shape.equals("rectangle") || shape.equals("square")) {
            g2d.drawRect(50, 50, x, y);
        }

        if (shape.equals("triangle")) {
            Image image = getToolkit().getImage("src/images/triangle.png");
            g.drawImage(image, 50, 50, this);
        }
    }
}