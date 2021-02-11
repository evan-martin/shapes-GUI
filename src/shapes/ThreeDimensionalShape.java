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

import javax.swing.*;

public class ThreeDimensionalShape extends JPanel {

    private float volume;


}

class Sphere extends ThreeDimensionalShape {


    public Sphere() {

    }

    public float calculateVolume(float radius) {
        return ((float) ((4 / 3d) * (Math.PI * Math.pow(radius, 3))));
    }
}

class Cube extends ThreeDimensionalShape {

    public Cube() {

    }

    public float calculateVolume(float length) {
         return ((float) Math.pow(length, 3));
    }
}

class Cone extends ThreeDimensionalShape {



    public Cone() {

    }

    public float calculateVolume(float radius, float height) {
       return ((float) ((1 / 3d) * (Math.PI * Math.pow(radius, 2)) * height));
    }
}

class Cylinder extends ThreeDimensionalShape {

    public Cylinder() {

    }

   public float calculateVolume(float radius, float height) {
        return ((float) ((Math.PI * Math.pow(radius, 2)) * height));
    }
}

class Torus extends ThreeDimensionalShape {

    public Torus() {

    }

    public float calculateVolume(float radius, float majorRadius) {
       return ((float) (Math.PI * Math.pow(radius, 2) * (2 * Math.PI * majorRadius)));
    }
}