/**
 * @author yulinsheng
 * @time 2021-04-23 11:18
 */

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 */
public class Offer28 {

}


class Solution28{
    public boolean isSymmetric(TreeNode root) {
        /**
         * [1,2,2,3,4,4,3]例子，上述为对称二叉树
         * 思路分析，不能简单的上来看成左右子树相等即可，因为需要考虑子树的下面，左子树的右节点和右子树的左节点相等。
         * 简单的来讲对称二叉树基本满足
         * L.val = R.val
         * L.left.val = R.right.val
         * L.right.val = R.left.val
         * 特殊条件root == null或者 仅仅有一个根节点。
         *
         *
         * 利用递归操作
         */
        if(root == null){
            return false;
        }//没有根节点也是对称二叉树
        return recur(root.left,root.right);


    }
    boolean recur(TreeNode L,TreeNode R){
        if(L == null && R == null){return true;} //同时没有叶子节点了
        //三种种情况，
        // 一个没有叶子节点一个有，不会出现同时没有叶子节点的情况，因为上述情况已经判断过了
        // 两个都存在叶子节点，但是值不等，此时直接返回false
        if(L == null || R == null || L.val != R.val){return false;}
        //上面已经判断了val的值相等，下面就进行递归操作即可。
        return recur(L.left,R.right)&&recur(L.right,R.left);
    }
}