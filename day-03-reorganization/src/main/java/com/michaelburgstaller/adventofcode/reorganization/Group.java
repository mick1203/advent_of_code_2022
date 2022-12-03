package com.michaelburgstaller.adventofcode.reorganization;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record Group(List<Rucksack> rucksacks) {

    public String commonItem() {
        Set<String> commonItems = new HashSet<>(rucksacks.get(0).allItems());

        for (Rucksack rucksack : rucksacks) {
            commonItems.retainAll(rucksack.allItems());
        }

        return commonItems.stream().findFirst().orElse(null);
    }

    public Integer priority() {
        return Prioritizer.findPriority(commonItem());
    }

    public static Group of(List<String> rawValues) {
        if (rawValues.size() != 3) {
            throw new IllegalStateException("Groups have to be made up of three members");
        }

        List<Rucksack> rucksacks = new ArrayList<>();
        for (String rawValue : rawValues) {
            rucksacks.add(Rucksack.of(rawValue));
        }

        return new Group(rucksacks);
    }

}
