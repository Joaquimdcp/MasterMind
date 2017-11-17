import java.util.Scanner;

public class BoardDriver {
    private static void testConstructor(int hintsUsed, int currentRound) {
        System.out.println("Creating default instance");
        Board defaultBoard = new Board();
        System.out.println("Default instance created");
        System.out.println("Creating basic instance");
        Board basicBoard = new Board(hintsUsed, currentRound);
        System.out.println("Basic instance created");
    }

    private static void testInitDifficulty(int nColors, int nPositions, int nRounds, int nHints) {
        Board tablero = new Board();
        tablero.initDifficulty(nColors, nPositions, nRounds, nHints);
        System.out.println("The difficulty has been set");
    }

    private static void testInitGame(boolean breakerIA) {
        Board tablero = new Board();
        tablero.initGame(breakerIA);
        System.out.println("The board has been initialized");
    }

    private static void testUseHint(int nHints, int hintsUsed, int currentRound) {
        Board tablero = new Board(hintsUsed, currentRound);
        tablero.setNHints(nHints);
        if (tablero.useHint()) {
            System.out.println("You were able to use a hint");
        } else {
            System.out.println("You can't use any more hints");
        }
    }

    private static void testNewHint() {
        Board tablero = new Board();
        Difficulty diff = new Difficulty();
        CodeMaker cm = new CodeMaker(true);
        tablero.setDifficulty(diff);
        tablero.setSolution(cm.make_code());
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
        } else  {
            System.out.println("The player did not win");
        }
    }

    private static void testSetVictory(boolean victory) {
        Board tablero = new Board();
        tablero.setVictory(victory);
        if (tablero.hasPlayerWon()) {
            System.out.println("The player has won");
        } else {
            System.out.println("The player didn't win");
        }
    }

    private static void testSetNHints(int nHints) {
        Board tablero = new Board();
        tablero.setNHints(nHints);
        System.out.println("The number of hints has been set");
    }

    private static void testSetDifficulty(Difficulty diff) {
        Board tablero = new Board();
        tablero.setDifficulty(diff);
        System.out.println("The difficulty has been set");
    }

    private static void testSetRound(int index, Round round) {
        Board tablero = new Board();
        tablero.setRound(index, round);
        System.out.println("The round has been set");
    }

    private static void testGetRound(int round) {
        Board tablero = new Board();
        Round testRound = new Round();
        tablero.setRound(round, testRound);
        System.out.println("The round has been set");
        Round resultRound = tablero.getRound(round);
        System.out.println();
    }

    private static void testGetCurrentRound() {
        Board tablero = new Board();
        tablero.setCurrentRound(3);
        System.out.println("The current round is " + tablero.getCurrentRound());
    }

    private static void testGetDifficulty() {
        Board tablero = new Board();
        Difficulty diff = new Difficulty();
        tablero.setDifficulty(diff);
        Difficulty testDiff = tablero.getDifficulty();
        System.out.println("The difficulty evaluation is " + testDiff.difficulty());
    }

    private static void testGetScore(int score) {
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
    }
}