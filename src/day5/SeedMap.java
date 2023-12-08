package day5;

public class SeedMap {
    private int soilNumber;
    private int seedNumber;
    private int range;

    public SeedMap(int soilNumber, int seedNumber, int range) {
        this.soilNumber = soilNumber;
        this.seedNumber = seedNumber;
        this.range = range;
    }

    public int getSoilNumber() {
        return soilNumber;
    }

    public SeedMap setSoilNumber(int soilNumber) {
        this.soilNumber = soilNumber;
        return this;
    }

    public int getSeedNumber() {
        return seedNumber;
    }

    public SeedMap setSeedNumber(int seedNumber) {
        this.seedNumber = seedNumber;
        return this;
    }

    public int getRange() {
        return range;
    }

    public SeedMap setRange(int range) {
        this.range = range;
        return this;
    }
}
