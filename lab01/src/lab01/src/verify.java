package lab01.src;
import java.util.Arrays;

public class verify {
    public boolean lineSize(String s) {
        return (s.length() > 40);
    }

    public boolean alphabet(char c) {
        return (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z');
    }
    public boolean upperCase(String s) {
        return s.equals(s.toUpperCase());
    }

    public boolean separator(char c) {
        return (c == ' ' || c == ',' || c == ';');
    }

    public boolean hasMinimumLength(String s) {
        return s.length() >= 3;
    }

    public boolean isSquare(String [] sopa) {
        int length = sopa.length;
        for (int i = 0; i < length; i++) {
            if (sopa[i].length() != length) {
                return false;
            }
        }
        return true;
    }

    public int wordInList(String s, String[] sopa) {
        int count = 0;
        for (int i = 0; i < sopa.length; i++) {
            for (int j = 0; j < sopa[i].length()-s.length(); j++) {
                if (sopa[i].charAt(j) == s.charAt(j)) {
                    if (sopa[j].substring(s.length()).startsWith(s)) {
                        return count++;
                    }
                }
            }
        }
        return count;
    }

    public void longest(String word[]){
        for (int i = 0; i < word.length; i++){
            for (int j = 0; j < word.length; j++){
                if (word[i].length() > word[j].length()){
                    if (word[i].contains(word[j])){
                        word[j] = word[word.length-1];
                        word = Arrays.copyOf(word, word.length-1);
                    }
                }
            }
        }
    }

}
