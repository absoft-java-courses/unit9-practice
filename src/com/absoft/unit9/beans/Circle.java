package com.absoft.unit9.beans;

import com.absoft.unit9.annotations.MyAnnotation;


public class Circle implements Shape {
    private final double radius;

    @MyAnnotation(myInt = 5)
    public Circle(double radius) {
        this.radius = radius;
    }

    @MyAnnotation(value = {"asdasd", "asdasd"}, myInt = 56)
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
