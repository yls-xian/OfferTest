/**
 * @author yulinsheng
 * @time 2021-04-26 21:04
 */

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：
 * 对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
 *
 * 例如，给定如下二叉树:root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。

 *

 */
public class Offer68_II {
}

class Solution68_II {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * 利用递归法查找（思路理解有点困难）
         */
//        if(root == null) return null;//如果树为空则返回null
//        if(root == p || root == q){return root;} // 如果p,q中有等于root的，那么公共祖先即为root
//        TreeNode left = lowestCommonAncestor(root.left,p,q);//遍历左子树，只要在左子树中找到p或者q,先找到谁就返回谁
//        TreeNode right = lowestCommonAncestor(root.right,p,q);//遍历右子树，只要在右子树中找到p或者q，先找到谁就返回谁
//        if(left == null) return right;//如果左子树没有的话就返回右子树
//        if(right == null) return left;//如果右子树没有就返回左子树
        return root;

        /**
         * 利用迭代法
         */
//        while(root != null){
//            if()
//        }

    }
}