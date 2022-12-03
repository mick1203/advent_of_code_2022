package com.michaelburgstaller.adventofcode.rockpaperscissors;

public enum Result {
    LOSE,
    DRAW,
    WIN;

    public static Result of(String rawValue) {
        return switch (rawValue) {
            case "X" -> LOSE;
            case "Y" -> DRAW;
            case "Z" -> WIN;
            default -> throw new IllegalStateException(String.format("Unknown result value '%s'", rawValue));
        };
    }
}
