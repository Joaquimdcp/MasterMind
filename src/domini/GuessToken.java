package domini;

import java.util.Arrays;
import java.util.List;

public class GuessToken extends Token {
    /**This class is used to represent a guess token. GuessTokens are composed of colour and an array
     * of the possible colours**/
    private static List<String> nameColours = Arrays.asList("Red", "Blue", "Green", "Yellow", "Purple", "Orange");

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

    public GuessToken(String colour) {
        /**
         * Constructor: Public constructor method for token with custom params
         */
        super(0);
        System.out.println(colour);
        if(colour.equals("red"))        super.colour = 0;
        else if (colour.equals("blue")) super.colour = 1;
        else if (colour.equals("green")) super.colour = 2;
        else if (colour.equals("yellow")) super.colour = 3;
        else if (colour.equals("purple")) super.colour = 4;
        else if (colour.equals("orange")) super.colour = 5;
    }

    //Getters
    public String getColour() {
        return nameColours.get(super.colour);
    }
}
