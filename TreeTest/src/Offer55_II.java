/**
 * @author yulinsheng
 * @time 2021-05-07 18:45
 */

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 *
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer55_II {
}

class SolutionOffer55_II {
    public boolean isBalanced(TreeNode root) {

    if (depth(root) >1){
        return false;
    }
    if(root.left != null)
    isBalanced(root.left);
    if(root.right!=null)
    isBalanced(root.right);
    return true;


    }
    public int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        int maxLeft = depth(root.left);
        int maxRight = depth(root.right);
        return Math.abs(maxLeft - maxRight);
    }
}