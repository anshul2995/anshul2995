package recursion;

public class f_zigzag {

    public static void main(String[] args) {
        int n = 2;
        printZigZag(n);
    }

    static void printZigZag(int n) {
        if (n == 0)
            return;

        System.out.println("Pre: "+ n); //Pre area before left call
        printZigZag(n-1); //left call
        System.out.println("In:  "+ n); //In area after left call and before right call
        printZigZag(n-1); //right call
        System.out.println("Post:"+ n); //Post area after right call.
    }
}
