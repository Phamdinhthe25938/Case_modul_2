package Controller;

import model.Gust;
import model.Room;

public interface InterfaceMangerGustAndRoom {
    Gust CreatGust();
    void addGust ();
    void displayGustList ();
    void editInformationGuest();
    void roomPayment() throws InterruptedException;
    void showAllInvoices();
    void ReprintTheInvoice();
    void totalRevenue();

    Room creatRoom();

    void addRoom();

    void editRoom();

    void displayRoomList ();

    void displayEmptyRoom();

}
