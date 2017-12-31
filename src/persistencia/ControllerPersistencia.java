package persistencia;

public class ControllerPersistencia {

    private boolean registerUser(String username, String password) {
        UserDB aux = new UserDB(username, password);
        if(aux.registerUser())
            return true;
        else
            return false;
    }

    private boolean logInUser(String username, String password) {
        UserDB aux = new UserDB(username, password);
        if(aux.authUser())
            return true;
        else
            return false;
    }
}
