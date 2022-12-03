package com.michaelburgstaller.adventofcode.reorganization;

public class Prioritizer {

    public static Integer findPriority(String item) {
        Integer asciiCode = item.codePointAt(0);
        Integer priority = 0;

        if (asciiCode >= 65 && asciiCode < (65 + 26)) {
            priority = (asciiCode - 65) + 27;
        } else if (asciiCode >= 97 && asciiCode < (97 + 26)) {
            priority = (asciiCode - 97) + 1;
        }

        return priority;
    }

}
