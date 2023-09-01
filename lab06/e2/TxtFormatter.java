package e2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class TxtFormatter implements ContactsStorageInterface {
     
     
     private String fname;

     public TxtFormatter(String fname){
         this.fname = fname;
     }
 
 
     public List<Contact> loadContacts(){
         List<Contact> contact_list = new ArrayList<>();
 
         try{
         Path fpath = Paths.get(this.fname);
         Scanner reader = new Scanner(new File(fpath.toString()));
         while (reader.hasNextLine()){
             String line = reader.nextLine();
             String[] data = line.split("\t");
             contact_list.add(new Contact(data[0], Integer.parseInt(data[1])));
         }
         } catch (FileNotFoundException e) {
             System.out.println("An error occurred.");
             e.printStackTrace();
         }
         return contact_list;
     }
     public boolean saveContacts(List<Contact> list){
         String data = "";
         for (Contact contact : list){
             data = data + contact.getName() + "\t" + contact.getNumber() + "\n";
         }
 
         try {
             Path fpath = Paths.get(this.fname);
             FileWriter writer = new FileWriter(fpath.toString());
             writer.write(data);
             writer.close();
         } catch (IOException e) {
             System.out.println("An error occurred.");
             e.printStackTrace();
             return false;
         }
 
         return true;
     
    }
}