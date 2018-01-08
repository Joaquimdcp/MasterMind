package domini;

import java.util.ArrayList;

public class Board {
    private int currentRound;
    private Difficulty difficulty;
    private int hintsUsed;
    private int nHints;
    private Timing time;
    private CodeBreaker codeBreaker;
    private CodeMaker codeMaker;
    private boolean victory;
    private ArrayList<Round> rounds = new ArrayList<Round>();
    private ArrayList<GuessToken> solution = new ArrayList<GuessToken>();

    public Board() {
        this.hintsUsed = 0;
        this.currentRound = 0;
    }

    public Board(int hintsUsed, int currentRound) {
        rounds.add(new Round());
        this.hintsUsed = hintsUsed;
        this.currentRound = currentRound;
    }

    /* Initializes the difficulty of the game */
    public void initDifficulty(int nRounds, int nHints, int nColors, int nPositions) {
        this.nHints = nHints;
        this.difficulty = new Difficulty(nRounds, nColors, nPositions);
    }
    /* Initializes all the basic attributes of the class to play a game */
    public void initGame(int nColors) {
        this.time = new Timing();
        this.victory = false;
        this.codeBreaker = new CodeBreaker();
        this.codeMaker = new CodeMaker();
        this.solution = this.codeMaker.make_code(nColors);
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
        ArrayList<GuessToken> currentGuess = (rounds.get(currentRound-1)).getTokensGuess();
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

    public boolean setGuessTokensRound(ArrayList<GuessToken> gt) {
        if (this.currentRound < this.difficulty.getN_rounds()) {
            // Create new Round
            Round r = new Round(currentRound+1);
            // If the guess is valid
            if (r.setGuess(gt, this.difficulty.getN_colors(), this.difficulty.getN_positions())) {
                r.setAnswer(this.solution);
                rounds.add(r);
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

    public void setRound(Round round) {
        this.rounds.add(this.currentRound, round);
    }

    public void setCurrentRound(int round) {
        this.currentRound = round;
    }

    public void setTime(Timing time) {
        this.time = time;
    }

    public void setRoundLoad(ArrayList<Round> rounds){
        this.rounds = rounds;
    }

    /* Returns the round with number 'round' */
    public Round getRound(int round) {
        return this.rounds.get(round);
    }

    /* Returns the current Round */
    public Round getCurrentRound() {
        return this.rounds.get(this.currentRound-1);
    }

    /* Returns the difficulty of the Board */
    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    /* Returns the current score of the game */
    public int getScore() {
        int score = this.difficulty.difficulty();
        int time = (int)this.time.time();
        return score;
    }

    public int getnHints(){
        return this.nHints;
    }

    public int getHintsUsed(){
        return this.hintsUsed;
    }

    public long getTime(){
        return this.time.time();
    }

    public int getCurrentRoundNumber(){
        return this.currentRound;
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
        return this.time.time();
    }

    public ArrayList<GuessToken> getSolution() {
        return this.solution;
    }

    public void setterOfLoad(int hintsUsed, long time, int currentRound) {
        this.hintsUsed = hintsUsed;
        this.currentRound = currentRound;
        this.time = new Timing();
        this.time.set_saved_time(time);
    }
}
