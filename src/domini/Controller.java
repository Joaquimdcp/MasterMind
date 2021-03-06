package domini;

import persistencia.ControllerPersistencia;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;

public class Controller {
    /**This class is the controller of the domain
     **/

    String currentUserName;
    Game currentGame;
    ControllerPersistencia contPers;

    //Constructor
    public Controller() {
        /** Constructor: Public constructor method for the controller with default parameters
         */
        this.currentUserName = "__default__";
        this.currentGame = new Game();
        this.contPers = new ControllerPersistencia();
    }

    //Setters
    public void setGameName(String name){
        /**Setter of the name of the Game that is being played
         */
        this.currentGame.setGameName(name);
    }

    public String setGuessTokensRound(ArrayList<String> st){
        /**Setter of the guess tokens of the next round. It returns false if something has gone wrong
         */
        ArrayList<GuessToken> gt = new ArrayList<GuessToken>();
        for(String color: st){ gt.add(new GuessToken(color)); }
        if(!this.currentGame.setGuessTokensRound(gt)){
            this.currentGame.endGame();
            if(this.currentGame.getWin()){
                this.contPers.readRanking();
                this.contPers.updateRanking(this.currentUserName, this.currentGame.getScore());
                this.contPers.saveRanking();
                return "Game won";
            }
            else
                return "Game ended but not won";
        }
        else
            return "Round played normally";
    }

    //Getters
    public String getCurrentUser(){
        /**Getter of the current user
         */
        return this.currentUserName;
    }

    public Game getCurrentGame(){
        /**Getter of the current game
         */
        return this.currentGame;
    }

    public Round getRound(int n){
        /**Public function that returns an instance of the round number n (where n is the parameter of the function
         */
        return this.currentGame.getRound(n);
    }

    public Round getCurrentRound(){
        /**Public function that returns an instance of the current round
         */
        return this.currentGame.getCurrentRound();
    }


    //Other functions
    public void initGame(boolean breakerIA, int nColours, int nPositions, int nRounds, int nHints) {
        /** Public function to initialize a Game. It initializes the Game, the Board and all the other classes needed
         * to play
         */
        this.currentGame = new Game(breakerIA, this.currentUserName);
        this.currentGame.initGame(nColours, nPositions, nRounds, nHints);
    }

    public String useHint() {
        /** Public function that returns a hint (if the player has used less hints that it is permitted)
         and increments the counter of number of hints
         */
        return this.currentGame.useHint();
    }

    public String playRound() {
        /**Public function to play a round. It also controls if it's the last round (either because the game has been
         * won or because it is the last trial)
         */
        if(!this.currentGame.playRound()){
            this.currentGame.endGame();
            if(this.currentGame.getWin()){
                this.contPers.readRanking();
                this.contPers.updateRanking(this.currentUserName, this.currentGame.getScore());
                this.contPers.saveRanking();
                return "Game won";
            }
            else
                return "Game ended but not won";
        }
        else
            return "Round played normally";
    }

    public void loadGame() {
        /**Public function to load a game
         */
        this.currentGame = this.contPers.loadGame(this.currentGame.getCurrentUser());
    }

    public boolean doesSavedExist(String user){
        return this.contPers.doesSavedExist(user);
    }

    public void saveGame() throws FileNotFoundException, UnsupportedEncodingException {
        /**Public function to save a game
         */
        this.contPers.saveGame(this.currentGame);
    }

    public void exitGame() {
        /** Public function to exit a game: it will erase the current game
         */
        this.currentGame = new Game();
    }

    public void setSolution(ArrayList<String> sol){
        ArrayList<GuessToken> gt = new ArrayList<GuessToken>();
        for(String color: sol){ gt.add(new GuessToken(color)); }

        this.currentGame.setSolution(gt);

    }

    public boolean logIn(String name, String password) {
        /** Public function to logIn as a user: if the user exists it returns true and it sets the user,
         * if not it returns false.
         */
        if(contPers.logInUser(name, password)){
            this.currentUserName = name;
            return true;
        }
        else
            return false;
    }

    public boolean registerUser(String name, String password) {
        /** Public function to create a new user: it checks if the user exists, if it does it returns false.
         * If not it sets a new user and returns true.
         */
        if(contPers.registerUser(name, password)){
            this.currentUserName = name;
            return true;
        }
        else
            return false;
    }

    public void logOut() {
        /** Public function: it logs out the current User.
         */
        this.currentUserName = "__default__";
    }
}