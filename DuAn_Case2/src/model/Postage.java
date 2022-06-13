package model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Postage implements Serializable {
    final int min =100000000;
    final int max = 999999999;
    private LocalDateTime paymentTime;


   private String  nameGuest;

    private double totalMoney;
    private int postalSeries = (int) (Math.random() * (max - min)) + min;


    public Postage(String nameGuest,LocalDateTime paymentTime,double totalMoney) {
        this.nameGuest=nameGuest;
        this.paymentTime= paymentTime;
        this.totalMoney=totalMoney;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(LocalDateTime paymentTime) {
        this.paymentTime = paymentTime;
    }

    public int getPostalSeries() {
        return postalSeries;
    }

    public void setPostalSeries(int postalSeries) {
        this.postalSeries = postalSeries;
    }

    public String getNameGuest() {
        return nameGuest;
    }

    public void setNameGuest(String nameGuest) {
        this.nameGuest = nameGuest;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return  "Tên khách hàng: "+nameGuest+
                " ,thời gian thanh toán: " + paymentTime+
                " ,tổng tiền hóa đơn: " + totalMoney +" $"+
                ", seri hóa đơn: " + postalSeries;
    }
}
