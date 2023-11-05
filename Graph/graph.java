package Graph;

import java.util.*;

public class graph {

    private static void bfsUtil(List<List<Integer>> adjacencyList) {
        int noOfVertices = adjacencyList.size();
        int[] visited = new int[noOfVertices];

        for (int i = 1; i < noOfVertices; i++)
            if (visited[i] == 0) //not visited    -> ek baar mai ek component ka pure nodes ko cover lagegi single iteration mai.
                // -> dosra component alag iteration mai. Same component k nodes different iterations mai ni honge.
                bfs(i, adjacencyList, visited);
    }

    //Queue mai element add kia toh matlab woh visited ho gya hai.
    private static void bfs(int node, List<List<Integer>> adjacencyList, int[] visitedArray) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(node);
        visitedArray[node] = 1;

        while (queue.size() > 0) {
            int poppedNode = queue.remove();
            System.out.print(poppedNode + ",");

            for (int neigbhours : adjacencyList.get(poppedNode)) {
                if (visitedArray[neigbhours] == 0) {
                    queue.add(neigbhours);
                    visitedArray[neigbhours] = 1; //yeh karna jaruri hai.
                    /**
                     *  2 - 3
                     *  |  /
                     *  7
                     *
                     * So, if you dont do this visitedArray[neigbhours] = 1, only add the element in the queue,
                     * when 2 -> queue: [3,7]
                     * when 3 -> queue mai dobara [7] add ho jayega, so [7,7]
                     * */
                }
            }
        }
    }

    private static void dfsUtil(List<List<Integer>> adjacencyList) {
        int noOfVertices = adjacencyList.size();
        int[] visited = new int[noOfVertices];

        for (int i = 1; i < noOfVertices; i++)
            if (visited[i] == 0) //not visited
                dfsIteration(i, adjacencyList, visited);
    }

    private static void dfsIteration(int node, List<List<Integer>> adjacencyList, int[] visitedArray) {

        Stack<Integer> stack = new Stack<>();

        stack.add(node);
        visitedArray[node] = 1;

        while (stack.size() > 0) {
            int poppedNode = stack.pop();
            System.out.print(poppedNode + ",");

            for (int neighbour : adjacencyList.get(poppedNode)) {
                if (visitedArray[neighbour] == 0) {
                    stack.add(neighbour);
                    visitedArray[neighbour] = 1;
                }
            }
        }
    }

    private static void dfsUtilRecursion(List<List<Integer>> adjacencyList) {
        int noOfVertices = adjacencyList.size();
        int[] visited = new int[noOfVertices];

        for (int i = 1; i < noOfVertices; i++)
            if (visited[i] == 0) //not visited    -> ek baar mai ek component ka pure nodes ko cover lagegi single iteration mai.
                // -> dosra component alag iteration mai. Same componenet k nodes different iterations mai ni honge
                dfsRecursion(adjacencyList, visited, i);

    }

    private static void dfsRecursion(List<List<Integer>> adjacencyList, int[] visitedArray, int node) {
        System.out.print(node + ",");

        visitedArray[node] = 1;

        for (int neighbour : adjacencyList.get(node)) { //level and options wala recursion h yeh.
            if (visitedArray[neighbour] == 0)
                dfsRecursion(adjacencyList, visitedArray, neighbour);
        }
    }

    private static void cycleUtilBFS(List<List<Integer>> adjacencyList) {

        int noOfVertices = adjacencyList.size();
        int visitedArray[] = new int[noOfVertices];

        for (int i = 1; i <= noOfVertices; i++)
            if (visitedArray[i] == 0)
                if (detectCycleBFS(i, adjacencyList, visitedArray)) /**
                 jaisa upar bata rakha hai, vaise hi single iteration mai 1 component pura cover ho jayega.
                 2nd iteration mai doosra component k nodes pure cover ho jayenge.
                 Therefore, respective component mai cycle hai ya ni, pata chal jayega from Line:108 k functions se, kyuki ek baar
                 mai woh pure nodes ko cover kar lega in a component whether cycle is present or not.
                 */
                    break;
    }

    private static boolean detectCycleBFS(int node, List<List<Integer>> adjacencyList, int[] visitedArray) {

        Queue<CycleClassBFS> queue = new LinkedList<>();
        queue.add(new CycleClassBFS(node, -1));
        visitedArray[node] = 1;

        while (!queue.isEmpty()) {
            CycleClassBFS poppedElement = queue.remove();

            for (int neighbour : adjacencyList.get(poppedElement.currentNode)) {
                if (visitedArray[neighbour] == 0) {
                    queue.add(new CycleClassBFS(neighbour, poppedElement.currentNode));
                    visitedArray[neighbour] = 1;
                } else if (neighbour == poppedElement.previousNode)
                    continue;
                else {
                    System.out.println("Cyclic Node:" + neighbour);
                    return true;
                }
            }
        }

        return false;
    }

    private static void cycleUtilDFS(List<List<Integer>> adjacencyList) {

        int noOfVertices = adjacencyList.size();
        int[] visitedArray = new int[noOfVertices];

        for (int i = 1; i <= noOfVertices; i++)
            if (visitedArray[i] == 0)
                if (detectCycleDFS(i, adjacencyList, visitedArray, new CycleClassBFS(i, -1)))
                    break;
    }

    private static boolean detectCycleDFS(int node, List<List<Integer>> adjacencyList, int[] visitedArray, CycleClassBFS history) {
        visitedArray[node] = 1;
            /*
            * you did this:
            if (visitedArray[neighbour] == 0) {
                detectCycleDFS(neighbour, adjacencyList, visitedArray, new CycleClassBFS(neighbour, history.currentNode)
            }
            * The reason is that, even if you detect the cycle, at that moment it will return true and go the previous thread.
            * When it returns from that previous thread, it doesn't know the outcome (returned value),
            * that is why you will have to return from there itself.
            * Someone beneath returned true, then all the upper fn (when recursion goes backward), should also return true.
            * */
        for (int neighbour : adjacencyList.get(node)) {
            if (visitedArray[neighbour] == 0) {
                if (detectCycleDFS(neighbour, adjacencyList, visitedArray, new CycleClassBFS(neighbour, history.currentNode))) //beneath someone returned a cycle
                    return true;
            } else if (neighbour == history.previousNode)
                continue;
            else {
                System.out.println("Cyclic Node:" + neighbour);  //currently got the cycle
                return true;
            }
        }
        return false;
    }

    private static boolean detectCycleDFSRecursion(List<List<Integer>> graph, int vertice, int parent, boolean[] visitedArray) {

/*        visitedArray[vertice] = true;

        for (Integer neighbour : graph.get(vertice)) {
            if (visitedArray[neighbour]) {
                if (parent != neighbour) {
                    System.out.println("Cyclic Node:" + neighbour + parent);
                    return true;
                }
            } else {
                return dfs(graph, neighbour, vertice, visitedArray);
            }
        }
        return false;
    }*/

        visitedArray[vertice] = true;

        for (Integer neighbour : graph.get(vertice)) {
            if (visitedArray[neighbour]) {
                if (parent != neighbour) {
                    System.out.println("Cyclic Node:" + neighbour);
                    return true;
                }
            } else {
                if (detectCycleDFSRecursion(graph, neighbour, vertice, visitedArray)) /**
                 agar previous recursive call ka result false hai, tabhi next neighbour check karo.
                 agar previous recursive call ka result true hai, tabhi return kardo, kyuki next neighbour check karne ki jarurat ni hai. Already cycle mil chuka h
                 **/
                    return true;
            }
        }
        return false;
    }

    private static void bipartiteGraphBFS(List<List<Integer>> adjacencyList) {

        boolean[] visitedArray = new boolean[adjacencyList.size()];

        for (int i = 0; i < adjacencyList.size(); i++) {
            if (!visitedArray[i]) //will check for every component
                if (!bipartitieGraph(adjacencyList, i, "B", visitedArray)) {
                    System.out.println("Not possible");
                    break;
                } else
                    System.out.println("Possible");
        }
    }

    /*
    Odd length cycle aren't bipartite graph and non-odd length -> even length cycle and no cycle graph are bipartite graph.
    * **/
    private static boolean bipartitieGraph(List<List<Integer>> graph, int vertice, String color, boolean[] visitingArray) {

        Queue<ColorNode> queue = new LinkedList<>();
        queue.add(new ColorNode(vertice, color));

        Map<Integer, String> map = new HashMap<>(); // Instead of using a hashmap, we could have an array of size #total_no_of_vertices
        map.put(vertice, color);
        visitingArray[vertice] = true;

        while (queue.size() > 0) {

            ColorNode node = queue.remove();

            for (Integer neighbour : graph.get(node.currentNode)) {
                if (!visitingArray[neighbour]) {

                    String newColor = "";
                    if (node.color.equals("G"))
                        newColor = "B";
                    if (node.color.equals("B"))
                        newColor = "G";

                    map.put(neighbour, newColor);
                    queue.add(new ColorNode(neighbour, newColor));
                    visitingArray[neighbour] = true;
                } else {
                    String neighbourColor = map.get(neighbour);
                    if (neighbourColor.equals(node.color))
                        return false;
                }
            }
        }
        return true;
    }

    private static void bipartiteGraphUtilDFS(List<List<Integer>> graph) {

        boolean[] visitedArray = new boolean[graph.size()];
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < graph.size(); i++) {
            if (!visitedArray[i]) {
                map.put(i, "B");
                if (!bipartitieGraphDFS(graph, i, "B", visitedArray, map)) {
                    System.out.println("Not possible");
                    break;
                } else
                    System.out.println("Possible");
            }
        }
    }

    private static boolean bipartitieGraphDFS(List<List<Integer>> graph, int vertice, String color, boolean[] vistingArray, Map<Integer, String> map) {

        vistingArray[vertice] = true;

        for (Integer neighbour : graph.get(vertice)) {
            if (!vistingArray[neighbour]) {
                String newColor = color.equals("B") ? "G" : "B";
                map.put(neighbour, newColor);
                if (!bipartitieGraphDFS(graph, neighbour, newColor, vistingArray, map)) { // yeh tumne dfs Cycle ki galti se sikha hai.
                    return false;
                }
            } else {
                String neighbourColor = map.get(neighbour);
                if (neighbourColor.equals(color))
                    return false;
            }
        }
        return true;
    }

    private static void detectCycleDirectedGraphUtilDFS(List<List<Integer>> graph) {

        boolean[] visited = new boolean[graph.size()];
        boolean[] currentDFSCallVisitedNode = new boolean[graph.size()];

        for (int i = 0; i < graph.size(); i++)
            if (!visited[i])
                if (detectCycleDirectedGraphDFS(graph, i, visited, currentDFSCallVisitedNode)) {
                    System.out.println("Cycle Detected");
                    return;
                }
        System.out.println("Cycle Not Detected");
    }

    private static boolean detectCycleDirectedGraphDFS(List<List<Integer>> graph, int vertice, boolean[] visitedArray, boolean[] currentDFSCallVisitedNode) {
        visitedArray[vertice] = true;
        currentDFSCallVisitedNode[vertice] = true;

        for (Integer neighbour : graph.get(vertice)) {
            if (!visitedArray[neighbour]) {
                if (detectCycleDirectedGraphDFS(graph, neighbour, visitedArray, currentDFSCallVisitedNode))
                    return true;
                //currentDFSCallVisitedNode[neighbour] = false;  //dfs over for that node for the current cycle jismai usko visit kia gya.
                /**
                 * yeh line yaha ni rahegi.
                 *         addEdgeDirected(graph, 5, 3);
                 *         addEdgeDirected(graph, 3, 1);
                 *         addEdgeDirected(graph, 1, 2);
                 *         addEdgeDirected(graph, 2, 4);
                 *         addEdgeDirected(graph, 4, 0);
                 *
                 * 0 jab aayega -> dfs(0), neighbour wale for loop mai entry ki ni h, toh phr currentDFSCallVisitedNode[0] upar jo true hua, woh false ni hoga.
                 * **/
            } else {
                if (currentDFSCallVisitedNode[neighbour]) { //current cycle ka node and woh node visited h.       YAHA PARENT KA CHAKKR NI H KYUKI DIRECTED GRAPH H
                    return true;
                }
                //return false; //visited hai, but woh current cycle ka hissa ni h node, islie return kar jayo.
                /**
                 * yeh line yaha ni rahegi.
                 *         addEdgeDirected(graph, 5, 3);
                 *         addEdgeDirected(graph, 3, 1);
                 *         addEdgeDirected(graph, 1, 2);
                 *         addEdgeDirected(graph, 2, 4);
                 *         addEdgeDirected(graph, 4, 0);
                 *
                 * 3 jab aayega, toh entry hui, else k andar wala if fail toh niche return hua lekin woh kabhi currentDFSCallVisitedNode[3] = false ni hua.
                 * 5 aayega, dfs(5) -> but visited[3] b raha and currentDFSCallVisitedNode[3] bhi true raha jabki woh false hona chaiyeh tha.
                 * **/
            }
        }
        currentDFSCallVisitedNode[vertice] = false;
        return false;


// thinking process: kya hua yaha pe, tm bfs se confuse ho gye jo tmne wrong jagah pe commented statements daale....
// dfs algo samj lo ache se.
// 3 -> 5: tmhre hisab se dfs(3) mai currentDFSCallVisitedNode[5]=0 hua, jab woh dfs(5) se return hua;
//          jabki hona ise dfs(5) mai hi tha.
    }

    private static void topologicalSortDFSUtil(List<List<Integer>> graph) {

        boolean[] visited = new boolean[graph.size()];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < graph.size(); i++)
            if (!visited[i]) {
                topologicalSortDFSStriver(graph, i, visited, stack);
            }

        int[] arr = new int[stack.size()];
        int j = 0;
        while (stack.size() > 0) {
            int k = stack.pop();
            arr[j++] = k;
        }

        Arrays.stream(arr).forEach(i -> System.out.print(i + ","));
    }

    private static Stack<Integer> topologicalSortDFSYourWay(List<List<Integer>> graph, int vertice, boolean[] visitedArray, Stack<Integer> stack) {

        visitedArray[vertice] = true;

        for (Integer neighbour : graph.get(vertice)) {
            if (!visitedArray[neighbour]) {
                topologicalSortDFSYourWay(graph, neighbour, visitedArray, stack); //yaha tum return ni laga skte ho, warna jab woh wapis hoga, recusion khatam hoga, toh current node add ni ho payega
                // 1 -> 2 :: 2 add ho jayega but 1 add ni ho payega.
            }
        }

        stack.add(vertice);
        return stack;
    }

    private static void topologicalSortDFSStriver(List<List<Integer>> graph, int vertice, boolean[] visitedArray, Stack<Integer> stack) {

        visitedArray[vertice] = true;

        for (Integer neighbour : graph.get(vertice)) {
            if (!visitedArray[neighbour]) {
                topologicalSortDFSStriver(graph, neighbour, visitedArray, stack);
            }
        }

        stack.add(vertice);
    }

    /***
     * Create the new indegree array. Indegree -> no. of edges to it.
     * Traverse through indegree array and whichever node has indegree 0, push all that nodes in the queue.
     * Do the BFS algorithm.
     * Decrease the indgree of the neighbour node by 1. If indegree becomes 0, then add to the queue.
     * 5 -> 0 <- 4
     * ↓         ↓
     * 2 -> 3 -> 1
     *
     * Why we are starting from 4 and 5 (indegree = 0), because we know that in the topological sort, 4 and 5 will appear 1st and thus with indgree 0 they dont have any dependencies ie. inke pehle koi nodes ni aayenge.
     * Why we decreasing the indgree by 1 for the neighbour nodes?
     *      Because: when we have visited them, we have noted the edge between u -> v (v is the neighbour here).
     *      eg: indegree(0) is 2. when we visited from 4, 4 -> 0, edge dekhli humne, toh indegree(0) ko decrease karo.
     *      when 5 -> 0, indegree(0) to decrease by 1.
     *
     * Intuition from GFG:
     * Topological sorting is a kind of dependencies problem so, we can start with the tasks which do not have any dependencies and can be done straight away or simply if we talk about in the term of node,
     *
     *We will always try to execute those nodes that have outdegree 0.
     *Then after execution of all those 0 outdegrees, we will execute which are directly dependent on currently resolved tasks (currently resolved tasks’ outdegrees will become 0 now) and so on will execute all other tasks.
     * */

    //ismai visitedArray ka koi concept ni hai
    private static void topologicalSortBFS(List<List<Integer>> graph) {
        int[] topoSort = new int[graph.size()];

        int[] indegree = new int[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.get(i).size(); j++)
                indegree[graph.get(i).get(j)]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        //Store ALL the nodes which have indegree value 0 to the queue.
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        int k = 0;
        while (queue.size() > 0) {
            int node = queue.remove();
            topoSort[k++] = node;

            for (int neighbour : graph.get(node)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0)
                    queue.add(neighbour);
            }
        }

        Arrays.stream(topoSort).forEach(i -> System.out.print(i + ","));
    }

    /**
     * If we aren't able to generate the topological sort then we can conclude that the graph has the cycle.
     * //ismai visitedArray ka koi concept ni hai
     */
    private static void detectCycleDirectedGraphBFS(List<List<Integer>> graph) {
        int[] indegree = new int[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.get(i).size(); j++)
                indegree[graph.get(i).get(j)]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        //Store ALL the nodes which have indegree value 0 to the queue.
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        int count = 0;
        while (queue.size() > 0) {
            int node = queue.remove();
            count++;
            for (int neighbour : graph.get(node)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0)
                    queue.add(neighbour);
            }
        }

        if (count != graph.size())
            System.out.print("Cycle is present");
        else
            System.out.print("Cycle is not a present");
    }

    /**
     * Shortest Path in undirected graph.
     * If weight is not given, then assume the weight to be 1 for all the edges.
     * We need to find the distance from source vertex to every vertex in the graph.
     * Take the distance array.
     * <p>
     * First step:
     * - add the node to the queue and distance[node] = 0
     * <p>
     * Iterate through the queue:
     * - pop the element from the queue.
     * - d = distance[node]
     * - Iterate through its neighbours
     * - new_distance = d + 1
     * - if new_distance < distance[neighbour]
     * - it means we have found the shorter distance to its neighbour.
     * - distance[neighbour] = new_distance
     * - queue.add(neighbour)
     * <p>
     * 0 - 1 - 3
     * \  |
     * 2
     * distance[Int.Max, Int.Max, Int.Max, Int.Max]
     * queue : 0
     * distance[0] = 0;
     * <p>
     * Iterate:
     * node = queue.remove() -> 0
     * d = distance[0] = 0
     * Neighbour:
     * 1
     * new_distance = d + 1 = 1
     * new_distance < distance[1]= Int.Max
     * distance[1] = new_distance
     * queue.add(1)
     * 2
     * new_distance = d + 1 = 1
     * new_distance < distance[1]= Int.Max
     * distance[2] = new_distance
     * queue.add(2)
     * <p>
     * Current State of Queue: [1,2]
     * distance[0,1,1,Int.Max]
     * <p>
     * node = queue.remove() -> 1
     * d = distance[1] = 1
     * Neighbour:
     * 0
     * new_distance = d + 1 = 2
     * new_distance < distance[0]=0 -> 2 < 0 -> False
     * THIS BASICALLY MEANS THAT THERE IS ALREADY A SHORTER PATH TO REACH THE NODE FROM THE SOURCE NODE.
     * 2
     * new_distance = d + 1 = 2
     * new_distance < distance[3]=0 -> 2 < 0 -> False
     * 3
     * new_distance = d + 1 = 2
     * new_distance < distance[3]= Int.Max
     * distance[3] = new_distance
     * queue.add(3)
     * <p>
     * ... similarly the case will be for 2 and 3.
     * <p>
     * BFS Algo ko modify kia hai. Hamesha yeh sequenetial order mai dekhta hai, meaning current_node + 1 (next immediate neighbours)
     */
    public static void shortestDistanceUndirectedGraphWithoutWeights(List<List<Integer>> graph, int noOfVertices, int src) {

        int distance[] = new int[noOfVertices];

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < noOfVertices; i++)
            distance[i] = Integer.MAX_VALUE;

        queue.add(src);
        distance[src] = 0; //distance to source itself will be 0.

        while (queue.size() > 0) {
            int node = queue.remove();
            int d = distance[node];

            for (Integer neighbour : graph.get(node)) {
                int new_distance = d + 1;
                if (new_distance < distance[neighbour]) {  //NEW SHORTER PATH FOUND
                    queue.add(neighbour);
                    distance[neighbour] = new_distance;
                } else {                                //SHORTER PATH ALREADY THERE from the source node.
                    continue;
                }
            }
        }

        Arrays.stream(distance).forEach(i -> System.out.print(i + ","));
    }

    /**
     * Spanning tree
     *  graph to tree such that it has N nodes and N-1 edges.
     *  every node is reachable via every other node.
     *  Graph can have multiple spanning trees.
     *
     * minimum spanning tree:
     *  among all the spanning trees possible from a graph, the spanning tree which has the minimum edge weight i.e.
     *      the sum of the weights of all the edges is minimum.
     *
     * **/


    //Prim's Algorithm
    /*
    * Keep on picking the minimal edges from the nodes.
    * Make sure cycle is not formed.
    * */


    public static void main(String[] args) {

        // List<List<Integer>> adjacencyList = constructAdjacencyList();
        // bfsUtil(adjacencyList);

//        List<List<Integer>> adjacencyList = constructAdjacencyLis1();
//        //dfsUtil(adjacencyList);
//        dfsUtilRecursion(adjacencyList);

        /*        List<List<Integer>> adjacencyList = constructAdjacencyListForBFSCycle();

        //cycleUtilBFS(adjacencyList);
        cycleUtilDFS(adjacencyList);*/


        //        List<List<Integer>> adjacencyList = constructAdjacencyListForBipartiteGraph();
//        bipartiteGraphBFS(adjacencyList);

//        List<List<Integer>> adjacencyList = constructAdjacencyListFordetectCycleDirectedGraphDFS();
//        detectCycleDirectedGraphUtilDFS(adjacencyList);

//        List<List<Integer>> adjacencyList = constructAdjacencyListForTopologicaSortDFS();
//        topologicalSortDFSUtil(adjacencyList);

        /*List<List<Integer>> adjacencyList = constructAdjacencyListForTopologicalSortBFS();
        topologicalSortBFS(adjacencyList);*/

        List<List<Integer>> adjacencyList = constructAdjacencyListForshortestDistanceUndirectedGraphWithoutWeights();
        shortestDistanceUndirectedGraphWithoutWeights(adjacencyList, adjacencyList.size(), 0);
    }

    private static List<List<Integer>> constructAdjacencyListForshortestDistanceUndirectedGraphWithoutWeights() {

        List<List<Integer>> graph = new ArrayList<>();
        int noOfVertices = 4;

        for (int i = 0; i < noOfVertices; i++) {
            graph.add(new ArrayList<>());
        }


        addEdgeUndirected(graph, 0, 1);
        addEdgeUndirected(graph, 1, 2);
        addEdgeUndirected(graph, 0, 2);
        addEdgeUndirected(graph, 1, 3);
        return graph;
    }


    private static List<List<Integer>> constructAdjacencyListForTopologicalSortBFS() {
        List<List<Integer>> graph = new ArrayList<>();
        int noOfVertices = 4;

        for (int i = 0; i < noOfVertices; i++) {
            graph.add(new ArrayList<>());
        }

//        addEdgeDirected(graph, 3, 0);
//        addEdgeDirected(graph, 1, 0);
//        addEdgeDirected(graph, 2, 0);

        addEdgeDirected(graph, 0, 1);
        addEdgeDirected(graph, 1, 2);
        addEdgeDirected(graph, 2, 3);

        return graph;
    }

    private static List<List<Integer>> constructAdjacencyListForTopologicaSortDFS() {
        List<List<Integer>> graph = new ArrayList<>();
        int noOfVertices = 7;

        for (int i = 0; i <= noOfVertices; i++) {
            graph.add(new ArrayList<>());
        }

        addEdgeDirected(graph, 6, 3);
        addEdgeDirected(graph, 7, 3);
        addEdgeDirected(graph, 6, 5);
        addEdgeDirected(graph, 3, 5);
        addEdgeDirected(graph, 7, 1);
        addEdgeDirected(graph, 1, 2);

//        addEdgeDirected(graph, 3, 0);
//        addEdgeDirected(graph, 1, 0);
//        addEdgeDirected(graph, 2, 0);


        return graph;
    }


    private static List<List<Integer>> constructAdjacencyListFordetectCycleDirectedGraphDFS() {
        List<List<Integer>> graph = new ArrayList<>();
//        int noOfVertices = 10;
//
//        for (int i = 1; i <= noOfVertices; i++) {
//            graph.add(new ArrayList<>());
//        }
//
//        addEdgeDirected(graph, 1, 2);
//        addEdgeDirected(graph, 2, 3);
//        addEdgeDirected(graph, 3, 4);
//        addEdgeDirected(graph, 4, 5);
//        addEdgeDirected(graph, 3, 6);
//        addEdgeDirected(graph, 6, 5);
//        addEdgeDirected(graph, 7, 2);
//        addEdgeDirected(graph, 7, 8);
//        addEdgeDirected(graph, 8, 9);
//        addEdgeDirected(graph, 9, 7);

        int noOfVertices = 6;

        for (int i = 0; i < noOfVertices; i++) {
            graph.add(new ArrayList<>());
        }

//        addEdgeDirected(graph, 5, 3);
//        addEdgeDirected(graph, 3, 8);
//        addEdgeDirected(graph, 8, 4);
//        addEdgeDirected(graph, 4, 2);
//        addEdgeDirected(graph, 2, 6);
//        addEdgeDirected(graph, 6, 0);
//        addEdgeDirected(graph, 0, 9);
//        addEdgeDirected(graph, 9, 1);
//        addEdgeDirected(graph, 1, 7);
//        addEdgeDirected(graph, 3, 1);
//        addEdgeDirected(graph, 0, 6);

        addEdgeDirected(graph, 5, 3);
        addEdgeDirected(graph, 3, 1);
        addEdgeDirected(graph, 1, 2);
        addEdgeDirected(graph, 2, 4);
        addEdgeDirected(graph, 4, 0);

        return graph;
    }

    private static List<List<Integer>> constructAdjacencyListForBipartiteGraph() {

        List<List<Integer>> graph = new ArrayList<>();
        int noOfVertices = 11;

        for (int i = 0; i < noOfVertices; i++) {
            graph.add(new ArrayList<>());
        }


        addEdgeUndirected(graph, 0, 1);
        addEdgeUndirected(graph, 1, 2);
        addEdgeUndirected(graph, 2, 3);
        addEdgeUndirected(graph, 2, 6);
        addEdgeUndirected(graph, 3, 4);
        addEdgeUndirected(graph, 6, 7);
        addEdgeUndirected(graph, 4, 8);
        addEdgeUndirected(graph, 7, 8);
        addEdgeUndirected(graph, 8, 9);
        addEdgeUndirected(graph, 9, 10);

//        addEdgeUndirected(graph, 2,5);
//        add(addEdgeUndirected, 5,8);

        return graph;
    }

    private static List<List<Integer>> constructAdjacencyListForBFSCycle() {

        List<List<Integer>> adjacencyList = new ArrayList<>();

        int noOfVertices = 8;

        for (int i = 0; i < noOfVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        addEdgeUndirected(adjacencyList, 0, 1);
        //add(graph, 1, 4);
        addEdgeUndirected(adjacencyList, 1, 2);
        addEdgeUndirected(adjacencyList, 2, 3);
        addEdgeUndirected(adjacencyList, 3, 6);
        addEdgeUndirected(adjacencyList, 4, 5);
        addEdgeUndirected(adjacencyList, 5, 6);
        addEdgeUndirected(adjacencyList, 5, 3);
        addEdgeUndirected(adjacencyList, 6, 7);

//        int v = 11; // number of vertices
//
//        for (int i = 0; i <= v; i++)
//            adjacencyList.add(new ArrayList<>());
//
//        addEdgeUndirected(adjacencyList, 1, 2);
//        addEdgeUndirected(adjacencyList, 2, 4);
//        addEdgeUndirected(adjacencyList, 3, 5);
//        addEdgeUndirected(adjacencyList, 5, 10);
//        addEdgeUndirected(adjacencyList, 5, 6);
//        addEdgeUndirected(adjacencyList, 6, 7);
//        addEdgeUndirected(adjacencyList, 10, 9);
//        addEdgeUndirected(adjacencyList, 9, 8);
//        addEdgeUndirected(adjacencyList, 7, 8);
//        addEdgeUndirected(adjacencyList, 8, 11);

        return adjacencyList;
    }

    private static List<List<Integer>> constructAdjacencyLis1() {

        List<List<Integer>> adjacencyList = new ArrayList<>();

        int v = 7; // number of vertices

        for (int i = 0; i <= v; i++)
            adjacencyList.add(new ArrayList<>());

        addEdgeUndirected(adjacencyList, 1, 2);
        addEdgeUndirected(adjacencyList, 2, 4);
        addEdgeUndirected(adjacencyList, 2, 7);
        addEdgeUndirected(adjacencyList, 4, 6);
        addEdgeUndirected(adjacencyList, 6, 7);
        addEdgeUndirected(adjacencyList, 3, 5);

        return adjacencyList;
    }

    private static List<List<Integer>> constructAdjacencyList() {

        List<List<Integer>> adjacencyList = new ArrayList<>();

        int v = 7; // number of vertices

        for (int i = 0; i <= v; i++)
            adjacencyList.add(new ArrayList<>());

        addEdgeUndirected(adjacencyList, 1, 2);
        addEdgeUndirected(adjacencyList, 2, 3);
        addEdgeUndirected(adjacencyList, 2, 7);
        addEdgeUndirected(adjacencyList, 3, 5);
        addEdgeUndirected(adjacencyList, 5, 7);
        addEdgeUndirected(adjacencyList, 4, 6);

        return adjacencyList;
    }

    private static void addEdgeUndirected(List<List<Integer>> adjacencyList, int u, int v) {  //undirected graph
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);
    }

    private static void addEdgeDirected(List<List<Integer>> adjacencyList, int u, int v) {  //directed graph
        adjacencyList.get(u).add(v);
    }

    static class CycleClassBFS {
        int currentNode;
        int previousNode;

        CycleClassBFS(int currentNode, int previousNode) {
            this.currentNode = currentNode;
            this.previousNode = previousNode;
        }
    }

    static class ColorNode {
        int currentNode;
        String color;

        public ColorNode(int currentNode, String color) {
            this.currentNode = currentNode;
            this.color = color;
        }
    }

}

//bfs
//construct a visiting array
//see if the node is not visited.
//add to the queue.
//Mark it visited
//pop the element from queue.
//iterate while queue not empty
//check for the neighbour 
//- if not visited add to the queue and mark it visited
//- else ignore

//dfs
//construct a visiting array
//see if the node is not visited.
//add to the stack. Mark it visited
//pop the element from stack.
//iterate while stack not empty
//check for the neighbour
//- if not visited add to the stack and mark it visited
//- else ignore
