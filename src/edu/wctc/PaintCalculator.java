package edu.wctc;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;


public class PaintCalculator implements Serializable{
    private List<Room> roomList = new ArrayList<Room>();

    private static final long serialVersionUID = 1L;


    public void addRoom(double length, double width, double height){
        Room room = new Room(length, width, height);
        roomList.add(room);
    }

    public String toString(){
        String rooms;
        if(roomList.size() == 0){
            rooms = "There are no rooms";
        }else{
            List<String> r = new ArrayList<>();
            int c = 0;
            for (Room i : roomList) {
                rooms = "  Room with area: " + i.toString();
                r.add(rooms);
                c++;
            }
            String[] areaList = new String[c];
            for(int i = 0; i < c; i++){
                areaList[i] = r.get(i);
            }
            rooms = String.join("|", areaList);
        }

        return rooms;
    }
}
