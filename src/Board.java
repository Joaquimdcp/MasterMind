import java.util.ArrayList;
import java.util.List;

public class Board {
    private int currentRound;
    private Difficulty difficulty;
    private int hintsUsed;
    private int nHints;
    private Timing time;
    private CodeBreaker codeBreaker;
    private CodeMaker codeMaker;
    private boolean victory;
    private ArrayList<Round> rounds;
    private ArrayList<GuessToken> solution;

    public Board() {
        this.hintsUsed = 0;
        this.currentRound = 0;
        this.rounds = new ArrayList<Round>();
        this.solution = new ArrayList<GuessToken>();
    }

    public Board(int hintsUsed, int currentRound) {
        this.hintsUsed = hintsUsed;
        this.currentRound = currentRound;
        this.rounds = new ArrayList<Round>();
        this.solution = new ArrayList<GuessToken>();
    }

    /* Initializes the difficulty of the game */
    public void initDifficulty(int nRounds, int nHints) {
        this.nHints = nHints;
        this.difficulty = new Difficulty(nRounds);
    }
    /* Initializes all the basic attributes of the class to play a game */
    public void initGame() {
        this.time = new Timing();
        this.victory = false;
        this.codeBreaker = new CodeBreaker();
        this.codeMaker = new CodeMaker();
        this.solution = this.codeMaker.make_code();
        this.time.set_saved_time();
    }

    /* Returns true if the hint was used, false if all the hints available have been used already */
    public boolean useHint() {
        if (this.hintsUsed < this.nHints) {
            hintsUsed += 1;
            return true;
        }
        return false;
    }

    public String newHint() {
        ArrayList<GuessToken> currentGuess = (rounds.get(currentRound)).getTokensGuess();
        Hint h = new Hint(this.difficulty, currentGuess, solution);
        return h.get_hints();
    }
    /* Returns true if the game continues, false if it's the end of the game (either because the code was broken
        or because there are no more rounds to be played. */
    public boolean playRound() {
        if (this.currentRound <= this.difficulty.getN_rounds()) {
            // Create new Round
            Round r = new Round(currentRound+1);
            //ArrayList<AnswerToken> answerCode = r.getTokensAnswer();
            ArrayList<GuessToken> guessCode = codeBreaker.play(this.solution);
            // If the guess is valid
            if (r.setGuess(guessCode, this.difficulty.getN_colors(), this.difficulty.getN_positions())) {
                // Get guess from codeBreaker
                r.setAnswer(this.solution);
                // Set the answer, add the round to the list of rounds, check if the codeBreaker won
                rounds.add(this.currentRound, r);
                this.currentRound++;
                this.victory = r.isFinalRound();
                return !this.victory;
            }
        }
        return false;
    }

    /* Returns true if the player has won */
    public boolean hasPlayerWon() {
        return this.victory;
    }

    public void setVictory(boolean victory) {
        this.victory = victory;
    }

    public void setNHints(int nHints) {
        this.nHints = nHints;
    }

    public void setDifficulty(Difficulty diff) {
        this.difficulty = diff;
    }

    public void setSolution(ArrayList<GuessToken> solution) {
        this.solution = solution;
    }

    public void setRound(int index, Round round) {
        this.rounds.add(index, round);
    }

    public void setCurrentRound(int round) {
        this.currentRound = round;
    }

    public void setTime(Timing time) {
        this.time = time;
    }

    /* Returns the round with number 'round' */
    public Round getRound(int round) {
        return this.rounds.get(round);
    }

    /* Returns the current Round */
    public Round getCurrentRound() {
        return this.rounds.get(this.currentRound);
    }

    /* Returns the difficulty of the Board */
    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    /* Returns the current score of the game */
    public int getScore() {
        int score = this.difficulty.difficulty();
        int time = (int)this.time.set_saved_time();
        return score / time;
    }

    //public boolean loadGame(Board board, Difficulty difficulty, List<Round> rounds, Player breaker, Player maker)
    public boolean loadGame() {
        return true;
    }

    public boolean saveGame() {
        return true;
    }

    public boolean restartGame() {
        return true;
    }

    public long endGame() {
        return this.time.set_saved_time();
    }
}
