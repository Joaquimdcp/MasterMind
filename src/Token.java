import java.util.List;
import java.util.Arrays;


public class Token{
    /**This class is used to represent a token. Tokens are composed of colour and position**/
    protected int colour;

    public Token(){
        /**
         * Constructor: Public constructor method for token with default params
         */
        this.colour = 0;
    }
    public Token(int colour){
        /**
         * Constructor: Public constructor method for token with custom params
         */
        this.colour = colour;
    }
    public boolean equalsToken(Token a){
        return a.getNumColour() == this.colour;
    }
    //Getters
    public int getNumColour(){return colour;}

}
