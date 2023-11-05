import java.util.*;

class practise1 {
    static public int minCostConnectPoints(int[][] points) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> a[2] - b[2]);
        parent = new int[points.length];
        rank = new int[points.length];

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int d = distance(points[i], points[j]);
                pq.add(new int[]{i, j, d});
            }
        }

        for (int i = 0 ; i < points.length; i++){
            parent[i] = i;
        }

        int ans = 0;
        while (pq.size() > 0) {
            int[] e = pq.remove();
            if (findParent(e[0]) != findParent(e[1])) {
                union(e[0], e[1]);
                ans += e[2];
            }
        }

        return ans;
    }

    static int distance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    static int[] parent;
    static int[] rank;

    static int findParent(int x) {
        if (x == parent[x])
            return x;

        parent[x] = findParent(parent[x]);
        return parent[x];
    }

    static void union(int u, int v) {
        u = findParent(u);
        v = findParent(v);

        if (u == v)
            return;

        if (rank[u] < rank[v])
            parent[u] = v;
        else if (rank[u] > rank[v])
            parent[v] = u;
        else {
            parent[v] = u;
            rank[u]++;
        }
    }

    public static void main(String[] args) {
//        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
//        minCostConnectPoints(points);

        //networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4, 2);

        //printFirstNegativeInteger(new long[]{-8,2,3,-6,10}, 5, 2);

        String s = "anshul";
        String s1 = new String("anshul");
        System.out.println(s == s1);
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        //[[2,1,1],[2,3,1],[3,4,1]]

        //Convert to adjacency list.
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge: times) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        //source -> [[dest, weight]]
        // 2 -> [[1,1],[3,1]]
        // 3 -> [[4,1]]

        //[distance, node]
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> a[0] - b[0]);

        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[k] = 0;
        pq.add(new int[]{0, k});

        while (pq.size() > 0){
            int[] node = pq.remove();
            int current_distance = node[0];
            int current_vertex = node[1];

            if (!graph.containsKey(current_vertex))
                continue;

            for (int[] neighbour: graph.get(current_vertex)){
                if (current_distance + neighbour[1] < distance[neighbour[0]]){
                    pq.add(new int[]{current_distance + neighbour[1], neighbour[0]});
                    distance[neighbour[0]] = current_distance + neighbour[1];
                }
            }
        }

        int max = 0;
        for (int i = 1 ; i < distance.length; i++){
            if (distance[i] == Integer.MAX_VALUE)
                return -1;
            else max = Math.max(max, distance[i]);
        }


        return max;
    }

    public static long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        Queue<Long> queue = new LinkedList<>();
        long[] ans = new long[N];
        List<Long> l = new ArrayList<>();

        int i = 0, j = 0, p = 0 ;

        while (j < A.length){

            if (A[j] < 0)
                queue.add(A[j]);

            if (j - i + 1 < K)
                j++;
            else {
                if (queue.size() == 0)
                    l.add(0L);
                else {
                    long t = queue.peek();
                    l.add(t);
                    if (t == A[i])
                        queue.remove();
                }
                i++;
                j++;
            }
        }
        for (long po: l)
            ans[p++] = po;
        return ans;
    }
}