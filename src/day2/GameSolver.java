package day2;

import utils.Reader;

import java.util.List;

public class GameSolver {

    public static final int RED = 12;
    public static final int GREEN = 13;
    public static final int BLUE = 14;

    public void solve() {
        List<String> lines = Reader.readFile("src/day2/games.txt");
        int total = 0;
        for (String line : lines) {
            total += handleLine(line);
        }
        System.out.println("Result: " + total);
    }


    private int handleLine(String line) {
        String[] split = line.replace("Game", "").split(":");
        String[] games = split[1].split(";");
        Game highestGame = new Game(0, 0, 0);
        for (String game : games) {
            String[] draw = game.split(",");
            for (String entry : draw) {
                String[] drawn = entry.stripLeading().split(" ");
                highestGame = compareGames(highestGame, calculateBalls(drawn[1], drawn[0]));
            }
        }
        int result = (highestGame.getRed() > 0 ? highestGame.getRed() : 1) *
                (highestGame.getGreen() > 0 ? highestGame.getGreen() : 1) *
                (highestGame.getBlue() > 0 ? highestGame.getBlue() : 1);
        System.out.println(highestGame);
        return result;
    }

    public Game compareGames(Game highest, Game toCompare) {
        highest.setRed(Math.max(highest.getRed(), toCompare.getRed()));
        highest.setGreen(Math.max(highest.getGreen(), toCompare.getGreen()));
        highest.setBlue(Math.max(highest.getBlue(), toCompare.getBlue()));
        return highest;
    }

    public Game calculateBalls(String color, String amount) {
        Game currentGame = new Game(0, 0, 0);
        int size = Integer.parseInt(amount);
        switch (color) {
            case "red" -> currentGame.setRed(size);
            case "green" -> currentGame.setGreen(size);
            case "blue" -> currentGame.setBlue(size);
            default -> throw new RuntimeException();
        }
        return currentGame;
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
