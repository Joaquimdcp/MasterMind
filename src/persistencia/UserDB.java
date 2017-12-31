package persistencia;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class UserDB {
    private String fileName = "users.txt";
    private String username;
    private String password;


    public UserDB(String username, String password) {
            /**
             *  Constructor of UserDB with parameters*/
        this.username = username;
        this.password = password;
    }

    private boolean userExists() {
        /**
         *  Returns true if the user was found in the DB. Returns false otherwise */
        List<String> users = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            users = br.lines().filter(line -> line.startsWith(this.username + "|")).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (users.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean authUser() {
    /**
     *  Returns true if the user was correctly authenticated */
        List<String> users = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            users = br.lines().filter(line -> line.startsWith(this.username + "|")).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!users.isEmpty()){
            StringTokenizer credentials = new StringTokenizer(users.get(0), "|");
            String usernameDB = credentials.nextToken();
            String passwordDB = credentials.nextToken();
            if (this.username.equals(usernameDB) && this.password.equals(passwordDB)) {
                return true;
            }
        }
        return false;
    }

    public boolean registerUser() {
        /**
         *  Returns true if the user was correctly added to the DB */
        if (!userExists()) {
            String newUser = this.username + "|" + this.password;
            try (FileWriter fw = new FileWriter(fileName, true);
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

    public String getUsername() {
        /**
         *  Returns the name of the user*/
        return username;
    }

    public String getPassword() {
        /**
         * Returns the password of the user*/
        return password;
    }
}
