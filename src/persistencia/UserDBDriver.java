package persistencia;
import java.io.PrintStream;
import java.util.Scanner;

public class UserDBDriver {
    static PrintStream out = System.out;
    static Scanner in = new Scanner(System.in);
    static UserDB currentUser = new UserDB("auxName", "auxpassword");

    private static void DriverRegisterCustom() {
        out.println("Enter the Username");
        String username = in.next();
        out.println("Enter the Password");
        String password = in.next();
        UserDB aux = new UserDB(username, password);
        if(aux.registerUser()) {
            out.println("User correctly registered");
            currentUser = aux;
        }
        else
            out.println("User already exists");
    }

    private static void DriverLogIn() {
        out.println("Enter the Username");
        String username = in.next();
        out.println("Enter the Password");
        String password = in.next();
        UserDB aux = new UserDB(username, password);
        if(aux.authUser()) {
            out.println("User correctly logged in");
            currentUser = aux;
        }
        else
            out.println("Username or password are not correct");
    }

    private static void DriverPrintUser(){
        out.println("The username is: " + currentUser.getUsername());
        out.println("The password is: "+ currentUser.getPassword());
    }

    public static void main(String[] args) {
        boolean keepAsking = true;

        while (keepAsking) {
            out.println();
            out.println("What do you wanna do?");
            out.println("1: Register new User");
            out.println("2: Login a user");
            out.println("3: Print the current user");
            out.println("Press any other key to exit the program");
            if (in.hasNextInt()) {
                switch (in.nextInt()) {
                    case 1:
                        DriverRegisterCustom();
                        break;
                    case 2:
                        DriverLogIn();
                        break;
                    case 3:
                        DriverPrintUser();
                        break;
                }
            }
            else{
                keepAsking = false;
            }
        }
    }
}
