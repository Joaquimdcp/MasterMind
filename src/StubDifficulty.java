import java.util.HashMap;
import java.util.Map;

public class StubDifficulty {

    public StubDifficulty() {

    }

    public StubDifficulty(int n_colors, int n_positions, int n_rounds) {
        /**
         * Constructor: Public constructor method for difficulty with custom params
         */
    }

    // Getters
    public int getN_colors() {
        return 6;
    }

    public int getN_positions() {
        return 4;
    }

    public int getN_rounds() {
        return 10;
    }

    public Map get_all() {
        Map information = new HashMap();
        information.put("n_colors", 6);
        information.put("n_positions", 4);
        information.put("n_rounds", 10);
        return information;

    }

    // Another methods
    public int difficulty() {
        /**
         * Public function for returning the value of difficulty of the game.
         */
        int evaluation = (2 * 6 + 4)/10;
        return evaluation;
    }
}
