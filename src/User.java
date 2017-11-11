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
import java.util.stream.Collectors;

public class User {
    private String username;
    private String password;
    private int id;
    private String defaultUserName = "__defaultUserName__";
    
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
    
    // Tries to authenticate the user. Returns true if the user was found in the DB and the password is correct
    // Returns false otherwise
    public boolean authUser() {
        if (this.username != "" && this.username != null) {
            String fileName = ".\\users.txt";
            List<String> users = new ArrayList<>();
            try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
                users = br.lines().filter(line -> line.startsWith(this.username)).collect(Collectors.toList());            
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (users.isEmpty()) {
                System.out.println("User " + this.username + " does not exist.");
                return false;
            }
            return true;
        }
        return false;
    }
    
    // Adds the user to the DB - returns true if the user was added correctly
    public boolean setUser() {
        String newUser = this.username + "|" + this.password;
        try (FileWriter fw = new FileWriter(".\\users.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw)) {
            out.println(newUser);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public String getName() {
        return this.username;
    }

    public int getID() {
        return this.id;
    }  
}
