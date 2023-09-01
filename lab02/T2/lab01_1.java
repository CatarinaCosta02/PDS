package lab01;

import java.io.File;
import java.io.FileNotFoundException;

public class lab01_1 {


    public static void main(String[] args) throws FileNotFoundException {

        File puzzleFile = new File(args[0]);
        
        Puzzle puzzle = new Puzzle(puzzleFile);
        puzzle.getPuzzleMap();
        String[] words = {"programming", "java", "words","lines"};
        puzzle.findWords(words);
    }
    
}
