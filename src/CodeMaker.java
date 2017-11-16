import java.util.ArrayList;
import java.util.Scanner;

public class CodeMaker extends Player {
    public CodeMaker(boolean IA) {
        this.IA = IA;
    }

    public ArrayList<GuessToken> make_code() {
        ArrayList<GuessToken> result = new ArrayList<>();
        if (IA) {
            for(int i: play){
                GuessToken t = new GuessToken(i);
                result.add(t);
            }
            return result;

        } else {
            System.out.println("Enter your code separated by spaces:");
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextInt())
                result.add(new GuessToken(scanner.nextInt()));
        }
        return result;
    }
}
