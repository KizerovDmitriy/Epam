package com.epam.rd.autotasks;


import java.util.*;

public class Words {

    public String countWords(List<String> lines) {
        Map<String, Integer> data = new HashMap<>();
        for (String line : lines) {
            String[] tmp = line.toLowerCase().split("[\\p{P}\\p{S}\\s]+");
            for (String worlds : tmp) {
                if (data.containsKey(worlds)) {
                    int result = data.get(worlds);
                    data.put(worlds, ++result);
                } else if (worlds.length() >= 4) {
                    data.put(worlds, 1);
                }
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(data.entrySet());
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (Objects.equals(o2.getValue(), o1.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                } else return o2.getValue().compareTo(o1.getValue());
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : list) {
            if (entry.getValue() >= 10) {
                sb.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");
            }
        }
        return sb.toString().trim();
    }
}