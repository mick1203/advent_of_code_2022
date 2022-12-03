package com.michaelburgstaller.adventofcode.reorganization;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record Rucksack(List<Compartment> compartments) {

    public Set<String> allItems() {
        Set<String> allItems = new HashSet<>();

        for (Compartment compartment : compartments) {
            allItems.addAll(compartment.uniqueItems());
        }

        return allItems;
    }

    public String wrongItem() {
        Set<String> firstCompartmentItems = compartments.get(0).uniqueItems();
        Set<String> secondCompartmentItems = compartments.get(1).uniqueItems();

        Set<String> commonItems = new HashSet<>(firstCompartmentItems);
        commonItems.retainAll(secondCompartmentItems);

        if (commonItems.size() != 1) {
            throw new IllegalStateException(String.format("There was more than one common item! '%s'", commonItems));
        }

        return commonItems.stream().findFirst().orElse(null);
    }

    public Integer priority() {
        return Prioritizer.findPriority(wrongItem());
    }

    public static Rucksack of(String rawValue) {
        Compartment firstCompartment = Compartment.of(rawValue.substring(0, rawValue.length() / 2));
        Compartment secondCompartment = Compartment.of(rawValue.substring(rawValue.length() / 2));
        return new Rucksack(List.of(firstCompartment, secondCompartment));
    }

}