/**
 * @author yulinsheng
 * @time 2021-04-26 15:47
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 *
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 */
public class Offer54 {
}
class Solution54{

    /**
     * 想法1，直接递归获得树的所有节点，然后排列，获得最后的倒数节点值即可。
     *
     * 执行用时：5 ms, 在所有 Java 提交中击败了5.80%的用户
     * 内存消耗：39.4 MB, 在所有 Java 提交中击败了5.01%的用户
     */

//    public int kthLargest(TreeNode root, int k) {
//        List<Integer> list = new ArrayList<Integer>();
//        findnum(root,list);
//        Collections.sort(list);//将获得的节点值排序
//        Object [] res = list.toArray();//转换为数组类型
//        return (int)res[res.length-k];//返回倒数的值
//
//    }
//    //前序遍历获得节点值
//    public void findnum(TreeNode root,List<Integer> list){
//        if(root == null){
//            return;
//        }
//        list.add(root.val);
//        findnum(root.left,list);
//        findnum(root.right,list);
//    }


    /**
     * 二叉搜索树的性质，
     * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
     * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
     * 此时利用中序遍历可以获得一个递减数列
     * 利用中序遍历的倒序，先访问右子树的节点值
     *
     *
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.1 MB, 在所有 Java 提交中击败了84.72%的用户
     * */

    int res,k;
    public int kthLargest(TreeNode root,int k){
        this.k = k;
        midOrder(root);
        return res;

    }
    void midOrder(TreeNode root){
    if(root == null){
        return;
    }
    midOrder(root.right);//先右节点
    if(k == 0){
        return;
    }
    //每次执行--k判断是否是0
    if(--k == 0){
        res = root.val;
    }
    midOrder(root.left);
    }
}

