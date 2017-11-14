import java.util.ArrayList;
import java.util.Random;

public class Hint {
    private String text;
    private int nhints;
    private int score;
    private int tryes;
    private Round round;
    private Round solu;



    private void soft_hint(){
        ArrayList<GuessToken> rnd = round.getTokensGuess();
        ArrayList<GuessToken> sl  = solu.getTokensGuess();

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
        ArrayList<GuessToken> rnd = round.getTokensGuess();
        ArrayList<GuessToken> sl  = solu.getTokensGuess();
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
        Random rn = new Random();
        int col = rn.nextInt() % (round.getTokensGuess()).size();
        this.text = "In position " + col + " you have to put " + ((round.getTokensGuess()).get(col)).getColour();
        this.nhints+=5;
    }

    public String get_hints(){
        tryes += 1;
        if(score>5 && tryes<2) soft_hint();
        else if(score>5 && tryes<5) mid_hint();
        else hard_hint();

        return this.text;
    }


    public Hint(Difficulty difficulty, Round round, Round solu) {
        this.text = "Empty hint";
        this.round = round;
        this.solu = solu;
        this.nhints = 0;
        this.tryes = 0;
        this.score = difficulty.difficulty();
    }

    public static void main(String[] args){
        System.out.println("HINT DRIVER");
    }
}