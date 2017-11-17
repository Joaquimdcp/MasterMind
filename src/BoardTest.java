import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    @org.junit.jupiter.api.Test
    void initDifficulty() {
        Board tester = new Board();
        tester.initDifficulty(10, 0);
        tester.initDifficulty(-1, 0);
        tester.initDifficulty(0, 0);
        tester.initDifficulty(1, 1);
        tester.initDifficulty(1, 0);
        tester.initDifficulty(1, -1);
    }

    @org.junit.jupiter.api.Test
    void initGame() {
        Board tester = new Board();
        tester.initGame();
    }

    @org.junit.jupiter.api.Test
    void useHint() {
        Board tester = new Board();
        tester.initDifficulty(1,1);
        assertEquals(true,tester.useHint());
        assertEquals(false,tester.useHint());
    }

    @org.junit.jupiter.api.Test
    void newHint() {
        Board tester = new Board();
        tester.initDifficulty(1,1);
        assertNotNull(tester.newHint());
    }

    @org.junit.jupiter.api.Test
    void playRound() {

    }

    @org.junit.jupiter.api.Test
    void hasPlayerWon() {
    }

    @org.junit.jupiter.api.Test
    void setVictory() {
    }

    @org.junit.jupiter.api.Test
    void setNHints() {
    }

    @org.junit.jupiter.api.Test
    void setDifficulty() {
    }

    @org.junit.jupiter.api.Test
    void setSolution() {
    }

    @org.junit.jupiter.api.Test
    void setRound() {
    }

    @org.junit.jupiter.api.Test
    void setCurrentRound() {
    }

    @org.junit.jupiter.api.Test
    void setTime() {
    }

    @org.junit.jupiter.api.Test
    void getRound() {
    }

    @org.junit.jupiter.api.Test
    void getCurrentRound() {
    }

    @org.junit.jupiter.api.Test
    void getDifficulty() {
    }

    @org.junit.jupiter.api.Test
    void getScore() {
    }

    @org.junit.jupiter.api.Test
    void loadGame() {
    }

    @org.junit.jupiter.api.Test
    void saveGame() {
    }

    @org.junit.jupiter.api.Test
    void restartGame() {
    }

    @org.junit.jupiter.api.Test
    void endGame() {
    }

}