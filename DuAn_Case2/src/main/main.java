package main;
//import Controller.ManagerRoom;
//import Menu.MenuGuest;
//import Menu.MenuRoom;
import Controller.ManagerRegisteredAccount;

public class main {
    public static void main(String[] args) {
        System.out.println("-----------");
        ManagerRegisteredAccount managerRegisteredAccount = new ManagerRegisteredAccount();
        while(true){
            managerRegisteredAccount.menuRegisterAccount();
        }
    }
}
