package Tree;

class Node {
    int data;
    Node left, right;
 
    Node(int item) {
        data = item;
        left = right = null;
    }
}
 
// An object of Res is passed around so that the
// same value can be used by multiple recursive calls.
class Res {
    int val;
}
 
class maxPathFromLeafToLeaf {
    static Node root;
 
    int maxPathSumUtil(Node node, Res res) {

        if (node == null)
            return 0;

        int l = maxPathSumUtil(node.left, res);
        int r = maxPathSumUtil(node.right, res);

        int temp = 0;
        if (node.left == null && node.right == null){
            temp = Math.max(Math.max(l, r) + node.data, node.data);
        } else {
            temp = Math.max(l, r) + node.data;
        }

        int ans = Math.max(temp, l+r+node.data);

        res.val = Math.max(res.val, ans);

        return temp;
    }
 
    int maxPathSum() {
        Res res = new Res();
        res.val = Integer.MIN_VALUE;
 
        int val = maxPathSumUtil(root, res);
       
        if (root.left != null && root.right != null)
            return res.val;
        else {
               //--- for test case ---
               //         7                 
              //        /    \               
                //    Null   -3                    
              // value of res will be INT_MIN but the answer is 4, 
              // which is returned by the function maxPathSumUtil()
              return Math.max(res.val,val);
        }
    }
 
    //Driver program to test above functions
    public static void main(String args[]) {
        maxPathFromLeafToLeaf tree = new maxPathFromLeafToLeaf();
        tree.root = new Node(-15);
        tree.root.left = new Node(5);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(-8);
        tree.root.left.right = new Node(1);
        tree.root.left.left.left = new Node(2);
        tree.root.left.left.right = new Node(6);
        tree.root.right.left = new Node(3);
        tree.root.right.right = new Node(9);
        tree.root.right.right.right = new Node(0);
        tree.root.right.right.right.left = new Node(4);
        tree.root.right.right.right.right = new Node(-1);
        tree.root.right.right.right.right.left = new Node(10);
     
        System.out.println("Max pathSum of the given binary tree is "
                + tree.maxPathSum());
    }
}