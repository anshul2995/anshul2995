package pattern.builder;

public class CakeBuilder {

    double sugar;
    double butter;
    int eggs;

    public CakeBuilder butter(double butter) {
        this.butter = butter;
        return this;
    }

    public CakeBuilder sugar(double sugar) {
        this.sugar = sugar;
        return this;
    }

    public CakeBuilder eggs(int eggs) {
        this.eggs = eggs;
        return this;
    }

    public Cake build() {
        return new Cake(this);
    }
}