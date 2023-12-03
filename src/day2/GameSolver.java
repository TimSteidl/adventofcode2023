package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class GameSolver {

    public static final int RED = 12;
    public static final int GREEN = 13;
    public static final int BLUE = 14;

    public void solve() {
        List<String> lines = readLines();
        int total = 0;
        for (String line : lines) {
            total += handleLine(line);
        }
        System.out.println("Result: " + total);
    }

    private List<String> readLines() {
        List<String> result = new ArrayList<>();
        Path path = Path.of("src/day2/games.txt");
        try (BufferedReader br = Files.newBufferedReader(path)) {
            result.addAll(br.lines().toList());
        } catch (IOException ioe) {
            System.out.println("Error reading file");
        }
        return result;
    }

    private int handleLine(String line) {
        String[] split = line.replace("Game", "").split(":");
        int id = Integer.parseInt(split[0].strip());
        String[] games = split[1].split(";");
        boolean valid = true;
        for (String game : games) {
            System.out.println(game);
            String[] draw = game.split(",");
            for (String entry : draw) {
                String[] drawn = entry.stripLeading().split(" ");
                if (!checkValidity(drawn[1], drawn[0])) {
                    valid = false;
                }
            }
        }
        if (valid) {
            System.out.println(id);
            return id;
        } else {
            return 0;
        }
    }

    @Deprecated
    public boolean checkValidity(String color, String amount) {
        System.out.println("Color: " + color + " Amount: " + amount);
        int size = Integer.parseInt(amount);
        switch (color) {
            case "red" -> {
                if (size > 12) {
                    return false;
                }
            }
            case "green" -> {
                if (size > 13) {
                    return false;
                }
            }
            case "blue" -> {
                if (size > 14) {
                    return false;
                }
            }
            default -> {
                throw new RuntimeException();
            }
        }
        return true;
    }
}
