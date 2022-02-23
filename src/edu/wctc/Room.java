package edu.wctc;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Room implements Serializable{
    private List<Wall> wallList = new ArrayList<Wall>();

    private static final long serialVersionUID = 1L;


    public Room(double width, double length, double height){
        Wall wall1 = new Wall(width, height);
        Wall wall2 = new Wall(width, height);
        Wall wall3 = new Wall(length, height);
        Wall wall4 = new Wall(length, height);

        wallList.add(wall1);
        wallList.add(wall2);
        wallList.add(wall3);
        wallList.add(wall4);
    }

    public double getArea(){
        double area = wallList.get(0).getArea() + wallList.get(1).getArea() + wallList.get(2).getArea() + wallList.get(3).getArea();
        return area;
    }

    public String toString(){
         String wallArea = Double.toString(getArea());
         return wallArea;
    }

}
