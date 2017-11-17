import java.util.ArrayList;
import java.util.Scanner;

public class CodeBreakerDriver {


    private static void play_after_create(TestCodeBreaker cb){
        System.out.println("You have to enter the code that you want to solve");
        ArrayList<StubGuessToken> solution = new ArrayList<>();
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
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();

            if(option>=0 && option<=6){
                StubGuessToken sg = new StubGuessToken(option);
                solution.add(sg);

            }
            System.out.println("Invalid token try again");
        }

        System.out.println("Enter number of rounds");
        Scanner sc = new Scanner(System.in);
        int rounds = sc.nextInt();
        for(int j = 0; j<rounds; j++){
            ArrayList<StubGuessToken> round = cb.play(solution);
            System.out.println("Round" + j);
            for(StubGuessToken s: round){
                System.out.print(s.getColour());
            }
            System.out.println();
        }


    }


    private static void CodeBreakerDriver(){
        System.out.println("Driving Code Breaker Constructor");
        TestCodeBreaker  cb = new TestCodeBreaker();
        System.out.println("Instance created");

        System.out.println("Do you want to play with this instance? (1-YES 2-NO)");
        Scanner sc = new Scanner(System.in);
        int choose = sc.nextInt();
        switch (choose){
            case 1:
                play_after_create(cb);
            case 2:
                System.out.println("Bye!");
        }
    }

    private static void playDriver(){
        System.out.println("You have to create an instance of Code Breaker first");
        TestCodeBreaker  cb = new TestCodeBreaker();
        System.out.println("Instance created");
        play_after_create(cb);
    }

    public static void main(String[] args){
        System.out.println("You are in CodeBreaker Driver");
        System.out.println("Choose one method to drive");
        System.out.println("1- CodreBreaker(Constructor)");
        System.out.println("2- play");
        Scanner sc = new Scanner(System.in);
        int choose = sc.nextInt();
        switch (choose){
            case 1:
                CodeBreakerDriver();
            case 2:
                playDriver();
        }
    }
}
