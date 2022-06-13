package Controller;

import AccountRegister.AccountRegister;

public interface InterfaceAccount {
    AccountRegister creatRegisteredAccount();

     void addAccount();
    void passwordRetrieval() throws InterruptedException;
    boolean verification();

    int checkTelephoneAccountExist(String numberTelephone);

    boolean checkLogIn(String nameAccountLogIn,String passwordAccountLogIn);

    void menuRegisterAccount();
}
