public class UserStub {

    public UserStub() {

    }

    public UserStub(String username, String password) {
    
    }

    // Tries to authenticate the user. 
    public boolean authUser() {
        return true;
    }

    // Adds the user to the DB - returns true if the user was added correctly
    public boolean setUser() {
        return true;
    }

    public String getName() {
        return "stubName";
    }
}
