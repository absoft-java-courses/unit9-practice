package com.absoft.unit9.beans;

import com.absoft.unit9.exceptions.MyInvalidArgumentException;

@Deprecated(since = "v1.2.3")
public class Square extends Rectangle {
    public Square(double side) throws MyInvalidArgumentException {
        super(side, side);
    }
}
