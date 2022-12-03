package com.michaelburgstaller.adventofcode.rockpaperscissors;

public enum Move {
    ROCK,
    PAPER,
    SCISSORS;

    public static Move of(String rawValue) {
        return switch (rawValue) {
            case "A", "X" -> ROCK;
            case "B", "Y" -> PAPER;
            case "C", "Z" -> SCISSORS;
            default -> throw new IllegalStateException(String.format("Unknown move value '%s'", rawValue));
        };
    }
}
