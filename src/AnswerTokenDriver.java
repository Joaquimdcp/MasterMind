import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class AnswerTokenDriver {
    static PrintStream out = System.out;
    static Scanner in = new Scanner(System.in);
    static ArrayList<AnswerToken> aux = new ArrayList<AnswerToken>();

    private static void DriverConstructorDefault() {
        aux.add(new AnswerToken());
        out.println("Token number " + Integer.toString(aux.size() - 1) + " created");
    }

    private static void DriverConstructorCustom() {
        out.println("Enter the number of the colour of the token");
        int num = in.nextInt();
        if(num ==0 || num==1){
            aux.add(new AnswerToken(num));
            out.println("Token number " + Integer.toString(aux.size() - 1) + " created");
        }
        else
            out.println("This is not a correct number of colour, it can only be 0 or 1");
    }

    private static void DriverCompareTokens(){
        out.println("Enter the number of the two tokens that you want to compare");
        int i1 = in.nextInt();
        int i2 = in.nextInt();
        if (i1 >= aux.size())
            out.println("The first token specified doesn't exist");
        else {
            if (i2 >= aux.size())
                out.println("The second token specified doesn't exist");
            else {
                if (aux.get(i1).equalsToken(aux.get(i2)))
                    out.println("Both tokens are the same");
                else
                    out.println("The tokens are different");
            }
        }
    }

    private static void DrivergetNumColor(){
        out.println("Enter the number of the token");
        int i = in.nextInt();
        out.println("The number of the color of the token is: " + Integer.toString(aux.get(i).getNumColour()));
    }

    private static void DrivergetColor(){
        out.println("Enter the number of the token");
        int j = in.nextInt();
        out.println("The color of the token is: " + aux.get(j).getColour());
    }

    public static void main(String[] args) {
        boolean keepAsking = true;

        while (keepAsking) {
            out.println();
            out.println("What do you wanna do?");
            out.println("1: Create new Token with default constructor");
            out.println("2: Create new Token with custom parameters");
            out.println("3: Compare two tokens");
            out.println("4: Print the number of the colour of a token");
            out.println("5: Print the colour of a token");
            out.println("Press any other key to exit the program");
            if (in.hasNextInt()) {
                switch (in.nextInt()) {
                    case 1:
                        DriverConstructorDefault();
                        break;
                    case 2:
                        DriverConstructorCustom();
                        break;
                    case 3:
                        DriverCompareTokens();
                        break;
                    case 4:
                        DrivergetNumColor();
                        break;
                    case 5:
                        DrivergetColor();
                        break;
                }
            }
            else{
                keepAsking = false;
            }
        }
    }
}

