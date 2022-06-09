package AccountRegister;

import java.io.Serializable;

public class AccountRegister implements Serializable {
    String registeredName;

    String registeredPassword;

    String registeredEmail;

    String registeredNumber;


    public AccountRegister() {
    }

    public AccountRegister(String registeredName, String registeredPassword, String registeredEmail, String registeredNumber) {
        this.registeredName = registeredName;
        this.registeredPassword = registeredPassword;
        this.registeredEmail = registeredEmail;
        this.registeredNumber = registeredNumber;
    }

    public String getRegisteredName() {
        return registeredName;
    }

    public void setRegisteredName(String registeredName) {
        this.registeredName = registeredName;
    }

    public String getRegisteredPassword() {
        return registeredPassword;
    }

    public void setRegisteredPassword(String registeredPassword) {
        this.registeredPassword = registeredPassword;
    }

    public String getRegisteredEmail() {
        return registeredEmail;
    }

    public void setRegisteredEmail(String registeredEmail) {
        this.registeredEmail = registeredEmail;
    }

    public String getRegisteredNumber() {
        return registeredNumber;
    }

    public void setRegisteredNumber(String registeredNumber) {
        this.registeredNumber = registeredNumber;
    }

    @Override
    public String toString() {
        return "FormRegister{" +
                "registeredName='" + registeredName  +
                ", registeredPassword='" + registeredPassword +
                ", registeredEmail='" + registeredEmail  +
                ", registeredNumber='" + registeredNumber  +
                '}';
    }
}
