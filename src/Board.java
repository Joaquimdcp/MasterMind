import java.util.ArrayList;

public class Board {
    private int boardID;
    private int hintsUsed;
    private int currentRound;
    private Difficulty difficulty;
    private Timing time;
    private CodeBreaker codeBreaker;
    private CodeMaker codeMaker;
    private ArrayList<Round> rounds; //(< a n_Rounds/trials)
    private ArrayList<Hint> hints; // ??
    private int maxHints;

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
        this.maxHints = n_hints;
    }
    public int initGame(boolean isIA) {
        this.time = new Timing();
        this.time.set_start_time();
        this.codeBreaker = new CodeBreaker();
        this.codeMaker = new CodeMaker(isIA);
        return boardID;
    }
        
    public boolean useHint() {
        hintsUsed += 1;
        return hintsUsed > maxHints;
    }

    public boolean playRound() {
        if (this.currentRound == 0) {
            this.codeMaker.make_code();
        } else {

        }
        return true;
    }

    public Round getRound(int round) {
        return rounds.get(round);
    }

    public Round getCurrentRound() {
        return rounds.get(this.currentRound);
    }

    public void newHint() {
        Hint h = new Hint(difficulty);
        // TODO: decidir cómo comunicar hints al controller/game
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
