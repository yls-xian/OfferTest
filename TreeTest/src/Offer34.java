/**
 * @author yulinsheng
 * @time 2021-04-23 12:15
 */

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;

/**
 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
                 5
                 / \
                 4   8
                 /   / \
                 11  13  4
                 /  \    / \
                 7    2  5   1
    target = 22
     结果
     [5,4,11,2],
     [5,8,4,5]
 */
public class Offer34 {
}

class Solution34{
    LinkedList<List<Integer>> res = new LinkedList<>();//结果存放
    LinkedList<Integer> path = new LinkedList<>();//中间路径存放
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root,target);//调用递归获得res值
    return res;
    }
    void recur(TreeNode root,int tar){
        if(root == null) return; //一旦到达叶子节点，返回
        path.add(root.val);//将路径上的值写入到path路径上
        tar -= root.val;//每次将tar减去路径上的值
        if(tar == 0 && root.left == null && root.right == null){
            res.add(new LinkedList(path));//一旦tar值等于0，并且左右都到达了叶子节点，将最终的路径写入到res中

        }
        recur(root.left,tar);//递归左节点
        recur(root.right,tar);//递归右节点
        path.removeLast();//删除最后一个元素,转换左右节点

    }
}