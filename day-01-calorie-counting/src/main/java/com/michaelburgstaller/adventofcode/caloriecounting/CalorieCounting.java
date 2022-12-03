package com.michaelburgstaller.adventofcode.caloriecounting;

import com.michaelburgstaller.adventofcode.common.Exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class CalorieCounting extends Exercise {

    public static Integer findCaloriesOfTopNElves(List<Elf> allElves, Integer n) {
        return allElves.stream().map(Elf::totalCalories).sorted(Comparator.reverseOrder()).limit(n).reduce(0,
                Integer::sum);
    }

    public static void findElfWithMostCalories(List<Elf> allElves) {
        List<Elf> elves = new ArrayList<>(allElves);

        Integer caloriesOfTopElf = findCaloriesOfTopNElves(allElves, 1);

        System.out.println(String.format("The elf with the most calories carried '%d' calories", caloriesOfTopElf));
    }

    public static void findTop3ElvesWithMostCalories(List<Elf> allElves) {
        List<Elf> elves = new ArrayList<>(allElves);

        Integer caloriesOfTopElf = findCaloriesOfTopNElves(allElves, 3);

        System.out.println(String.format("The top three elves with the most calories carried '%d' calories", caloriesOfTopElf));
    }

    public static void main(String[] args) {
        Stream<List<String>> input = getBufferedLineStream();
        List<Elf> elves = input.map(Elf::of).toList();

        findElfWithMostCalories(elves);
        findTop3ElvesWithMostCalories(elves);
    }
}
