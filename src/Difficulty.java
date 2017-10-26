public class Difficulty {
    private int n_colors;
    private int n_positions;
    private int n_rounds;
    private int n_hints;

    public Difficulty(){
        this.n_colors = 4;
        this.n_positions = 4;
        this.n_rounds = 10;
        this.n_hints = 3;
    }

    public Difficulty(int n_colors, int n_positions, int n_rounds, int n_hints){
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

    // Setters


    // Another methods
    public int difficulty(){
        int evaluation = (2*n_colors + n_positions) / (2*n_rounds + n_hints);
        return evaluation;
    }
}
