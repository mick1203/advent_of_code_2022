package com.michaelburgstaller.adventofcode.reorganization;

import com.michaelburgstaller.adventofcode.common.Exercise;
import org.apache.commons.collections4.ListUtils;

import java.util.List;

public class Reorganization extends Exercise {

    public static void findPriorityOfCommonItemsInAllRucksacks(List<String> rawValues) {
        List<Rucksack> rucksacks = rawValues.stream().map(Rucksack::of).toList();

        Integer totalPriority = rucksacks.stream().peek(rucksack ->
                System.out.printf("'%s' -> '%s'\n", rucksack.wrongItem(), rucksack.priority())
        ).map(Rucksack::priority).reduce(0, Integer::sum);

        System.out.printf("The sum of priorities for all common items is '%s'\n", totalPriority);
    }

    public static void findPriorityOfCommonItemInAllGroups(List<String> rawValues) {
        List<Group> groups = ListUtils.partition(rawValues, 3).stream().map(Group::of).toList();

        Integer totalPriority = groups.stream().peek(group -> System.out.printf("'%s' -> '%s'\n",
                group.commonItem(), group.priority())).map(Group::priority).reduce(0, Integer::sum);

        System.out.printf("The sum of priorities for all common items in all groups is '%s'\n", totalPriority);
    }

    public static void main(String[] args) {
        List<String> rawValues = getLineStream().toList();

        findPriorityOfCommonItemsInAllRucksacks(rawValues);
        findPriorityOfCommonItemInAllGroups(rawValues);
    }
}
