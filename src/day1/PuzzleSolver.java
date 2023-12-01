package day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PuzzleSolver {

    private final Map<String, Integer> realNumbers =
            Map.of("one", 1, "two", 2, "three", 3, "four", 4, "five", 5, "six", 6, "seven", 7, "eight", 8, "nine", 9);

    public int calculate() {
        Path path = Path.of("src/day1/puzzleInput.txt");
        int total = 0;
        try (BufferedReader br = Files.newBufferedReader(path)) {
            List<String> stringList = new ArrayList<>(br.lines().toList());
            String localTotal = "";
            List<String> newList = new ArrayList<>();

            for (String line : stringList) {
                total += getString(line.toLowerCase());
            }

        } catch (IOException ioe) {
            System.out.println("Error reading file.");
        }
        return total;
    }

    private int getString(String line) {
        System.out.println(line);
        TreeMap<Integer, String> sortedMap = new TreeMap<>();
        String[] split = line.split("");
        for (int i = 0; i < split.length; i++) {
            if (split[i].matches("[1-9]")) {
                System.out.println("start : " + i + " value: " + split[i]);
                sortedMap.put(i, split[i]);
            }
        }

        for (Map.Entry<String, Integer> number : realNumbers.entrySet()) {
            if (line.contains(number.getKey())) {
                int start = 0;
                StringBuilder match = new StringBuilder();
                for (int i = 0; i < split.length; i++) {
                    if (start == 0) {
                        start = i;
                    }
                    if (number.getKey().contains(split[i])) {
                        match.append(split[i]);
                        if (match.toString().equals(number.getKey())) {
                            System.out.println("start : " + start + " value: " + number.getKey());
                            match.setLength(0);
                            sortedMap.put(start, String.valueOf(number.getValue()));
                            start = 0;

                        }
                       

                    }
                    System.out.println(match);
                }
            }
        }
        System.out.println("First: " + sortedMap.firstEntry().getValue() + " Second: " + sortedMap.lastEntry().getValue());
        return Integer.parseInt(sortedMap.firstEntry().getValue() + sortedMap.lastEntry().getValue());
    }
}