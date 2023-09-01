package lab01.src;
import java.util.Arrays;

public class WSSolver {
    static int direction;
    static int[] diagonalDirection = new int[2];
    public static void solve(String[] word, String[] sopa) {
        for (int i = 0; i < word.length; i++) {
            for (int j = 0; j < sopa.length; j++) {
                for (int k = 0; k < sopa[j].length(); k++) {
                    if (sopa[j].charAt(k) == word[i].charAt(0)) {
                        direction = line(word[i], sopa, j, k);
                        if (direction != 0) {
                            //sum the direction * word.length to get the last position

                        }
                        direction = column(word[i], sopa, j, k);
                        if (direction != 0) {
                            //sum the direction * word.length to get the last position
                        }
                        diagonalDirection = diagonal(word[i], sopa, j, k);
                        if (!Arrays.equals(diagonalDirection, new int[] { 0, 0 })) {
                            //sum the diagonalDirection * word.length to get the last position
                        }
                    }
                }
            }
        }
    }

    public static int line(String word, String[] sopa, int j, int k) {
        int match = 0;
        
            for (int i = 1; i < word.length(); i++) {
                if (sopa[i].charAt(k + i) != word.charAt(i)) {
                    match = 0;
                    sopa[i] = sopa[i].replace(sopa[i].charAt(k+i), '.');
                    break;
                }
                match = 1;
            }
            for (int i = 1; i < word.length(); i++) {
                if (sopa[i].charAt(k - i) != word.charAt(i)) {
                    match = 0;
                    sopa[i] = sopa[i].replace(sopa[i].charAt(k-i), '.');
                    break;
                }
                match = -1;
            }
            return match;
    }


    public static int column(String word, String[] sopa, int j, int k) {
        int match = 0;
        for (int i = 1; i < word.length(); i++) {
            if (sopa[j + i].charAt(k) != word.charAt(i)) {
                match = 0;
                sopa[j + i] = sopa[j + i].replace(sopa[j + i].charAt(k+i), '.');
                break;
            }
            match = 1;
        }
        for (int i = 1; i < word.length(); i++) {
            if (sopa[j - i].charAt(k) != word.charAt(i)) {
                match = 0;
                sopa[j - i] = sopa[j - i].replace(sopa[j - i].charAt(k-i), '.');
                break;
            }
            match = -1;
        }
        return match;
    }

    public static int[] diagonal(String word, String[] sopa, int j, int k) {
        int match[] = {0,0};
    
        for (int i = 1; i < word.length(); i++) {
            if (sopa[j + i].charAt(k + i) != word.charAt(i)) {
                match[0] = 0;
                match[1] = 0;
                sopa[j + i] = sopa[j + i].replace(sopa[j + i].charAt(k+i), '.');
                break;
            }
            match[0] = 1;
            match[1] = 1;
        }
        for (int i = 1; i < word.length(); i++) {
            if (sopa[j + i].charAt(k - i) != word.charAt(i)) {
                match[0] = 0;
                match[1] = 0;
                sopa[j + i] = sopa[j + i].replace(sopa[j + i].charAt(k-i), '.');
                break;
            }
            match[0] = 1;
            match[1] = -1;
        }
        for (int i = 1; i < word.length(); i++) {
            if (sopa[j - i].charAt(k + i) != word.charAt(i)) {
                match[0] = 0;
                match[1] = 0;
                sopa[j - i] = sopa[j - i].replace(sopa[j - i].charAt(k+i), '.');
                break;
            }
            match[0] = -1;
            match[1] = 1;
        }
        for (int i = 1; i < word.length(); i++) {
            if (sopa[j - i].charAt(k - i) != word.charAt(i)) {
                match[0] = 0;
                match[1] = 0;
                sopa[j - i] = sopa[j - i].replace(sopa[j - i].charAt(k-i), '.');
                break;
            }
            match[0] = -1;
            match[1] = -1;
        }
        return match;
    }
}
