package com.epam.rd.autotasks;


import java.util.*;
import java.util.stream.Collectors;

public class Words {

    public String countWords(List<String> lines) {

        Map<String, Integer> words = lines.stream()
                .map(line -> line.split("[\\p{P}\\p{S}\\s]+"))
                .flatMap(Arrays::stream)
                .filter(str -> str.length() >= 4)
                .collect(Collectors.toMap(String::toLowerCase, v -> 1, Integer::sum));

        HashMap<String, Integer> result = words.entrySet().stream()
                .filter(e -> e.getValue() >= 10)
                .sorted(Comparator.comparing(Map.Entry<String, Integer>::getValue)
                        .reversed()
                        .thenComparing(Map.Entry::getKey))
                .collect(Collectors
                        .toMap(Map.Entry::getKey, Map.Entry::getValue, (k, v) -> {
                            throw new IllegalStateException();
                        }, LinkedHashMap::new));

        StringBuilder sb = new StringBuilder();
        result.forEach((k, v) -> sb.append(k).append(" - ").append(v).append("\n"));
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}
