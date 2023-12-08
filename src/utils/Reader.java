package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class Reader {
    private Reader() {
    }

    public static List<String> readFile(String givenPath) {
        List<String> result = new ArrayList<>();
        Path path = Path.of(givenPath);
        try (BufferedReader br = Files.newBufferedReader(path)) {
            result.addAll(br.lines().toList());
        } catch (IOException ioe) {
            System.out.println("Error reading file");
        }
        return result;

    }
}
