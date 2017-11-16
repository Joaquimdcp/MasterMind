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
        tablero.setDifficulty(diff);
        tablero.setSolution(solution);
        System.out.println("The hint is " + tablero.newHint());
    }

    private static void testPlayRound() {

    }

    private static void testHasPlayerWon() {
        Board tablero = new Board();
        tablero.setVictory(victory);
        if (tablero.hasPlayerWon()) {
            System.out.println("THe ");
        }
    }

    private static void testSetNHints(int nHints) {
        Board tablero = new Board();
        tablero.setNHints(nHints);
        System.out.println("The number of hints has been set");
    }

    private static void testGetRound() {

    }

    private static void testGetCurrentRound() {

    }

    private static void testGetDifficulty() {

    }

    private static void testLoadGame() {

    }

    private static void testSaveGame() {

    }

    private static void testRestartGame() {

    }

    private static void testEndGame() {

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
    }
}