import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerDriver {
    static Controller controller = new Controller();
    static PrintStream out = System.out;
    static Scanner in = new Scanner(System.in);

    private static void DriverConstructorDefault(){
        controller = new Controller();
        out.println("New Controller created");
    }

    private static void DriverSetGameName(){
        out.println("Enter the name of the game");
        String nameG = in.next();
        controller.setGameName(nameG);
        out.println("The name of the game has been setted");
    }

    private  static  void DriversetGuessTokensRound(){
        ArrayList<GuessToken> a = new ArrayList<GuessToken>();
        out.println("Enter the number of positions that you want to enter");
        int n = in.nextInt();
        for(int i=0; i<n; ++i){
            out.println("Enter the number of the colour of the guess token number "+Integer.toString(i));
            int t = in.nextInt();
            a.add(new GuessToken(t));
        }
        boolean b = controller.setGuessTokensRound(a);
        if(b)
            out.println("Guess tokens of the next round setted correctly");
        else
            out.println("There has been an error setting the guess tokens of the next round");
    }

    private static void DrivergetCurrentUser(){
        out.println("The name of the user is "+ controller.getCurrentUser().getName());
    }

    private static void DrivergetCurrentGame(){
        out.println("Name: " +controller.getCurrentGame().getGameName());
        out.println("User: " + controller.getCurrentGame().getCurrentUser().getName());
        out.println("Difficulty: " + Integer.toString(controller.getCurrentGame().getDifficulty()));
        out.println("Score: "+ Integer.toString(controller.getCurrentGame().getScore()));
    }

    private static void DrivergetCurrentRanking(){
        controller.getCurrentRanking();
        //QUE RETORNA???
    }

    private static void DrivergetRound(){
        out.println("Enter the number of the round that you want to view");
        int n = in.nextInt();
        Round r = controller.getRound(n);
        boolean ini = true;
        for(int i=0; i<r.getTokensGuess().size(); ++i){
            if(ini){
                out.println("The guess tokens are:");
                ini = false;
            }
            out.println("Token "+Integer.toString(i)+" is "+r.getTokensGuess().get(i).getColour());
        }
        ini = true;
        for(int i=0; i<r.getTokensAnswer().size(); ++i){
            if(ini){
                out.println("The answer tokens are:");
                ini = false;
            }
            out.println("Token "+Integer.toString(i)+" is "+r.getTokensAnswer().get(i).getColour());
        }
    }

    private static void DrivergetCurrentRound(){
        Round r = controller.getCurrentRound();
        boolean ini = true;
        for(int i=0; i<r.getTokensGuess().size(); ++i){
            if(ini){
                out.println("The guess tokens are:");
                ini = false;
            }
            out.println("Token "+Integer.toString(i)+" is "+r.getTokensGuess().get(i).getColour());
        }
        ini = true;
        for(int i=0; i<r.getTokensAnswer().size(); ++i){
            if(ini){
                out.println("The answer tokens are:");
                ini = false;
            }
            out.println("Token "+Integer.toString(i)+" is "+r.getTokensAnswer().get(i).getColour());
        }
    }
    private static void DriverinitGame(){
        out.println("Type 1 if the codebreaker is the IA, type 0 if the codemaker is the IA");
        int b = in.nextInt();
        if(b!=0 && b!=1)
            out.println("You have to enter a 0 or a 1");
        else {
            out.println("Enter the number of different colors");
            int nc = in.nextInt();
            out.println("Enter the number of positions");
            int np = in.nextInt();
            out.println("Enter the maximum number of rounds");
            int nr = in.nextInt();
            out.println("Enter the maximum number of hints");
            int nh = in.nextInt();
            controller.initGame(b == 1, nc, np, nr, nh);
            out.println("The game has been initialized");
        }
    }

    private static void DriveruseHint(){
        out.println(controller.useHint());
    }

    private static void DriverplayRound(){
        String s = controller.playRound();
        out.println("The round has been played");
        out.println(s);
    }

    private static void DriverloadGame(){
        boolean b = controller.loadGame();
        if(b)
            out.println("Game loaded");
        else
            out.println("There has been an error in the loading");
    }

    private static void DriversaveGame(){
        boolean b = controller.saveGame();
        if(b)
            out.println("Game saved");
        else
            out.println("There has been an error in the saving");
    }

    private static void DriverrestartGame(){
        boolean b = controller.restartGame();
        if(b)
            out.println("Game restarted");
        else
            out.println("There has been an error in the restarting");
    }

    private static void DriverexitGame(){
        controller.exitGame();
        out.println("You've left the game");
    }

    private static void  DriverlogIn(){
        out.println("Enter the name of the user");
        String nameU = in.next();
        out.println("Enter the password of the user");
        String pasU = in.next();
        boolean b = controller.logIn(nameU, pasU);
        if(b)
            out.println("Log in has been successful");
        else
            out.println("There has been an error in the log in");
    }

    private static void DriverregisterUser(){
        out.println("Enter the name of the user");
        String nameU = in.next();
        out.println("Enter the password of the user");
        String pasU = in.next();
        boolean b = controller.registerUser(nameU, pasU);
        if(b)
            out.println("Register has been successful");
        else
            out.println("There has been an error in the register");
    }

    private static void DriverlogOut(){
        controller.logOut();
        out.println("Log out has been successful");
    }

    public static void main(String[] args) {
        boolean keepAsking = true;

        while (keepAsking) {
            out.println();
            out.println("What do you wanna do?");
            out.println("1: Create a new Controller with default constructor");
            out.println("3: Set name of the game");
            out.println("4: Set the Guess Tokens of the next Round");
            out.println("5: Get the current user");
            out.println("6: Get the current game");
            out.println("7: Get the current ranking");
            out.println("8: Get an specific round");
            out.println("9: Get the current round");
            out.println("10: Initialize the game");
            out.println("11: Use a hint");
            out.println("12: Play a round");
            out.println("13: Load a game");
            out.println("14: Save the game");
            out.println("15: Restart the game");
            out.println("16: Exit the game");
            out.println("17: Log in a user");
            out.println("18: Register a user");
            out.println("19: Log out the user");
            out.println("Press any other key to exit the program");
            if (in.hasNextInt()) {
                switch (in.nextInt()) {
                    case 1:
                        DriverConstructorDefault();
                        break;

                    case 3:
                        DriverSetGameName();
                        break;
                    case 4:
                        DriversetGuessTokensRound();
                        break;
                    case 5:
                        DrivergetCurrentUser();
                        break;
                    case 6:
                        DrivergetCurrentGame();
                        break;
                    case 7:
                        DrivergetCurrentRanking();
                        break;
                    case 8:
                        DrivergetRound();
                        break;
                    case 9:
                        DrivergetCurrentRound();
                        break;
                    case 10:
                        DriverinitGame();
                        break;
                    case 11:
                        DriveruseHint();
                        break;
                    case 12:
                        DriverplayRound();
                        break;
                    case 13:
                        DriverloadGame();
                        break;
                    case 14:
                        DriversaveGame();
                        break;
                    case 15:
                        DriverrestartGame();
                        break;
                    case 16:
                        DriverexitGame();
                        break;
                    case 17:
                        DriverlogIn();
                        break;
                    case 18:
                        DriverregisterUser();
                        break;
                    case 19:
                        DriverlogOut();
                        break;
                }
            }
            else{
                keepAsking = false;
            }
        }
    }
}

