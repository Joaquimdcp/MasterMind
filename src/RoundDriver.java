import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class RoundDriver {
    static PrintStream out = System.out;
    static Scanner in = new Scanner(System.in);
    static ArrayList<Round> aux = new ArrayList<Round>();

    private static void DrivercreateRoundDefault(){
        aux.add(new Round());
        out.println("Round number " + Integer.toString(aux.size() - 1) + " created");
    }

    private static void DrivercreateRoundCustom(){
        out.println("Enter the number of the round ");
        int num = in.nextInt();
        if(num>=0){
            aux.add(new Round(num));
            out.println("Round number " + Integer.toString(aux.size() - 1) + " created");
        }
        else
            out.println("This is not a correct number of round, it has to be bigger or equal to 0");
    }

    private static void DriversetNumRound(){
        out.println("Enter the round that you want to modify");
        int i = in.nextInt();
        if(i<aux.size() && i>=0) {
            out.println("Enter the new number of round");
            int num = in.nextInt();
            if(num>=0) {
                aux.get(i).setNRound(num);
                out.println("New number of round setted");
            }
            else
                out.println("This is not a valid number of round");
        }
        else
            out.println("This is not a valid number of round");
    }

    private static void DriversetGuessTokens(){
        out.println("Enter the round where you want to set the guess tokens");
        int round = in.nextInt();
        if(round<aux.size() && round>=0) {
            out.println("Enter the number of positions");
            int npos = in.nextInt();
            if(npos>=0) {
                out.println("Enter the number of possible colors");
                int ncol = in.nextInt();
                if(ncol>=0) {
                    ArrayList<GuessToken> auxG = new ArrayList<GuessToken>();
                    for (int i = 0; i < npos; ++i) {
                        out.println("Enter the number of the color of the token " + Integer.toString(i));
                        int color = in.nextInt();
                        auxG.add(new GuessToken(color));
                    }
                    if (aux.get(round).setGuess(auxG, ncol, npos))
                        out.println("Guess tokens have been setted");
                    else
                        out.println("There has been an error");
                }
                else
                    out.println("This is not a correct number of possible colors");
            }
            else
                out.println("This is not a valid number of possible colours");
        }
        else
            out.println("This is not a valid number of round");
    }

    private static void DriversetAnswerTokens(){
        out.println("Enter the round where you want to set the answer tokens");
        int round = in.nextInt();
        if(round<aux.size() && round>=0) {
            out.println("Enter the round that is the solution of the code");
            int sol = in.nextInt();
            if(sol<aux.size() && sol>=0 && aux.get(sol).getTokensGuess().size()>0) {
                aux.get(round).setAnswer(aux.get(sol).getTokensGuess());
                out.println("The answer tokens have been setted");
            }
            else
                out.println("This is not a valid round or it doesn't have any guess tokens");
        }
        else
            out.println("This is not a valid round");
    }

    private static void DrivergetNumRound(){
        out.println("Enter the number of the round");
        int i = in.nextInt();
        if(i<aux.size() && i>=0)
            out.println("The number of the round is: " + aux.get(i).getnRound());
        else
            out.println("This is not a valid number of round");
    }

    private static void DrivergetAnswerTokens(){
        out.println("Enter the number of the round");
        int i = in.nextInt();
        if(i<aux.size() && i>=0) {
            for (int j = 0; j < aux.get(i).getTokensAnswer().size(); ++j) {
                out.println("The token number " + Integer.toString(j) + " is " + aux.get(i).getTokensAnswer().get(j).getColour());
            }
        }
        else
            out.println("This is not a valid number of round");
    }

    private static void DrivergetGuessTokens(){
        out.println("Enter the number of the round");
        int i = in.nextInt();
        if(i<aux.size() && i>=0) {
            for (int j = 0; j < aux.get(i).getTokensGuess().size(); ++j) {
                out.println("The token number " + Integer.toString(j) + " is " + aux.get(i).getTokensGuess().get(j).getColour());
            }
        }
        else
            out.println("This is not a valid number of round");
    }

    public static void DrivergetIsFinalRound(){
        out.println("Enter the number of the round");
        int i = in.nextInt();
        if(i<aux.size() && i>=0) {
            if(aux.get(i).isFinalRound())
                out.println("This is a final round");
            else
                out.println("This is not a final round");
        }
        else
            out.println("This is not a valid number of round");
    }

    public static void main(String[] args) {
        boolean keepAsking = true;
        while (keepAsking) {
            out.println();
            out.println("What do you wanna do?");
            out.println("1: Create new Round with default constructor");
            out.println("2: Create new Round with custom parameters");
            out.println("3: Set the number of round of a round");
            out.println("4: Set the guess tokens of a round");
            out.println("5: Set the answer tokens of a round");
            out.println("6: Print the number of a round");
            out.println("7: Print the answer tokens of a round");
            out.println("8: Print the guess tokens of a round");
            out.println("9: Print if a Round is final");
            out.println("Press any other key to exit the program");
            if (in.hasNextInt()) {
                int num;
                int i;
                int round;
                switch (in.nextInt()) {
                    case 1:
                        DrivercreateRoundDefault();
                        break;
                    case 2:
                        DrivercreateRoundCustom();
                        break;
                    case 3:
                        DriversetNumRound();
                        break;
                    case 4:
                        DriversetGuessTokens();
                        break;
                    case 5:
                        DriversetAnswerTokens();
                        break;
                    case 6:
                        DrivergetNumRound();
                        break;
                    case 7:
                        DrivergetAnswerTokens();
                        break;
                    case 8:
                        DrivergetGuessTokens();
                        break;
                    case 9:
                        DrivergetIsFinalRound();
                        break;
                }
            }
            else{
                keepAsking = false;
            }
        }
    }
}
