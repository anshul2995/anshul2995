package pattern.builder;

public class Cake {

    private final double sugar;   //cup
    private final double butter;  //cup
    private final int eggs;

    public Cake(CakeBuilder cb) {
        this.butter = cb.butter;
        this.sugar = cb.sugar;
        this.eggs = cb.eggs;
    }

}
