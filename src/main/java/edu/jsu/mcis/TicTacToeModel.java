package edu.jsu.mcis;

public class TicTacToeModel {
    
    private Mark[][] board; /* Game board */
    private boolean xTurn;  /* True if X is current player */
    private int width;      /* Size of game board */
    
    /* ENUM TYPE DEFINITIONS */
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a TIE,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("TIE"), 
        NONE("NONE");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        this(TicTacToe.DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create board (width x width) as a 2D Mark array */
        
        board = new Mark[width][width];

        /* Initialize board by filling every square with empty marks */
        
        // INSERT YOUR CODE HERE

		for(int i = 0; i < width; ++i){
			for(int j = 0; j < width; ++j){
				board[i][j] = Mark.EMPTY;
            }
        }
        
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Use "isValidSquare()" to check if the specified location is in range,
           and use "isSquareMarked()" to see if the square is empty!  If the
           specified location is valid, make a mark for the current player, then
           toggle "xTurn" from true to false (or vice-versa) to switch to the
           other player before returning TRUE.  Otherwise, return FALSE. */
        
        // INSERT YOUR CODE HERE

         boolean test = false;
        if(isValidSquare(row, col)){
            if(!isSquareMarked(row, col)){
                if(xTurn){
                    board[row][col] = Mark.X;
                    
                }
                else{
                    board[row][col] = Mark.O;
                     
                }
                xTurn = !xTurn;
                test = true;
            }
            return test;
        }
        
        return false;
               
    }     
    
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return TRUE if the specified location is within the bounds of the board */
        
        // INSERT YOUR CODE HERE

          if((row < width) && (row >= 0) && (col < width) && (col >= 0) ){
         return true;
        }
        else{
            return false;
        }
        
    }
	
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return TRUE if the square at specified location is marked */
        
        // INSERT YOUR CODE HERE

         if(board[row][col] == Mark.EMPTY ){
            return false;
        }
        else{
            return true;
        }
        
    }
	

	
    public Mark getMark(int row, int col) {
        
        /* Return the mark from the square at the specified location */
        
        // INSERT YOUR CODE HERE

        Mark zone = board[row][col];
        return zone;
      
    }
	
        
    public Result getResult() {
        
        /* Call "isMarkWin()" to see if X or O is the winner, if the game is a
           TIE, or if the game is not over.  Return the corresponding Result
           value */
        
        // INSERT YOUR CODE HERE

         if(isMarkWin(Mark.X)){
            return Result.X;
        }
        else if(isMarkWin(Mark.O)){
            return Result.O;
        }
        else if(isTie()){
            return Result.TIE;
        }
        else{
            return Result.NONE;
        }
        

    }
      
        
	
private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        //Vertical
        int counter = 0; 

        for(int i = 0; i < width; i++){
         counter = 0;
         for(int j = 0; j < width; j++){
             if(getMark(i,j) == mark){
                 counter++;
             }
         }

         if(counter == width){
             return true;
         }
     }
         //Horizontal
         for(int h = 0; h < width; h++){
             counter = 0;
             for(int z = 0; z < width; z++){
                 if(getMark(z,h) == mark){
                     counter++;
                 }
                 if(counter == width){
                     return true;
                 }
             }
         }

         //Diagonal 1
         counter = 0;
         for(int n = 0; n < width; n++){
             if(getMark(n,n) == mark){
                 counter++;
             }
         }

         if(counter == width){
             return true;
         }

         //Diagonal 2
         counter = 0;
         for(int p = 0; p < width; p++){
             if(getMark(p,width-p-1) == mark){
                 counter++;
             }
         }

         if(counter == width){
             return true;
         }
        
         return false;

         

    }

    private boolean isTie() {

        if (isMarkWin(Mark.X)|| isMarkWin(Mark.O)){
            return false;
        }

        for (int i = 0; i < width; i++) {
            for(int j = 0;j < width; j++) {
                if (getMark(i,j) == Mark.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isGameover() {
        
        /* Return TRUE if the game is over */
        
        return (Result.NONE != getResult());
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
    @Override
    public String toString() {
        
        StringBuilder output = new StringBuilder("  ");
        
        /* Output the board contents as a string (see examples) */
        for(int i = 0; i < width; ++i){
            output.append(i);
        }

        for(int j = 0; j < width; ++j){
            output.append("\n");
            output.append(j + " ");

            
            for(int z = 0; z < width; ++z){
                output.append(board[j][z]);                
            }
        } 
        output.append("\n");
        return output.toString();
        
    }
    
}
