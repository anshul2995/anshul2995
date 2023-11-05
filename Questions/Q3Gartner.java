package Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Q3Gartner {
    public static void main(String[] args) {

//        String s = "anshul";
//        String newWord = "";
//
//        StringBuilder sb = new StringBuilder("");
//        for (int i = s.length() - 1 ; i >= 0; i++){
//            char ch = s.charAt(i);
//            sb.append(ch);
//        }

        int profit = 0;
        //int[] arr = {100, 180, 260, 310, 40, 535, 695};
        //int[] arr = {100, 180, 260, 310, 100,90};
        //int[] arr = {110, 100, 180, 260, 310, 300, 40, 535, 695};
        //int[] arr = {110, 100, 180, 260, 310, 300, 40, 535, 525};
        int[] arr = {4, 2, 2, 2, 1};


        int j = 0;
        //starting from 2nd element.
        for (int i = 1; i < arr.length; i++) {

            //we are updating the window size if a decreasing sequeunce is found
            if (arr[i - 1] > arr[i]) {
                j = i;
            }
            //we should sell if the current element is at the peak.
            // previous_index <= current_index  > next_index
            if (arr[i - 1] <= arr[i] && (i + 1 == arr.length || arr[i] > arr[i + 1])) {
                profit = profit + arr[i] - arr[j];
            }
        }

        System.out.println("maximum profit: "+ profit);


        final List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);


//        List<Integer> l = list.stream().filter(list1::contains).collect(Collectors.toList());

        boolean ans = list.stream().anyMatch(list1::contains);
        System.out.println(ans);


       // select salary from table order by salary desc limit 4, 1;




    }
}

//    Stock Buy Sell to Maximize Profit
//
//    The cost of a stock on each day is given in an array. Find the maximum profit that you can make by buying and selling on those days.
//        If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.
//        Case1. :
//        Input: arr[] = {100, 180, 260, 310, 100,90}
//        Output: 210
//        Explanation: Buy the stock on day 0 and sell it on day 3 => 310 – 100 = 210
//        Maximum Profit  = 210
//
//        Case 2 :
//        Input: arr[] = {100, 180, 260, 310, 40, 535, 695}
//        Input: arr[] = {110, 100, 180, 260, 310, 300, 40, 535, 695}
//        Output: 865
//        Explanation: Buy the stock on day 0 and sell it on day 3 => 310 – 100 = 210
//        Buy the stock on day 4 and sell it on day 6 => 695 – 40 = 655
//        Maximum Profit  = 210 + 655 = 865
//
//
//        Case 3 :
//
//        Input: arr[] = {4, 2, 2, 2, 4}
//        Output: 2
//        Explanation: Buy the stock on day 1 and sell it on day 4 => 4 – 2 = 2
//        Maximum Profit  = 2
