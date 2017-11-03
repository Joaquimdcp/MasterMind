import java.util.ArrayList;

public class Round {
    /**This class is used to represent a round. Rounds are composed of the number of the round, a list of the guessed
     * tokens and a list of the answer tokens**/
    private int nRound;
    private ArrayList<Token> tokensGuess;
    private ArrayList<Token> tokensAnswer;

    public Round(){
        /**
         * Constructor: Public constructor method for Round with default params
         */
        this.nRound = 0;
        this.tokensAnswer = new ArrayList<>();
        this.tokensGuess = new ArrayList<>();
    }
    public Round(int nRound, ArrayList<Token> tokensGuess){
        /**
         * Constructor: Public constructor method for round with custom params
         */
        this.nRound = nRound;
        this.tokensGuess = tokensGuess;
        this.tokensGuess = new ArrayList<>();
    }

    //Getters

    //Setters
}
