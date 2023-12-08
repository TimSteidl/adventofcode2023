package day8;

import utils.Reader;

import java.util.ArrayList;
import java.util.List;

public class HauntedWasteland {

    List<Node> nodes = new ArrayList<>();

    public void run() {
        List<String> lines = Reader.readFile("src/day8/Map.txt");
        String instructions =
                "LLLLRLRLRRLRRRLRRLRLRRLRLLRRRLRRLRRRLRLLLRLRRLRLLRRRLRRLRLRRLLRRRLRRRLRLRRLRRRLRRLRRLLRRRLLLLRRLRRLRRLRRRLLLRLRLRLRRLRRRLRLRRRLRLRRRLRRLRRLLRRLLRLRRRLRLRRRLLLRLRRRLRLRRRLRRLRLRRLRRRLRRRLRRLLLRRRLRRLRRLRRLRRRLLLRRLRLRRRLLLLRRRLRRLRRRLLRLRLRRLLRRRLLRLRLRLRRLRRLRRRLRRLLRLRRLRRLLLLRRLRLRRLLRRLLRRLRRLRRRLLLRRRR";
        String[] splitInstructions = instructions.split("");
        getNodes(lines);
        Node currentNode = findNextNode("AAA");
        int steps = 0;
        for (int i = 0; i < splitInstructions.length; i++) {
            String instruction = splitInstructions[i];
            if (!currentNode.getStart().equals("ZZZ")) {
                if (instruction.equals("L")) {
                    currentNode = findNextNode(currentNode.getLeft());
                } else {
                    currentNode = findNextNode(currentNode.getRight());
                }
                steps += 1;
                if (i == splitInstructions.length - 1) {
                    i = -1;
                }
            }
        }
        System.out.println(steps);
    }

    private void getNodes(List<String> lines) {
        for (String line : lines) {
            String left = line.split(" ")[2].replace("(", "").replace(",", "");
            String right = line.split(" ")[3].replace(")", "");
            this.nodes.add(new Node(line.split(" ")[0], left, right));
        }
    }

    private Node findNextNode(String direction) {
        Node newNode = this.nodes.stream().filter(n -> n.getStart().equals(direction)).toList().getLast();
        System.out.println("->" + newNode.getStart());
        return newNode;
    }
}
