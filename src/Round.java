import java.util.ArrayList;

public class Round {
    /**This class is used to represent a round. Rounds are composed of the number of the round, a list of the guessed
     * tokens and a list of the answer tokens**/
    private int nRound;
    private ArrayList<GuessToken> tokensGuess;
    private ArrayList<AnswerToken> tokensAnswer;

    public Round(){
        /**
         * Constructor: Public constructor method for Round with default params
         */
        this.nRound = 0;
        this.tokensAnswer = new ArrayList<>();
        this.tokensGuess = new ArrayList<>();
    }
    public Round(int nRound){
        /**
         * Constructor: Public constructor method for round with custom param
         */
        this.nRound = nRound;
        this.tokensAnswer = new ArrayList<>();
        this.tokensGuess = new ArrayList<>();
    }

    //Getters
    public int getnRound(){return nRound;}

    public ArrayList<AnswerToken> getTokensAnswer() { return tokensAnswer;}

    public ArrayList<GuessToken> getTokensGuess() { return tokensGuess;}

    //Setters
    public void setNRound(int n){ this.nRound = nRound;}

    public boolean setGuess(ArrayList<GuessToken> tokensGuess){
        /** Setter of the tokensGuess: It also makes sure that there as many tokens as the number of positions in the
         * board and that all the tokens are of accepted colours; if one of this requirements is not fulfuilled it
         * returns false
         */
        int colors[] = Board.getNcolours(); //depen de com s'implmenti a BOARD (entenc [ncolors, nposicions])
        if(tokensGuess.size() == colors[1]){
            boolean bien = true;
            for (int i=0; i<tokensGuess.size() && bien; ++i) {
                if(tokensGuess.get(i).getNumColour()>colors[0]){
                    bien = false;
                }
            }
            if (bien) {
                this.tokensGuess = tokensGuess;
                return true;
            }
        }
        return false;
    }

    public boolean setAnswer(ArrayList<AnswerToken> tokensAnswer){
        /** Setter of the tokensAnswer: It also makes sure that the Answer is correct
         */
        ArrayList<GuessToken> llSolucio = Board.getRound(0); //depen de BOARD -> NOMES VULL ELS GUESSTOKEN
                                                        //depen de Board canviar la linia
        boolean bien = true;
        int black= 0;
        int white = 0;
        for(int i=0; i<tokensAnswer.size(); ++i){
            if(tokensAnswer.get(i).getColour()=="Black") ++black;
            else if(tokensAnswer.get(i).getColour()=="White") ++white;
        }
        //COM ES CONSIDEREN ELS REPETITS??!!! mirar normativa del joc
        for(int i=0; i<tokensGuess.size() && bien; ++i){
            //considerem que en la sempre es passen les ArrayList de Token ordenades de pos 0 a pos n!!!!!!!!!!
            //reduir black i white


            if(black<0 || white<0) bien = false;
        }
        if (bien){
            this.tokensAnswer = tokensAnswer;
            return true;
        }
        return false;
    }
}
