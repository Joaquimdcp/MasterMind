<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> origin/Difficulty

public class Board {
    private int boardID;
    private int hintsUsed;
    private int currentRound;
    private Difficulty difficulty;
    private Timing time;
    private CodeBreaker codeBreaker;
    private Player codeMaker;
    private ArrayList<Round> rounds; //(< a n_Rounds/trials)
    private ArrayList<Hint> hints;

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
    // Recibo de game: parámetros de Dif
    //                 rol
    //                 time
    //                 CREO HINT CUANDO ME LA PIDAN
    public void initDifficulty(int n_colors, int n_positions, int n_rounds, int n_hints) {
        this.difficulty = new Difficulty(n_colors, n_positions, n_rounds, n_hints);
    }
    public int initGame() {
        
        this.time = new Timing();
        this.codeBreaker = new CodeBreaker();
        this.codeMaker = new Player();
        return boardID;
    }
<<<<<<< HEAD

=======
    /**
    public boolean loadGame(Board board, Difficulty difficulty, List<Round> rounds, Player breaker, Player maker) {
        
    }


    public saveGame() {
    
    }
    
    public restartGame() {
        
    }

    public endGame() {
    
    }
     ***/
        
>>>>>>> origin/Difficulty
    public boolean useHint() {
        hintsUsed += 1;
        // TODO: MAX_HINTS a partir de la dificultad
        return hintsUsed > MAX_HINTS;
    }

    public boolean playRound() {
        return true;
    }

    public int getRound(int round) {
        // TODO
        return r;
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
        return true;
    }

    public boolean endGame() {
        return true;
    }
}
