package day8;

public class Node implements Comparable<Node> {
    private String start;
    private String left;
    private String right;

    public Node(String start, String left, String right) {
        this.start = start;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "start: " + start + " left: " + left + " right: " + right;
    }

    public String getStart() {
        return start;
    }

    public Node setStart(String start) {
        this.start = start;
        return this;
    }

    public String getLeft() {
        return left;
    }

    public Node setLeft(String left) {
        this.left = left;
        return this;
    }

    public String getRight() {
        return right;
    }

    public Node setRight(String right) {
        this.right = right;
        return this;
    }

    @Override
    public int compareTo(Node o) {
        return this.start.compareTo(o.start);
    }
}
