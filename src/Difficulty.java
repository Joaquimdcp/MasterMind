import java.util.HashMap;
import java.util.Map;

public class Difficulty {
    /**
     * This class is for making a dynamic difficulty. You can choose:
     * number of colors, number of columns, number of rounds and number of hints used
     */
    private int n_colors;
    private int n_positions;
    private int n_rounds;
    private int n_hints;


    public Difficulty(){
        /**
         * Constructor: Public constructor method for difficulty with default params
         */
        this.n_colors = 4;
        this.n_positions = 4;
        this.n_rounds = 10;
        this.n_hints = 3;
    }

    public Difficulty(int n_colors, int n_positions, int n_rounds, int n_hints){
        /**
         * Constructor: Public constructor method for difficulty with custom params
         */
        this.n_colors = n_colors;
        this.n_positions = n_positions;
        this.n_rounds = n_rounds;
        this.n_hints = n_hints;
    }

    // Getters
    public int getN_colors(){ return n_colors;}
    public int getN_positions(){return n_positions;}
    public int getN_rounds(){return n_rounds;}
    public int getN_hints(){return n_hints;}
    public Map get_all(){
        Map information  = new HashMap();
        information.put("n_colors", n_colors);
        information.put("n_positions", n_positions);
        information.put("n_rounds", n_colors);
        information.put("n_hints", n_hints);
        return information;



    }

    // Setters


    // Another methods
    public int difficulty(){
        /**
         * Public function for returning the value of difficulty of the game.
         */
        int evaluation = (2*n_colors + n_positions) / (2*n_rounds + n_hints);
        return evaluation;
    }
}
