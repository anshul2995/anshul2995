package src;

public class MainthreeException {

    public static void main(String[] args) {

        System.out.println(m());
    }

    static int m() {
        try {
            int m = 15 / 0;
            System.out.println("a");
            return 1;
        } catch (Exception e) {
            System.out.println("b");
            return 2;
        } finally {
            System.out.println("c");
            return 3;
        }
    }
}
