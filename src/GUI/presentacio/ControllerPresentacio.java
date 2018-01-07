package GUI.presentacio;

import domini.Controller;
import domini.GuessToken;
import domini.Round;

import java.util.ArrayList;
import java.util.Map;

public class ControllerPresentacio {
    private Controller contDom;

    //Constructor
    public ControllerPresentacio(){
        /** Constructor: Public constructor method for the controller of the presentation
         *  with default parameters
         */
        contDom = new Controller();
    }

    //Setters
    public void setGameName(String name){
        /**Setter of the name of the Game that is being played
         */
        this.contDom.setGameName(name);
    }

    public String setGuessTokensRound(ArrayList<GuessToken> gt){
        /**Setter of the guess tokens of the next round. It returns false if something has gone wrong
         */
        return this.contDom.setGuessTokensRound(gt);
    }

    //Getters
    public Round getCurrentRound(){
        /**Public function that returns an instance of the current round
         */
        return this.contDom.getCurrentRound();
    }

    //Other functions
    public void initGame(boolean breakerIA, int nColours, int nPositions, int nRounds, int nHints) {
        /** Public function to initialize a Game. It initializes the Game, the Board and all the other classes needed
         * to play
         */
        this.contDom.initGame(breakerIA, nColours, nPositions, nRounds, nHints);
    }

    public String useHint() {
        /** Public function that returns a hint (if the player has used less hints that it is permitted)
         and increments the counter of number of hints
         */
        return this.contDom.useHint();
    }

    public String playRound() {
        /**Public function to play a round. It also controls if it's the last round (either because the game has been
         * won or because it is the last trial)
         */
        return this.contDom.playRound();
    }

    public boolean loadGame() {
        /**Public function to load a game
         */
        return this.contDom.loadGame();
    }

    public boolean saveGame() {
        /**Public function to save a game
         */
        return this.contDom.saveGame();
    }

    public void exitGame() {
        /** Public function to exit a game: it will erase the current game
         */
        this.contDom = new Controller();
    }

    public boolean logIn(String name, String password) {
        /** Public function to logIn as a user: if the user exists it returns true and it sets the user,
         * if not it returns false.
         */
        return this.contDom.logIn(name, password);
    }

    public boolean registerUser(String name, String password) {
        /** Public function to create a new user: it checks if the user exists, if it does it returns false.
         * If not it sets a new user and returns true.
         */
        return this.contDom.registerUser(name, password);
    }

    public void logOut() {
        /** Public function: it logs out the current User.
         */
        this.contDom.logOut();
    }
}