package edu.jsu.mcis;

import java.util.Scanner;

public class TicTacToeView {
    
    private final Scanner keyboard;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView() {
        
        /* Initialize scanner (for console keyboard) */
        
        keyboard = new Scanner(System.in);
        
    }
	
    public TicTacToeMove getNextMove(boolean isXTurn) {
        
        /* Prompt the player to enter the row and the column of their next move.
           Return as a TicTacToeMove object. */
        
        // INSERT YOUR CODE HERE

        int row;
        int col;

        System.out.println("Enter the row and column numbers, separated by a space:");

        if(isXTurn){
            System.out.println("Player one (x), make your move:");
            row=Integer.parseInt(keyboard.next());
            col=Integer.parseInt(keyboard.next());
            TicTacToeMove turn = new TicTacToeMove(row,col);
            return turn;
        }
        
        else{
            System.out.println("Player two (O), make your move");
            row=Integer.parseInt(keyboard.next());
            col=Integer.parseInt(keyboard.next());
            TicTacToeMove turn = new TicTacToeMove(row,col);
            return turn;
        }
        

    }


    public void showInputError() {

        System.out.println("Entered location is invalid, already marked, or out of bounds.");

    }

    public void showResult(String r) {

        System.out.println(r + "!");

    }
    
    public void showBoard(String board) {
        
        System.out.println("\n\n" + board);
        
    }
	
}
