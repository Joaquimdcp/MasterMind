import java.util.List;
import java.util.Arrays;

public abstract class Token {
    /**This class is used to represent a token. Tokens are composed of colour**/
    protected int colour;

    public Token() {
        /**
         * Constructor: Public constructor method for token with default params
         */
        this.colour = 0;
    }

    public Token(int colour) {
        /**
         * Constructor: Public constructor method for token with custom params
         */
        this.colour = colour;
    }

    public boolean equalsToken(Token a) {
        /**
         * Public function that returns true if the two tokens have the same color number
         */
        return a.getNumColour() == this.colour;
    }

    //Getters
    public int getNumColour() {
        /**
         * Public functions that returns the number of the token
         */
        return colour;
    }
}
