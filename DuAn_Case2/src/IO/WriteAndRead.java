package IO;

import model.Room;

import java.io.*;
import java.util.ArrayList;

public class WriteAndRead<E>  {
    public void write(ArrayList<E> list,String path){
        File file = new File(path);
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
//            System.out.println("Not data room!");
        }}
    public ArrayList<E> read(String path){
        File file =new File(path);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (ArrayList<E>) objectInputStream.readObject();
        }
        catch (IOException | ClassNotFoundException i){
//            System.out.println("File room not data !");
        }
        return  new ArrayList<>();
    }
    }

