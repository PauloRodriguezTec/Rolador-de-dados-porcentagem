package main.Java.model;
import java.util.Random;

public class Dice {
    private int sides;
    private Random random;

    public Dice(int sides) {

        if (sides < 2) {
            throw new IllegalArgumentException("Dice must have at least 2 sides.");
        }
        this.sides = sides;
        this.random = new Random();
    }

    public int roll() {
        return random.nextInt(sides) + 1; // Returns a number between 1 and sides
    }

    public int getSides() {
        return sides;
    }

    @Override
    public String toString() {
        return "Dice{" +
                "sides=" + sides +
                '}';
    }
}