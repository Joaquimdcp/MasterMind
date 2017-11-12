public class Game {
    /**This class is used to represent a Game. A Game is composed of all the information needed to play: it has a user,
     * a board, and all the information that is needed for the ranking once the game has ended.
     * **/
    private boolean role;
    private boolean finished;
    private boolean win;
    private int score;
    private int difficulty;
    private String gameName;
    private User currentUser;
    private Board currentBoard;

    public Game() {
        /** Constructor: Public constructor method for Round with default parameters
         */
        this.role = true;
        this.finished = false;
        this.win = false;
        this.score = 0;
        this.difficulty = 0;
        this.gameName = "__defaultGameName__";
        this.currentUser = new User();
        this.currentBoard = new Board();
    }
     public Game(boolean role, User currentUser){
         /** Constructor: Public constructor method for Round with custom parameters
          */
         this.role = role;
         this.finished = false;
         this.win = false;
         this.score = 0;
         this.difficulty = 0;
         this.gameName = "__defaultGameName__";
         this.currentUser = currentUser;
         this.currentBoard = new Board();
     }

     //Setters
    public void setRole (boolean role){
        /** Setter of the role of the human player
         */
        this.role = role;
    }

    public void setDifficulty (){
        /** Setter of the difficulty of the game
         */
        this.difficulty = Board.getDifficulty();
    }

    public void setGameName(String name){
        /** Setter of the name of the Game
         */
        this.gameName = name;
    }

    public void setCurrentUser(User currentUser){
        /** Setter of the user that is gonna play this game
         */
        this.currentUser = currentUser;
    }

    //Getter
    public boolean getRole(){
        /** Getter of the role of the human player
         */
        return this.role;
    }

    public boolean getFinished(){
        /** Getter that tells if the game is finished or not
         */
        return this.finished;
    }

    public boolean getWin(){
        /** Getter that tells if the human player has won or not
          */
        return this.win;
    }

    public int getScore(){
        /** Getter that returns the score of the currentGame. If the game is not  finished it will always return 0
         */
        return this.score;
    }

    public int getDifficulty(){
        /** Getter that returns the difficulty (weighted as an integer) of the game. If the game is not finished it
         * will always return 0
         */
        return this.difficulty;
    }

    public String getGameName(){
        /** Getter of the name of the game
         */
        return this.gameName;
    }

    public User getCurrentUser(){
        /** Getter that returns the instance of the player that is playing this Game
         */
        return this.currentUser;
    }

    //Other functions
    public void initGame(int nColours, int nPositions, int nRounds, int nHints){
        /** Public function that initiates the Board and all the classes needed to play the first round
         */
        currentBoard.initGame(this.role);
        currentBoard.initDificulty(nColours, nPositions, nRounds, nHints);
    }

    public String useHint(){
        /** Public function that returns a hint (if the player has used less hints that it is permitted)
         * and increments the counter of number of hints
         */
        if(!this.currentBoard.useHint())
            return this.currentBoard.newHint(); //Entenc que retorna hint com un string
    }

    public boolean playRound(){
        /** Public function used to play a round. It returns true if it is the last round
         */
        return this.currentBoard.playRound(); //entenc que si retorna true es que es la ultima ronda
    }

    public Round getRound(int n){
        /**Public function that returns an instance of the round number n (where n is the parameter of the function
         */
        return this.currentBoard.getRount(n);
    }

    public Round getCurrentRound(){
        /** Public function that returns an instance of the current round
         */
        return this.currentBoard.getCurrentRound();
    }

    public boolean loadGame(){
        /** Public function to load a game
         */
        return this.currentBoard.loadGame();
    }

    public boolean saveGame(){
        /** Public function to save a game
         */
        return this.currentBoard.saveGame();
    }

    public boolean restartGame(){
        /** Public function to reestart a game: a restarted game is a game with the same user and same parameter
         * but a different combination to guess
         */
        return this.currentBoard.restartGame();
    }
    public void endGame(){
        /** Public function that ends a game
         */
        this.finished = true;
        this.win = this.currentBoard.hasPlayerWon();
        this.score = this.currentBoard.getScore();
        this.difficulty = this.currentBoard.getDifficulty();
        this.currentBoard = new Board();
    }
}
