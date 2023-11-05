public class Mainthree {


    public static void main(String[] args) {

        TreeNode seven = new TreeNode(-7);
        TreeNode fifteen = new TreeNode(-15);
        TreeNode twenty = new TreeNode(-20);
        TreeNode ten = new TreeNode(-10);
        TreeNode nine = new TreeNode(90);

        twenty.left = fifteen;
        twenty.right = seven;

        ten.right = twenty;
        ten.left = nine;

        int val = maxPathSum(ten);
        System.out.println(val);
    }

    public static int maxPathSum(TreeNode root) {

        int maxValue[] = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        abcd(root,maxValue);
        return maxValue[0];
    }

    public static int abcd(TreeNode node, int[] maxValue) {
        if (node == null) //left node....
            return 0;
        int leftSum = Math.max(0, abcd(node.left, maxValue));
        int rightSum = Math.max(0, abcd(node.right, maxValue));

        maxValue[0] = Math.max(maxValue[0], leftSum+rightSum+node.val);

        return Math.max(leftSum, rightSum) + node.val;
    }


    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(TreeNode left,  TreeNode right, int val){
            this.left = left;
            this.right = right;
            this.val = val;
        }

        TreeNode(int val){
            this.val = val;
        }
    }
}
