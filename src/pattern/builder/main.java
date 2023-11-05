package pattern.builder;

public class main {

    public static void main(String[] args){

        Cake c = new CakeBuilder().butter(1).sugar(1).eggs(1).build();

    }
}
