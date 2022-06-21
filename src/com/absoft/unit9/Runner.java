package com.absoft.unit9;

import com.absoft.unit9.beans.Circle;
import com.absoft.unit9.beans.Rectangle;
import com.absoft.unit9.beans.Shape;
import com.absoft.unit9.beans.Square;
import com.absoft.unit9.exceptions.MyInvalidArgumentException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLClientInfoException;

public class Runner {

    //checked
    //un-checked
    public static void main(String[] args) throws MyInvalidArgumentException{
        try {
            System.out.println("hello from try 1");
            var rectangle = new Rectangle(12, 5);
            System.out.println("hello from try 2");

        } catch (IllegalArgumentException | ArithmeticException exception) {
            System.out.println("GOT EXCEPTION! IllegalArgumentException");
            exception.printStackTrace(System.out);
        } catch (MyInvalidArgumentException exception) {
            System.out.println("GOT EXCEPTION! generic Exception");
            exception.printStackTrace(System.out);
        } finally {
            System.out.println("Hello from finally");
        }

        System.out.println("Hello world");


        FileReader reader = null;
        try {
            reader = new FileReader("myfile.txt");
        } catch (IOException e) {
            ///
        }
        finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        }

        try(var reader1 = new FileReader("file.txt")) {
            reader1.read();////

        } catch (IOException e) {
            e.printStackTrace(System.out);
        }


    }
}
