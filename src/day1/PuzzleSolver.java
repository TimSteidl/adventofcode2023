package day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PuzzleSolver {

    public int calculate(){
        Path path = Path.of("src/day1/puzzleInput.txt");
        int total = 0;
        try(BufferedReader br = Files.newBufferedReader(path)){
            List<String> stringList = br.lines().toList();
            String localTotal = "";
            List<String> newList = new ArrayList<>();
            stringList.forEach((l) -> {
                newList.add(l.replaceAll("[a-z]", ""));
            });
            newList.forEach(System.out::println);
            for(String entry: newList){
                char[] chars = entry.toCharArray();
                System.out.println(Arrays.toString(chars));
                if(chars.length > 1){
                    localTotal = chars[0] +""+chars[chars.length-1];
                } else {
                    localTotal = chars[0] +"" + chars[0];
                }
                total += Integer.parseInt(localTotal);
            }

        } catch (IOException ioe){
            System.out.println("Error reading file.");
        }
        return total;
    }
}
