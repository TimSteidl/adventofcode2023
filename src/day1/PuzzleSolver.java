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
            for (String line : stringList) {
                int returnedValue = parseStringToValue(line);
                System.out.println(returnedValue);
                total += returnedValue;
            }
        } catch (IOException ioe) {
            System.out.println("Error reading file.");
        }
        return total;
    }

    private int parseStringToValue(String line) {
        TreeMap<Integer, String> map = new TreeMap<>();
        String[] split = line.split("");
        List<String> keys;
        for (int i = 0; i < split.length; i++) {
            if (split[i].matches("[\\d]")) {
                map.put(i, split[i]);
            } else {
                keys = checkStartingCharacter(split[i]);
                for (String key : keys) {
                    String returnedValue = checkNextCharacterEquals(key, split, i + 1);
                    if (!returnedValue.isEmpty()) {
                        map.put(i, returnedValue);
                    }
                }
            }
        }
        System.out.println(line);
        for (Map.Entry<Integer, String> entries : map.entrySet()) {
            System.out.println("Value: " + entries.getValue() + " Key: " + entries.getKey());
        }
        return Integer.parseInt(map.firstEntry().getValue() + map.lastEntry().getValue());
    }

    private List<String> checkStartingCharacter(String character) {
        List<String> toReturn = new ArrayList<>();
        for (Map.Entry<String, Integer> numbers : this.realNumbers.entrySet()) {
            if (numbers.getKey().startsWith(character)) {
                toReturn.add(numbers.getKey());
            }
        }
        return toReturn;
    }

    private String checkNextCharacterEquals(String key, String[] split, int start) {
        int splitCount = 1;
        int trueCount = 0;
        String[] splitKey = key.split("");
        for (int i = start; i < split.length; i++) {
            if (i + 1 < split.length && splitCount < splitKey.length) {
                if (splitKey[splitCount].equals(split[i])) {
                    trueCount++;
                }
                splitCount++;
                if (trueCount == splitKey.length - 2) {
                    return String.valueOf(realNumbers.get(key));
                }
            }
        }
        return "";
    }
}












