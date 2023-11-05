package recursion;

class b_printIncreasing {

    public static void main(String[] args) {
        int n = 5;
        printIncreasing(n);
    }


    public static void printIncreasing(int n){

        if (n == 0)   // base condition, how to think of base condition?
            return;  // you can dry run and create stack. Here 0 shouldn't be printed. So when n = 0, return.

        printIncreasing(n-1);  //Faith in n-1 that it will give our expected result.
        System.out.println(n);  //Linking of the faith with our expectation.
    }
}
