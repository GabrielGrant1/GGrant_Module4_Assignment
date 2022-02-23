package edu.wctc;

import java.io.Serializable;


public class Wall implements Serializable{

    private static final long serialVersionUID = 1L;

    private double width;
    private double height;

    public Wall(double width, double height){
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        double area;
        area = getWidth()*getHeight();
        return area;
    }
}
