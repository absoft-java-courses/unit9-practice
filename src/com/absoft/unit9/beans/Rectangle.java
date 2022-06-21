package com.absoft.unit9.beans;

import com.absoft.unit9.exceptions.MyInvalidArgumentException;

public class Rectangle implements Shape {
    private final double height;
    private final double width;

    public Rectangle(double height, double width) throws MyInvalidArgumentException {
        try {
            validateArguments(height, width);
        } finally {
            System.out.println("finally from Rectangle constructor");
        }


        this.height = height;
        this.width = width;
    }

    private void validateArguments(double height, double width) throws MyInvalidArgumentException {
        try {
            System.out.println("validateArguments 1");
            if (height <= 0) {
                throw new MyInvalidArgumentException("height is non positive");
            }

            System.out.println("validateArguments 2");
            if (width <= 0) {
                throw new MyInvalidArgumentException("width is non positive");
            }

        } finally {
            System.out.println("finally from Rectangle.validateArguments");
        }

//        System.out.println("validateArguments 3");
    }

    @Override
    public double getPerimeter() {
        return (height + width) * 2;
    }
}
