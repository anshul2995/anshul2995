package Questions;

import java.util.HashMap;
import java.util.Map;

public class Q4 {
    public static void main(String[] args) {

        String s1 = "aanshul";
        String s2 = "saurabh";

        Map<Character, Integer> ans = new HashMap<>();

        for (int i = 0 ; i < s1.length(); i++){
            char ch1= s1.charAt(i);
            if (ans.containsKey(ch1)) {
                ans.put(ch1, ans.get(ch1)+1);
                continue;
            }

            int count = 0;

            for (int j = 0 ; j < s2.length(); j++){
                char ch2 = s2.charAt(j);
                if (ch1 == ch2)
                    count++;
            }
            if (count != 0) {
                ans.put(ch1, count+1);
            }
        }

        for (char ch: ans.keySet()) {
            System.out.println(ch+":"+ans.get(ch));
        }
    }
}

//Employee
//id, name, salary, department
//
//select max(salary) from Employee where salary < (select max(salary) from Employee)