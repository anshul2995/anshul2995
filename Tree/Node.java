package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

class TreeNode {

    int data;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int data) {
        this.data = data;
    }

    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    // left root right
    static void inOrderTraversal(TreeNode node) {

        if (node == null)
            return;

        inOrderTraversal(node.left);
        System.out.print(node.data + ",");
        inOrderTraversal(node.right);
    }

    //root left right
    static void preOrderTraversal(TreeNode node) {

        if (node == null)
            return;

        System.out.print(node.data + ",");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    //left right root
    static void postOrderTraversal(TreeNode node) {

        if (node == null)
            return;

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + ",");
    }

    static int maxDepthOrHeight(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftHeight = maxDepthOrHeight(node.left);
        int rightHeight = maxDepthOrHeight(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    static int checkForBalanceBT(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftHeight = checkForBalanceBT(node.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = checkForBalanceBT(node.right);
        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return 1 + Math.max(leftHeight, rightHeight);
    }

    static void levelOrderTraversal(TreeNode node) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(node);
        while (!q.isEmpty()) {
            TreeNode n = q.remove();
            System.out.print(n.data + ",");
            if (n.left != null) {
                q.add(n.left);
            }
            if (n.right != null) {
                q.add(n.right);
            }
        }
    }

    //The above implementation can be optimized by calculating the height in the same recursion rather than calling a height() separately
    static int diameter(TreeNode node, int[] diameter) {

        if (node == null)
            return 0;


        int leftHeight = diameter(node.left, diameter);
        int rightHeight = diameter(node.right, diameter);

        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);  //diameter[0] will be acting as a global variable.

        return 1 + Math.max(leftHeight, rightHeight);
    }

    static List<Integer> zigZagTraversal(TreeNode root) {

        if (root == null)
            return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean level = false;   // false -> L to R,    true -> R to L
        List<Integer> ans = new ArrayList<>();

        while (queue.size() > 0) {
            int size = queue.size(); //traverse all the nodes in a particular level.
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();

                temp.add(node.data);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            if (level)
                Collections.reverse(temp);

            ans.addAll(temp);
            level = !level;
        }
        return ans;
    }

    static List<Integer> boundryLevelTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        if (root == null)
            new ArrayList<>();

        if (checkIfLeaf(root)) {
            list.add(root.data);
            return list;
        }

        list.add(root.data);

        //left boundry traversal excluding the leaf node
        leftBoundryTraversal(root.left, list);

        //leaf node traversal
        addLeafNode(root, list);

        //right boundry traversal excluding the leaf node
        addRightNode(root.right, list);

        return list;
    }

    private static boolean checkIfLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private static void leftBoundryTraversal(TreeNode node, List<Integer> ans) {
        while (true) {

            if (node == null || checkIfLeaf(node))
                break;

            ans.add(node.data);
            node = node.left == null ? node.right : node.left;
        }
    }

    private static void addLeafNode(TreeNode node, List<Integer> ans) {
        if (node == null)
            return;

        if (checkIfLeaf(node)) {
            ans.add(node.data);
            return;
        }

        addLeafNode(node.left, ans);
        addLeafNode(node.right, ans);
    }

    private static void addRightNode(TreeNode node, List<Integer> ans) {
        List<Integer> stack = new ArrayList<>();
        while (true) {

            if (node == null || checkIfLeaf(node))
                break;

            stack.add(node.data);
            node = node.right == null ? node.left : node.right;
        }

        Collections.reverse(stack);
        ans.addAll(stack);
    }

    static class Tuple {
        TreeNode node;
        int vertical;
        int level;

        Tuple(TreeNode node, int vertical, int level) {
            this.node = node;
            this.vertical = vertical;
            this.level = level;
        }
    }

    static List<List<Integer>> verticalOrderTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();

        queue.add(new Tuple(root, 0, 0));

        while (queue.size() > 0) {
            Tuple tuple = queue.remove();

            TreeNode node = tuple.node;
            int vertical = tuple.vertical;
            int level = tuple.level;

            if (!map.containsKey(vertical))
                map.put(vertical, new TreeMap<>());

            if (!map.get(vertical).containsKey(level))
                map.get(vertical).put(level, new PriorityQueue<>());

            map.get(vertical).get(vertical).add(node.data);

            if (node.left != null)
                queue.add(new Tuple(node.left, vertical - 1, level + 1));

            if (node.right != null)
                queue.add(new Tuple(node.right, vertical + 1, level + 1));
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> levels : map.values()) {
            ans.add(new ArrayList<>());
            for (PriorityQueue<Integer> values : levels.values()) {
                while (values.size() > 0) {
                    ans.get(ans.size() - 1).add(values.remove());
                }
            }
        }
        return ans;
    }

    static class Pair {
        TreeNode node;
        int vertical;

        Pair(TreeNode node, int vertical) {
            this.node = node;
            this.vertical = vertical;
        }
    }

    static List<Integer> topView(TreeNode root) {

        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer, TreeNode> map = new TreeMap<>();

        queue.add(new Pair(root, 0));

        while (queue.size() > 0) {
            Pair tuple = queue.remove();
            TreeNode node = tuple.node;
            int vertical = tuple.vertical;

            if (!map.containsKey(vertical))
                map.put(vertical, node);

            if (node.left != null)
                queue.add(new Pair(node.left, vertical - 1));

            if (node.right != null)
                queue.add(new Pair(node.right, vertical + 1));
        }

        List<Integer> ans = new ArrayList<>();

        for (TreeNode node : map.values()) {
            ans.add(node.data);
        }

        return ans;
    }

    static List<Integer> bottomView(TreeNode root) {

        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer, TreeNode> map = new TreeMap<>();

        queue.add(new Pair(root, 0));

        while (queue.size() > 0) {
            Pair pair = queue.remove();
            TreeNode node = pair.node;
            int vertical = pair.vertical;

            map.put(vertical, node);

            if (node.left != null)
                queue.add(new Pair(node.left, vertical - 1));

            if (node.right != null)
                queue.add(new Pair(node.right, vertical + 1));
        }

        List<Integer> ans = new ArrayList<>();
        for (TreeNode node : map.values()) {
            ans.add(node.data);
        }

        return ans;
    }

    static void rightViewRecursion(TreeNode node, List<Integer> ans, int level) {
        if (node == null)
            return;

        if (level == ans.size())
            ans.add(node.data);

        rightViewRecursion(node.right, ans, level + 1);
        rightViewRecursion(node.left, ans, level + 1);
    }

    static void rightViewIteration(TreeNode root) { // iteration using the level order traversal

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();

        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) // visiting every nodes at a particular level.
            {
                TreeNode node = queue.remove();

                if (i == size - 1)  //uring level order traversal ,we had one size variable which tells the size of queue at each level so if i==size-1; 
                    //then that element is the last element of that level so we can push it into the data structure
                    list.add(node.data);

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }
        }
        System.out.println("Right view of the tree");
        list.stream().forEach(i -> System.out.print(i + " "));
    }

    static void leftViewRecursion(TreeNode node, List<Integer> ans, int level) {
        if (node == null)
            return;

        if (level == ans.size())
            ans.add(node.data);

        leftViewRecursion(node.left, ans, level + 1);
        leftViewRecursion(node.right, ans, level + 1);
    }

    static void leftViewIteration(TreeNode root) { // iteration using the level order traversal

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();

        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) // visiting every nodes at a particular level.
            {
                TreeNode node = queue.remove();

                if (i == 0)  //uring level order traversal ,we had one size variable which tells the size of queue at each level so if i==0; 
                    //then that element is the 1st element of that level so we can push it into the data structure.
                    list.add(node.data);

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }
        }
        System.out.println("Left view of the tree");
        list.stream().forEach(i -> System.out.print(i + " "));
    }

    static TreeNode LCA(TreeNode node, TreeNode p, TreeNode q) {

        if (node == null)
            return null;

        if (node.data == p.data || node.data == q.data)
            return node;

        TreeNode left = LCA(node.left, p, q);
        TreeNode right = LCA(node.right, p, q);

        if (left != null && right != null)
            return node;
        if (left != null && right == null)
            return left;
        if (left == null && right != null)
            return right;

        return null; //when (left == null && right == null)
    }

    // self did it.
    static TreeNode rootToNodePath(TreeNode node, TreeNode p, List<Integer> list) {

        if (node == null)
            return null;

        if (node.data == p.data) {
            list.add(node.data);
            return node;
        }

        TreeNode left = rootToNodePath(node.left, p, list);
        TreeNode right = rootToNodePath(node.right, p, list);

        if (left != null && right == null) {
            list.add(node.data);
            return left;
        }

        if (left == null && right != null) {
            list.add(node.data);
            return right;
        }

        return null;
    }

//    public static TreeNode invertTree(TreeNode root) {
//
//        if (root != null && root.left != null && root.right != null) {
//            TreeNode temp = root.left;
//            root.left = root.right;
//            root.right = temp;
//        }
//        if (root != null && root.left != null)
//            invertTree(root.left);
//
//        if (root != null && root.right != null)
//            invertTree(root.right);
//
//        return root;
//    }


    public static void main(String[] args) {
        //TreeNode head = tree();

        // inOrderTraversal(head);
        // System.out.println();
        // preOrderTraversal(head);
        // System.out.println();
        // postOrderTraversal(head);
        // System.out.println();
        //levelOrderTraversal(head);

        //System.out.println("max height of the tree:" + maxDepthOrHeight(head));


        // int[] d = new int[1];
        // diameter(head, d);
        // System.out.println("diameter of the tree:" + d[0]);
        // System.out.println("max height of the tree:" + diameter(head, d));

        //TreeNode head = tree2();
        //System.out.println("Zigzag traversal:" + zigZagTraversal(head));

        // TreeNode head = tree3();
        // System.out.println("Boundrylevel traversal:" + boundryLevelTraversal(head));

        // TreeNode head = tree4();
        // System.out.println("verticallevel traversal:" + verticalOrderTraversal(head));

        // TreeNode head = tree5();
        // System.out.println("topview of the tree:" + topView(head));

        // TreeNode head = tree6();
        // System.out.println("bottomview of the tree:" + bottomView(head));

        //TreeNode head = tree7();
        // List<Integer> list = new ArrayList<>();
        // rightViewRecursion(head, list, 0);
        // System.out.println("right view of the tree:"+ list);

        //rightViewIteration(head);

        // List<Integer> list = new ArrayList<>();
        // leftViewRecursion(head, list, 0);
        // System.out.println("left view of the tree:"+ list);

        //leftViewIteration(head);   

        TreeNode head = tree8();
        //System.out.println("LCA:" + LCA(head, new TreeNode(4), new TreeNode(7)).data);
        //System.out.println("LCA:" + LCA(head, new TreeNode(5), new TreeNode(9)).data);

//        List<Integer> list = new ArrayList<>();
//        rootToNodePath(head, new TreeNode(7), list);
//        Collections.reverse(list);
//        System.out.println("Path:" + list);

        head = treeInvertBinaryTree();
        //invertTree(head);
    }

    static TreeNode tree8() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
        TreeNode nine = new TreeNode(9);

        five.left = six;
        five.right = seven;

        two.left = four;
        two.right = five;

        three.left = eight;
        three.right = nine;

        one.left = two;
        one.right = three;

        return one;
    }

    static TreeNode tree7() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);

        five.left = six;
        two.left = four;
        two.right = five;

        three.right = seven;
        one.left = two;
        one.right = three;

        return one;
    }

    static TreeNode tree6() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
        TreeNode nine = new TreeNode(9);

        five.left = eight;
        six.right = nine;

        two.left = four;
        two.right = five;

        three.left = six;
        three.right = seven;

        one.left = two;
        one.right = three;

        return one;
    }

    static TreeNode tree5() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);

        five.left = six;
        two.left = four;
        two.right = five;
        three.right = seven;

        one.left = two;
        one.right = three;

        return one;
    }

    static TreeNode tree4() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode nine = new TreeNode(9);
        TreeNode ten = new TreeNode(10);
        TreeNode ten1 = new TreeNode(10);

        five.right = six;
        four.right = five;

        two.left = four;
        two.right = ten;

        three.left = nine;
        three.right = ten1;

        one.left = two;
        one.right = three;

        return one;
    }

    static TreeNode tree3() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
        TreeNode nine = new TreeNode(9);
        TreeNode ten = new TreeNode(10);
        TreeNode eleven = new TreeNode(11);
        TreeNode twelve = new TreeNode(12);
        TreeNode thirteen = new TreeNode(13);

        nine.left = ten;
        nine.right = eleven;
        eight.left = nine;
        eight.right = thirteen;
        seven.right = eight;

        four.left = five;
        four.right = six;
        three.left = twelve;
        three.right = four;
        two.left = three;

        one.left = two;
        one.right = seven;

        return one;
    }

    static TreeNode tree() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);

        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;
        one.left = two;
        one.right = three;

        return one;
    }

    static TreeNode tree1() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
        TreeNode nine = new TreeNode(9);

        seven.right = eight;
        six.right = seven;
        five.left = nine;
        four.left = five;

        three.left = four;
        three.right = six;

        one.left = two;
        one.right = three;


        return one;
    }

    static TreeNode tree2() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);


        two.left = four;
        two.right = five;
        three.right = six;
        one.left = two;
        one.right = three;

        return one;
    }

    static TreeNode treeInvertBinaryTree() {
        TreeNode four = new TreeNode(4);
        TreeNode two = new TreeNode(2);
        TreeNode seven = new TreeNode(7);
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        TreeNode nine = new TreeNode(9);

        four.left = two;
        four.right = seven;
        two.left = one;
        two.right = three;
        seven.left = six;
        seven.right = nine;

        return four;
    }
}
