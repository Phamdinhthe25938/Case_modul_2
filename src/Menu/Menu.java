package Menu;

import Controller.ManagerGuestAndRoom;
import Controller.ManagerStaff;

import java.util.Scanner;

public class Menu {
    Scanner sc= new Scanner(System.in);
    ManagerGuestAndRoom managerGuestAndRoom =new ManagerGuestAndRoom();
    ManagerStaff managerStaff = new ManagerStaff();
    public void menuGust() {
        while (true) {
            System.out.println("1.Thêm khách hàng mới!");
            System.out.println("2.Hiển thị danh sách khách hàng!");
            System.out.println("3.Chỉnh sửa thông tin khách hàng !");
            System.out.println("4.Thực hiện thanh toán cho khách hàng!");
            System.out.println("5.In ra tất cả các hóa đơn đã thanh toán  !");
            System.out.println("6.Tổng doanh thu trong ngày !");
            System.out.println("0.Thoát!");
            int choiceGust;
                try {
                    System.out.println("Nhập sự lựa chọn :");
                    choiceGust = Integer.parseInt(sc.nextLine());
                            switch (choiceGust) {
                                case 1:
                                    managerGuestAndRoom.addGust();
                                    break;
                                case 2:
                                    managerGuestAndRoom.displayGustList();
                                    break;
                                case 3:
                                    managerGuestAndRoom.editInformationGuest();
                                    break;
                                case 4:
                                    managerGuestAndRoom.roomPayment();
                                    break;
                                case 5:
                                    managerGuestAndRoom.showAllInvoices();
                                    break;
                                case 6:
                                    managerGuestAndRoom.totalRevenue();
                                    break;
                            }
                    if(choiceGust<0 || choiceGust >6) {
                        System.out.println("Nhập quá chỉ số vui lòng nhập lại!");
                    }
                    else  if(choiceGust==0){
                        break;
                    }
                        }
                 catch (NumberFormatException e) {
                    System.out.println("Nhập sai định dạng ký tự !");
                }
            }
        }
        public void menuRoom () {
            while (true) {
                System.out.println("1.Thêm một phòng mới!");
                System.out.println("2.Hiện thị danh sách phòng!");
                System.out.println("3.Hiện thị danh sách các phòng trống!");
                System.out.println("4.Sửa thông tin phòng!");
                System.out.println("0.Thoát");
                int choiceRoom;
                    try {
                        System.out.println("Enter choice room:");
                        choiceRoom = Integer.parseInt(sc.nextLine());
                                switch (choiceRoom) {
                                    case 1:
                                        managerGuestAndRoom.addRoom();
                                        break;
                                    case 2:
                                        managerGuestAndRoom.displayRoomList();
                                        break;
                                    case 3:
                                        managerGuestAndRoom.displayEmptyRoom();
                                        break;
                                    case 4:
                                        managerGuestAndRoom.editRoom();
                                        break;
                                }
                        if(choiceRoom<0 || choiceRoom >4) {
                            System.out.println("Nhập quá chỉ số vui lòng nhập lại!");
                        }
                        else  if(choiceRoom==0){
                            break;
                        }
                            }
                    catch (NumberFormatException e) {
                        System.out.println("Nhập sai định dạng ký tự !");
                    }
            }
        }
    public void menuStaff(){
        while (true){
            System.out.println("1.Thêm nhân viên mới !");
            System.out.println("2.Chỉnh sửa thông tin nhân viên  !");
            System.out.println("3.Xóa nhân viên khỏi danh sách!");
            System.out.println("4.Chấm công cho nhân viên !");
            System.out.println("5.In bảng công của nhân viên  !");
            System.out.println("0.Thoát!");
            int choiceStaff;
                try {
                    System.out.println("Enter choice :");
                     choiceStaff = Integer.parseInt(sc.nextLine());
                            switch (choiceStaff){
                                case 1:
                                    managerStaff.addStaff();
                                    break;
                                case 2:
                                    managerStaff.editInformationStaff();
                                    break;
                                case 3:
                                    managerStaff.deleteStaff();
                                    break;
                                case 4:
                                    managerStaff.timekeeping();
                                    break;
                                case 5:
                                    managerStaff.Payroll();
                                    break;
                            }
                    if(choiceStaff<0 || choiceStaff >4) {
                        System.out.println("Nhập quá chỉ số vui lòng nhập lại!");
                    }
                    else  if(choiceStaff==0){
                        break;
                    }
                        }
                    catch (NumberFormatException e){
                        System.out.println("Nhập sai định dạng ký tự !");
                    }
        }
    }
    public void menu(String nameAccount){
        final String nameAccountManager="Phamdinhthe";
        while(true){
            System.out.println("---Menu---");
            System.out.println("1.Quản lý khách hàng !");
            System.out.println("2.Quản lý homeStay !");
            if(nameAccount.trim().equals(nameAccountManager.trim())){
                System.out.println("3.Quản lý nhân viên !");
            }
            System.out.println("0.Thoát !");
            int choice ;
                try {
                    System.out.println("Nhập sự lựa chọn của bạn:");
                    choice = Integer.parseInt(sc.nextLine());
                        if(nameAccount.trim().equals(nameAccountManager.trim())){
                            switch (choice) {
                                case 1:
                                    menuGust();
                                    break;
                                case 2:
                                    menuRoom();
                                    break;
                                case 3:
                                    menuStaff();
                                    break;
                            }
                        }
                        else {
                            switch (choice) {
                                case 1:
                                    menuGust();
                                    break;
                                case 2:
                                    menuRoom();
                                    break;
                            }
                        }
                        if(choice==0){
                        break;
                    }
                }
                catch (NumberFormatException e){
                    System.out.println("Ký tự không hợp lệ vui lòng thử lại !");
                }
        }
    }
}
