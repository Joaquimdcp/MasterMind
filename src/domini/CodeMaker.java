package domini;

import java.util.ArrayList;
import java.util.Random;

public class CodeMaker {
    public CodeMaker() {

    }

    public ArrayList<GuessToken> make_code(int n_colors) {
        ArrayList<GuessToken> result = new ArrayList<>();
        Random rand = new Random();

        for (int i=0; i<4; i++) {
            GuessToken t = new GuessToken(rand.nextInt(n_colors));
            result.add(t);
        }
        return result;
    }

}
