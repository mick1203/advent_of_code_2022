package com.michaelburgstaller.adventofcode.reorganization;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record Compartment(List<String> items) {

    public Set<String> uniqueItems() {
        return new HashSet<>(items);
    }

    public static Compartment of(String rawValue) {
        String[] tokens = rawValue.split("");
        return new Compartment(Arrays.stream(tokens).toList());
    }
}
