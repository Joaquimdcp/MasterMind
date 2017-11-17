import java.util.ArrayList;
import java.util.Scanner;

public class DifficultyDriver {
    private static void DriverConstructor(){
        System.out.println("Constructor");
        Difficulty d = new Difficulty();
        System.out.println("Tested all OK");
    }

    private static void DriverConstructorCustom(){
        System.out.println("Custom Constructor");
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert the number of rounds");
        int nrounds = sc.nextInt();
        Difficulty d = new Difficulty(nrounds);
        System.out.println("Tested all OK");
    }

    private static void DriverGetColors(){
        Difficulty d = new Difficulty();
        System.out.println("The result is: " + d.getN_colors());

    }
    private static void DriverGetPositions(){
        Difficulty d = new Difficulty();
        System.out.println("The result is: " + d.getN_positions());

    }
    private static void DriverGetRounds(){
        Difficulty d = new Difficulty();
        System.out.println("The result is: " + d.getN_rounds());

    }
    private static void DriverGetAll(){
        Difficulty d = new Difficulty();
        System.out.println("The result is: " + d.get_all());

    }



    public static void main(String[] args){
        /**
         *  DRIVER
         */
        System.out.println("HINT DRIVER");
        Scanner sc = new Scanner(System.in);
        System.out.println("Method Options: ");
        System.out.println("1: Difficulty()");
        System.out.println("2: Difficulty(...)");
        System.out.println("3: getN_Colors()");
        System.out.println("4: getN_Positions()");
        System.out.println("5: getN_Rounds()");
        System.out.println("6: get_all()");
        int option = sc.nextInt();
        switch (option){
            case 1:
                DriverConstructor();
                break;
            case 2:
                DriverConstructorCustom();
                break;
            case 3:
                DriverGetColors();
                break;
            case 4:
                DriverGetPositions();
                break;
            case 5:
                DriverGetRounds();
                break;
            case 6:
                DriverGetAll();
                break;
        }
    }
}
