<<<<<<< HEAD
package lab03;

import java.util.spi.CurrencyNameProvider;
import java.util.Arrays;

import lab03.JGaloInterface;
import lab03.JGaloInterface;
=======
package T1;
import java.util.spi.CurrencyNameProvider;
import java.util.Arrays;

import JGaloInterface;
>>>>>>> 9ecdf5e48e6c3ab08a2e7c11aac86c4014247a0e

public class ActualJGalo implements JGaloInterface {

    private char player1, player2;
    private int counter = 1;
    private char[][] board;

    public ActualJGalo() {
        this.player1 = 'X';
        this.player2 = 'O';
<<<<<<< HEAD
        this.board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; i < 3; i++) {
=======
        this.board =  new char[3][3];   
        for(int i=0; i<3 ;i++){
            for(int j=0; i<3 ;i++){
>>>>>>> 9ecdf5e48e6c3ab08a2e7c11aac86c4014247a0e
                this.board[i][j] = 'E'; //empty
            }
        }
    }

    @Override
    public char getActualPlayer() {
        if ((counter % 2) == 0) {
            counter++;
            return player2;
        } else {
            counter++;
            return player1;
        }
    }

    @Override
    public boolean setJogada(int lin, int col) {
        char currentplayer = getActualPlayer();
        if (this.board[lin][col] == 'E') {
            this.board[lin][col] = currentplayer;
            return true;
        } else return true;
    }

    @Override
    public boolean isFinished() {
        if (counter == 10) {
            return true;
            break;
        }
// nao faz sentido terem usado o equals num tipo tao premitivo de dados
        for (int lin = 1; lin < 3; lin++) {  // check every line
            if ((Arrays.equals(board[lin][1], board[lin][2])) && (Arrays.equals(board[lin][2], board[lin][3]))) {
                return true;
                break;
            }
        }

        for (int col = 1; col < 3; col++) {  // check every collumn
            if ((Arrays.equals(board[1][col], board[2][col])) && (Arrays.equals(board[2][col], board[3][col]))) {
                return true;
                break;
            }
        }

        // check diagonal1
        if ((Arrays.equals(board[1][1], board[2][2])) && (Arrays.equals(board[2][2], board[3][3]))) {
            return true;
            break;
        }

        // check diagonal2
        else if ((Arrays.equals(board[1][3], board[2][2])) && (Arrays.equals(board[2][2], board[3][1]))) {
            return true;
            break;
        }

        return false;
    }

    @Override
    public char checkResult() {
        for (int lin = 1; lin < 3; lin++) {  // check every line
            if ((Arrays.equals(board[lin][1], board[lin][2])) && (Arrays.equals(board[lin][2], board[lin][3]))) {
                return board[lin][1];
                break;
            }
        }

        for (int col = 1; col < 3; col++) {  // check every collumn
            if ((Arrays.equals(board[1][col], board[2][col])) && (Arrays.equals(board[2][col], board[3][col]))) {
                return board[1][col];
                break;
            }
        }

        // check diagonal1
        if ((Arrays.equals(board[1][1], board[2][2])) && (Arrays.equals(board[2][2], board[3][3]))) {
            return board[1][1];
            break;
        }

        // check diagonal2
        else if ((Arrays.equals(board[1][3], board[2][2])) && (Arrays.equals(board[2][2], board[3][1]))) {
            return board[1][3];
            break;
        }
        return 0;
    }

}

