import java.util.ArrayList;
import java.util.Collections;

public class Round {
    /**This class is used to represent a round. Rounds are composed of the number of the round, a list of the guessed
     * tokens and a list of the answer tokens
     **/
    private int nRound;
    private ArrayList<GuessToken> tokensGuess;
    private ArrayList<AnswerToken> tokensAnswer;

    //Private functions

    private ArrayList<AnswerToken> answerCode(ArrayList<GuessToken> llSolucio) {
        /** Private function that returns the answer code of the current round
         */
        ArrayList<Integer> doneSolution = new ArrayList<Integer>(Collections.nCopies(tokensGuess.size(), 1));
        ArrayList<Integer> doneMine = new ArrayList<Integer>(Collections.nCopies(tokensGuess.size(), 1));
        ArrayList<AnswerToken> resultBlack = new ArrayList<AnswerToken>();
        ArrayList<AnswerToken> resultWhite = new ArrayList<AnswerToken>();
        for (int i = 0; i < tokensGuess.size(); ++i) {
            if (tokensGuess.get(i).equalsToken(llSolucio.get(i))) {
                AnswerToken b = new AnswerToken(1);
                resultBlack.add(b);
                doneMine.set(i, 0);
                doneSolution.set(i, 0);
            }
        }
        for (int i = 0; i < doneSolution.size(); ++i) {
            if (doneSolution.get(i) == 1) {
                boolean notFound = true;
                for (int j = 0; j < doneMine.size() && notFound; ++j) {
                    if (doneMine.get(j) == 1) {
                        if (tokensGuess.get(j).equalsToken(llSolucio.get(i))) {
                            AnswerToken w = new AnswerToken(0);
                            resultWhite.add(w);
                            doneMine.set(j, 0);
                            notFound = false;
                        }
                    }
                }
            }
        }
        resultBlack.addAll(resultWhite);
        return resultBlack;
    }

    //Constructors

    public Round() {
        /**
         * Constructor: Public constructor method for Round with default parameters
         */
        this.nRound = 0;
        this.tokensAnswer = new ArrayList<>();
        this.tokensGuess = new ArrayList<>();
    }

    public Round(int nRound) {
        /**
         * Constructor: Public constructor method for round with custom parameters
         */
        this.nRound = nRound;
        this.tokensAnswer = new ArrayList<>();
        this.tokensGuess = new ArrayList<>();
    }

    //Getters

    public int getnRound() {
        /**Getter of the number of round that this round represents
         */
        return nRound;
    }

    public ArrayList<AnswerToken> getTokensAnswer() {
        /** Getter of the answer tokens that this round is composed of
         */
        return tokensAnswer;
    }

    public ArrayList<GuessToken> getTokensGuess() {
        /** Getter of the guesses tokens that this round is composed of
         */
        return tokensGuess;
    }

    //Setters

    public void setNRound(int n) {
        /**Setter of the number of Round that this round represents
         */
        this.nRound = nRound;
    }

    public boolean setGuess(ArrayList<GuessToken> tokensGuess, int nColours, int nPositions) {
        /** Setter of the tokensGuess: It also makes sure that there as many tokens as the number of positions in the
         * board and that all the tokens are of accepted colours; if one of this requirements is not fulfuilled it
         * returns false
         */
        if (tokensGuess.size() == nPositions) {
            boolean bien = true;
            for (int i = 0; i < tokensGuess.size() && bien; ++i) {
                if (tokensGuess.get(i).getNumColour() > nColours) {
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

    public void setAnswer(ArrayList<GuessToken> combinationSolution) {
        /** Setter of the tokensAnswer: it sets the correct answer
         */
        this.tokensAnswer = answerCode(combinationSolution);
    }

    public boolean checkAndSetAnswer(ArrayList<AnswerToken> tokensAnswer, ArrayList<GuessToken> combinationSolution) {
        /** Setter of the tokensAnswer: it checks if the answer of the parameter is right,
         * in that case it is setted and it returns true. If it's not correct it returns false.
         */
        ArrayList<AnswerToken> answer = answerCode(combinationSolution);
        if (answer.size() != tokensAnswer.size())
            return false;
        else {
            boolean allGood = true;
            for (int i = 0; i < answer.size() && allGood; ++i) {
                if (!answer.get(i).equalsToken(tokensAnswer.get(i)))
                    allGood = false;
            }
            if (allGood){
                this.tokensAnswer = tokensAnswer;
                return true;
            }
            return false;
        }
    }

    //Other functions
    public boolean isFinalRound() {
        /** Public function: It returns true if the guessed code of this round is correct.
         */
        if (tokensAnswer.size() == tokensGuess.size()) {
            boolean allGood = true;
            for (int i = 0; i < tokensAnswer.size() && allGood; ++i) {
                if (tokensAnswer.get(i).getNumColour() != 1)
                    allGood = false;
            }
            return allGood;
        } else
            return false;
    }
}
