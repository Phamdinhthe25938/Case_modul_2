package main;
//import Controller.ManagerRoom;
//import Menu.MenuGuest;
//import Menu.MenuRoom;
import Controller.ManagerRegisteredAccount;

public class main {
    public static void main(String[] args) {
//        String str= "The";
//        String str1=str;
//        str="nam";
//        System.out.println(str);
//        System.out.println(str1);
        System.out.println("-----------");
        ManagerRegisteredAccount managerRegisteredAccount = new ManagerRegisteredAccount();
        while(true){
            managerRegisteredAccount.menuRegisterAccount();
        }
    }
}
