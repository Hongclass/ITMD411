/*
    File:   TicTacToe.java
	Author: Hong Zhang
    Date:   02/26/2014
    Description:
    This program create a tic-tac-toe game on a 3x3 board, as follows:
    The program prompts the first player to enter an "X" token, and then 
    prompts the second player to enter an "O" token. Whenever a token is 
    entered, the program refreshes the board and determines the status 
    of the game (win, draw, or unfinished).
*/

import java.util.Scanner;

class TicTacToe{

    // main method
    public static void main(String[] args){
	
	// set up a 2D array as a game board
	   final int ROWS = 3;
	   final int COLUMNS = 3;
	   char[][] board = new char[ROWS][COLUMNS];
		
        // initialize the game board
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLUMNS; j++)
                board[i][j] = ' ';
				
		// first display the game board	 
        displayBoard(board);
				
	char playValue = ' ';
	boolean gameOverX = false;
	    boolean gameOverO = false;
		
	do{
            // move for player X, then update the game		
	       playValue = 'X';
	       makeAMove(board, playValue );		
	       displayBoard(board);
               gameOverX = update(board, playValue);
            		
            // move for player O, then update the game
	       if (gameOverX == false){
	           playValue = 'O';
		   makeAMove(board, playValue);
		   displayBoard(board);
	           gameOverO = update(board, playValue); 	
	       }
	
	    }while (!gameOverX && !gameOverO);

	} // end of main method
	
	// display the game board
	public static void displayBoard(char[][] board){
	    System.out.println("_______"); // print horizontal partition
		// loop for each row
		for (int row = 0; row < board.length; row++){
		    // loop for each column in row
			for (int col = 0; col < board[row].length; col++)
			    System.out.print("|" + board[row][col]);
		    // newline at end of row
			System.out.println("|\n_______");
		}
		System.out.println();
	} // end of displayBoard method    
	
	// make a move
	public static void makeAMove(char[][] board, char playValue){
	    // for input validation
		boolean validInput = false; 
		Scanner input = new Scanner(System.in); // the input Scanner
		int row;
		int column;
		do {
		    if (playValue == 'X'){
			System.out.print("Enter a row (0, 1, or 2) for player X: ");
			row = input.nextInt();
		        System.out.print("Enter a column (0, 1, or 2) for player X: ");
			column = input.nextInt();
			}
			else {
			System.out.print("Enter a row (0, 1, or 2) for player O: ");
			row = input.nextInt();
		    System.out.print("Enter a column (0, 1, or 2) for player O: ");
			column = input.nextInt();
			}
			if (row >= 0 && row < board.length && column >= 0 
			        && column < board[row].length && board[row][column] == ' '){
			    int currentRow = row;
                            int currentCol = column;
                            board[currentRow][currentCol] = playValue;
			    validInput = true;
			}
			else{
			    System.out.println("This move is invalid. Please try again!\n ");
			}
		} while(!validInput); // repeat until input is valid
	} // end of makeAMove method
	
	// update the game
	public static boolean update(char[][] board, char playValue){
		if (hasWon(board, playValue)){
		    System.out.println(playValue + " player won");
                    return true;
        }   
		else if (boardFull(board)){
		    System.out.println("It is a draw");
                    return true;    
        }
    return false;
	} // end of update method
    
    // return true if the player with playValue has won after move
    public static boolean hasWon(char[][] board, char playValue){
	    // check vertical win
		for (int row = 0, vTotal = 0; row < board.length; row++, vTotal = 0){
			for (int col = 0; col < board[row].length; col++)
			    if (board[row][col] == playValue){
				    vTotal++;
			    if(vTotal == board.length)
		        return true;
			}
		}			
			
		// check horizontal win
		for (int col = 0, hTotal = 0; col < board[0].length; col++, hTotal = 0){
		    for (int row = 0; row < board.length; row++){
			    if(board[row][col] == playValue)
				    hTotal++;
		    if (hTotal == board.length)
		        return true;
			}
		}
		
		// check diagonal win
		if ((board[0][0]==board[1][1]&& board[1][1]==board[2][2] 
		                             && board[0][0] ==playValue)
		      || (board[0][2]==board[1][1]
			    && board[1][1]==board[2][0] 
				&& board[0][2]==playValue))
            return true;					
					
        return false;
	} // end of hasWon method	

	// return true if all positions are occupied
	public static boolean boardFull(char[][] board){
	    for (int row = 0; row < board.length; row++){
			for (int col = 0; col < board[row].length; col++){
			    if (board[row][col] == ' ')
				    return false;
		    }
		}
		return true;
	} // end of boardFull method  
		
} // end of class 
	
/* Sample Output:
_______
| | | |
_______
| | | |
_______
| | | |
_______

Enter a row (0, 1, or 2) for player X: 1
Enter a column (0, 1, or 2) for player X: 1
_______
| | | |
_______
| |X| |
_______
| | | |
_______

Enter a row (0, 1, or 2) for player O: 1
Enter a column (0, 1, or 2) for player O: 2
_______
| | | |
_______
| |X|O|
_______
| | | |
_______

Enter a row (0, 1, or 2) for player X: 0
Enter a column (0, 1, or 2) for player X: 0
_______
|X| | |
_______
| |X|O|
_______
| | | |
_______

Enter a row (0, 1, or 2) for player O: 1
Enter a column (0, 1, or 2) for player O: 0
_______
|X| | |
_______
|O|X|O|
_______
| | | |
_______

Enter a row (0, 1, or 2) for player X: 2
Enter a column (0, 1, or 2) for player X: 2
_______
|X| | |
_______
|O|X|O|
_______
| | |X|
_______

X player won

Another Sample Output:
_______
| | | |
_______
| | | |
_______
| | | |
_______

Enter a row (0, 1, or 2) for player X: 0
Enter a column (0, 1, or 2) for player X: 3
This move is invalid. Please try again!

Enter a row (0, 1, or 2) for player X: 0
Enter a column (0, 1, or 2) for player X: 1
_______
| |X| |
_______
| | | |
_______
| | | |
_______

Enter a row (0, 1, or 2) for player O: 0
Enter a column (0, 1, or 2) for player O: 0
_______
|O|X| |
_______
| | | |
_______
| | | |
_______

Enter a row (0, 1, or 2) for player X: 2
Enter a column (0, 1, or 2) for player X: 2
_______
|O|X| |
_______
| | | |
_______
| | |X|
_______

Enter a row (0, 1, or 2) for player O: 1
Enter a column (0, 1, or 2) for player O: 1
_______
|O|X| |
_______
| |O| |
_______
| | |X|
_______

Enter a row (0, 1, or 2) for player X: 2
Enter a column (0, 1, or 2) for player X: 0
_______
|O|X| |
_______
| |O| |
_______
|X| |X|
_______

Enter a row (0, 1, or 2) for player O: 2
Enter a column (0, 1, or 2) for player O: 1
_______
|O|X| |
_______
| |O| |
_______
|X|O|X|
_______

Enter a row (0, 1, or 2) for player X: 1
Enter a column (0, 1, or 2) for player X: 0
_______
|O|X| |
_______
|X|O| |
_______
|X|O|X|
_______

Enter a row (0, 1, or 2) for player O: 0
Enter a column (0, 1, or 2) for player O: 2
_______
|O|X|O|
_______
|X|O| |
_______
|X|O|X|
_______

Enter a row (0, 1, or 2) for player X: 1
Enter a column (0, 1, or 2) for player X: 2
_______
|O|X|O|
_______
|X|O|X|
_______
|X|O|X|
_______

It is a draw

*/
    

    