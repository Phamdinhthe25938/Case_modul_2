package model;

import java.io.Serializable;

public class Room implements Serializable {
   private int roomCode;

   private String kindRoom;

   private double priceRoom;

   private int currentQuantityGust;

    public Room() {
    }

    public Room(int roomCode, String kindRoom, double priceRoom, int quantityGust) {
        this.roomCode = roomCode;
        this.kindRoom = kindRoom;
        this.priceRoom = priceRoom;
        this.quantityGust = quantityGust;
    }

    private int quantityGust;

    public int getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(int roomCode) {
        this.roomCode = roomCode;
    }

    public String getKindRoom() {
        return kindRoom;
    }

    public void setKindRoom(String kindRoom) {
        this.kindRoom = kindRoom;
    }

    public double getPriceRoom() {
        return priceRoom;
    }

    public void setPriceRoom(double priceRoom) {
        this.priceRoom = priceRoom;
    }

    public int getCurrentQuantityGust() {
        return currentQuantityGust;
    }

    public void setCurrentQuantityGust(int currentQuantityGust) {
        this.currentQuantityGust = currentQuantityGust;
    }

    public int getQuantityGust() {
        return quantityGust;
    }

    public void setQuantityGust(int quantityGust) {
        this.quantityGust = quantityGust;
    }

    @Override
    public String toString() {
        return "Mã phòng:" + roomCode +
                ", loại phòng:" + kindRoom +
                ", giá phòng:" + priceRoom +" $"+
                ", số khách trong phòng:" + currentQuantityGust +
                ", số khách tối đa: " + quantityGust;
    }
}
