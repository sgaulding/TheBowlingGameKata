package com.kata.bowlinggame;

public class BowlingGame {
    private static final int MaxRollsPerGame = 21;
    private static final int MaxPinsPerFrame = 10;
    private static final int FramesPerGame = 10;

    private int rolls[] = new int[MaxRollsPerGame];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        int index = 0;
        for (int frame = 0; frame < FramesPerGame; frame++) {
            if (isStrike(index)) {
                score += MaxPinsPerFrame + strikeBonus(index);
                index++;
            } else if (isSpare(index)) {
                score += MaxPinsPerFrame + spareBonus(index);
                index += 2;
            } else {
                score += sumBallsInFrame(index);
                index += 2;
            }
        }

        return score;
    }

    private int sumBallsInFrame(int index) {
        return rolls[index] + rolls[index + 1];
    }

    private int spareBonus(int index) {
        return rolls[index + 2];
    }

    private int strikeBonus(int index) {
        return rolls[index + 1] + rolls[index + 2];
    }

    private boolean isStrike(int index) {
        return rolls[index] == 10;
    }

    private boolean isSpare(int index) {
        return rolls[index] + rolls[index + 1] == 10;
    }
}
