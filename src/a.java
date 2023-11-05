package src;

import java.io.FileNotFoundException;

public class a extends b{

    static void m1(){
        System.out.println("a");
    }

    public static void main(String[] args) throws FileNotFoundException {
        a a = new a();
        a.m1();

        b b = new a();
        b.m1();
    }
}
