package Questions;

public class Q2Paytm {

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        Node (int value) {
            this.value = value;
        }

    }
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//
//        int arr[] = {1,2,3,4,5,6};
//        //Output: [6,3,8,15,24,20];
//
//        //Minimum length is 3.
//
//        int prev = arr[0];
//        int second_last = arr[arr.length - 3];
//
//        //1st element
//        arr[0] = arr[1] * arr[2];
//        //{1,2,3,4,5,6};
//
//        //[2,3,4,5]
//        for (int i = 1 ; i < arr.length -1 ; i++) {
//
//            int curr = arr[i];
//            arr[i] = prev * arr[i+1];
//            prev = curr;
//        }
//        //last element
//        arr[arr.length - 1]  = prev * second_last;
//
//        for (int i = 0 ; i < arr.length; i++) {
//            System.out.print(arr[i] + ", ");
//        }


//        Node one = new Node(1);
//        Node two = new Node(2);
//        Node three = new Node (3);
//        Node four = new Node(4);
//        Node five  = new Node(5);
//        Node six = new Node(6);
//        Node seven = new Node(7);
//        Node one1 = new Node(1);

//        two.left = four;
//        two.right = five;
//        three.left = six;
//        three.right = seven;
//        one.left = two;
//        one.right = three;

//        two.left = one;
//        two.right = three;
//        six.left = five;
//        six.right = one1;
//        four.left = two;
//        four.right = six;
//
//        //System.out.println(isBST(one));
//        System.out.println(isBST(four));

        int[][] arr = new int[][]{{1,2,3}, {4,5,6}, {7,8,9},{10,11,12}};
        int i , j;
        int[][] arrAns = new int[arr[0].length][arr.length];

        for ( i = 0 ; i < arr.length; i++) {
            for (j = 0 ; j < arr[i].length; j++) {
                arrAns[i][j] = arr[j][i];
            }
        }

        for ( i = 0 ; i < arrAns.length; i++) {
            for (j = 0 ; j < arrAns[i].length; j++) {
                System.out.print(arrAns[i][j] + ",");
            }
            System.out.println();
        }

    }

    static boolean isBST(Node root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && maxValue(root.left) > root.value)
            return false;
        if (root.right != null && minValue(root.right) < root.value)
            return false;

        if (isBST(root.left) == false || isBST(root.right) == false)
            return false;
        return true;
    }

    static int maxValue(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        int value = node.value;
        int leftChild = maxValue(node.left);
        int rightChild = maxValue(node.right);
        return Math.max(value, Math.max(leftChild, rightChild));
    }
    static int minValue(Node node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        int value = node.value;
        int leftChild = minValue(node.left);
        int rightChild = minValue(node.right);
        return Math.min(value, Math.min(leftChild, rightChild));
    }
}


//                       1
//                2           3
//              4   5       6    7
//
//
//                                4
//                             2      6
//                           1   3  5   1



//[[1, 2, 3,
// [4, 5, 6],
// [7, 8, 9],
// [10,11,12]]
//
//
//
//
//[[1,4,7,10],
// [2,5,8,11]
// [3,6,9,12]]
//
//
//
//1, 2, 3, 4
//5, 6, 7, 8
//9,10,11,12
//
//1,5,9
//2,6,10
//3,7,11
//4,8,12
