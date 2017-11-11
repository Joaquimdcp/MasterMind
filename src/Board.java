import jdk.nashorn.internal.runtime.Timing;

public class Board {
    private int boardID;
    private int hintsUsed;
    private int currentRound;
    private Difficulty difficulty;
    private Timing time;
    private CodeBreaker codeBreaker;
    private Player codeMaker;
    
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
    
    public int initGame(int n_colors, int n_positions, int n_rounds, int n_hints) {
        this.difficulty = new Difficulty(n_colors, n_positions, n_rounds, n_hints);
        this.time = new Timing();
        this.codeBreaker = new CodeBreaker();
        this.codeMaker = new Player();
        return boardID;
    }
    
    public boolean loadGame(Board board, Difficulty difficulty, List<Round> rounds, Player breaker, Player maker) {
        
    }
    
    public saveGame() {
    
    }
    
    public restartGame() {
        
    }

    public endGame() {
    
    }
        
    public boolean useHint() {
        hintsUsed += 1;
        return hintsUsed > MAX_HINTS;
    }
    
    public boolean playRound() {
        return true;
    }
    
    public int getRound(int round) {
        
        return r;
    }
}
