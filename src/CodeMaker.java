import java.util.ArrayList;
import java.util.Scanner;

public class CodeMaker extends Player {
    public CodeMaker(boolean IA) {
        this.IA = IA;
    }

    public ArrayList<Integer> make_code() {
        ArrayList<Integer> result = new ArrayList<>();
        if (IA) {
        } else {
            System.out.println("Enter your code separated by spaces:");
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextInt())
                result.add(scanner.nextInt());

        }
        return result;
    }
}
