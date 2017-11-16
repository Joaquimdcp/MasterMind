import java.util.ArrayList;
import java.util.Scanner;

public class HintDriver {

    private static void DriverConstructor(){
        System.out.println("Constructor");
        StubDifficulty d = new StubDifficulty();
        ArrayList<StubGuessToken> round = new ArrayList<>();
        ArrayList<StubGuessToken> sol = new ArrayList<>();
        TestHint h = new TestHint(d,round,sol);
        System.out.println("Tested all OK");

    }

    private static void DriverGetHint(){
        System.out.println("Constructor");
        StubDifficulty d = new StubDifficulty();
        ArrayList<StubGuessToken> round = new ArrayList<>();
        ArrayList<StubGuessToken> sol = new ArrayList<>();
        TestHint h = new TestHint(d,round,sol);
        System.out.println("The result is: " + h.get_hints());
        System.out.println("Tested all OK");

    }


    public static void main(String[] args){
        /**
         *  DRIVER
         */
        System.out.println("HINT DRIVER");
        Scanner sc = new Scanner(System.in);
        System.out.println("Method Options: ");
        System.out.println("1: Constructor");
        System.out.println("2: Get Hint");
        int option = sc.nextInt();
        switch (option){
            case 1:
                DriverConstructor();
            case 2:
                DriverGetHint();
        }
    }
}
