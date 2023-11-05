package Questions;

import java.util.*;

public class practise {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static int count = 0;

    public static void main(String[] args) {

//        TreeNode three = new TreeNode(3);
//        TreeNode one = new TreeNode(1);
//        TreeNode four = new TreeNode(4);
//        TreeNode three1 = new TreeNode(3);
//        TreeNode one1 = new TreeNode(1);
//        TreeNode five = new TreeNode(5);
//
//        three.left = one;
//        three.right = four;
//        one.left = three1;
//        four.left = one1;
//        four.right = five;
//
//        count(three, Integer.MIN_VALUE);
//        System.out.println(count);

//        String s = "a good   example";
//        //s = s.trim();
//        String temp = "";
//        StringBuilder newWord = new StringBuilder();
//        s = s + " ";
//        for (int i = 0 ; i < s.length(); i++){
//            char ch = s.charAt(i);
//            if (ch!= ' '){
//                temp = temp + ch;
//            } else {
//                if (temp.equals(""))
//                    continue;
//                newWord.insert(0, temp + " ");
//                temp="";
//            }
//        }
//        System.out.println(newWord);

//        int[][] grid = {{1,2}};
//        orangesRotting(grid);


        //kClosestViaMaxPQ(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);

        kthClosetViaQuickSelect(new int[][]{{10, -2}, {2, -2}, {10, 10}, {9, 4}, {-8, 1}}, 4);
    }

    public static int[][] kClosestViaMaxPQ(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> distance(b[0], b[1]) - distance(a[0], a[1]));

        int i = 0;
        while (i < k) {
            pq.add(points[i]);
            i++;
        }

        while (i < points.length) {
            int[] peek = pq.peek();
            if (distance(points[i][0], points[i][1]) < distance(peek[0], peek[1])) {
                pq.remove();
                pq.add(points[i]);
            }
            i++;
        }

        i = 0;
        int[][] result = new int[k][2];
        while (pq.size() > 0) {
            result[i++] = pq.remove();
        }

        return result;
    }

    public static int[][] kthClosetViaQuickSelect(int[][] point, int k) {

        quickSelect(point, 0, point.length - 1, k);
        int[][] result = new int[k][2];

        for (int j = 0; j < k; j++)
            result[j] = point[j];

        return result;
    }

    public static void quickSelect(int[][] point, int low, int high, int k) {
        if (low > high)
            return;

        int pivot = pivot(point, low, high);
        if (k == pivot) {
            return;
        } else if (k > pivot)
            quickSelect(point, pivot + 1, high, k);
        else
            quickSelect(point, low, pivot - 1, k);

    }

    public static int pivot(int[][] point, int low, int high) {
        int j = low, i = j;

        while (i <= high) {
            if (distance(point[i][0], point[i][1]) > distance(point[high][0], point[high][1])) {
                i++;
            } else {
                int[] temp = point[i];
                point[i] = point[j];
                point[j] = temp;
                i++;
                j++;
            }
        }
        return j - 1;
    }

    public static int distance(int x, int y) {
        return (x * x) + (y * y);
    }

    public static int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int num_fresh_oranges = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    num_fresh_oranges++;
                }
            }
        }
        int time = 0;

        while (queue.size() > 0) {
            int size = queue.size();
            time++;

            for (int i = 0; i < size; i++) { //similar to level order traversal print.
                int[] current = queue.remove();
                int current_row = current[0];
                int current_col = current[1];


                if (current_row - 1 >= 0 && grid[current_row - 1][current_col] == 1) {
                    grid[current_row - 1][current_col] = 2;
                    queue.add(new int[]{current_row - 1, current_col});
                    num_fresh_oranges--;
                }
                if (current_row + 1 < n && grid[current_row + 1][current_col] == 1) {
                    grid[current_row + 1][current_col] = 2;
                    queue.add(new int[]{current_row + 1, current_col});
                    num_fresh_oranges--;
                }
                if (current_col - 1 >= 0 && grid[current_row][current_col - 1] == 1) {
                    grid[current_row][current_col - 1] = 2;
                    queue.add(new int[]{current_row, current_col - 1});
                    num_fresh_oranges--;
                }
                if (current_col + 1 < m && grid[current_row][current_col + 1] == 1) {
                    grid[current_row][current_col + 1] = 2;
                    queue.add(new int[]{current_row, current_col + 1});
                    num_fresh_oranges--;
                }
            }
        }
        return num_fresh_oranges == 0 ? time : -1;
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int totalRows = heights.length;
        int totalColumns = heights[0].length;

        boolean[][] pacific = new boolean[totalRows][totalColumns];
        boolean[][] atlantic = new boolean[totalRows][totalColumns];

        for (int col = 0; col < totalColumns; col++) {
            dfs(0, col, totalRows, totalColumns, heights, pacific);
            dfs(totalRows - 1, col, totalRows, totalColumns, heights, atlantic);
        }

        for (int row = 0; row < totalRows; row++) {
            dfs(row, 0, totalRows, totalColumns, heights, pacific);
            dfs(row, totalColumns - 1, totalRows, totalColumns, heights, atlantic);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; i < totalColumns; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    ans.add(Arrays.asList(i, j));
            }
        }

        return ans;
    }

    public void dfs(int i, int j, int n, int m, int[][] heights, boolean[][] visited) {

        visited[i][j] = true;

        if (i - 1 >= 0 && visited[i - 1][j] == false && heights[i][j] <= heights[i - 1][j]) {
            dfs(i - 1, j, n, m, heights, visited);
        }

        if (i + 1 < n && visited[i + 1][j] == false && heights[i][j] <= heights[i + 1][j]) {
            dfs(i + 1, j, n, m, heights, visited);
        }

        if (j - 1 >= 0 && visited[i][j - 1] == false && heights[i][j] <= heights[i][j - 1]) {
            dfs(i, j - 1, n, m, heights, visited);
        }

        if (j + 1 < m && visited[i][j + 1] == false && heights[i][j] <= heights[i][j + 1]) {
            dfs(i, j + 1, n, m, heights, visited);
        }
    }

//    static int[][] solution(int h, int w, String[] queries) {
//        int arr[][] = new int[h][w];
//        ArrayList<BKT> sol = new ArrayList<BKT>();
//        for (int i = 0; i < queries.length; i++) {
//            String s = queries[i];
//            String[] sArr = s.split(" ");
//            if (sArr[0].equals("x")) {
//                int x = Integer.parseInt(sArr[1]);
//                int y = Integer.parseInt(sArr[2]);
//                arr[x][y] = 1;
//            } else if (sArr[0].equals("<")) {
//                int ansX = -1, ansY = -1;
//                int x = Integer.parseInt(sArr[1]);
//                int y = Integer.parseInt(sArr[2]);
//                for (int j = 0; j < y; j++) {
//                    if (arr[x][j] == 0) {
//                        ansX = x;
//                        ansY = y;
//                    }
//                }
//                BKT anshul = new BKT();
//                anshul.a = ansX;
//                anshul.b = ansY;
//                sol.add(anshul);
//            } else if (sArr[0].equals(">")) {
//                int ansX = -1, ansY = -1;
//                int x = Integer.parseInt(sArr[1]);
//                int y = Integer.parseInt(sArr[2]);
//                for (int j = w - 1; j > y; j--) {
//                    if (arr[x][j] == 0) {
//                        ansX = x;
//                        ansY = y;
//                    }
//                }
//                BKT anshul = new BKT();
//                anshul.a = ansX;
//                anshul.b = ansY;
//                sol.add(anshul);
//            } else if (sArr[0].equals("^")) {
//                int ansX = -1, ansY = -1;
//                int x = Integer.parseInt(sArr[1]);
//                int y = Integer.parseInt(sArr[2]);
//                for (int j = 0; j < x; j++) {
//                    if (arr[j][y] == 0) {
//                        ansX = x;
//                        ansY = y;
//                    }
//                }
//                BKT anshul = new BKT();
//                anshul.a = ansX;
//                anshul.b = ansY;
//                sol.add(anshul);
//            } else {
//                int ansX = -1, ansY = -1;
//                int x = Integer.parseInt(sArr[1]);
//                int y = Integer.parseInt(sArr[2]);
//                for (int j = h - 1; j > x; j--) {
//                    if (arr[j][y] == 0) {
//                        ansX = x;
//                        ansY = j;
//                    }
//                }
//                BKT anshul = new BKT();
//                anshul.a = ansX;
//                anshul.b = ansY;
//                sol.add(anshul);
//            }
//        }
//        int[][] ansF = new int[sol.size()][2];
//        for (int i = 0; i < sol.size(); i++) {
//            ansF[i][0] = sol.get(i).a;
//            ansF[i][1] = sol.get(i).b;
//        }
//
//        return ansF;
//    }
}