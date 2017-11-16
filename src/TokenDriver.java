import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TokenDriver {
    public static void main(String[] args) {
        PrintStream out = System.out;
        Scanner in = new Scanner(System.in);
        ArrayList<Token> aux = new ArrayList<Token>();
        boolean keepAsking = true;

        while (keepAsking) {
            out.println();
            out.println("What do you wanna do?");
            out.println("1: Create new Token with default constructor");
            out.println("2: Create new Token with custom parameters");
            out.println("3: Compare two tokens");
            out.println("4: Print the number of the colour of a token");
            out.println("Press any other key to exit the program");
            if (in.hasNextInt()) {
                switch (in.nextInt()) {
                    case 1:
                        aux.add(new Token());
                        out.println("Token number " + Integer.toString(aux.size() - 1) + " created");
                        break;
                    case 2:
                        out.println("Enter the number of the colour of the token");
                        int num = in.nextInt();
                        aux.add(new Token(num));
                        out.println("Token number " + Integer.toString(aux.size() - 1) + " created");
                        break;
                    case 3:
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
                        break;
                    case 4:
                        out.println("Enter the number of the token");
                        int i = in.nextInt();
                        out.println("The number of the color of the token is: " + Integer.toString(aux.get(i).getNumColour()));
                        break;
                }
            }
            else{
                keepAsking = false;
            }
        }
    }
}
