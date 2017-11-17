import java.util.ArrayList;

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
        tester.setCurrentRound(0);
        Round r = new Round();
        tester.setRound(r);
        assertNotNull(tester.newHint());
    }

    @org.junit.jupiter.api.Test
    void playRound() {
        Board tester = new Board();
        tester.initDifficulty(1,1);
        tester.initGame();
        assertTrue(tester.playRound());
        //assertFalse(tester.playRound());


    }

    @org.junit.jupiter.api.Test
    void setVictory() {
        Board tester = new Board();
        tester.setVictory(true);
    }

    @org.junit.jupiter.api.Test
    void hasPlayerWon() {
        Board tester = new Board();
        tester.setVictory(true);
        assertTrue(tester.hasPlayerWon());
        tester.setVictory(false);
        assertFalse(tester.hasPlayerWon());
    }



    @org.junit.jupiter.api.Test
    void setNHints() {
        Board tester = new Board();
        tester.setNHints(4);
        tester.setNHints(0);
    }

    @org.junit.jupiter.api.Test
    void setDifficulty() {
        Difficulty diff = new Difficulty();
        Board tester = new Board();
        tester.setDifficulty(diff);

    }

    @org.junit.jupiter.api.Test
    void setSolution() {
        ArrayList<GuessToken> sol = new ArrayList<>();
        sol.add(new GuessToken(0));
        sol.add(new GuessToken(1));
        sol.add(new GuessToken(1));
        sol.add(new GuessToken(0));

        Board tester = new Board();
        tester.setSolution(sol);
    }

    @org.junit.jupiter.api.Test
    void setRound() {
        Board tester = new Board();
        Round r = new Round();
        tester.setRound(r);
    }

    @org.junit.jupiter.api.Test
    void setCurrentRound() {
        Board tester = new Board();
        tester.setCurrentRound(1);
    }

    @org.junit.jupiter.api.Test
    void setTime() {
        Timing t = new Timing();
        Board tester = new Board();
        tester.setTime(t);

    }

    @org.junit.jupiter.api.Test
    void getRound() {
        Board tester = new Board();
        Round r = new Round();
        tester.setRound(r);
        assertEquals(r,tester.getRound(0));

    }

    @org.junit.jupiter.api.Test
    void getCurrentRound() {
        Board tester = new Board();
        tester.setCurrentRound(0);
        Round r = new Round();
        tester.setRound(r);
        assertEquals(r,tester.getCurrentRound());
    }

    @org.junit.jupiter.api.Test
    void getDifficulty() {
        Difficulty diff = new Difficulty();
        Board tester = new Board();
        tester.setDifficulty(diff);
        assertEquals(diff,tester.getDifficulty());
    }

    @org.junit.jupiter.api.Test
    void getScore() {
        Difficulty diff = new Difficulty();
        Board tester = new Board();
        Timing t = new Timing();
        tester.setDifficulty(diff);
        tester.setTime(t);

        assertEquals(diff.difficulty()/t.set_saved_time(),tester.getScore());
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
        Board tester = new Board();
        tester.initGame();
        tester.endGame();
    }


}