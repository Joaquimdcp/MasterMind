import java.util.ArrayList;

public class Board {
    private int hintsUsed;
    private int currentRound;

    private Difficulty difficulty;
    private Timing time;
    private CodeBreaker codeBreaker;
    private CodeMaker codeMaker;
    private boolean breakerIA;
    private boolean victory;
    private ArrayList<Round> rounds;
    private ArrayList<GuessToken> solution;

    public Board() {
        this.hintsUsed = 0;
        this.currentRound = 0;
    }

    public Board(int boardID, int hintsUsed, int currentRound) {
        this.boardID = boardID;
        this.hintsUsed = hintsUsed;
        this.currentRound = currentRound;
    }
    public void initDifficulty(int nColors, int nPositions, int nRounds, int nHints) {
        this.difficulty = new Difficulty(nColours, nPositions, nRounds, nHints);
    }
    /* Initializes all the basic attributes of the class to play a game */
    public void initGame(boolean breakerIA) {
        this.time = new Timing();
        this.victory = false;
        this.breakerIA = breakerIA;
        this.codeBreaker = new CodeBreaker(breakerIA);
        this.codeMaker = new CodeMaker(!breakerIA);
        this.solution = this.codeMaker.make_code();
        this.time.set_start_time();
    }
    
    /* Returns true if the hint was used, false if all the hints available have been used already */
    public boolean useHint() {
        if (this.hintsUsed > (this.difficulty.getN_hints())) {
            Hint h = new Hint(this.difficulty);
            this.hints.add(h);
            System.out.println(h.get_hints());
            hintsUsed += 1;
            return true;
        }
        return false;
    }

    /* Returns true if the game continues, false if it's the end of the game (either because the code was broken
        or because there are no more rounds to be played. */
    public boolean playRound() {
        if (this.currentRound <= this.difficulty.getN_rounds()) {
            // Create new Round
            Round r = new Round();
            // Get guess from codeBreaker
            ArrayList<GuessToken> guessCode = codeBreaker.play(this.answer, this.currentRound);
            // If the guess is valid
            if (r.setGuess(guessCode, this.difficulty.getN_colors(), this.difficulty.getN_positions())) {
                // Get answer (black and white) from codeMaker
                // ArrayList<AnswerToken> answerCode
                // If the codeBreaker is IA
                if (this.breakerIA) {
                    // 
                    if (r.checkAndSetAnswer(userAnswerTokens, this.solution)) {
                    }
                }
                else {
                    r.setAnswer(this.solution);
                }
                rounds.add(this.currentRound, r);
                this.currentRound++;
                this.victory = r.isFinalRound();
                return !this.victory;
            }
        }
        return false;
    }

    public boolean hasPlayerWon() {
        return this.victory;
    }
    
    public Round getRound(int round) {
        return this.rounds.get(round);
    }

    public Round getCurrentRound() {
        return this.rounds.get(this.currentRound);
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    //public boolean loadGame(Board board, Difficulty difficulty, List<Round> rounds, Player breaker, Player maker)
    public boolean loadGame() {
        System.out.println("Game loaded");
        return true;
    }

    public boolean saveGame() {
        System.out.println("Game saved");
        return true;
    }

    public boolean restartGame() {
        this.time.set_start_time();
        return true;
    }

    public long endGame() {
        this.time.set_save_time();
        return this.time.getSavedTime();
    }
}
