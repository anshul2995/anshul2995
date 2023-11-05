
import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Given an array of strings strs , group the anagrams together. You can return the answer in any order.

        //An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

        //Input: strs = ["Eat","Tea","Tan","ate","nat","bat"]
        //Output: [["bat"],["nat","Tan"],["ate","Eat","Tea"]]

        String[] str = {"Eat","Tea","Tan","ate","nat","bat"};

        List<List<String>> res = groupAnagram(str);
        System.out.println(res);
    }

    public static List<List<String>> groupAnagram(String[] strs){



        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0 ; i < strs.length; i++){
            char[] word = strs[i].toLowerCase().toCharArray();

            Arrays.sort(word);

            String sortedWord = String.valueOf(word);

            // String[] str = {"Eat","Tea","Tan","ate","nat","bat"};

            if (map.get(sortedWord) != null) { //contains key, value present in map
                List<String> tempList = map.get(sortedWord);
                tempList.add(strs[i]);
                map.put(sortedWord, tempList);
            } else { //does not contains key, value not present in map
                List<String> tempList = new ArrayList<>();
                tempList.add(strs[i]);
                map.put(sortedWord, tempList);
            }
        }

        for (Map.Entry<String, List<String>> m: map.entrySet()){
            res.add(m.getValue());
        }

        return res;

    }


}