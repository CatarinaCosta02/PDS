package e2;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String txtFileName = "contacts.txt";
        String binFileName = "contacts.bin";
    
        try {
            File txtFile = new File(txtFileName);
            txtFile.createNewFile();
            FileWriter txtWriter = new FileWriter(txtFile.getPath());
            txtWriter.write("Pessoa1\t111111111\n");
            txtWriter.write("Pessoa2\t222222222\n");
            txtWriter.write("Pessoa3\t333333333\n");
            txtWriter.write("Pessoa4\t444444444\n");
            txtWriter.close();
    
            TxtFormatter txtFormatter = new TxtFormatter(txtFileName);
    
            ContactsImplementation lista = new ContactsImplementation();
    
            lista.openAndLoad(txtFormatter);
    
            Contact c1 = new Contact("Pessoa5", 555555555);
            lista.add(c1);
            lista.add(new Contact("Pessoa6", 666666666));
    
            lista.remove(c1);
            lista.remove(lista.getByName("Pessoa2"));
    
            System.out.println("Is Pessoa5 in Contacts?   " + lista.exist(c1));
            System.out.println("Is Pessoa1 in Contacts?   " + lista.exist(lista.getByName("Pessoa1")));
    
            lista.saveAndClose();
    
            File binFile = new File(binFileName);
            binFile.createNewFile();
    
            BinFormatter binFormatter = new BinFormatter(binFileName);
    
            lista.saveAndClose(binFormatter);
    
            ContactsImplementation contactApi = new ContactsImplementation();
    
            contactApi.openAndLoad(binFormatter);
    
        } catch (IOException e) {
            System.err.println("An error occurred while working with files: " + e.getMessage());
        }
    }
    
}
