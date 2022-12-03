package com.michaelburgstaller.adventofcode.rockpaperscissors;

public record ExpectationGame(Move opponent, Result result) {

    public int score() {
        Move playerMove = findPlayerMove(result);
        int shapeScore = playerMove.ordinal() + 1;
        int gameScore = result == Result.LOSE ? 0 : result == Result.DRAW ? 3 : 6;
        return shapeScore + gameScore;
    }

    public Move findPlayerMove(Result desiredResult) {
        switch (desiredResult) {
            case WIN -> {
                int winningMoveIndex = (opponent.ordinal() + 1) % 3;
                return Move.values()[winningMoveIndex];
            }
            case LOSE -> {
                int losingMoveIndex = (opponent.ordinal() + 2) % 3;
                return Move.values()[losingMoveIndex];
            }
            case DRAW -> {
                return opponent;
            }
            default -> throw new IllegalStateException(String.format("Unknown result value '%s'", result));
        }
    }

    public static ExpectationGame of(String rawValue) {
        String[] tokens = rawValue.split(" ");
        Move opponent = Move.of(tokens[0]);
        Result result = Result.of(tokens[1]);
        return new ExpectationGame(opponent, result);
    }
}
