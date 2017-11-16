import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class User {
    private String defaultUserName = "__defaultUserName__";
    private String username;
    private String password;
    private String credential;

    public User() {
        this.username = defaultUserName;
        this.password = null;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password; //will be hashed in the final version
        //this.id = LAST_USER_ID + 1; //LAST_USER_ID must be somewhere in the DB
        //en caso de necesitarlo se haría
    }

    // Returns true if the user was found in the DB and sets the user credentials
    // Returns false otherwise
    private boolean userExists(String username) {
        String fileName = "users.txt";
        List<String> users = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            users = br.lines().filter(line -> line.startsWith(this.username + "|")).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (users.isEmpty()) {
            return false;
        }
        this.credential = users.get(0);
        return true;
    }

    // Tries to authenticate the user. 
    public boolean authUser() {
        if (!this.username.isEmpty() && this.username != null) {
            if (userExists(this.username)) {
                StringTokenizer credentials = new StringTokenizer(credential, "|");
                String username = credentials.nextToken();
                String password = credentials.nextToken();
                if (username.equals(this.username) && password.equals(this.password)) {
                    System.out.println("User " + this.username + " correctly authentified");
                    return true;
                }
            }
        }
        return false;
    }

    // Adds the user to the DB - returns true if the user was added correctly
    public boolean setUser() {
        if (!userExists(this.username)) {
            String newUser = this.username + "|" + this.password;
            try (FileWriter fw = new FileWriter("users.txt", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter out = new PrintWriter(bw)) {
                out.println(newUser);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }
        return false;
    }

    public String getName() {
        return this.username;
    }
}
