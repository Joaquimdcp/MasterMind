package domini;

import java.util.ArrayList;

public class Game {
    /**This class is used to represent a Game. A Game is composed of all the information needed to play: it has a user,
     * a board, and all the information that is needed for the ranking once the game has ended.
     */
    private boolean breakerIA;
    private boolean finished;
    private boolean win;
    private int score;
    private int difficulty;
    private String gameName;
    private String currentUserName;
    private Board currentBoard;
    private int ncolors;

    public Game() {
        /** Constructor: Public constructor method for Game with default parameters
         */
        this.breakerIA = true;
        this.finished = false;
        this.win = false;
        this.score = 0;
        this.difficulty = 0;
        this.gameName = "__defaultGameName__";
        this.currentUserName = "__default__";
        this.currentBoard = new Board();
    }

    public Game(boolean breakerIA, String currentUser){
        /** Constructor: Public constructor method for Game with custom parameters
        */
        this.breakerIA = breakerIA;
        this.finished = false;
        this.win = false;
        this.score = 0;
        this.difficulty = 0;
        this.gameName = "__defaultGameName__";
        this.currentUserName = currentUser;
        this.currentBoard = new Board();
    }

     //Setters
    public void setRole (boolean breakerIA){
        /** Setter of the role of the human player
         */
        this.breakerIA = breakerIA;
    }

    public void setDifficulty (){
        /** Setter of the difficulty of the game
         */
        this.difficulty = currentBoard.getDifficulty().difficulty();
    }

    public void setGameName(String name){
        /** Setter of the name of the Game
         */
        this.gameName = name;
    }

    public boolean setGuessTokensRound(ArrayList<GuessToken> gt){
        /**Setter of the guess tokens of the next round. It returns false if something has gone wrong
         */
        //return this.currentBoard.setGuessTokensRound(gt);
        return true;
    }

    //Getter
    public boolean getRole(){
        /** Getter of the role of the human player
         */
        return this.breakerIA;
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

    public int getNcolors(){
        /** Getter of number of colors
         */
        return ncolors;
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

    public String getCurrentUser(){
        /** Getter that returns the instance of the player that is playing this Game
         */
        return this.currentUserName;
    }

    public Round getRound(int n){
        /**Public function that returns an instance of the round number n (where n is the parameter of the function
         */
        return this.currentBoard.getRound(n);
    }

    public Round getCurrentRound(){
        /** Public function that returns an instance of the current round
         */
        return this.currentBoard.getCurrentRound();
    }


    //Other functions
    public void initGame(int nColours, int nPositions, int nRounds, int nHints){
        /** Public function that initiates the Board and all the classes needed to play the first round
         */
        this.ncolors = nColours;
        currentBoard.initGame();
        currentBoard.initDifficulty(nRounds, nHints);
    }

    public String useHint(){
        /** Public function that returns a hint (if the player has used less hints that it is permitted)
         * and increments the counter of number of hints
         */
        if(!this.currentBoard.useHint())
            return this.currentBoard.newHint(); //Entenc que retorna hint com un string
        else
            return "You've used all your hints";
    }

    public boolean playRound(){
        /** Public function used to play a round. It returns false if it is the last round
         */
        return this.currentBoard.playRound();
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
        this.difficulty = this.currentBoard.getDifficulty().difficulty();
        this.currentBoard = new Board();
    }
}
