package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Tree.BST.Node;

class BST {
    
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right= right;
        }

        Node(int data){
            this.data = data;
        }
    }

    static Node addNodeRecursion(Node node, int value){

        if (node == null)
            return new Node(value);

        if (value > node.data)
            node.right = addNodeRecursion(node.right, value);
        else if (value < node.data)
            node.left = addNodeRecursion(node.left, value);
       
        return node; //wapsi mai use hoga(jab addition ho gya hai, and recursive fn ke result aa rhe hai, toh yahi se return hoga)
    }

    static void inOrderTraversal(Node node){

        if (node == null)
            return;

        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }

    static void preOrderTraversal(Node node){

        if (node == null)
            return;

        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    static Node delete(Node node, int value){

        if (node == null)
            return null;

        if (value > node.data)
            node.right = delete(node.right, value);
        else if (value < node.data)
            node.left = delete(node.left, value);
        else {

            //no child of the node to be deleted.
            if (node.left == null && node.right == null)
                return null;

            //when node to be deleted has 1 child    
            if ((node.left != null && node.right == null))  //node has left child
                return node.left;
            if ((node.left == null && node.right != null))  //node has right child
                return node.right;

            //when node to be deleted has 2 children
            int leftSubtreeMax = max(node.left);  //finding out the max value in the left subtree
            node.data = leftSubtreeMax;    // replacing the node to be deleted with the leftSubtree max
            node.left = delete(node.left, leftSubtreeMax);  // deleting the leftSubtree max reference from its original parent.

            return node;
        }
        
        return node; //wapsi mai use hoga (jab deletion ho gya hai, and recursive fn ke result aa rhe hai, toh yahi se return hoga)
    }

    private static int max(Node node){

        if(node.right == null)
            return node.data;

        return max(node.right);
    }

    static Node sortedArrayToBST(int[] arr, int start, int end){

        if (start > end)
            return null;

        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);

        root.left = sortedArrayToBST(arr, start, mid-1);
        root.right = sortedArrayToBST(arr, mid+1, end);

        return root; //wapsi ke samay
    }

    static List<Integer> inOrderTraversal(Node node, List<Integer> list){

        if (node == null)
            return list;

        inOrderTraversal(node.left, list);
        list.add(node.data);
        inOrderTraversal(node.right, list);

        return list;
    }

    static Node createBalancedBST(Node root){

        List<Integer> list = new ArrayList<>();
        list = inOrderTraversal(root, list);
        
        int[] arr = new int[list.size()];
        for (int i = 0 ; i < list.size(); i++)
            arr[i] = list.get(i);
        
        root = sortedArrayToBST(arr, 0, list.size()-1);
        return root;
    }



    public static void main(String[] args) {
        
        //Node head = tree1();
        // inOrderTraversal(head);
        // System.out.println();
        // head = delete(head, 50);
        // inOrderTraversal(head);

        //===

        // int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        // Node root = sortedArrayToBST(arr, 0 , arr.length-1); //intially you send sortedArrayToBST(arr, 0, arr.lenght)
        //                                         // we got OutOfBoundException when we were setting the rightnode of node 7
        //                                         // at that moment, the value of mid was 7 and end was 7, thus mid = 7 which is out of bound of it.
        // preOrderTraversal(root);

        //===
        // List<Integer> list = new ArrayList<>();
        // list = inOrderTraversal(head, list);
        // System.out.println("Sorted List:" + list);

        //===
        // Node head = unbalancedTree();
        // inOrderTraversal(head);
        // head = createBalancedBST(head);
        // System.out.println();
        // preOrderTraversal(head);

        //===
        Node head = tree2();
        BStIterator bStIterator = new BStIterator(head);
        System.out.println("value:"+ bStIterator.next());
        System.out.println("value:"+ bStIterator.next());
        System.out.println("value:"+ bStIterator.next());
        System.out.println("hasNext:"+ bStIterator.hasNext());
        System.out.println("value:"+ bStIterator.next());
        System.out.println("value:"+ bStIterator.next());
        System.out.println("value:"+ bStIterator.next());
        System.out.println("value:"+ bStIterator.next());
        System.out.println("value:"+ bStIterator.next());
        System.out.println("value:"+ bStIterator.next());
        System.out.println("value:"+ bStIterator.next());
        System.out.println("hasNext:"+ bStIterator.hasNext());
    }

    private static Node unbalancedTree() {

        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node ten = new Node(10);

        six.left = five;
        seven.left = six;
        eight.left = seven;
        ten.left = eight;

        return ten;
    }

    private static Node tree2() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine = new Node(9);
        Node ten = new Node(10);

        two.left = one;
        three.left = two;

        five.left = four;
        six.left = five;
        three.right = six;

        nine.left = eight;
        ten.left = nine;

        seven.left = three;
        seven.right = ten;

        return seven;
    }

    private static Node tree1(){

        Node fifty = new Node(50);
        Node thirty = new Node(30);
        Node seventy = new Node(70);
        Node fourty = new Node(40);
        Node sixty = new Node(60);
        Node eighty = new Node(80);

        thirty.right = fourty;
        seventy.left = sixty;
        seventy.right = eighty;

        fifty.left = thirty;
        fifty.right = seventy;

        return fifty;
    }

}

class BStIterator {

    Stack<Node> stack = new Stack<>();

    BStIterator(Node node) {
        constructorFull(node);
    }

    private void constructorFull(Node node){
        if(node == null)
            return;

        stack.push(node);
        constructorFull(node.left);
    }

    boolean hasNext(){
        return stack.size() > 0;
    }

    int next() {
        Node node = stack.pop();
        if (node.right != null)  {
            constructorFull(node.right);
        }
        return node.data;
    }
}
