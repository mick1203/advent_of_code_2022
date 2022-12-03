package com.michaelburgstaller.adventofcode.rockpaperscissors;

import com.michaelburgstaller.adventofcode.common.Exercise;

import java.util.List;
import java.util.stream.Stream;

public class RockPaperScissors extends Exercise {

    public static void findScoreWhenMovesHaveBeenSelected(List<String> games) {
        Stream<SelectionGame> selectionGames = games.stream().map(SelectionGame::of);

        Integer totalScore = selectionGames.map(SelectionGame::score).reduce(0, Integer::sum);

        System.out.println(String.format("When the moves have been selected, a score of '%d' can be achieved!", totalScore));
    }

    public static void findScoreWhenResultHasBeenSelected(List<String> games) {
        Stream<ExpectationGame> expectationGames = games.stream().map(ExpectationGame::of);

        Integer totalScore = expectationGames.map(ExpectationGame::score).reduce(0, Integer::sum);

        System.out.println(String.format("When the results have been selected, a score of '%d' can be achieved!", totalScore));
    }

    public static void main(String[] args) {
        List<String> games = getLineStream().toList();

        findScoreWhenMovesHaveBeenSelected(games);
        findScoreWhenResultHasBeenSelected(games);
    }
}
