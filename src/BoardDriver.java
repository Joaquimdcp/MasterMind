import java.util.Scanner;

public class BoardDriver {
    private static void testConstructor() {
        System.out.println("Creating default instance");
        Board defaultBoard = new Board();
        System.out.println("Default instance created");
        System.out.println("Creating basic instance");
        Board basicBoard = new Board(3, 2);
        System.out.println("Basic instance created");
    }

    private static void testInitDifficulty() {
        Board tablero = new Board();
        tablero.initDifficulty(4, 6, 10, 5);
        System.out.println("The difficulty has been set");
    }

    private static void testInitGame() {
        Board tablero = new Board();
        tablero.initGame(true);
        System.out.println("The board has been initialized");
    }

    private static void testUseHint(int nHints, int hintsUsed) {
        Board tablero = new Board(hintsUsed, 1);
        tablero.setNHints(nHints);
        if (tablero.useHint()) {
            System.out.println("You were able to use a hint");
        } else {
            System.out.println("You can't use any more hints");
        }
    }

    private static void testNewHint() {
        Board tablero = new Board();
        Round r = new Round(1);
        Difficulty diff = new Difficulty();
        CodeMaker cm = new CodeMaker(true);
        tablero.setDifficulty(diff);
        tablero.setSolution(cm.make_code());
        r.setGuess(cm.make_code(), 4, 6);
        tablero.setCurrentRound(1);
        tablero.setRound(1, r);
        System.out.println("The hint is " + tablero.newHint());
    }

    private static void testPlayRound() {
        Board tablero = new Board();
        Difficulty diff = new Difficulty();
        CodeMaker cm = new CodeMaker(true);
        tablero.setDifficulty(diff);
        tablero.setCurrentRound(1);
        tablero.setSolution(cm.make_code());
        if (tablero.playRound()) {
            System.out.println("The round was played normally and the game continues");
        } else {
            System.out.println("The round ended the game");
        }
    }

    private static void testHasPlayerWon(boolean victory) {
        Board tablero = new Board();
        tablero.setVictory(victory);
        if (tablero.hasPlayerWon()) {
            System.out.println("The player won");
        } else {
            System.out.println("The player did not win");
        }
    }

    private static void testSetNHints(int nHints) {
        Board tablero = new Board();
        tablero.setNHints(nHints);
        System.out.println("The number of hints has been set to " + nHints);
    }

    private static void testSetDifficulty() {
        Board tablero = new Board();
        Difficulty diff = new Difficulty();
        tablero.setDifficulty(diff);
        System.out.println("The difficulty has been set");
    }

    private static void testSetSolution() {
        Board tablero = new Board();
        CodeMaker cm = new CodeMaker(true);
        tablero.setSolution(cm.make_code());
        System.out.println("The solution has been set");
    }

    private static void testSetRound(int index) {
        Board tablero = new Board();
        Round round = new Round();
        tablero.setRound(index, round);
        System.out.println("The round has been set");
    }

    private static void testSetCurrentRound(int index) {
        Board tablero = new Board();
        tablero.setCurrentRound(index);
        System.out.println("The current round has been set");
    }

    private static void testSetTime() {
        Board tablero = new Board();
        Timing time = new Timing();
        tablero.setTime(time);
        System.out.println("The time has been set");
    }

    private static void testGetRound(int round) {
        Board tablero = new Board();
        Round testRound = new Round(round);
        tablero.setRound(round, testRound);
        Round resultRound = tablero.getRound(round);
        System.out.println("You got the round " + resultRound.getnRound());
    }

    private static void testGetCurrentRound() {
        Board tablero = new Board();
        tablero.setCurrentRound(1);
        Round testRound = new Round(1);
        tablero.setRound(1, testRound);
        System.out.println("The current round is " + tablero.getCurrentRound().getnRound());
    }

    private static void testGetDifficulty() {
        Board tablero = new Board();
        Difficulty diff = new Difficulty();
        tablero.setDifficulty(diff);
        Difficulty testDiff = tablero.getDifficulty();
        System.out.println("The difficulty evaluation is " + testDiff.difficulty());
    }

    private static void testGetScore() {
        Board tablero = new Board();
        Difficulty diff = new Difficulty();
        tablero.setDifficulty(diff);
        Timing time = new Timing();
        tablero.setTime(time);
        System.out.println("The score is " + tablero.getScore());
    }

    private static void testLoadGame() {
        Board tablero = new Board();
        if (tablero.loadGame()) {
            System.out.println("Game loaded");
        } else {
            System.out.println("The game wasn't loaded");
        }
    }

    private static void testSaveGame() {
        Board tablero = new Board();
        if (tablero.saveGame()) {
            System.out.println("Game saved");
        } else {
            System.out.println("The game wasn't saved");
        }
    }

    private static void testRestartGame() {
        Board tablero = new Board();
        if (tablero.restartGame()) {
            System.out.println("Game restarted");
        } else {
            System.out.println("The game wasn't restarted");
        }
    }

    private static void testEndGame() {
        Board tablero = new Board();
        Timing time = new Timing();
        tablero.setTime(time);
        System.out.println("Game ended at time " + tablero.endGame());
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String choice;
        boolean quit = false;
        String exitChoice = "";

        System.out.println("Welcome to the Board class");
        while (!quit) {
            System.out.println("C: Constructor method");
            System.out.println("I: initDifficulty method");
            System.out.println("G: initGame method");
            System.out.println("H: useHint method");
            System.out.println("N: newHint method");
            System.out.println("P: playRound method");
            System.out.println("W: setVictory and hasPlayerWon method");
            System.out.println("SN: setNHints method");
            System.out.println("SD: setDifficulty method");
            System.out.println("SS: setSolution method");
            System.out.println("SR: setRound method");
            System.out.println("SC: setCurrentRound method");
            System.out.println("ST: setTime method");
            System.out.println("GR: getRound method");
            System.out.println("GC: getCurrentRound method");
            System.out.println("GD: getDifficulty method");
            System.out.println("GS: getScore method");
            System.out.println("L: loadGame method");
            System.out.println("S: saveGame method");
            System.out.println("R: restartGame method");
            System.out.println("E: endGame method");
            System.out.println("Press any other key to exit");
            choice = s.nextLine();
            switch (choice) {
                case "C":
                    testConstructor();
                    break;
                case "I":
                    testInitDifficulty();
                    break;
                case "G":
                    testInitGame();
                    break;
                case "H":
                    System.out.println("Please enter the number of hints total");
                    int nHints = s.nextInt();
                    System.out.println("Please enter the number of hints used");
                    int hintsUsed = s.nextInt();
                    testUseHint(nHints, hintsUsed);
                    break;
                case "N":
                    testNewHint();
                    break;
                case "P":
                    testPlayRound();
                    break;
                case "W":
                    System.out.println("Do you want the player to win? (Y/N)");
                    String victory = s.nextLine();
                    if (victory.equals("Y")) {
                        testHasPlayerWon(true);
                    } else if (victory.equals("N")) {
                        testHasPlayerWon(false);
                    }
                    break;
                case "SN":
                    System.out.println("Please enter the number of hints to set");
                    int n = s.nextInt();
                    testSetNHints(n);
                    break;
                case "SD":
                    testSetDifficulty();
                    break;
                case "SS":
                    testSetSolution();
                    break;
                case "SR":
                    System.out.println("Please enter the round number to set");
                    int index = s.nextInt();
                    testSetRound(index);
                    break;
                case "SC":
                    System.out.println("Please enter the round number to set to be current");
                    int c = s.nextInt();
                    testSetCurrentRound(c);
                    break;
                case "ST":
                    testSetTime();
                    break;
                case "GR":
                    System.out.println("Please enter the round you want to get");
                    int round = s.nextInt();
                    testGetRound(round);
                    break;
                case "GC":
                    testGetCurrentRound();
                    break;
                case "GD":
                    testGetDifficulty();
                    break;
                case "GS":
                    testGetScore();
                    break;
                case "L":
                    testLoadGame();
                    break;
                case "S":
                    testSaveGame();
                    break;
                case "R":
                    testRestartGame();
                    break;
                case "E":
                    testEndGame();
                    break;
                default:
                    quit = true;
                    break;
            }
            System.out.println("'X' to exit, press any other key to continue testing");
            exitChoice = s.nextLine();
            if (exitChoice.equals("X")) {
                quit = true;
            }
        }
    }
}