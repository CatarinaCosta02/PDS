package lab01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Puzzle {

    char[][] puzzleMap;
    File file;

    public enum dirs{
        UP,
        UPRIGHT,
        RIGHT,
        DOWNRIGHT,
        DOWN,
        DOWNLEFT,
        LEFT,
        UPLEFT
    }

    public Puzzle(File puzzleFile){  
        file = puzzleFile;
    }

    public void getPuzzleMap() throws FileNotFoundException {
        Scanner reader = new Scanner(file);
        String currLine = reader.nextLine();
        int puzzleSize = currLine.length();
    
        puzzleMap = new char[puzzleSize][puzzleSize];
    
        for(int i = 0; i < puzzleSize; i++) {      
            for(int j = 0; j < puzzleSize; j++) {
                puzzleMap[i][j] = currLine.charAt(j);
            }
            currLine = reader.nextLine();
        }
    
        reader.close();
    }
    

    public void printPuzzleMap() {
        for (int i = 0; i < puzzleMap.length; i++) {
            for (int j = 0; j < puzzleMap[i].length; j++) {
                System.out.print(puzzleMap[i][j] + " ");
            }
            System.out.println();
        }
    }


    
    public void findWords(String[] words) {
        int size = puzzleMap.length;
        char[][] foundWordsMap = new char[size][size];
    
        for (int i = 0; i < size; i++) {
            Arrays.fill(foundWordsMap[i], '.');
        }


    
        for (String word : words) {
            word = word.toUpperCase();
    
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    if (puzzleMap[row][col] == word.charAt(0)) {
                        for (dirs direction : dirs.values()) {
                            int r = row;
                            int c = col;
                            boolean found = true;
    
                            for (int i = 1; i < word.length(); i++) {
                                switch (direction) {
                                    case UP:
                                        r--;
                                        break;
                                    case UPRIGHT:
                                        r--;
                                        c++;
                                        break;
                                    case RIGHT:
                                        c++;
                                        break;
                                    case DOWNRIGHT:
                                        r++;
                                        c++;
                                        break;
                                    case DOWN:
                                        r++;
                                        break;
                                    case DOWNLEFT:
                                        r++;
                                        c--;
                                        break;
                                    case LEFT:
                                        c--;
                                        break;
                                    case UPLEFT:
                                        r--;
                                        c--;
                                        break;
                                }
    
                                if (r < 0 || r >= size || c < 0 || c >= size) {
                                    found = false;
                                    break;
                                }
    
                                if (puzzleMap[r][c] != word.charAt(i)) {
                                    found = false;
                                    break;
                                }
                            }
    
                            if (found) {
                                int newr = row;
                                int newc = col;
                                for (int i = 0; i < word.length(); i++) {
                                    switch (direction) {
                                        case UP:
                                            foundWordsMap[newr][newc] = (puzzleMap[newr][newc]);
                                            newr--;
                                            break;
                                        case UPRIGHT:
                                            foundWordsMap[newr][newc] = (puzzleMap[newr][newc]);
                                            newr--;
                                            newc++;
                                            break;
                                        case RIGHT:
                                            foundWordsMap[newr][newc] = (puzzleMap[newr][newc]);
                                            newc++;
                                            break;
                                        case DOWNRIGHT:
                                            foundWordsMap[newr][newc] = (puzzleMap[newr][newc]);
                                            newr++;
                                            newc++;
                                            break;
                                        case DOWN:
                                            foundWordsMap[newr][newc] = (puzzleMap[newr][newc]);
                                            newr++;
                                            break;
                                        case DOWNLEFT:
                                            foundWordsMap[newr][newc] = (puzzleMap[newr][newc]);
                                            newr++;
                                            newc--;
                                            break;
                                        case LEFT:
                                            foundWordsMap[newr][newc] = (puzzleMap[newr][newc]);
                                            newc--;
                                            break;
                                        case UPLEFT:
                                            foundWordsMap[newr][newc] = (puzzleMap[newr][newc]);
                                            newr--;
                                            newc--;
                                            break;
                                    }
                                }
                                System.out.printf("%-10s %-5d %-2d,%-4d %s %n ", word, word.length(), row, col, direction);
                            }
                        }
                    }
                }
            }
        }
        
        for (int i = 0; i < foundWordsMap.length; i++) {
            for (int j = 0; j < foundWordsMap[i].length; j++) {
                System.out.print(foundWordsMap[i][j] + " ");
            }
            System.out.println();
        }
    
}
}