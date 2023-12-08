package day3;

import java.util.List;

public class Number {
    private String line;
    private List<Integer> characterPositions;
    private int lineId;

    public Number(String line, String lineBelow, int lineId, List<Integer> characterPositions) {
        this.line = line;
        this.lineId = lineId;
        this.characterPositions = characterPositions;
    }

    public String getLine() {
        return this.line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public List<Integer> getCharacterPositions() {
        return this.characterPositions;
    }

    public void setCharacterPositions(List<Integer> characterPositions) {
        this.characterPositions = characterPositions;
    }

    public int getLineId() {
        return this.lineId;
    }

    public void setLineId(int lineId) {
        this.lineId = lineId;
    }

    @Override
    public String toString() {
        return "Number{" +
                "line='" + line + '\'' + "\n" +
                ", characterPositions=" + characterPositions +
                ", lineId=" + lineId +
                '}';
    }
}
