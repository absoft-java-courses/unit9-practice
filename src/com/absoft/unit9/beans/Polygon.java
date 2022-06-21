package com.absoft.unit9.beans;

public class Polygon implements Shape {
    private final double[] lengths;

    public Polygon(double... lengths) {
        this.lengths = lengths;
    }

    @Override
    public double getPerimeter() {
        double perimeter = 0;

        for (var len: lengths) {
            perimeter += len;
        }

        return perimeter;
    }
}
