import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static void register(){
        System.out.println("You choose register");
        Scanner s = new Scanner(System.in);
        String username = "user";
        System.out.println("Enter your username:");
        username = s.nextLine();
        System.out.println("Enter your password:");
        String  pass = s.nextLine();
        Controller cont = new Controller();
        if(cont.registerUser(username,pass)){
            System.out.println("You are registered!");
            userMenu();
        }
        else System.out.println("Error!");
    }

    private static void login(){
        System.out.println("You choose login");
        Scanner s = new Scanner(System.in);
        String username = "user";
        System.out.println("Enter your username:");
        username = s.nextLine();
        System.out.println("Enter your password:");
        String  pass = s.nextLine();
        Controller cont = new Controller();
        if(cont.logIn(username,pass)) {
            System.out.println("You are logged!");
            userMenu();
        }
        else System.out.println("Error!");
    }

    private  static void userMenu(){
        System.out.println("Command Options: ");
        System.out.println("n: New game");
        System.out.println("l: Load game");
        System.out.println("v: View ranking");
        System.out.println("q: Quit");
        Scanner s = new Scanner(System.in);

    }


    private static void play(){
        boolean valid = false;
        System.out.println("You choose play");
        System.out.println("If you are already registered please press L to login or R to register");
        valid = false;
        Scanner s = new Scanner(System.in);
        String c = "L";
        while(!valid){
            c = s.nextLine();
            if(c.equals("L") || c.equals("R")) valid = true;
            else System.out.println("Wrong: If you are already registered please press L to login or R to register");
        }
        switch (c){
            case "R":
                register();
                break;
            case "L":
                login();
                break;
        }
    }

    private static void help(){
        System.out.println("You choose help");
    }

    public static void main(String[] args) {

        System.out.println("Welcome to MasterMind!");

        System.out.println("Please press P if you want to play or H if you need help:");
        boolean valid = false;
        String c = "L";
        Scanner s = new Scanner(System.in);
        while(!valid){
            c = s.nextLine();
            System.out.println(c);
            if(c.equals("P") || c.equals("H")) valid = true;
            else System.out.println("Please you have to press P if you want to play or H if you need help:");
        }
        switch (c){
            case "P":
                play();
                break;
            case "H":
                help();
                break;
        }
    }
}
