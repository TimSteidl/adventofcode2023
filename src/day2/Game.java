package day2;

public class Game {
    private int red;
    private int green;
    private int blue;

    public Game(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return this.red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return this.green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return this.blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    @Override
    public String toString() {
        return "red: " + this.red + " green: " + this.green + " blue: " + this.blue;
    }
}
