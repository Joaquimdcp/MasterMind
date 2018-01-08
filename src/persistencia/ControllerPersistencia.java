package persistencia;

public class ControllerPersistencia {

    private UserDB users;
    private Ranking rankig;

    public ControllerPersistencia(){
        users = new UserDB();
        rankig = new Ranking();
    }

    public boolean registerUser(String username, String password) {
        /** Public function to create a new user: it checks if the user exists, if it does it returns false.
         * If not it sets a new user and returns true.
         */
        UserDB users = new UserDB(username, password);
        if(users.registerUser())
            return true;
        else
            return false;
    }

    public boolean logInUser(String username, String password) {
        /** Public function to logIn as a user: if the user exists it returns true and it sets the user,
         * if not it returns false.
         */
        UserDB users = new UserDB(username, password);
        if(users.authUser())
            return true;
        else
            return false;
    }

    /* Updates the ranking with the new entry, if the score is good enough */
    public void updateRanking(String username, Integer score) {
        this.rankig.updateRanking(username, score);
    }

    public void readRanking() {
        this.rankig.readRanking();
    }

    public void saveRanking() {
        this.rankig.saveRanking();
    }
}