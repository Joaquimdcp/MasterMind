import java.util.ArrayList;

public class Board {
    private int hintsUsed;
    private int currentRound;

    private Difficulty difficulty;
    private Timing time;
    private CodeBreaker codeBreaker;
    private CodeMaker codeMaker;
    private boolean breakerIA;
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

    /* Initializes all the basic attributes of the class to play a game */
    public void initGame(boolean breakerIA, int n_colors, int n_positions, int n_rounds, int n_hints) {
        this.time = new Timing();
        this.difficulty = new Difficulty(n_colors, n_positions, n_rounds, n_hints);
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
            // creo una nueva ronda
            Round r = new Round();
            // obtengo el código del codeBreaker
            ArrayList<GuessToken> guessCode = codeBreaker.play(this.answer, this.currentRound);
            if (r.setGuess(guessCode, this.difficulty.getN_colors(), this.difficulty.getN_positions())) {
                if (this.breakerIA) {

                    if(r.checkAndSetAnswer(userAnswerTokens, this.solution)) {
                    }
                }
                else {
                    r.setAnswer(this.solution);
                }
                rounds.add(this.currentRound, r);
                this.currentRound++;
                return !(r.isFinalRound());
            }
        }
        return false;
    }

    public Round getRound(int round) {
        return this.rounds.get(round);
    }

    public Round getCurrentRound() {
        return this.rounds.get(this.currentRound);
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
        return this.time.getSavedTime();
    }
}
