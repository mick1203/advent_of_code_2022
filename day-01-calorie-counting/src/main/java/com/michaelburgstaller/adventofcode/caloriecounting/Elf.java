package com.michaelburgstaller.adventofcode.caloriecounting;

import java.util.List;

public record Elf(List<String> packets) {

    public Integer totalCalories() {
        return packets.stream().map(Integer::parseInt).reduce(0, Integer::sum);
    }

    public static Elf of(List<String> raw) {
        return new Elf(raw);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Elf { ");
        builder.append(String.join(" ", packets));
        builder.append(" }");

        return builder.toString();
    }
}
