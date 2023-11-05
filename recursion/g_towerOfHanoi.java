package recursion;

public class g_towerOfHanoi {

    public static void main(String[] args) {
        toh(3, "A", "B", "C");
    }

    static void toh(int n, String t1, String t2, String t3){
        if (n == 0)
            return;

        toh(n-1, t1, t3, t2); //Have faith it will print the instructions to move the n-1 tiles from t1 to t3 using t2.
        System.out.println(n + "[" + t1 + "->" + t2 + "]"); // (so if n = 3), and when n = 3, when this statement is executed, then it has moved all the n-1 tiles.
        toh(n-1, t3, t2, t1); //Have faith it will print the instructions to move the n-1 tiles from t3 to t2 using t1.
    }
}
