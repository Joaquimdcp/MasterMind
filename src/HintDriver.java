import java.util.ArrayList;
import java.util.Scanner;

public class HintDriver {

    private static void DriverConstructor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Constructor");
        System.out.println("Please enter the number of rounds, of the game");
        int rounds = sc.nextInt();

        Difficulty d = new Difficulty(rounds);
        ArrayList<StubGuessToken> round = new ArrayList<>();
        ArrayList<StubGuessToken> sol = new ArrayList<>();
        System.out.println("Please Enter the code (user have to break)");
        for(int i = 1; i<=4; i++){
            System.out.println("Please enter guess " + i);
            System.out.println("Creating STUB of Guess Token");
            System.out.println("Please enter a Tokern color");
            System.out.println("0 - Red");
            System.out.println("1 - Blue");
            System.out.println("2 - Green");
            System.out.println("3 - Yellow");
            System.out.println("4 - Purple");
            System.out.println("5 - Orange");
            int option = sc.nextInt();

            if(option>=0 && option<=6){
                StubGuessToken sg = new StubGuessToken(option);
                sol.add(sg);

            }
            System.out.println("Invalid token try again");
        }

        System.out.println("Please Enter the answer (user attempt)");
        for(int i = 1; i<=4; i++){
            System.out.println("Please enter guess " + i);
            System.out.println("Creating STUB of Guess Token");
            System.out.println("Please enter a Tokern color");
            System.out.println("0 - Red");
            System.out.println("1 - Blue");
            System.out.println("2 - Green");
            System.out.println("3 - Yellow");
            System.out.println("4 - Purple");
            System.out.println("5 - Orange");
            int option = sc.nextInt();

            if(option>=0 && option<=6){
                StubGuessToken sg = new StubGuessToken(option);
                round.add(sg);

            }
            System.out.println("Invalid token try again");
        }

        TestHint h = new TestHint(d,round,sol);
        System.out.println("Instance created!");
        System.out.println("Do you want to get a hint with this instance? (1-YES 2-NO)");
        int choose = sc.nextInt();
        switch (choose){
            case 1:
                hint_after_create(h);
            case 2:
                System.out.println("Bye!");
        }

    }

    private static void DriverGetHint(){
        System.out.println("Constructor");
        Difficulty d = new Difficulty();
        ArrayList<StubGuessToken> round = new ArrayList<>();
        ArrayList<StubGuessToken> sol = new ArrayList<>();
        TestHint h = new TestHint(d,round,sol);
        System.out.println("The result is: " + h.get_hints());
        System.out.println("Tested all OK");

    }

    private static void hint_after_create(TestHint h){
        Scanner sc = new Scanner(System.in);
        boolean finished = false;
        while(!finished) {
            System.out.println("The result is: " + h.get_hints());
            System.out.println("Tested all OK");
            System.out.println("Do you want to get another hint? (1-YES 2-NO)");
            int choose = sc.nextInt();
            if(choose!=1) finished=true;
        }

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
                break;
            case 2:
                DriverGetHint();
                break;
        }
    }
}
