package com.kata.bowlinggame;

import junit.framework.TestCase;

public class BowlingGameTest extends TestCase {
    private BowlingGame bowlingGame;

    protected void setUp() throws Exception {
        bowlingGame = new BowlingGame();
    }

    public void testRollGutterBallGame() throws Exception {
        rollMany(20, 0);
        assertEquals(0, bowlingGame.score());
    }

    public void testRoll1Pin() throws Exception {
        rollMany(20, 1);
        assertEquals(20, bowlingGame.score());
    }

    public void testRollsWithSpare() throws Exception {
        rollSpare();
        bowlingGame.roll(3);
        rollMany(17, 0);
        assertEquals(16, bowlingGame.score());
    }

    public void testRollsWithStrike() throws Exception {
        rollStrike();
        bowlingGame.roll(3);
        bowlingGame.roll(4);
        rollMany(16, 0);
        assertEquals(24, bowlingGame.score());
    }

    public void testRollPerfectGame() throws Exception {
        rollMany(12, 10);
        assertEquals(300, bowlingGame.score());
    }

    private void rollMany(int rolls, int pins) {
        for (int i = 0; i < rolls; i++)
            bowlingGame.roll(pins);
    }

    private void rollSpare() {
        bowlingGame.roll(5);
        bowlingGame.roll(5);
    }

    private void rollStrike() {
        bowlingGame.roll(10);
    }

}

