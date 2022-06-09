package Controller;

import IO.WriteAndRead;
import Validate.ValidateGustAndStaff;
import model.Staff;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ManagerStaff implements InterfaceStaff{
    ValidateGustAndStaff<Staff> validateGustAndStaff = new ValidateGustAndStaff<>();

    WriteAndRead<Staff> writeAndReadStaff = new WriteAndRead<>();
     ArrayList<Staff> staffLists = new ArrayList<>();

    Scanner sc = new Scanner(System.in);
    public ManagerStaff() {
        staffLists=writeAndReadStaff.read("Staff.csv");
        if (staffLists.size()==0){
        staffLists.add(new Staff("Trần Văn Tuấn ",35,new Date(12/3/1992),"0123456789","1111","Nam Định","111","Phục vụ"));
        staffLists.add(new Staff("Phạm Đức Anh ",23,new Date(12/3/1992),"0123456789","2222","Nam Định","112","Lễ tân"));
        staffLists.add(new Staff("Trần Tuấn Khải ",22,new Date(12/3/1992),"0123456789","3333","Nam Định","113","Lễ tân"));
        staffLists.add(new Staff("Nguyễn Văn Hầu ",19,new Date(12/3/1992),"0123456789","4444","Nam Định","114","Phục vụ"));
        staffLists.add(new Staff("Nguyễn Văn Hầu ",32,new Date(12/3/1992),"0123456789","5555","Nam Định","114","Phục vụ"));
        }
    }
    @Override
    public Staff creatStaff() {
        String nameStaff;
        int ageStaff;
        Date dateStaff;
        String numberTelephoneStaff;
        String idStaff;
        String staffAddress;
        String employeeCode;
        String position;
        while (true){
            System.out.println("Nhập tên của nhân viên:");
            nameStaff = sc.nextLine();
            if(!validateGustAndStaff.validateFullName(nameStaff)){
                if(nameStaff.length()==0){
                    System.out.println("Vui lòng nhập tên!");
                }
                else {
                    break;
                }
            }else
                System.out.println("Tên không hợp lệ vui lòng nhập lại!");
        }

        System.out.println("Nhập tuổi của nhân viên :");
        ageStaff=validateGustAndStaff.age();

        System.out.println("Nhập ngày sinh của nhân viên :");
        dateStaff= validateGustAndStaff.date();

         System.out.println("Nhập số điện thoại của nhân viên :");
         numberTelephoneStaff = validateGustAndStaff.validateNumberTelephone(staffLists);

        System.out.println("Nhập CCCD của nhân viên : " );
        idStaff = validateGustAndStaff.id(staffLists);

        while (true){
            System.out.println("Nhập địa chỉ  của nhân viên :");
            staffAddress = sc.nextLine();
            if(staffAddress.length()!=0){
                break;
            }
            else {
                System.out.println("Vui lòng nhập địa chỉ !");
            }
        }

        employeeCode= validateGustAndStaff.employeeCode(staffLists);

        position = validateGustAndStaff.position();

       return  new Staff(nameStaff,ageStaff,dateStaff,numberTelephoneStaff,idStaff,staffAddress,employeeCode,position);
    }
    @Override
    public void addStaff(){
        staffLists.add(creatStaff());
        writeAndReadStaff.write(staffLists,"Staff.csv");
    }
    @Override
    public void editInformationStaff(){
        for(Staff s:staffLists){
            System.out.println(s);
        }
        while (true){
            System.out.println("Nhập mã nhân viên bạn muốn chỉnh sửa:");
            String employeeCodeEdit = sc.nextLine();
            if(validateGustAndStaff.employeeCodeExist(staffLists,employeeCodeEdit)>=0){
                int vtEmployeeCodeEdit = validateGustAndStaff.employeeCodeExist(staffLists,employeeCodeEdit);
                staffLists.remove(vtEmployeeCodeEdit);
                staffLists.set(vtEmployeeCodeEdit,creatStaff());
                writeAndReadStaff.write(staffLists,"Staff.csv");
                break;
            }
            else {
                System.out.println("Mã nhân viên không tồn tại!");
            }
        }
    }
    @Override
    public void deleteStaff(){
        while (true){
            System.out.println("Nhập mã nhân viên bạn muốn xóa: ");
            String employeeCodeDelete = sc.nextLine();
            if(validateGustAndStaff.employeeCodeExist(staffLists,employeeCodeDelete)>=0){
                int vtEmployeeCodeDelete = validateGustAndStaff.employeeCodeExist(staffLists,employeeCodeDelete);
                staffLists.remove(vtEmployeeCodeDelete);
                writeAndReadStaff.write(staffLists,"Staff.csv");
                break;
            }
            else {
                System.out.println("Mã nhân viên không tồn tại!");
            }
        }
    }
    @Override
    public  void timekeeping(){
        for(int i=0;i<staffLists.size();i++){
            System.out.println(staffLists.get(i).getEmployeeCode()+" "+staffLists.get(i).getName());
               if(validateGustAndStaff.attendance()==1){
                   staffLists.get(i).setWorkingStatus(true);
                   staffLists.get(i).setNumberOfWorkdays(staffLists.get(i).getNumberOfWorkdays()+1);
               }
               else {
                   staffLists.get(i).setWorkingStatus(false);
                   staffLists.get(i).setSomeHolidays(staffLists.get(i).getSomeHolidays()+1);
               }
        }
        writeAndReadStaff.write(staffLists,"Staff.csv");
    }
    @Override
    public  void Payroll(){
        System.out.println("Bảng lương của nhân viên: ");
        for(int i=0;i<staffLists.size();i++){
            if(staffLists.get(i).getPosition().equals("Lễ tân")){
                System.out.println(
                                "Tên :"+staffLists.get(i).getName()+
                                ",  Vị trí:"+staffLists.get(i).getPosition()+
                                ",  Số ngày đi làm: "+staffLists.get(i).getNumberOfWorkdays()+
                                ",  Số ngày nghỉ:"+staffLists.get(i).getSomeHolidays()+
                                    ",  Tiền lương :"+staffLists.get(i).getNumberOfWorkdays()*15+" $");
            }
            else {
                System.out.println(
                        "Tên :"+staffLists.get(i).getName()+
                        ",  Vị trí:"+staffLists.get(i).getPosition()+
                        ",  Số ngày đi làm: "+staffLists.get(i).getNumberOfWorkdays()+
                        ",  Số ngày nghỉ:"+staffLists.get(i).getSomeHolidays()+
                        ",  Tiền lương :"+staffLists.get(i).getNumberOfWorkdays()*20+" $");
            }
        }
    }

}
