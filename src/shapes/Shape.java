// CMSC 335
// Project 1
// Evan Martin
// January 26, 2021

//Shape.java
// This class defines the Shape object and contains the attribute numberOfDimensions

package shapes;

public class Shape { //extends Object

    public final int numberOfDimensions;

    public Shape(int numberOfDimensions) {
        this.numberOfDimensions = numberOfDimensions;
    }
}