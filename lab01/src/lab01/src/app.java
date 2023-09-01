package lab01.src;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class app {
    public static void main(String[] args) {
        //2D char array
        verify v = new verify();
        String[] sopa;
        String[] word = new String[1];
        String tempString = "";
        int length = 0, wordIndex = 0;
        try {
            File file = new File("sopa.txt");
            Scanner sc = new Scanner(file);
            String line = sc.nextLine();
            length = line.length();
            if (v.lineSize(line)){
                System.out.println("Error: cannot be grater than 40");
                sc.close();
                return;
            }
            sopa = new String[length];
            for(int i=0; i<length; i++) {
                    for(int j=0; j<length; j++){
                        if (v.upperCase(line)){
                            sopa[i] = line;
                        }else{
                            System.out.println("Error: cannot be a number");
                            sc.close();
                            return;
                        }
                    }
                line = sc.nextLine();
            }
            for(int i=0; i<line.length(); i++) {
                if ((v.alphabet(line.charAt(i)))){
                    tempString += line.charAt(i);
                }else if (v.separator(line.charAt(i))){
                    if (v.upperCase(tempString)){
                        System.out.println("Error: cannot be all uppercase");
                        sc.close();
                        return;
                    }
                    word[wordIndex] = tempString;
                    tempString = "";
                    wordIndex++;
                    word = java.util.Arrays.copyOf(word, word.length+1);
                }
            }
            
            while (sc.hasNextLine()) {
                tempString = "";
                line = sc.nextLine();
                for(int i=0; i<line.length(); i++) {
                    //if the caracter is between a-z or A-Z
                    if (v.alphabet(line.charAt(i))){
                        tempString += line.charAt(i);
                    }else if (v.separator(line.charAt(i))){
                        word[wordIndex] = tempString;
                        tempString = "";
                        wordIndex++;
                    }
                    System.out.println(tempString);
                }
            }
            if (!v.isSquare(sopa)){
                System.out.println("Error: has to be a square");
                sc.close();
                return;
            }
            for(int i=0; i<wordIndex; i++){
                if (v.wordInList(word[i], sopa) == 0){
                    System.out.println("Error: word not found");
                    sc.close();
                    return;
                }
            }
            v.longest(word);
            for(int i=0; i<wordIndex; i++){
                if (!v.hasMinimumLength(word[i])){
                    System.out.println("Error: word has to be at least 3 characters long");
                    sc.close();
                    return;
                }
            }
            sc.close();
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for(int i=0; i<wordIndex; i++){
            System.out.println(word[i]);
        }

    }
}