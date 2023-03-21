package com.efimchick.ifmo;


import com.efimchick.ifmo.util.CourseResult;
import com.efimchick.ifmo.util.MyContainer;
import com.efimchick.ifmo.util.Person;


import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Collecting {

    public int sum(IntStream intStream) {
        return intStream.sum();
    }

    public int production(IntStream intStream) {
        return intStream.reduce(1, (a, b) -> a * b);
    }

    public int oddSum(IntStream intStream) {
        return intStream.filter(val -> val % 2 != 0)
                .sum();
    }

    public Map<Integer, Integer> sumByRemainder(int divider, IntStream intStream) {
        return intStream.boxed().collect(Collectors.groupingBy(val -> val % divider, Collectors.summingInt(Integer::intValue)));
    }

    public Map<Person, Double> totalScores(Stream<CourseResult> results) {
        return getPersonMap(results)
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        val -> val.getValue()
                                .values()
                                .stream()
                                .mapToInt(Integer::intValue).average().orElse(0.0)));
    }

    public double averageTotalScore(Stream<CourseResult> results) {
        return getPersonMap(results)
                .values()
                .stream()
                .flatMap(val -> val.values().stream())
                .mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public Map<String, Double> averageScoresPerTask(Stream<CourseResult> results) {
        return getPersonMap(results)
                .values()
                .stream()
                .flatMap(entry -> entry.entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.averagingInt(Map.Entry::getValue)));
    }

    public Map<Person, String> defineMarks(Stream<CourseResult> results) {
        return getPersonMap(results).entrySet()
                .stream().collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> {
                            double val = entry
                                    .getValue()
                                    .values()
                                    .stream()
                                    .mapToInt(Integer::intValue).average().orElse(0.0);
                            return getLetter(val);
                        }));
    }

    public String easiestTask(Stream<CourseResult> results) {
        Map<String, Double> averageScoresPerTask = averageScoresPerTask(results);
        Optional<Map.Entry<String, Double>> max = averageScoresPerTask.entrySet().stream().max(Map.Entry.comparingByValue());
        return max.map(Map.Entry::getKey).orElse(null);
    }

    public Collector<CourseResult, ?, String> printableStringCollector() {
        return Collector.of(
                MyContainer::new,
                MyContainer::add,
                MyContainer::merge,
                MyContainer::print
        );
    }

    private static Map<Person, Map<String, Integer>> getPersonMap(Stream<CourseResult> results) {
        Map<Person, Map<String, Integer>> map = results.collect(Collectors.toMap(CourseResult::getPerson, CourseResult::getTaskResults));

        Set<String> courses = map.values().stream()
                .flatMap(k -> k.keySet().stream())
                .collect(Collectors.toSet());

        return map.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> {
                    Map<String, Integer> res = entry.getValue();
                    for (String s : courses) {
                        res.computeIfAbsent(s, k -> 0);
                    }
                    return res;
                }));
    }
    public static String getLetter(double value) {
        if (value > 90) {
            return "A";
        }
        if (value >= 83) {
            return "B";
        }
        if (value >= 75) {
            return "C";
        }
        if (value >= 68) {
            return "D";
        }
        if (value >= 60) {
            return "E";
        }
        return "F";
    }
}