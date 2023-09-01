package e2;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class TextReader implements TextReaderInterface{
    private Scanner scanner;

    public TextReader(String fileName) throws FileNotFoundException {
        scanner = new Scanner(new File(fileName));
    }

    public boolean hasNext() {
        return scanner.hasNextLine();
    }

    public String next() {
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.trim().length() == 0) {
                break;
            }
            sb.append(line).append(System.lineSeparator());
        }
        return sb.toString();
    }
}