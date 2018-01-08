package domini;

import java.util.Arrays;
import java.util.List;

public class AnswerToken extends Token {
    /**This class is used to represent an answer token. AnswerTokens are composed of colour and an array
     * of the possible colours**/
    private static List<String> nameColours = Arrays.asList("White", "Black");

    public AnswerToken() {
        /**
         * Constructor: Public constructor method for Answertoken with default params
         */
        super();
    }

    public AnswerToken(int colour) {
        /**
         * Constructor: Public constructor method for token with custom params
         */
        super(colour);
    }

    public AnswerToken(String colour) {
        /**
         * Constructor: Public constructor method for token with custom params
         */
        super(0);
        if(colour == "White") super.colour = 0;
        else if (colour=="Black") super.colour = 1;
    }
    //Getters
    public String getColour() {
        return nameColours.get(super.colour);
    }
}
