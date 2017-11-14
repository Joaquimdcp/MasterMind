import java.util.ArrayList;

public class Board {
    private int boardID;
    private int hintsUsed;
    private int currentRound;
    private Difficulty difficulty;
    private Timing time;
    private CodeBreaker codeBreaker;
    private CodeMaker codeMaker;
    private ArrayList<Round> rounds;
    private ArrayList<Hint> hints; // la necesito?
    private ArrayList<AnswerToken> answer;

    public Board() {
        this.boardID = 0;
        this.hintsUsed = 0;
        this.currentRound = 0;
    }

    public Board(int boardID, int hintsUsed, int currentRound) {
        this.boardID = boardID;
        this.hintsUsed = hintsUsed;
        this.currentRound = currentRound;
    }

    public void initDifficulty(int n_colors, int n_positions, int n_rounds, int n_hints) {
        this.difficulty = new Difficulty(n_colors, n_positions, n_rounds, n_hints);
    }
    public int initGame(boolean isIA) {
        this.time = new Timing();
        this.time.set_start_time();
        this.codeBreaker = new CodeBreaker(isIA);
        this.codeMaker = new CodeMaker(isIA);
        this.answer = this.codeMaker.make_code();
        return boardID;
    }
        
    public boolean useHint() {
        hintsUsed += 1;
        if (this.hintsUsed > (this.difficulty.getN_hints())) {
            Hint h = new Hint(this.difficulty);
            this.hints.add(h);
            System.out.println(h.get_hints());
            return true;
        }
        return false;
    }

    public boolean playRound() {
        // play contiene la jugada del codeBreaker (tanto si es IA como si no)
        ArrayList<GuessToken> play = codeBreaker.play(this.answer, this.currentRound);
        Round r = new Round(this.currentRound);
        r.setGuess(play, this.difficulty.getN_colors());
        boolean b = r.setAnswer();
        rounds.add(this.currentRound, r);
        this.currentRound++;
        return true;
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
