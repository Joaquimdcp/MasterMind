import java.util.ArrayList;
import java.util.Scanner;

public class CodeMakerDriver {

    private static void play_after_create(CodeMaker cm){
        ArrayList<GuessToken> round = cm.make_code();
        for(GuessToken s: round) {
            System.out.print(s.getColour());
        }
    }

    private static void CodeMakerDriver(){
        System.out.println("Driving Code Breaker Constructor");
        CodeMaker  cm = new CodeMaker();
        System.out.println("Instance created");

        System.out.println("Do you want to play with this instance? (1-YES 2-NO");
        Scanner sc = new Scanner(System.in);
        int choose = sc.nextInt();
        switch (choose){
            case 1:
                play_after_create(cm);
            case 2:
                System.out.println("Bye!");
        }
    }

    private static void make_code(){
        System.out.println("You have to create an instace before use it");
        CodeMaker  cm = new CodeMaker();
        System.out.println("Instance created");

        play_after_create(cm);

    }

    public static void main(String[] args){
        System.out.println("You are in CodeBreaker Driver");
        System.out.println("Choose one method to drive");
        System.out.println("1- CodreMaker(Constructor)");
        System.out.println("2- make_code");
        Scanner sc = new Scanner(System.in);
        int choose = sc.nextInt();
        switch (choose){
            case 1:
                CodeMakerDriver();
            case 2:
                make_code();
        }
    }
}
