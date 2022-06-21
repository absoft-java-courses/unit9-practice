package com.absoft.unit9.beans;

public class Rectangle implements Shape {
    private final double height;
    private final double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double getPerimeter() {
        return (height + width) * 2;
    }
}
