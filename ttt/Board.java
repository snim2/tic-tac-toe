public class Board {
    private final int ROWS = 3;
    private final int COLS = 3;
    private Token[][] board = new Token[ROWS][COLS];

    /** Place a token on the board. */
    public boolean playToken(int index, Token token) {
	if (this.board[index/3][index%3] != null)
	    return false;
	else {
	    this.board[index/3][index%3] = token;
	    return true;
	}
    }

    /** Is the board full? */
    public boolean isFull() {
	for (int row=0; row<ROWS; row++) {
	    for (int col=0; col<COLS; col++) {
	       if (this.board[row][col] == null) {
		   return false;
	       }
	    }
	}
	return true;
    }

    /** Find out if one of the players has won. */
    public boolean hasWon(Token player) {
	// Check vertical win
	for (int row=0; row<ROWS; row++) {
	    if (player.equals(this.board[row][0]) &&
		player.equals(this.board[row][1]) &&
		player.equals(this.board[row][2]))
		    return true;
	}
	// Check horizontal win
	for (int col=0; col<COLS; col++) {
	    if (player.equals(this.board[0][col]) &&
		player.equals(this.board[1][col]) &&
		player.equals(this.board[2][col]))
		    return true;		
	}
	// Check diagonal win 
	if (player.equals(this.board[0][0]) &&
	    player.equals(this.board[1][1]) &&
	    player.equals(this.board[2][2]))
	    return true;
	if (player.equals(this.board[2][0]) &&
	    player.equals(this.board[1][1]) &&
	    player.equals(this.board[0][2]))
	    return true;
	// If we get down to here then noone has won!
	return false;
    }

    public String toString(){
	String hSep = "-----------";
	String vSep = "|";
	String board = "";
	for (int row=0; row<ROWS; row++) {
		for (int col=0; col<COLS; col++) {
		    board += tokToString(this.board[row][col]);
		    if (col != 2) board += vSep;
		}
		if (row != 2) 
		    board += ("\n" + hSep + "\n");
		else
		    board += "\n";
	}
	return board;
    }

    /** Adds whitespace to the token string. */
    private String tokToString(Token token) {
	if (token==null) {
	    return "   ";
	}
	else {
	    return (" " + token.toString() + " ");
	}
    }
    
}
