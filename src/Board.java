public class Board {
    private int boardID;
    private int hintsUsed;
    private int currentRound;
    
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
    
    public int initGame() {
        Difficulty difficulty = new Difficulty();
        Timing time = new Timing();
        Player codeBreaker = new Player();
        Player codeMaker = new Player();
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
        
    }
    
    public int getRound(int round) {
        
        return r;
    }
}
