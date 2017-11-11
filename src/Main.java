import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to MasterMind!");

        System.out.println("Please press L if you want to login or H if you need help:");
        boolean valid = false;
        String c;
        while(!valid){
            c = s.nextLine();
            if(c=="L" || c=="H") valid = true;
            else System.out.println("Please you have to press L if you want to login or H if you need help:");
        }
        switch (c){
            case "L":
                System.out.println("You choose login");
                System.out.println("If you are already registered please press L to login or R to register");
                valid = false;
                while(!valid){
                    c = s.nextLine();
                    if(c=="L" || c=="R") valid = true;
                    else System.out.println("Wrong: If you are already registered please press L to login or R to register");
                }


        }


    }
}
