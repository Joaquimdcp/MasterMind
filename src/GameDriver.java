import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class GameDriver {
    static Game game = new Game();
    static PrintStream out = System.out;
    static Scanner in = new Scanner(System.in);

    private static void DriverConstructorDefault(){
        game = new Game();
        out.println("New Game created");
    }

    private static void DriverConstructorCustom(){
        out.println("Enter the name of the user");
        String nameU = in.next();
        out.println("Enter the password of the user");
        String pasU = in.next();
        User u = new User(nameU, pasU);
        out.println("Type 1 if the codebreaker is the IA, type 0 if the codemaker is the IA");
        int b = in.nextInt();
        if(b!=0 && b!=1)
            out.println("You have to enter a 0 or a 1");
        else{
            game = new Game(b==1, u);
            out.println("New Game created");
        }
    }

    private static void DriversetRole(){
        out.println("Type 1 if the codebreaker is the IA, type 0 if the codemaker is the IA");
        int b = in.nextInt();
        if(b!=0 && b!=1)
            out.println("You have to enter a 0 or a 1");
        else{
            game.setRole(1==b);
            out.println("Role setted");
        }
    }

    private static void DriversetDifficulty(){
        game.setDifficulty();
        out.println("Difficulty setted");
    }

    private static void DriverSetGameName(){
        out.println("Enter the name of the game");
        String nameG = in.next();
        game.setGameName(nameG);
        out.println("The name of the game has been setted");
    }

    private static void DriversetCurrentUser(){
        out.println("Enter the name of the user");
        String nameU = in.next();
        out.println("Enter the password of the user");
        String pasU = in.next();
        User u = new User(nameU, pasU);
        game.setCurrentUser(u);
        out.println("User setted");
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
        boolean b = game.setGuessTokensRound(a);
        if(b)
            out.println("Guess tokens of the next round setted correctly");
        else
            out.println("There has been an error setting the guess tokens of the next round");
    }
    private static void DrivergetRole(){
        boolean b = game.getRole();
        if(b)
            out.println("The IA is the code breaker");
        else
            out.println("The IA is the code maker");
    }

    private static void DrivergetFinished(){
        boolean b = game.getFinished();
        if (b)
            out.println("The game is finished");
        else
            out.println("The game is not finished");
    }

    private static void DrivergetWin(){
        boolean b = game.getWin();
        if(b)
            out.println("The game has been won");
        else
            out.println("The game has been lost");
    }

    private static void DrivergetScore(){
        int s = game.getScore();
        out.println("The score of the game is " + Integer.toString(s));
    }

    private static void DrivergetDifficulty(){
        int d = game.getDifficulty();
        out.println("The difficulty of the game is " + Integer.toString(d));
    }

    private static void DrivergetGameName(){
        String s = game.getGameName();
        out.println("The name of the game is "+s);
    }

    private static void DrivergetCurrentUser(){
        out.println("The name of the user is "+ game.getCurrentUser().getName());
    }

    private static void DrivergetRound(){
        out.println("Enter the number of the round that you want to view");
        int n = in.nextInt();
        Round r = game.getRound(n);
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
        Round r = game.getCurrentRound();
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
        out.println("Enter the number of different colors");
        int nc = in.nextInt();
        out.println("Enter the number of positions");
        int np = in.nextInt();
        out.println("Enter the maximum number of rounds");
        int nr = in.nextInt();
        out.println("Enter the maximum number of hints");
        int nh = in.nextInt();
        game.initGame(nc,np, nr, nh);
        out.println("The game has been initialized");
    }

    private static void DriveruseHint(){
        out.println(game.useHint());
    }

    private static void DriverplayRound(){
        boolean b = game.playRound();
        if(b)
            out.println("The round has been played and it is the final round");
        else
            out.println("The round has been played and it is not the final round");
    }

    private static void DriverloadGame(){
        boolean b = game.loadGame();
        if(b)
            out.println("Game loaded");
        else
            out.println("There has been an error in the loading");
    }

    private static void DriversaveGame(){
        boolean b = game.saveGame();
        if(b)
            out.println("Game saved");
        else
            out.println("There has been an error in the saving");
    }

    private static void DriverrestartGame(){
        boolean b = game.restartGame();
        if(b)
            out.println("Game restarted");
        else
            out.println("There has been an error in the restarting");
    }

    private static void DriverendGame(){
        game.endGame();
        out.println("The game has been ended");
    }

    public static void main(String[] args) {
        boolean keepAsking = true;

        while (keepAsking) {
            out.println();
            out.println("What do you wanna do?");
            out.println("1: Create new Game with default constructor");
            out.println("2: Create new Game with custom parameters");
            out.println("3: Set the role");
            out.println("4: Set the difficulty");
            out.println("5: Set the name of the game");
            out.println("6: Set the current user");
            out.println("7: Set the guess tokens of a round");
            out.println("8: Get the role of the IA");
            out.println("9: Get if the game is finished");
            out.println("10: Get if the game is won");
            out.println("11: Get the score of the game");
            out.println("12: Get the difficulty of the game");
            out.println("13: Get the name of the game");
            out.println("14: Get the current user");
            out.println("15: Get a round");
            out.println("16: Get the current round");
            out.println("17: Initialize a game");
            out.println("18: Use a hint");
            out.println("19: Play a round");
            out.println("20: Load a game");
            out.println("21: Save the game");
            out.println("22: Restart the game");
            out.println("23: End the game");
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
                        DriversetRole();
                        break;
                    case 4:
                        DriversetDifficulty();
                        break;
                    case 5:
                        DriverSetGameName();
                        break;
                    case 6:
                        DriversetCurrentUser();
                        break;
                    case 7:
                        DriversetGuessTokensRound();
                        break;
                    case 8:
                        DriversetRole();
                        break;
                    case 9:
                        DrivergetFinished();
                        break;
                    case 10:
                        DrivergetWin();
                        break;
                    case 11:
                        DrivergetScore();
                        break;
                    case 12:
                        DrivergetDifficulty();
                        break;
                    case 13:
                        DrivergetGameName();
                        break;
                    case 14:
                        DrivergetCurrentUser();
                        break;
                    case 15:
                        DrivergetRound();
                        break;
                    case 16:
                        DrivergetCurrentRound();
                        break;
                    case 17:
                        DriverinitGame();
                        break;
                    case 18:
                        DriveruseHint();
                        break;
                    case 19:
                        DriverplayRound();
                        break;
                    case 20:
                        DriverloadGame();
                        break;
                    case 21:
                        DriversaveGame();
                        break;
                    case 22:
                        DriverrestartGame();
                        break;
                    case 23:
                        DriverendGame();
                        break;
                }
            }
            else{
                keepAsking = false;
            }
        }
    }
}

