package model;

import java.io.Serializable;
import java.util.Date;

public class Staff extends people implements Serializable {
    String employeeCode;

    public String position;

    public boolean workingStatus=false;

    public int numberOfWorkdays;

    public int someHolidays;
    public Staff() {

    }

    public Staff(String name, int age, Date date,String number ,String idPersonal, String address, String employeeCode,String position) {
        super(name, age, date, number,idPersonal, address);
        this.employeeCode = employeeCode;
        this.position=position;
//        this.workingStatus=workingStatus;
//        this.numberOfWorkdays=numberOfWorkdays;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isWorkingStatus() {
        return workingStatus;
    }

    public void setWorkingStatus(boolean workingStatus) {
        this.workingStatus = workingStatus;
    }

    public int getNumberOfWorkdays() {
        return numberOfWorkdays;
    }

    public int getSomeHolidays() {
        return someHolidays;
    }

    public void setSomeHolidays(int someHolidays) {
        this.someHolidays = someHolidays;
    }

    public void setNumberOfWorkdays(int numberOfWorkdays) {
        this.numberOfWorkdays = numberOfWorkdays;
    }

    @Override
    public String toString() {
        return "EmployeeCode: " + employeeCode +
                "Position:"+this.position
                +super.toString()
                +"Working status in day: "+workingStatus
                +"Number of workdays: "+numberOfWorkdays
                +"Some holiday:"+someHolidays;
    }
}
