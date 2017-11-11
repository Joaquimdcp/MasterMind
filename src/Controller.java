
public class Controller {
    User currentUser;

    //Constructor
    public Controller(){
        currentUser = new User();
    }

    public void initGame() {}

    public void loadGame() {}

    public void saveGame() {}

    public void exitGame() {}

    public void getRanking() {}

    public void howToPlay() {}

    public void getHint() {}

    public void playRound() {}

    /** Public function to logIn as a user: if the user exists it returns true and it sets the user,
     * if not it returns false.
     */
    public boolean logIn(String name, String password){
        User userAux = new User(name, password);
        if(userAux.authUser()){
            currentUser = userAux;
            return true;
        }
        else
            return false;
    }

    /** Public function to create a new user: it checks if the user exists, if it does it returns false.
     * If not it sets a new user and returns true.
     */
    public boolean registerUser(String name, String password){
        User userAux = new User(name, password);
        if(!userAux.authUser()){
            userAux.setUser();
            currentUser = userAux;
            return true;
        }
        else
            return false;
    }
    /** Public function: it logs out the current User.
     */
    public void logOut(){
        currentUser = new User();
    }
    public void endGame() {}
}
