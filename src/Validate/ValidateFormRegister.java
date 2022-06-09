package Validate;

import AccountRegister.AccountRegister;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateFormRegister {
    Scanner sc = new Scanner(System.in);
    public boolean checkRegisteredNameExist(ArrayList<AccountRegister> accountList, String nameRegister){
        for (int i=0;i<accountList.size();i++){
            boolean dk2=accountList.get(i).getRegisteredName().trim().equals(nameRegister.trim());
            if( dk2 ) {
                return true;
            }
        }
        return false;
    }
    public String validateRegisteredName(ArrayList<AccountRegister> accountList) {
        System.out.println("Nhập tên tài khoản :");
        String registeredName = sc.nextLine();
        final String registeredNameRegex = "^[A-Z]{1}[a-z0-9]{5,12}";
        Pattern p = Pattern.compile(registeredNameRegex);
        Matcher m = p.matcher(registeredName.trim());
        if (m.matches()) {
            if(checkRegisteredNameExist(accountList,registeredName)){
                System.out.println("Vui lòng đặt nick name khác,nick name đã tồn tại");
                return validateRegisteredName(accountList);
            }
            else {
                return registeredName;
            }
        } else {
            System.out.println("Vui lòng nhập lai ! Chữ cái đầu cần viết hoa và có đủ độ dài từ 6-12 ký tự!");
            return validateRegisteredName(accountList);
        }
    }

    public boolean validateRegisteredNPassword(String registeredPassword) {
        final String registeredNameRegex = "[0-9]{6,10}";
        Pattern p = Pattern.compile(registeredNameRegex);
        Matcher m = p.matcher(registeredPassword.trim());
        return m.matches();
    }

    public int checkRegisteredEmailExist(ArrayList<AccountRegister> accountList, String email) {
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getRegisteredEmail().equals(email)) {
                return i;
            }
        }
        return -1;
    }

    public String validateRegisteredEmail(ArrayList<AccountRegister> accountList) {
        System.out.println("Nhập email mà bạn muốn đăng ký :");
        String registeredEmail = sc.nextLine();
        final String emailRegex = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        Pattern p = Pattern.compile(emailRegex);
        Matcher m = p.matcher(registeredEmail.trim());
        if (m.matches()) {
            if (checkRegisteredEmailExist(accountList, registeredEmail)< 0) {
                return registeredEmail;
            } else {
                System.out.println("Email đã tồn tại ! Vui lòng nhập lại !");
                return validateRegisteredEmail(accountList);
            }
        } else {
            System.out.println("Email không hợp lệ ! Vui lòng nhập lại !");
            return validateRegisteredEmail(accountList);
        }
    }
    public int checkRegisteredNumberTelephoneExist(ArrayList<AccountRegister> accountList, String numberTelephone){
        for(int i =0;i<accountList.size();i++){
            if(accountList.get(i).getRegisteredNumber().equals(numberTelephone)){
                return i;
            }
        }
        return -1;
    }
    public String validateRegisteredNumberTelephone(ArrayList<AccountRegister> accountList){
        System.out.println("Nhập số điện thoại mà bạn muốn đăng ký:");
        String registeredNumberTelephone = sc.nextLine();
        final String numberTelephoneRegex= "^0[0-9]{9}";
        Pattern p = Pattern.compile(numberTelephoneRegex);
        Matcher m = p.matcher(registeredNumberTelephone.trim());
        if(m.matches()){
            if(checkRegisteredNumberTelephoneExist(accountList,registeredNumberTelephone)<0){
                return registeredNumberTelephone;
            }
            else {
                System.out.println("Số điện thoại đã tồn tại ! vui lòng nhập lại!");
                return validateRegisteredNumberTelephone(accountList);
            }
        }
        else {
            System.out.println("Số điện thoại không hợp lệ ! Vui lòng nhập lại!");
            return validateRegisteredNumberTelephone(accountList);
        }
    }
}
