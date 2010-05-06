public class Token {
    public static final int o = 1;
    public static final int x = 2;

    /** INV: token should be a member of the set:
     * { Token.o, Token.x }
     */
    private int token = 0;

    public Token(int token) {
	this.setToken(token);
    }

    public int getToken() {
	return this.token;
    }

    // Preserves class invariant.
    public void setToken(int token) {
	if (token == Token.o || token == Token.x) 
	    this.token = token;
	else this.token = 0; 
    }
    
    public boolean equals(Object o) {
	if (o == null) return false;
	Token t = (Token)o;
	if (t.getToken() == this.token) return true;
	else return false;
    }

    public String toString()
    {
       if (token == Token.o) 
           return "o";
       else if (token == Token.x)
           return "x";
       else
           return " ";
    }  
}
