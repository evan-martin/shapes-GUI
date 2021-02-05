// CMSC 335
// Project 1
// Evan Martin
// January 26, 2021

//ThreeDimensionalShape.java
// The first class defines the ThreeDimensionalShape object and
// contains the volume attribute
// The rest of the classes in the file define various 3d shapes
// and calculates their volumes

package shapes;

public class ThreeDimensionalShape extends Shape {

    private float volume;

    public ThreeDimensionalShape() {
        super(3);
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }
}

class Sphere extends ThreeDimensionalShape {

    private final float radius;

    public Sphere(float radius) {
        this.radius = radius;
        calculateVolume();
    }

    private void calculateVolume() {
        setVolume((float) ((4 / 3d) * (Math.PI * Math.pow(radius, 3))));
    }
}

class Cube extends ThreeDimensionalShape {

    private final float length;

    public Cube(float length) {
        this.length = length;
        calculateVolume();
    }

    private void calculateVolume() {
        setVolume((float) Math.pow(length, 3));
    }
}

class Cone extends ThreeDimensionalShape {

    private final float radius;
    private final float height;

    public Cone(float radius, float height) {
        this.radius = radius;
        this.height = height;
        calculateVolume();
    }

    private void calculateVolume() {
        setVolume((float) ((1 / 3d) * (Math.PI * Math.pow(radius, 2)) * height));
    }
}

class Cylinder extends ThreeDimensionalShape {

    private final float radius;
    private final float height;

    public Cylinder(float radius, float height) {
        this.radius = radius;
        this.height = height;
        calculateVolume();
    }

    private void calculateVolume() {
        setVolume((float) ((Math.PI * Math.pow(radius, 2)) * height));
    }
}

class Torus extends ThreeDimensionalShape {

    private final float radius;
    private final float majorRadius;

    public Torus(float majorRadius, float radius) {
        this.majorRadius = majorRadius;
        this.radius = radius;
        calculateVolume();
    }

    private void calculateVolume() {
        setVolume((float) (Math.PI * Math.pow(radius, 2) * (2 * Math.PI * majorRadius)));
    }
}