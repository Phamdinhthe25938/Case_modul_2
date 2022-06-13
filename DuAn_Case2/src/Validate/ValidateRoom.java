package Validate;

import model.Room;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class ValidateRoom  {
    Scanner sc = new Scanner(System.in);

    public int checkCodeRoomAllExist(ArrayList<Room> rooms, int codeRoom) {
        for(int i=0;i<rooms.size();i++){
            if(rooms.get(i).getRoomCode()==codeRoom){
                return i;
            }
        }
        return -1;
    }
    public  int validateCodeRoomAdd(ArrayList<Room> rooms){
       try {
           System.out.println("Nhập mã phòng (xxx):");
           int codeRoom = Integer.parseInt(sc.nextLine());
           if(checkCodeRoomAllExist(rooms,codeRoom)<0){
               return codeRoom;
           }
           else {
               System.out.println("Mã phòng đã tồn tại vui lòng nhập mã phòng khác để tạo !");
               return validateCodeRoomAdd(rooms);
           }
       }
       catch (NumberFormatException e){
           System.out.println("Nhập sai định dạng ký tự vui lòng nhập lại mã phòng !");
           return validateCodeRoomAdd(rooms);
       }
       finally {
           System.out.println("");
       }
    }
    public int checkCodeRoomExistDrum(ArrayList<Room> rooms, int codeRoom){
        for(int i=0;i<rooms.size();i++){
            if(rooms.get(i).getCurrentQuantityGust()==0){
                if(rooms.get(i).getRoomCode()==codeRoom){
                    return i;
                }
            }else if(rooms.get(i).getRoomCode()==codeRoom){
                    return -1;
            }
        }
        return -2;
    }
    public int validateCodeRoom(ArrayList<Room> rooms) {
        try {
            int codeRoomEdit = Integer.parseInt(sc.nextLine());
            if (checkCodeRoomExistDrum(rooms, codeRoomEdit) >= 0) {
                return codeRoomEdit;
            }else if(checkCodeRoomExistDrum(rooms,codeRoomEdit)==-1) {
                System.out.println("Mã phòng đang có người sử dụng vui lòng nhập lại !");
                return validateCodeRoom(rooms);
            }
            else {
                System.out.println("Mã phòng không tồn tại vui lòng nhập lại!");
                return validateCodeRoom(rooms);
            }
        }
        catch (NumberFormatException e){
            System.out.println("Nhập sai định dạng vui lòng nhập ký tự số !");
            return validateCodeRoom(rooms);
        }
    }
//    public void
    public String  kindRoom(){
        try {
            System.out.println("Nhập lựa chọn:");
            int choice = Integer.parseInt(sc.nextLine());
            if(choice>0 && choice<4){
                if(choice==1){
                    return "Normal room";
                }
                else if(choice==2){
                    return  "Vip room";
                }
                else if(choice==3){
                    return "Family room";
                }
            }
            else {
                throw new IndexOutOfBoundsException();
            }
            throw new  NumberFormatException();
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Nhập quá chỉ số lựa!");
            return kindRoom();
        }
        catch (NumberFormatException e){
            System.out.println("Nhập sai định dạng ký tự vui lòng nhập lại!");
            return kindRoom();
        }
    }
    public double validatePriceRoom(){
      try {
            System.out.println("Nhập giá phòng mà bạn muốn tạo: ");
            double newPriceRoom = Double.parseDouble(sc.nextLine());
            if(newPriceRoom>0){
                return newPriceRoom;
            }
            throw new Exception();
      }
      catch (NumberFormatException e){
          System.out.println("Nhập sai định dạng ký tự !");
          return validatePriceRoom();
      }
      catch (Exception e){
          System.out.println("Gía phòng không hợp lệ ! ");
          return validatePriceRoom();
      }
    }
    public int validateQuantityGustRoom(){
        try {
            System.out.println("Nhập số lượng khách tối đa :");
            int quantity = Integer.parseInt(sc.nextLine());
               if(quantity>0){
                   System.out.println("Hãy xác nhận số khách tối đa bạn đã nhập cho phòng là đúng hay chưa?");
                   System.out.println("Yes || No !");
                   String confirm= sc.nextLine();
                   if(confirm.trim().equals("Yes") ||confirm.trim().equals("yes")){
                       return quantity;
                   }
                   else {
                       return validateQuantityGustRoom();
                   }
               }
                throw new NumberFormatException();
            }
        catch (NumberFormatException e){
            return validateQuantityGustRoom();
        }
    }


}
