package Questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class practise3 extends Thread {

    public static void main(String[] args) {
        String s1 = "anshul";
        String s2 = "anshul";

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        StringBuilder sb1 = new StringBuilder("an");
        StringBuilder sb2 = new StringBuilder("an");

        System.out.println(sb1.hashCode());
        System.out.println(sb2.hashCode());


    }

    public void run() {

    }
}
