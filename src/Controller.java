import java.util.ArrayList;
import java.util.Map;

public class Controller {
    /**This class is the controller of the domain
     **/

    User currentUser;
    Game currentGame;
    Ranking currentRanking;

    //Constructor
    public Controller() {
        /** Constructor: Public constructor method for the controller with default parameters
         */
        this.currentUser = new User();
        this.currentGame = new Game();
        this.currentRanking = new Ranking();
    }

    //Setters
    public void setGameName(String name){
        /**Setter of the name of the Game that is being played
         */
        this.currentGame.setGameName(name);
    }

    public String setGuessTokensRound(ArrayList<GuessToken> gt){
        /**Setter of the guess tokens of the next round. It returns false if something has gone wrong
         */
        if(!this.currentGame.setGuessTokensRound(gt)){
            this.currentGame.endGame();
            if(this.currentGame.getWin()){
                this.currentRanking.updateRanking(this.currentUser.getName(), this.currentGame.getScore());
                return "Game won";
            }
            else
                return "Game ended but not won";
        }
        else
            return "Round played normally";
    }

    //Getters
    public User getCurrentUser(){
        /**Getter of the current user
         */
        return this.currentUser;
    }

    public Game getCurrentGame(){
        /**Getter of the current game
         */
        return this.currentGame;
    }

    public Map<String, Integer> getCurrentRanking(){
        /** Getter of the current ranking
         */
        return this.currentRanking.getRanking();
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
        this.currentGame = new Game(breakerIA, this.currentUser);
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
                this.currentRanking.updateRanking(this.currentUser.getName(), this.currentGame.getScore());
                return "Game won";
            }
            else
                return "Game ended but not won";
        }
        else
            return "Round played normally";
    }

    public boolean loadGame() {
        /**Public function to load a game
         */
        return this.currentGame.loadGame();
    }

    public boolean saveGame() {exitGame();
        /**Public function to save a game
         */
        return this.currentGame.saveGame();
    }

    public boolean restartGame(){
        /**Public function to restart a game
         */
        return this.currentGame.restartGame();
    }

    public void exitGame() {
        /** Public function to exit a game: it will erase the current game
         */
        this.currentGame = new Game();
    }

    public boolean logIn(String name, String password) {
        /** Public function to logIn as a user: if the user exists it returns true and it sets the user,
         * if not it returns false.
         */
        User userAux = new User(name, password);
        if(userAux.authUser()){
            this.currentUser = userAux;
            return true;
        }
        else
            return false;
    }

    public boolean registerUser(String name, String password) {
        /** Public function to create a new user: it checks if the user exists, if it does it returns false.
         * If not it sets a new user and returns true.
         */
        User userAux = new User(name, password);
        if(userAux.setUser()){
            this.currentUser = userAux;
            return true;
        }
        else
            return false;
    }

    public void logOut() {
        /** Public function: it logs out the current User.
         */
        currentUser = new User();
    }
}
