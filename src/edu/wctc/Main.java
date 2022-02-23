package edu.wctc;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner keyboard = new Scanner(System.in);

    private static PaintCalculator paintCalculator = new PaintCalculator();




    private static void printMenu() {
        System.out.println("Add room (1)");
        System.out.println("View rooms (2)");
        System.out.println("Read rooms from file (3)");
        System.out.println("Write rooms to file (4)");
        System.out.println("Exit program (5)");
    }

    private static double promptForDimension(String dimensionName){
        System.out.println("Enter the wall's " + dimensionName);
        double dimension = keyboard.nextDouble();
        return dimension;
    }

    private static void createRoom(){
        double length = promptForDimension("length");
        double width = promptForDimension("width");
        double height = promptForDimension("height");
        paintCalculator.addRoom(length, width, height);
    }

    private static void readFile() {
        try (FileInputStream fis = new FileInputStream("rooms.obj");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            paintCalculator = (PaintCalculator)ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("The file can not be found");
        }
    }

    private static void writeFile() {
        //TODO write paintcalculator to file.
        try (FileOutputStream fos = new FileOutputStream("rooms.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            oos.writeObject(paintCalculator);
        } catch (IOException e) {
            System.out.println("File could not be opened");
        }
    }

    public static void main(String[]args) {
        boolean Exit = false;
        do{
            printMenu();
            //use a char and parse to int to prevent crash.
            int input = keyboard.nextInt();
            switch(input){
                case 1:
                    createRoom();
                break;
                case 2:
                    //System.out.println(paintCalculator.toString());
                    String rooms = paintCalculator.toString();
                    String[] splitRooms = rooms.split("|");
                    for(String r: splitRooms) {
                        System.out.print(r);
                    }
                    System.out.println("");
                    break;
                case 3:
                    readFile();
                break;
                case 4:
                    writeFile();
                break;
                case 5:
                    Exit = true;
                break;
                default: System.out.println("That was not an option, please try again.");
            }
        }while(Exit == false);
    }
}


