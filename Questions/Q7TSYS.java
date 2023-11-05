package Questions;

import java.util.Arrays;
import java.util.List;

public class Q7TSYS {

    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
        myList.stream()
                .map(i -> String.valueOf(i))
                .filter(s -> s.startsWith("1"))
                .forEach(s -> System.out.println(Integer.parseInt(s)));

        //Given a String, find the first non-repeated character in it using Stream functions?

        String input = "articles Java are Awesome";

        //THIS DIDN'T WORK!!!!!
        input.chars().mapToObj(c -> Character.valueOf((char) c))
                .findFirst().ifPresent(c -> System.out.println(c));
    }

//        Controller -> Handler  -> Service -> Repository <DB interaction>


}

