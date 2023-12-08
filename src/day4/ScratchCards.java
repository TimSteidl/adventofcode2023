package day4;

import utils.Reader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScratchCards {

    public void run() {
        List<String> lines = Reader.readFile("src/day4/scratch.txt");
        List<Card> cards = parseToCards(lines);
        int total = 0;
        for (Card card : cards) {
            int points = 0;
            for (Integer numberOne : card.getDrawnNumbers()) {
                for (Integer numberTwo : card.getGameNumbers()) {
                    if (numberOne.equals(numberTwo)) {
                        System.out.println(numberOne + " " + numberTwo + " " + card.getGameId());
                        if (points == 0) {
                            points += 1;
                        } else {
                            points *= 2;
                        }
                        System.out.println(points);
                    }
                }
            }
            total += points;
        }
        System.out.println("Result: " + total);
    }

    private List<Card> parseToCards(List<String> lines) {
        List<Card> cards = new ArrayList<>();
        for (String line : lines) {
            String header = line.split(":")[0];
            String content = line.split(":")[1];
            List<String> first =
                    Arrays.stream(content.split("\\|")[0].stripLeading().stripTrailing().split(" ")).toList();
            List<String> second = Arrays.stream(content.split("\\|")[1].stripLeading().split(" ")).toList();
            List<Integer> parsedNumbers = new ArrayList<>();
            for (String f : first) {
                if (!f.isEmpty()) {
                    parsedNumbers.add(Integer.parseInt(f));
                }
            }
            List<Integer> parsedSecondNumbers = new ArrayList<>();
            for (String f : second) {
                if (!f.isEmpty()) {
                    parsedSecondNumbers.add(Integer.parseInt(f));
                }
            }
            String[] splitHeader = header.split(" ");
            String cardNumber = splitHeader[splitHeader.length - 1];
            cards.add(new Card(Integer.parseInt(cardNumber), parsedNumbers, parsedSecondNumbers));
        }
        return cards;
    }
}
