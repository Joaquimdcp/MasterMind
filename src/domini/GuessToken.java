package domini;

import java.util.Arrays;
import java.util.List;

public class GuessToken extends Token {
    /**This class is used to represent a guess token. GuessTokens are composed of colour and an array
     * of the possible colours**/
    private static List<String> nameColours = Arrays.asList("Red", "Blue", "Green", "Yellow", "Purple", "Orange", "Brown", "Pink");

    public GuessToken() {
        /**
         * Constructor: Public constructor method for Answertoken with default params
         */
        super();
    }

    public GuessToken(int colour) {
        /**
         * Constructor: Public constructor method for token with custom params
         */
        super(colour);
    }

    //Getters
    public String getColour() {
        return nameColours.get(super.colour);
    }
}
