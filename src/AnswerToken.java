import java.util.Arrays;
import java.util.List;

public class AnswerToken extends Token{
    /**This class is used to represent an answer token. AnswerTokens are composed of colour, a position and an array
     * of the possible colours**/
    private static List<String> nameColours = Arrays.asList("White", "Black");

    public AnswerToken(){
        /**
         * Constructor: Public constructor method for Answertoken with default params
         */
        super();
    }
    public AnswerToken(int colour){
        /**
         * Constructor: Public constructor method for token with custom params
         */
        super(colour);
    }
    //Getters
    public String getColour(){return nameColours.get(super.colour);}

}
