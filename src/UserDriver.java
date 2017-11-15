import java.util.Scanner;

public class UserDriver {
    public static void main(String[] args) {
        String username;
        String password;
        Scanner s = new Scanner(System.in);
        String choice;
        User usuario;
        boolean quit = false;
        String exitChoice = "";

        System.out.println("Welcome to the User class");
        while (!quit) {
            System.out.println("[+] Please enter the username");
            username = s.nextLine();
            System.out.println("[*] Please enter the password");
            password = s.nextLine();
            usuario = new User(username, password);
            System.out.println("R: Register user " + username);
            System.out.println("L: Login with user " + username);
            System.out.println("Press any other key to exit");
            choice = s.nextLine();
            switch (choice) {
                case "R":
                    if (usuario.setUser()) {
                        System.out.println("User " + username + " has been registered");
                        System.out.println("You can now login to your account");
                        System.out.println("'X' to exit, press any other key to continue");
                        exitChoice = s.nextLine();
                        
                    }
                    else {
                        System.out.println("User " + username + " already exists");
                        System.out.println("Please try again");
                    }
                    break;
                case "L":
                    if (usuario.authUser()) {
                        System.out.println("You're now logged in");
                        System.out.println("'X' to exit, press any other key to continue");
                        exitChoice = s.nextLine();
                    } else {
                        System.out.println("Wrong credentials");
                    }
                    break;
                default:
                    quit = true;
                    break;
            }
            if (exitChoice.equals("X")) {
                quit = true;
            }
        }
        
    }
}