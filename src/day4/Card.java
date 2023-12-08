package day4;

import java.util.ArrayList;
import java.util.List;

public class Card {

    private int gameId;
    private List<Integer> drawnNumbers = new ArrayList<>();
    private List<Integer> gameNumbers = new ArrayList<>();

    public Card(int gameId, List<Integer> drawnNumbers, List<Integer> gameNumbers) {
        this.drawnNumbers = drawnNumbers;
        this.gameId = gameId;
        this.gameNumbers = gameNumbers;
    }

    public int getGameId() {
        return gameId;
    }

    public Card setGameId(int gameId) {
        this.gameId = gameId;
        return this;
    }

    public List<Integer> getDrawnNumbers() {
        return drawnNumbers;
    }

    public Card setDrawnNumbers(List<Integer> drawnNumbers) {
        this.drawnNumbers = drawnNumbers;
        return this;
    }

    public List<Integer> getGameNumbers() {
        return gameNumbers;
    }

    public Card setGameNumbers(List<Integer> gameNumbers) {
        this.gameNumbers = gameNumbers;
        return this;
    }
}
