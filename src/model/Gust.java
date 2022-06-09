package model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Gust extends people implements Serializable {
    Room room;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Gust(String name, int age, Date date, String number, String idPersonal, String address, Room room) {
        super(name, age, date,number, idPersonal, address);
        this.room = room;
    }

    @Override
    public String toString() {
        return super.toString()+
                ",  mã phòng:"+
                 room.getRoomCode()+
                ", gía phòng:"+room.getPriceRoom()+" $";
    }
}
