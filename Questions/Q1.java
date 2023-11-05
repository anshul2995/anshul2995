package Questions;/*
* Given a grid and a word, write a function that returns the location of the word in the grid as a list of coordinates. If there are multiple matches, return any one.



grid = {
    {'c', 'c', 't', 'n', 'a', 'x'},
    {'c', 'c', 'a', 't', 'n', 't'},
    {'a', 'c', 'n', 'n', 't', 't'},
    {'t', 'n', 'i', 'i', 'p', 'p'},
    {'a', 'o', 'o', 'o', 'a', 'a'},
    {'s', 'a', 'a', 'a', 'o', 'o'},
    {'k', 'a', 'i', 'o', 'k', 'i'},
}
*
*
* */

import java.util.HashMap;
import java.util.Map;

public class Q1 {

    static int[][] positionToMove = {{-1,0}, {1,0}, {0,-1}, {0,1}}; //possible moves
    public static void main(String[] args) {

        char[][] grid = {
                {'c', 'c', 't', 'n', 'a', 'x'},
                {'c', 'c', 'a', 't', 'n', 't'},
                {'a', 'c', 'n', 'n', 't', 't'},
                {'t', 'n', 'i', 'i', 'p', 'p'},
                {'a', 'o', 'o', 'o', 'a', 'a'},
                {'s', 'a', 'a', 'a', 'o', 'o'},
                {'k', 'a', 'i', 'o', 'k', 'i'},
        };


        String word = "catnip";
        //word2 = "cccc"
        //word3 = "s"
        //word4 = "ant"
        //word5 = "aoi"
        //word6 = "ki"
        //word7 = "aaoo"
        //word8 = "ooo"

//        boolean[][] visited = new boolean[grid.length][grid[0].length];
//
//        for (int i = 0 ; i < grid.length; i++){
//            for (int j = 0 ; j < grid[0].length; j++){
//                if (grid[i][j] == word.charAt(0)) {
//                    String s1 = word.substring(1);
////                    if(dfs(i, j, s1, visited, grid)) {
////                        printCoordinates(visited);
////                        return;
////                    }
//                    if(dfsMyWay(i, j, s1, visited, grid)) {
//                        printCoordinates(visited);
//                        return;
//                    }
//                }
//            }
//        }

        //lengthOfLongestSubstring("au");

        characterReplacement("aaba", 0);

    }

    static void printCoordinates(boolean[][] visited){

        for (int i = 0 ; i < visited.length; i++){
            for (int j = 0 ; j < visited[0].length; j++){
                if (visited[i][j])
                    System.out.println(i + "," + j);
            }
        }
    }

    static boolean dfs(int x,  int y, String word, boolean[][] visited, char[][] grid){

        visited[x][y] = true;

        if (word.length() == 0){
            return true;
        }

        boolean ans = false;

        //Traversing now
        for (int[] move: positionToMove){

            int curr_x = move[0] + x;
            int curr_y = move[1] + y;

            //Check for boundary conditions
            if (0 <= curr_x && curr_x < grid.length && 0 <= curr_y && curr_y < grid[0].length){
                if (!visited[curr_x][curr_y] && grid[curr_x][curr_y] == word.charAt(0)) {
                    String s = word.substring(1);
                    if (dfs(curr_x, curr_y, s, visited, grid))
                        return true;
                }
            }
        }
        visited[x][y] = false;
        return ans;
    }

    static boolean dfsMyWay(int x,  int y, String word, boolean[][] visited, char[][] grid) {

        visited[x][y] = true;

        if (word.length() == 0)
            return true;

        //Checking for top
        if (x-1 >= 0 && !visited[x-1][y] && word.charAt(0) == grid[x-1][y]){
            if (dfsMyWay(x-1, y, word.substring(1), visited, grid))
                return true;
        }

        //Checking for bottom
        if (x+1 < grid.length && !visited[x+1][y] && word.charAt(0) == grid[x+1][y]){
            if (dfsMyWay(x+1, y, word.substring(1), visited, grid))
                return true;
        }

        //Checking for left
        if (y-1 >= 0 && !visited[x][y-1] && word.charAt(0) == grid[x][y-1]){
            if (dfsMyWay(x, y-1, word.substring(1), visited, grid))
                return true;
        }

        //Checking for right
        if (y+1 < grid[0].length && !visited[x][y+1] && word.charAt(0) == grid[x][y+1]){
            if (dfsMyWay(x, y+1, word.substring(1), visited, grid))
                return true;
        }

        visited[x][y] = false;
        return false;

    }


    public static int lengthOfLongestSubstring(String s) {

        if (s.length() == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int i = 0 , j = 0 ;

        while (j < s.length()){
            char ch = s.charAt(j);
            if (map.containsKey(ch))
                map.put(ch, map.get(ch)+1);
            else
                map.put(ch, 1);


            if (map.size() == j - i + 1) {
                max = Math.max(max, j - i + 1);
                j++;
            } else if (map.size () < j - i + 1) {
                while (map.size() < j - i + 1) {
                    char ithPosChar = s.charAt(i);
                    int  ithPosCharFreq = map.get(ithPosChar);
                    ithPosCharFreq--;
                    map.put(ithPosChar, ithPosCharFreq);

                    if (map.get(ithPosChar) == 0)
                        map.remove(ithPosChar);
                    i++;
                }
                j++;
            }
        }

        return max;
    }
    static Map<Character, Integer> chMap;

    public static  int characterReplacement(String s, int k) {

        int max = Integer.MIN_VALUE;
        int i = 0, j = 0;

        chMap = new HashMap<>();

        for (char ch = 'a' ; ch <= 'z'; ch++)
            chMap.put(ch, 0);

        while (j < s.length()){
            char ch = s.charAt(j);

            if (chMap.containsKey(ch)){
                chMap.put(ch, chMap.get(ch)+1);
            } else {
                chMap.put(ch, 1);
            }

            int maxChar = findMaxCount();
            int windowSize = j - i + 1;

            if (windowSize - maxChar <= k){
                max = Math.max(max, windowSize);
                j++;
            } else {
                while (windowSize - maxChar > k) {
                    char ithPosChar = s.charAt(i);
                    int ithPosCharFreq = chMap.get(ithPosChar);
                    ithPosCharFreq--;

                    chMap.put(ithPosChar, ithPosCharFreq);

                    if (chMap.get(ithPosChar) == 0)
                        chMap.remove(ithPosChar);
                    i++;
                    windowSize = j - i + 1;
                    maxChar = findMaxCount();
                }
                max = Math.max(max, windowSize);
                j++;
            }
        }

        return max;
    }

    public static int findMaxCount(){
        int max = Integer.MIN_VALUE;
        for (char c : chMap.keySet()){
            max = Math.max(max, chMap.get(c));
        }
        return max;
    }

}