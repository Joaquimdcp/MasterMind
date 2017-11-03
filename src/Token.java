import java.util.List;
import java.util.Arrays;


public class Token{
    /**This class is used to represent a token. Tokens are composed of colour and position**/
    protected int colour;
    protected int position;

    public Token(){
        /**
         * Constructor: Public constructor method for token with default params
         */
        this.colour = 0;
        this.position = 0;
    }
    public Token(int colour, int position){
        /**
         * Constructor: Public constructor method for token with custom params
         */
        this.colour = colour;
        this.position = position;
    }
    //Getters
    public int getNumColour(){return colour;}
    public int getPosition(){return position;}

}
