package com.divya.diceroller;

public class Dice {
    public int roll(int numSides) {
        return (int) (Math.random() * numSides + 1);
    }
}