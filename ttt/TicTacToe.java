import java.io.*;
public class TicTacToe {

    private Board board = new Board();
    private boolean oPlaying = true;
    private final String layout = ("\n0 | 1 | 2\n---------\n" +
	  		           "3 | 4 | 5\n---------\n6 | 7 | 8\n");

    /** Top-level method to play TicTacToe. */
    public void play() {
	Token token;
	String exitMsg;
	System.out.println("Welcome to Tic-Tac-Toe!");
	System.out.println("Squares on the board are numbered like this:");
	System.out.println(this.layout);
	// Start play.
	do {
      	    if (this.oPlaying) token = new Token(Token.o);
	    else token = new Token(Token.x);
	    // Play a counter on the next square...
	    while (!this.board.playToken(this.getSquare(), token)) {
		System.out.println("That square is already taken! Try again...");
	    }
	    System.out.println(this.board.toString()); // Show the new board
	    this.oPlaying = !this.oPlaying;            // Change player
	} while (!this.board.hasWon(new Token(Token.o)) &&
	         !this.board.hasWon(new Token(Token.x)) &&
	         !this.board.isFull());
	// Game over. 
	if (this.board.hasWon(new Token(Token.o)))
	    exitMsg = "o wins -- congratulations!";
	else if (this.board.hasWon(new Token(Token.x)))
	    exitMsg = "x wins -- congratulations!";
	else
	    exitMsg = "It's a draw!";
	System.out.println(exitMsg);
    }
    
    /** Ask the player for a square and return the corresponding ArrayList 
     *  index.
     */
    private int getSquare() {
	String player;
	if (this.oPlaying) player = "o";
	else player = "x";
	System.out.println(player+" to play. Pick a square:");
	return TicTacToe.getInt();
    }

    /** Ask the user for an int between 0 and 8. */
    private static int getInt() {
       String s = new String();
       byte[] b = new byte[512];
       int bytesRead = 0;
       int i = 0;
       boolean validInput = false;
       while(!validInput) {
	   try {
	       bytesRead = System.in.read(b);
	       s = new String(b,0,bytesRead-1);
	       i = Integer.parseInt(s.trim());
	       if (i>=0 && i<=8)
		   validInput = true;
	       else throw new NumberFormatException();
	   }
	   catch(NumberFormatException e) {
	       System.out.println("That wasn't an integer between 0 and 8, try again:");
	   }
	   catch(IOException e) {
	       System.out.println(e.getMessage());
	   }
       }
       return i;
    }
}
