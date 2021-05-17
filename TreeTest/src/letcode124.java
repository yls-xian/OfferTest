public class letcode124 {
}

class Solution124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        globalMax(root);
        return max;

    }
    public int globalMax(TreeNode node){
        if(node == null){return 0;}

        int left = globalMax(node.left);
        int right = globalMax(node.right);
        left = Math.max(left,0);
        right = Math.max(right,0);
        max = Math.max(max,left+right+node.val);
        return Math.max(left+node.val,right+node.val);

    }

}