
public class Controller {
    User currentUser;

    //Constructor
    public Controller(){
        currentUser = new User();
    }

    public void initGame();

    public void loadGae();

    public void saveGae();

    public void exitGame();

    public void getRanking();

    public void howToPlay();

    public void getHint();

    public void playRound();

    /** Public function to logIn as a user: if the user exists it returns true and it sets the user,
     * if not it returns false.
     */
    public boolean logIn(String name, String password){
        User userAux = User(name, password);
        if(authUser(userAux)){
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
        User userAux = User(name, password);
        if(!authUser(userAux)){
            setUser(name, password);
            currentUser = userAux;
            return true;
        }
        else
            return false;
    }
    /** Public function: it logs out the current User.
     */
    public void logOut(){
        currentUser =  User();
    }
    public void endGame();
}
