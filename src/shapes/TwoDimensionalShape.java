// CMSC 335
// Project 1
// Evan Martin
// January 26, 2021

//TwoDimensionalShape.java
// The first class defines the TwoDimensionalShape object and
// contains the area attribute
// The rest of the classes in the file define various 2d shapes
// and calculates their areas

package shapes;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;

public class TwoDimensionalShape extends JPanel {

    DrawPane drawPane;
    JButton button = new JButton("Draw");
    JLabel lengthLabel = new JLabel("Enter Length", JLabel.CENTER);
    JTextField lengthText = new JTextField(20);
    JPanel inputPanel = new JPanel();

}

class Circle extends TwoDimensionalShape {

    public Circle() {

        JLabel radiusLabel = new JLabel("Enter Radius", JLabel.CENTER);
        JTextField radiusText = new JTextField(20);
        inputPanel.setLayout(new GridLayout(1,1));
        inputPanel.add(radiusLabel);
        inputPanel.add(radiusText);
        add(inputPanel);
        add(button);

        button.addActionListener(e -> {
            drawPane.setCircle(Float.parseFloat(radiusText.getText()));
        });

        drawPane = new DrawPane();
        add(drawPane);
    }


}

class Rectangle extends TwoDimensionalShape {

    public Rectangle() {

        JLabel widthLabel = new JLabel("Enter Width", JLabel.CENTER);
        JTextField widthText = new JTextField(20);
        inputPanel.setLayout(new GridLayout(2,1));
        inputPanel.add(lengthLabel);
        inputPanel.add(lengthText);
        inputPanel.add(widthLabel);
        inputPanel.add(widthText);
        add(inputPanel);
        add(button);

        button.addActionListener(e -> {
            drawPane.setRectangle(
                    Integer.parseInt(lengthText.getText()),
                    Integer.parseInt(widthText.getText())
            );
        });

        drawPane = new DrawPane();
        add(drawPane);
    }
}

class Square extends TwoDimensionalShape {

    public Square(){
        inputPanel.setLayout(new GridLayout(1,1));
        inputPanel.add(lengthLabel);
        inputPanel.add(lengthText);
        add(inputPanel);
        add(button);

        button.addActionListener(e -> {
            drawPane.setSquare(Integer.parseInt(lengthText.getText()));
        });

        drawPane = new DrawPane();
        add(drawPane);
    }
}

class Triangle extends TwoDimensionalShape{

    public Triangle(){

        JLabel baseLabel = new JLabel("Enter Base", JLabel.CENTER);
        JTextField baseText = new JTextField(20);
        JLabel heightLabel = new JLabel("Enter Height", JLabel.CENTER);
        JTextField heightText = new JTextField(20);
        inputPanel.setLayout(new GridLayout(2,1));
        inputPanel.add(heightLabel);
        inputPanel.add(heightText);
        inputPanel.add(baseLabel);
        inputPanel.add(baseText);
        add(inputPanel);
        add(button);

        button.addActionListener(e -> {
            drawPane.setTriangle(
                    Integer.parseInt(baseText.getText()),
                    Integer.parseInt(heightText.getText())
            );
        });

        drawPane = new DrawPane();
        add(drawPane);
    }
}

class DrawPane extends JPanel {

    private int x = 0;
    private int y = 0;
    String shape = "circle";

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

    public void setSquare(float length){
        shape = "square";
        x = (int) length;
        y = (int) length;
        repaint();
    }

    public void setTriangle(float base, float height){
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

        if(shape.equals("circle")) {
            g2d.drawOval(50, 50, x, y);
        }

        if(shape.equals("rectangle") || shape.equals("square")) {
            g2d.drawRect(50, 50, x, y);
        }

        if(shape.equals("triangle")){
            Image image = getToolkit().getImage("images/triangle.png");
            g.drawImage(image,50,50, this);
        }
    }
}