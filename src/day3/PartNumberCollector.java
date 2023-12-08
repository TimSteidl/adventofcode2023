package day3;

import utils.Reader;

import java.util.*;

public class PartNumberCollector {

    public Map<Integer, String> linesMap = new TreeMap<>();

    public void run() {
        List<String> lines = Reader.readFile("src/day3/engine_schematic.txt");
        this.linesMap = convertToMap(lines);
        int total = 0;
        List<Number> numbers = convertToList(this.linesMap.entrySet());
        for (int i = 0; i < numbers.size(); i++) {
            Number number = numbers.get(i);
            System.out.println(number.toString());
            total += getTotal(number, number.getCharacterPositions(), 1);
            if (i < numbers.size() - 1) {
                Number nextLine = numbers.get(i + 1);
                System.out.println(nextLine);
                total += getTotal(nextLine, number.getCharacterPositions(), 1);
            }
        }
        System.out.println("Result: " + total);
    }

    public Map<Integer, String> convertToMap(List<String> lines) {
        Map<Integer, String> mappedLines = new HashMap<>();
        for (int i = 0; i < lines.size(); i++) {
            mappedLines.put(i, lines.get(i));
        }
        return mappedLines;
    }

    public List<Number> convertToList(Set<Map.Entry<Integer, String>> lines) {
        List<Number> numberList = new ArrayList<>();
        for (Map.Entry<Integer, String> line : lines) {
            String[] split = line.getValue().split("");
            List<Integer> specialPositions = new ArrayList<>();
            for (int i = 0; i < split.length; i++) {
                if (split[i].matches("[+\\*#$&%;/@=]")) {
                    specialPositions.add(i + 1);
                }
            }
            numberList.add(new Number(line.getValue(), this.linesMap.get(line.getKey() + 1), line.getKey(), specialPositions));
        }
        return numberList;
    }

    private int getTotal(Number number, List<Integer> characterPositions, int offset) {
        int total = 0;
        List<Range> ranges = calcualteTotalForString(number.getLine().split(""));
        for (Range range : ranges) {
            for (Integer position : characterPositions) {
                if (isBetween(range, position, offset)) {
                    System.out.println("match at: " + range.getStart() + " " + range.getEnd() + " value: " + range.getContent() + " position: " + position);
                    total += position;
                    break;
                }
            }
        }
        return total;
    }

    public List<Range> calcualteTotalForString(String[] split) {
        int start = 0;
        StringBuilder content = new StringBuilder();
        List<Range> rangeList = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            if (start == 0) {
                start = i;
            }
            if (split[i].matches("[\\d]")) {
                content.append(split[i]);
            } else {
                if (!content.isEmpty()) {
                    rangeList.add(new Range(start, i, Integer.parseInt(content.toString())));
                    content.setLength(0);
                }
                start = 0;
            }
        }
        return rangeList;
    }

    private boolean isBetween(Range range, int position, int offset) {
        return position >= range.getStart() - offset && position <= range.getEnd() + offset;
    }
}
