package com.michaelburgstaller.adventofcode.rockpaperscissors;

public record SelectionGame(Move opponent, Move player) {

    public int score() {
        int shapeScore = player.ordinal() + 1;
        int gameScore = opponentWon() ? 0 : nobodyWon() ? 3 : 6;
        return shapeScore + gameScore;
    }

    public boolean nobodyWon() {
        return opponent == player;
    }

    public boolean playerWon() {
        return opponent == Move.ROCK && player == Move.PAPER
                || opponent == Move.PAPER && player == Move.SCISSORS
                || opponent == Move.SCISSORS && player == Move.ROCK;
    }

    public boolean opponentWon() {
        return !playerWon() && !nobodyWon();
    }

    public static SelectionGame of(String rawValue) {
        String[] tokens = rawValue.split(" ");
        Move opponent = Move.of(tokens[0]);
        Move player = Move.of(tokens[1]);
        return new SelectionGame(opponent, player);
    }
}
