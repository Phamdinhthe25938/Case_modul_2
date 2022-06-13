package Validate;

import model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateGustAndStaff <E>{
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        public  boolean  validateFullName(String name) {
            String[] number = {"0", "1", "2", "3"," 4", "5", "6", "8", "9"};
            for (int i=0;i<name.length();i++){
                for (String s : number) {
                    if (Character.toString(name.charAt(i)).equals(s) ) {
                        return true;
                    }
                }
            }
            return false;
        }
        public int checkNumberTelephoneExist(ArrayList<? extends people> list,String numberTelephone){
            for(int i=0;i<list.size();i++){
                if(list.get(i).getNumber().equals(numberTelephone)){
                    return i;
                }
            }
            return -1;
        }
        public String validateNumberTelephone(ArrayList<? extends people> list){
            String numberTelephone= sc.nextLine();
            Pattern p = Pattern.compile("^[0][0-9]{9}");
            Matcher m = p.matcher(numberTelephone.trim());
            if(m.matches()){
                if(checkNumberTelephoneExist(list,numberTelephone)<0){
                    return numberTelephone;
                }
                else {
                    System.out.println("Số điện thoại đã tồn tại ! Vui lòng nhập lại!");
                    return validateNumberTelephone(list);
                }
            }
            System.out.println("Số điện thoại không chính xác!Vui lòng nhập lại!");
           return validateNumberTelephone(list);
        }
        public int age(){
            try {
                int ageCustomer = Integer.parseInt(sc.nextLine());
                if(ageCustomer>=18){
                    return  ageCustomer;
                }
                throw new Exception();
            }
            catch (NumberFormatException e ){
                System.out.println("Nhập sai định dạng vui lòng nhập định dạng ký tự số !");
                return age();
            } catch (Exception e){
                System.out.println("Vui lòng nhập lại ! Tuổi không hợp lệ ! Tối thiểu là 18 tuổi");
                return age();
            }
        }
        public Date date(){
            try {
                Date dateBirthday = dateFormat.parse(sc.nextLine());
                return dateBirthday;
            } catch (ParseException e) {
                System.out.println(" Vui lòng nhập ngày sinh đúng định dạng (xx/MM/yyyy)! ");
                return date();
            }
        }
        public int checkIdExist(String idPerson,ArrayList<? extends people> listGuest){
            for (int i=0;i<listGuest.size();i++) {
                if (listGuest.get(i).getIdPersonal().equals(idPerson)){
                   return i;
                }
            }
            return -1;
        }
        public String id(ArrayList<? extends people> list){
            String idPerson =sc.nextLine();
            Pattern p = Pattern.compile("[0-9]{4}");
            Matcher m = p.matcher(idPerson.trim());
                if(m.matches()){
                    if(checkIdExist(idPerson,list)<0){
                        return idPerson;
                    }
                    else {
                        System.out.println("CCCD đã tồn tại!Vui lòng nhập CCCD khác!");
                        return id(list);
                    }
                }
                else {
                    System.out.println("CCCD chỉ gồm 4 ký tự số ! Vui lòng nhập lại!");
                    return id(list);
                }
        }
        public int checkSeriPostageExist(ArrayList<Postage> postages,int numberSeri){
            for(int i=0;i<postages.size();i++){
                if(postages.get(i).getPostalSeries()==numberSeri){
                    return i;
                }
            }
            return -1;
        }
        public int validateNumberSeri(ArrayList<Postage> postages){
            try {
                System.out.println("Nhập số seri bạn muốn in lại hóa đơn");
                int numberSeri = Integer.parseInt(sc.nextLine());
                if(checkSeriPostageExist(postages,numberSeri)>=0){
                    return numberSeri;
                }
                else {
                    System.out.println("Số seri không tồn tại vui lòng nhập lại !");
                    return validateNumberSeri(postages);
                }
            }catch (NumberFormatException e){
                System.out.println("Nhập sai định dạng ký tự vui lòng nhập ký tự số!");
                return validateNumberSeri(postages);
            }
        }
        public int locationByGuest(ArrayList<Room> rooms,String idPerson,ArrayList<Gust> list){
            if(checkIdExist(idPerson,list)>=0){
                for(int i=0;i<rooms.size();i++){
                    if(rooms.get(i).getPriceRoom()==list.get(checkIdExist(idPerson,list)).getRoom().getPriceRoom()){
                        return i;
                    }
                }
            }
            return -1;
        }
        public int employeeCodeExist(ArrayList<Staff> staffs,String employeeCode){
            for(int i=0;i<staffs.size();i++){
                if(staffs.get(i).getEmployeeCode().equals(employeeCode)){
                    return i;
                }
            }
            return -1;
        }
        public String employeeCode(ArrayList<Staff> staffs){
            System.out.println("Nhập mã của nhân viên :");
             String employeeCode = sc.nextLine();
                Pattern p = Pattern.compile("[0-9]{3}");
                Matcher m = p.matcher(employeeCode.trim());
                if(m.matches()){
                    if(employeeCodeExist(staffs,employeeCode)<0){
                        return employeeCode;
                    }
                    else {
                        System.out.println("Mã nhân viên đã tồn tại !");
                        return employeeCode(staffs);
                    }
                }
                else {
                    System.out.println("Mã nhân viên chỉ gồm 3 ký số ! Vui lòng nhập lại!");
                    return employeeCode(staffs);
                }
            }
            public  String position (){
                System.out.println("Nhập vị trí của nhân viên :");
                System.out.println("   1.Lễ tân");
                System.out.println("   2.Phục vụ");
                try {
                    System.out.println("Nhập lựa chọn:");
                    int choice = Integer.parseInt(sc.nextLine());
                    if(choice>0 && choice<3){
                        if(choice==1){
                            return "Lễ tân";
                        }
                        else {
                            return "Phục vụ";
                        }
                    }
                    throw new IndexOutOfBoundsException();
                }
                catch (NumberFormatException e){
                    System.out.println("Định dạng lựa chọn không đúng vui lòng nhập lại !");
                    return position();
                }
                catch (IndexOutOfBoundsException e){
                    System.out.println("Nhập quá chỉ số lựa chọn vui lòng nhập lại ");
                    return position();
                }
            }
            public int attendance(){
                try {
                    System.out.println("1.Có  2.Không:");
                    int choice = Integer.parseInt(sc.nextLine());
                    if(choice>0 && choice<3){
                        return choice;
                    }
                    throw new IndexOutOfBoundsException();
                    }
                catch (NumberFormatException e){
                    System.out.println("Định dạng lựa chọn không đúng vui lòng nhập lại !");
                    return attendance();
                }
                catch (IndexOutOfBoundsException e){
                    System.out.println("Nhập quá chỉ số lựa chọn vui lòng nhập lại  ");
                    return attendance();
                }
            }
}
