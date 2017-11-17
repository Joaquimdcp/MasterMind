import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hint {
    /**
     * Hit class is for managing all hints of the game. You can create a hint,
     * and retrieve the measure of the help in base of which kind of hint did the
     * user used.
     */


    private String text;
    private int nhints;
    private int score;
    private int attempt;
    private ArrayList<GuessToken> rnd;
    private ArrayList<GuessToken> sl;



    private void soft_hint(){
        /**
         *  Creates a "soft hint". It only returns a softhint if in the current
         *  round you have one guess with one right possible color
         */

        for(GuessToken r: rnd){
            for(GuessToken s: sl){
                String color = s.getColour();
                if(color.equals(r.getColour())){
                    this.nhints += 1;
                    this.text = "You have in the correct position the color: " + color;
                    return;
                }
            }
        }
        this.text = "Sorry, no hints for you";
    }

    private void mid_hint(){
        /**
         *  Creates a "mid hint". It only returns a midhint if in the current
         *  round you have one guess in the right position.
         */
        int i = 0;
        while(rnd.size()>i && sl.size()>i){
            GuessToken s = sl.get(i);
            if(s.equals(rnd.get(i))){
                this.nhints+=2;
                this.text = "Your position " + i + " is correct.";
                return;
            }
        }
        this.text = "Sorry, no hints for you";
    }

    private void hard_hint(){
        /**
         *  Creates a "hard hint". The solution of one position
         */
        Random rn = new Random();
        int col = rn.nextInt() % rnd.size();
        this.text = "In position " + col + " you have to put " + (rnd.get(col)).getColour();
        this.nhints+=5;
    }

    public String get_hints(){
        /**
         *  Creates a hint in base of the difficulty and the attempts,
         *  returns the hint in String structure
         */
        attempt += 1;
        if(score>50 && attempt<2) soft_hint();
        else if(score>50 && attempt<5) mid_hint();
        else hard_hint();

        return this.text;
    }


    public Hint(Difficulty difficulty, ArrayList<GuessToken> round, ArrayList<GuessToken> solu) {
        /**
         * [CONSTRUCTOR] Creates a Hint instance and it needs:
         *      difficulty: An instance of difficulty of the game, at the moment.
         *      round:      An instance of the last round played.
         *      solu:       An instance of the solution round (0)
         */
        this.text = "Empty hint";
        this.rnd = round;
        this.sl = solu;
        this.nhints = 0;
        this.attempt = 0;
        this.score = difficulty.difficulty();
    }

}