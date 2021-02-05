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

public class TwoDimensionalShape extends Shape {

    private float area;

    public TwoDimensionalShape() {
        super(2);
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public String toString(){
        return String.valueOf(area);
    }
}

class Circle extends TwoDimensionalShape {

    private final float radius;

    public Circle(float radius) {
        this.radius = radius;
        calculateArea();
    }

    private void calculateArea() {
        setArea((float) (Math.PI * Math.pow(radius, 2)));
    }
}


class Rectangle extends TwoDimensionalShape {

    private final float length;
    private final float width;

    public Rectangle(float length, float width) {
        this.length = length;
        this.width = width;
        calculateArea();
    }

    private void calculateArea() {
        setArea((length * width));
    }
}

class Square extends TwoDimensionalShape {

    private final float length;

    public Square(float length) {
        this.length = length;
        calculateArea();
    }

    private void calculateArea() {
        setArea((length * length));
    }
}

class Triangle extends TwoDimensionalShape {

    private final float base;
    private final float height;

    public Triangle(float base, float height) {
        this.base = base;
        this.height = height;
        calculateArea();
    }

    private void calculateArea() {
        setArea(((float) .5 * (base) * (height)));
    }
}







