/**
 * @author yulinsheng
 * @time 2021-04-27 10:03
 */
/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树: root =[6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 *
 *  二叉搜索树：
 *  若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 *  若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 *  中序遍历是一个递增的：如上述树的中序遍历
 *  0 2 3 4 5 6 7 8 9
 */
public class Offer68_I {

}
class Solution68_I {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * 由于搜索树的中序遍历存在顺序，因此我们可以考虑迭代法.
         * 思路：当root的值大于p和q的值时，可以知道根节点在root的左侧，左侧值小于根节点。
         * 当root的值小于p和q的值时，可以知道根节点在root的右侧，右侧值大于根节点的值。
         *
         * 执行用时：6 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：39.1 MB, 在所有 Java 提交中击败了70.83%的用户
         */

//        while(root != null){
//            if(root.val > Math.max(p.val,q.val)){
//                root = root.left;//当val大于p,q的值，则在root的左侧子树
//            }
//            else if(root.val < Math.min(p.val,q.val)){
//                root = root.right;//当val小于p,q的值，则在root的右侧子树。
//            }
//            else{
//                break;//一旦p ,q在root的左右两侧（或者root.val = p.val或q.val），返回结果。
//            }
//        }
//        return root;

        /**
         * 递归法同样适用,同样是利用搜索二叉树的性质，判断处于左子树还是右子树。
         * 执行用时：6 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：39.3 MB, 在所有 Java 提交中击败了28.93%的用户
         */
        if(root.val > Math.max(p.val,q.val)){
            return lowestCommonAncestor(root.left,p,q);//调用左子树递归
        }
        if(root.val < Math.min(p.val,q.val)){
            return lowestCommonAncestor(root.right,p,q);//调用右子树递归
        }
        return root;//当val值等于p或q的值或者p,q位于root的两边时返回结果

    }
}