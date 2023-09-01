<<<<<<< HEAD
package lab03;
=======
package T1; // you may change this package

>>>>>>> 9ecdf5e48e6c3ab08a2e7c11aac86c4014247a0e
public interface JGaloInterface {
	public char getActualPlayer(); // 'O' or 'X'
	public boolean setJogada(int lin, int col);
	public boolean isFinished();   // someone wons, or no empty positions
	public char checkResult();	// who wons?
}