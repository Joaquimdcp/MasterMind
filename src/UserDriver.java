import java.util.Scanner;

public class UserDriver {
    
    private static void testConstructor(String username, String password) {
        System.out.println("Creating default instance");
        User defaultUser = new User();
        System.out.println("Default instance created");
        System.out.println("Creating basic instance");
        User usuario = new User(username, password);
        System.out.println("Basic instance created");
    }

    private static void testGetName(String username, String password) {
        User usuario = new User(username, password);
        System.out.println("The username is " + usuario.getName());
    }

    private static void testSetUser(String username, String password) {
        System.out.println("Creating new user");
        User usuario = new User(username, password);
        if (usuario.setUser()) {
            System.out.println("User " + username + " has been registered");
        } else {
            System.out.println("User " + username + " already exists");
            System.out.println("Please try again");
        }
    }

    private static void testAuthUser(String username, String password) {
        User usuario = new User(username, password);
        if (usuario.authUser()) {
            System.out.println("You're now logged in");
        } else {
            System.out.println("Wrong credentials");
        }
    }

    public static void main(String[] args) {
        String username;
        String password;
        Scanner s = new Scanner(System.in);
        String choice;
        boolean quit = false;
        String exitChoice = "";

        System.out.println("Welcome to the User class");
        while(!quit) {
            System.out.println("[+] Please enter the username");
            username = s.nextLine();
            System.out.println("[*] Please enter the password");
            password = s.nextLine();
            System.out.println("C: Constructor method");
            System.out.println("N: getName method");
            System.out.println("R: Register user " + username + " (setUser method)");
            System.out.println("L: Login with user " + username + " (authUser method)");
            System.out.println("Press any other key to exit");
            choice = s.nextLine();
            switch (choice) {
                case "C":
                    testConstructor(username, password);
                    break;
                case "N":
                    testGetName(username, password);
                    break;
                case "R":
                    testSetUser(username, password);
                    break;
                case "L":
                    testAuthUser(username, password);
                    break;
                default:
                    quit = true;
                    break;
            }
            System.out.println("'X' to exit, press any other key to continue testing");
            exitChoice = s.nextLine();
            if (exitChoice.equals("X")) {
                quit = true;
            }
        }
        
    }
}