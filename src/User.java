//Prueba de lectura de archivo *.txt

import java.io.IOException;
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
    
    public User() {
        this.username = defaultUser;
        this.password = NULL;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password; //will be hashed in the final version
        //this.id = LAST_USER_ID + 1; //LAST_USER_ID must be somewhere in the DB
        //en caso de necesitarlo se haría
    }
    
    public boolean authUser() {
        // TODO
        if (user.username != "defaultUser") {
            String fileName = "users.txt";
            List<String> credentials = new ArrayList<>();
            String username = user.getName();
            try (Stream<String> stream = Files.lines(Path.get(fileName))) {
                credentials = stream.filter(line -> line.startsWith(username)).collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace(); //error handling
            }
            //credentials verification
            credentials.forEach(System.out::println);
        }
        return false;
    }
    
    public String getName() {
        return this.username;
    }

    public int getID() {
        return this.id;
    }    
    public void setUser() {
        // TODO: add newUser to the database
    }
}
