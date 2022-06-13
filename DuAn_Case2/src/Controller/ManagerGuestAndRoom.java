package Controller;

import IO.WriteAndRead;
import Validate.ValidateGustAndStaff;
import Validate.ValidateRoom;
import model.Gust;
import model.Postage;
import model.Room;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ManagerGuestAndRoom implements InterfaceMangerGustAndRoom {
     WriteAndRead<Gust> writeAndReadGust =new WriteAndRead<>();

    WriteAndRead<Room> writeAndReadRoom =new WriteAndRead<>();

    WriteAndRead<Postage> writeAndReadPostage =new WriteAndRead<>();
    ValidateGustAndStaff<Gust> validateGustAndStaff =new ValidateGustAndStaff<>();
    ValidateRoom validateRoom = new ValidateRoom();

    ArrayList<Postage> postageList = new ArrayList<>();
    ArrayList<Gust> gustsList= new ArrayList<>();
    ArrayList<Room> roomList= new ArrayList<>();
    Scanner sc =new Scanner(System.in);
    public ManagerGuestAndRoom() {
        postageList= writeAndReadPostage.read("Postage.csv");
        roomList = writeAndReadRoom.read("Room.csv");
        if(roomList.size()==0){
            roomList.add(new Room(213,"Normal room",5.4,2));
            roomList.add(new Room(322,"Normal room",5.4,2));
            roomList.add(new Room(251,"Normal room",4.6,2));
            roomList.add(new Room(421,"Vip room",9.6,2));
            roomList.add(new Room(113,"Vip room",8.2,3));
            roomList.add(new Room(261,"Family room",12,5));
            roomList.add(new Room(163,"Family room",10,4));
        }
        gustsList = writeAndReadGust.read("Gust1.csv");
    }
//    Manager guest
    @Override
    public Gust CreatGust(){
        String nameCustomer;
        int ageCustomer;
        Date dateGuest;
        int roomCodeChoice;
        String numberTelephoneCustomer;
        String idCustomer ;
        String customerAddress ;
        System.out.println("Danh sách số lượng phòng còn trống: ");
        int j = 1;
        for(Room room : roomList) {
            if (room.getCurrentQuantityGust() == 0) {
                System.out.println("   " + j + "_" + room);
                j++;
            }
        }

               System.out.println("Nhập mã phòng bạn muốn chọn cho khách :");
               roomCodeChoice = validateRoom.validateCodeRoom(roomList);
               int vt = validateRoom.checkCodeRoomExistDrum(roomList,roomCodeChoice);
            int guestNumber;
            while (true) {
                try {
                    System.out.println("Nhập số lượng người mà khách hàng muốn đăng ký ở phòng  :");
                    guestNumber = Integer.parseInt(sc.nextLine());
                    if (guestNumber > roomList.get(vt).getQuantityGust()) {
                        System.out.println("Số lượng không hợp lệ ! Vượt quá số lượng khách tối đa cho phép! ");
                    } else
                        break;
                }
                catch (NumberFormatException e){
                    System.out.println("Nhập sai định dạng vui lòng nhập lại!");
                }
            }
//            Enter name:
                while (true){
                    System.out.println("Nhập tên của khách hàng :");
                    nameCustomer = sc.nextLine();
                    if(!validateGustAndStaff.validateFullName(nameCustomer)){
                        if(nameCustomer.length()==0){
                            System.out.println("Vui lòng nhập tên !");
                        }
                        else{
                            break;
                        }
                    }
                    else
                        System.out.println("Tên không hợp lệ vui lòng nhập lại!");
                }
//        Enter age
                 System.out.println("Nhập tuổi của khách hàng:");
                ageCustomer = validateGustAndStaff.age();
//          Enter birthday:
                    System.out.println("Nhập ngày sinh của khách hàng:");
                     dateGuest = validateGustAndStaff.date();
//            Enter telephone:
                System.out.println("Nhập số điện thoại của khách hàng:");
                numberTelephoneCustomer = validateGustAndStaff.validateNumberTelephone(gustsList);
//            Enter id:
                System.out.println("Nhập CCCD của khách hàng :");
                idCustomer = validateGustAndStaff.id(gustsList);
//            Enter address:
            while (true){
                System.out.println("Nhập địa chỉ của khách hàng:");
                customerAddress = sc.nextLine();
                if(customerAddress.length()!=0){
                    break;
                }else {
                    System.out.println("Vui lòng nhập địa chỉ!");
                }
            }
       roomList.get(vt).setCurrentQuantityGust(roomList.get(vt).getCurrentQuantityGust() + guestNumber);
            return new Gust(nameCustomer, ageCustomer, dateGuest, numberTelephoneCustomer, idCustomer, customerAddress, roomList.get(vt));
        }
    @Override
        public void addGust () {
            gustsList.add(CreatGust());
            writeAndReadGust.write(gustsList,"Gust1.csv");
            writeAndReadRoom.write(roomList,"Room.csv");
        }
    @Override
    public void displayGustList () {
        int j=1;
        for (Gust g : gustsList) {
            System.out.println("  "+j+"_"+g);
            j++;
        }
    }
    @Override
    public void editInformationGuest() {
            while (true){
                System.out.println("Nhập CCCD khách hàng mà bạn muốn sửa thông tin :");
                String idPersonEdit = sc.nextLine();
                if(validateGustAndStaff.checkIdExist(idPersonEdit,gustsList)>=0){
                    int vtGuestEdit = validateGustAndStaff.checkIdExist(idPersonEdit, gustsList);
                    int vtRoomEditByGuest = validateGustAndStaff.locationByGuest(roomList,idPersonEdit,gustsList);
                    roomList.get(vtRoomEditByGuest).setCurrentQuantityGust(0);
                    gustsList.set(vtGuestEdit,CreatGust());
                    writeAndReadRoom.write(roomList,"Room.csv");
                    writeAndReadGust.write(gustsList,"Gust1.csv");
                    break;
                }
                else {
                    System.out.println("Mã CCCD không tồn tại !");
                }
            }
    }

    @Override
    public void roomPayment()  {
        while (true){
            System.out.println("Nhập CCCD của khách mà bạn muốn thanh toán: ");
            String idPersonPayment = sc.nextLine();
            if(validateGustAndStaff.checkIdExist(idPersonPayment,gustsList)>=0){
                System.out.print("Đang thực hiện thanh toán ");
                try {
                    for(int i=1;i<=4;i++){
                        Thread.sleep(2000);
                        System.out.print(".");
                    }
                }
                catch (Exception e){
                }
                int vtGuestPayment = validateGustAndStaff.checkIdExist(idPersonPayment, gustsList);
                int vtRoomByGuestPayment = validateGustAndStaff.locationByGuest(roomList,idPersonPayment,gustsList);
                roomList.get(vtRoomByGuestPayment).setCurrentQuantityGust(0);
                String nameGuestPayment = gustsList.get(vtGuestPayment).getName();
                double totalMoneyGuestPayment =  gustsList.get(vtGuestPayment).getRoom().getPriceRoom();
                postageList.add(new Postage(nameGuestPayment,java.time.LocalDateTime.now(),totalMoneyGuestPayment));
                System.out.println("");
                System.out.println(postageList.get(postageList.size()-1));
                System.out.println("Qúy khách: "+gustsList.get(vtGuestPayment).getName()+" đã thực hiện thanh toán thành công !");
                gustsList.remove(vtGuestPayment);
                writeAndReadRoom.write(roomList,"Room.csv");
                writeAndReadGust.write(gustsList,"Gust1.csv");
                writeAndReadPostage.write(postageList,"Postage.csv");
                break;
            }
            else {
                System.out.println("Mã CCCD không tồn tại !");
            }
        }
    }

    @Override
    public void showAllInvoices() {
        for (Postage p:postageList){
            System.out.println(p);
        }
    }
    @Override
    public void ReprintTheInvoice(){
        int numberSeri = validateGustAndStaff.validateNumberSeri(postageList);
        int vtNumberSeri = validateGustAndStaff.checkSeriPostageExist(postageList,numberSeri);
        System.out.println(postageList.get(vtNumberSeri));
    }

    @Override
    public void totalRevenue() {
        double totalRevenue=0;
        System.out.print("Tổng doanh thu của khách sạn: ");
        for (Postage p:postageList){
            totalRevenue +=p.getTotalMoney();
        }
        System.out.print(totalRevenue+" $");
        System.out.println("");
    }

    //        Manager Room
    @Override
    public Room creatRoom(){
       int codeRoom = validateRoom.validateCodeRoomAdd(roomList);
        System.out.println("Chọn loại phòng mà bạn muốn tạo mới :");
        System.out.println("\t\t1.Normal room");
        System.out.println("\t\t2.Vip room");
        System.out.println("\t\t3.Family room");
        String kindRoom = validateRoom.kindRoom();
        double priceRoom = validateRoom.validatePriceRoom();
        int quantityGuestRoom = validateRoom.validateQuantityGustRoom();
        return new Room(codeRoom,kindRoom,priceRoom,quantityGuestRoom);
    }
    @Override
    public void addRoom(){
        roomList.add(creatRoom());
        writeAndReadRoom.write(roomList,"Room.csv");
    }
    @Override
    public void editRoom(){
        System.out.println("Nhập mã phòng mà bạn muốn sửa :");
        int CodeRoomEdit= validateRoom.validateCodeRoom(roomList);
        int vtCodeRoomEdit = validateRoom.checkCodeRoomExistDrum(roomList,CodeRoomEdit);
        roomList.set(vtCodeRoomEdit,creatRoom());
        writeAndReadRoom.write(roomList,"Room.csv");
    }
    @Override
    public void displayRoomList () {
        for (int i=0;i<roomList.size();i++) {
            System.out.println("   " + (i+1) + "_" + roomList.get(i));
        }
    }
    @Override
    public void displayEmptyRoom(){
        int j=0;
        for (Room room : roomList) {
            if (room.getCurrentQuantityGust() == 0) {
                System.out.println("   " + (j + 1) + "_" + room);
                j++;
            }
        }
    }
    }
