package com.absoft.unit9;

import com.absoft.unit9.beans.Circle;
import com.absoft.unit9.beans.Rectangle;
import com.absoft.unit9.beans.Shape;
import com.absoft.unit9.beans.Square;

import java.lang.reflect.InvocationTargetException;

public class Runner {

    public static void main(String[] args) throws ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {


        var circleClass = Circle.class;
        circleClass.getMethods()[1].getModifiers();

        System.out.println(circleClass.getName());
        System.out.println(circleClass.getSimpleName());

        var annotations = circleClass.getAnnotations();
        for (var annotation: annotations) {
            System.out.println(annotation.annotationType());
        }

        System.out.println("=============================");
        printPerimeter(new Square(10));
        printPerimeter(new Rectangle(10, 11));


        System.out.println("=============================");

        Class<?> aClass = Class.forName(args[0]);
        var shape =
                (Shape) aClass.getDeclaredConstructor(double.class)
                        .newInstance(10.0);

        printPerimeter(shape);

    }


    private static void printPerimeter(Shape shape) {
        Class<? extends Shape> aClass = shape.getClass();
        var className = aClass.getSimpleName();

        var annotation = aClass.getAnnotation(Deprecated.class);
        if (annotation != null) {
            System.out.println(className + " has been deprecated.");
        } else {
            System.out.println("perimeter of " + className + " is: " + shape.getPerimeter());
        }

    }
}
