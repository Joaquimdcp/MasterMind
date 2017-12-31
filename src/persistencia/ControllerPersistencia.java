package persistencia;

public class ControllerPersistencia {

    public boolean registerUser(String username, String password) {
        /** Public function to create a new user: it checks if the user exists, if it does it returns false.
         * If not it sets a new user and returns true.
         */
        UserDB aux = new UserDB(username, password);
        if(aux.registerUser())
            return true;
        else
            return false;
    }


    public boolean logInUser(String username, String password) {
        /** Public function to logIn as a user: if the user exists it returns true and it sets the user,
         * if not it returns false.
         */
        UserDB aux = new UserDB(username, password);
        if(aux.authUser())
            return true;
        else
            return false;
    }
}
