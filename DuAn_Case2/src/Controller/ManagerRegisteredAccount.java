package Controller;

import AccountRegister.AccountRegister;
import IO.WriteAndRead;
import Menu.Menu;
import Validate.ValidateFormRegister;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerRegisteredAccount implements InterfaceAccount {
     ArrayList<AccountRegister> AccountList = new ArrayList<>();
     ValidateFormRegister validateFormRegister = new ValidateFormRegister();
     WriteAndRead<AccountRegister> writeAndReadAccount = new WriteAndRead<>();
     Scanner sc = new Scanner(System.in);

     Menu menu = new Menu();

    public ManagerRegisteredAccount(){
        AccountList=writeAndReadAccount.read("Account.csv");
        if(AccountList.size()==0){
            AccountList.add(new AccountRegister("Phamdinhthe","111111","phamthe@gmail.com","0888888888"));
        }
    }
   @Override
    public AccountRegister creatRegisteredAccount(){
           String nameRegisteredAccount=validateFormRegister.validateRegisteredName(AccountList);
        String registeredPassword;
           while (true) {
               System.out.println("Nhập mật khẩu người đăng ký  :");
                registeredPassword = sc.nextLine();
               if (validateFormRegister.validateRegisteredNPassword(registeredPassword)) {
                   break;
               } else {
                   System.out.println("Mật khẩu bao cần đủ 6 ký tự là ký tự số!");
               }
           }
           while (true){
               System.out.println("Nhập lại mật khẩu của bạn:");
               String registeredPasswordAgain = sc.nextLine();
               if(registeredPasswordAgain.equals(registeredPassword)){
                   break;
               }
               else {
                   System.out.println("Mật khẩu không trùng khớp!Vui lòng nhập lại!");
               }
           }
           String emailRegisteredAccount= validateFormRegister.validateRegisteredEmail(AccountList);
           String telephoneNumberRegisteredAccount= validateFormRegister.validateRegisteredNumberTelephone(AccountList);
           return new AccountRegister(nameRegisteredAccount,registeredPassword,emailRegisteredAccount,telephoneNumberRegisteredAccount);
     }
    @Override
     public void addAccount(){
           AccountList.add(creatRegisteredAccount());
           writeAndReadAccount.write(AccountList,"Account.csv");
     }
    @Override
     public int checkTelephoneAccountExist(String numberTelephone) {
         for (int i = 0; i < AccountList.size(); i++) {
             if (AccountList.get(i).getRegisteredNumber().equals(numberTelephone)) {
                 return i;
             }
         }
         return -1;
     }
    @Override
     public boolean verification(){
         int maxRd= 999999;
         int minRd=100000;
         int countVer =0;
         int times=3;
         int verification = (int) (Math.random()*(maxRd - minRd) + minRd);
         System.out.println("Mã xác  nhận :"+verification);
         while (true){
             if(times==3){
                 System.out.println("Bạn có "+times +" lần nhập");
             }
             else {
                 System.out.println("Bạn còn "+times+" lần nhập");
             }
             System.out.println("Nhập mã xác nhận :");
           try {
               int ver = Integer.parseInt(sc.nextLine());
               if(ver==verification){
                   return true;
               }
               else {
                   if(countVer<2){
                       System.out.println("Mã xác nhận không hợp lệ ! Vui lòng nhập lại !");
                   }
                   times--;
                   countVer++;
               }
               if(countVer==3){
                   System.out.println("Mã xác nhận đã hết hiệu lưc !");
                   return false;
               }
           }
           catch (NumberFormatException e){
               if(countVer<2){
                   System.out.println("Mã xác nhận không thể là ký tự chữ ! Vui lòng nhập lại !");
               }
               times--;
               countVer++;
               if(countVer==3){
                   System.out.println("Mã xác nhận đã hết hiệu lưc !");
                   return false;
               }
           }
         }
     }
    @Override
     public void passwordRetrieval()  {
        int vt;
         while (true){
             System.out.println("Nhập số điện thoại của bạn :");
             String numberTelephone = sc.nextLine();
             if(checkTelephoneAccountExist(numberTelephone)>=0){
                 vt =checkTelephoneAccountExist(numberTelephone);
                 try {
                     System.out.println("Mã xác nhận sẽ được gửi về sau vài giây !");
                     Thread.sleep(3000);
                 }
                 catch (InterruptedException ignored){
                 }
                 if(verification()){
                     System.out.println("Nhập mật khẩu mới:");
                     String newPassword = sc.nextLine();
                     while (true){
                         System.out.println("Nhập lại mật khẩu mới:");
                         String newPasswordAgain = sc.nextLine();
                         if(newPasswordAgain.equals(newPassword)){
                             System.out.println("Cập nhật mật khẩu mới thành công !");
                             break;
                         }
                         else {
                             System.out.println("Mật khẩu chưa hợp lệ vui lòng nhập lại!");
                         }
                     }
                     AccountList.get(vt).setRegisteredPassword(newPassword);
                     writeAndReadAccount.write(AccountList,"Account.csv");
                 }
                 break;
             }
             else {
                 System.out.println("Số điện thoại chưa tồn tại !");
             }
         }
     }
    @Override
     public boolean checkLogIn(String nameAccountLogIn,String passwordAccountLogIn){
         for(int i=0;i<AccountList.size();i++){
             if(AccountList.get(i).getRegisteredName().trim().equals(nameAccountLogIn.trim())
                     && AccountList.get(i).getRegisteredPassword().trim().equals(passwordAccountLogIn.trim())){
                return true;
             }
         }
         return false;
     }
    @Override
public void menuRegisterAccount(){
    System.out.println("1.Đăng ký !");
    System.out.println("2.Đăng nhập!");
    System.out.println("3.Lấy lại mật khẩu !");
    try {
        System.out.println("----------");
        System.out.println("Nhập lựa chọn:");
        int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    addAccount();
                    String newName = AccountList.get(AccountList.size()-1).getRegisteredName();
                    System.out.println("Hello:"+newName+" chúc mùng bạn đã đăng kí thành công");
                    System.out.println("-----------");
                    break;
                case 2:
                    for(AccountRegister f:AccountList){
                        System.out.println(f);
                    }
                    while (true){
                        System.out.println("Nhập tên tài khoản :");
                        String nameAccountLogIn = sc.nextLine();
                        System.out.println("Nhập mật khẩu :");
                        String passwordAccountLogIn = sc.nextLine();
                        if (checkLogIn(nameAccountLogIn,passwordAccountLogIn)){
                            menu.menu(nameAccountLogIn);
                            break;
                        }
                        else{
                            System.out.println("Chưa chính xác vui lòng nhập lại !");
                        }
                    }
                    break;
                case 3:
                    passwordRetrieval();
                    break;
            }
            if(choice<0 || choice>3){
                System.out.println("Vượt quá chỉ số lựa chọn vui lòng chọn lại !");
            }
    }
    catch (NumberFormatException e){
        System.out.println("Ký tự lựa chọn không hợp lệ!");
    }
}
}
