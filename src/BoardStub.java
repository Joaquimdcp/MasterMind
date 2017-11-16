public class BoardStub {

    public BoardStub() {
    }

    public BoardStub(int hintsUsed, int currentRound) {
        
    }
    
    /* Initializes the difficulty of the game */
    public void initDifficulty(int nColors, int nPositions, int nRounds, int nHints) {
        
    }
    /* Initializes all the basic attributes of the class to play a game */
    public void initGame(boolean breakerIA) {
        
    }
    
    /* Returns true if the hint was used, false if all the hints available have been used already */
    public boolean useHint() {
        return true;
    }
    
    public String newHint() {
        return "Your position 3 is correct.";
    }
    /* Returns true if the game continues, false if it's the end of the game (either because the code was broken
        or because there are no more rounds to be played. */
    public boolean playRound() {
        return true;
    }

    /* Returns true if the player has won */
    public boolean hasPlayerWon() {
        return true;
    }
    
    /* Returns the round with number 'round' */
    public Round getRound(int round) {
        Round r = new Round();
        return r;
    }

    /* Returns the current Round */
    public Round getCurrentRound() {
        Round r = new Round(1);
        return r;
    }

    /* Returns the difficulty of the Board */
    public Difficulty getDifficulty() {
        Difficulty d = new Difficulty(4, 5, 6);
        return d;
    }

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
        return 1000;
    }
}
