package day3;

public class Range {
    private int start;
    private int end;
    private int content;

    public Range(int start, int end, int content) {
        this.start = start;
        this.end = end;
        this.content = content;
    }

    public int getStart() {
        return this.start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return this.end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getContent() {
        return this.content;
    }

    public void setContent(int content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Range{" +
                "start=" + start +
                ", end=" + end +
                ", content=" + content +
                '}';
    }
}
