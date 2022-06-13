package model;

import com.sun.org.apache.xerces.internal.impl.xs.util.XSObjectListImpl;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract  class people implements Serializable {
    private String name;
    private int age;
    private Date date;
    private String number;
    private String idPersonal;
    private String address;

    public people() {

    }
    public people(String name, int age, Date date,String number, String idPersonal, String address) {
        this.name = name;
        this.age = age;
        this.date = date;
        this.number=number;
        this.idPersonal = idPersonal;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(String idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        DateFormat dateFormat =new SimpleDateFormat("dd/MM/yyyy");
        return "Tên: " + name  +
                ", tuổi: " + age +
                ", ngày sinh: " + dateFormat.format(date) +
                ", số điện thoại: "+number+
                ", sô CCCD: " + idPersonal +
                ", địa chỉ:" + address ;
    }
}
