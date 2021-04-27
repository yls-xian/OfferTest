/**
 * @author yulinsheng
 * @time 2021-04-19 21:06
 */

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * 左右子树互换
 */
public class Offer27 {
}

class Solution27{
    /**
     * 方法一，思路分析，左右子树完全互换。可以利用递归的思想解决。
     * 递归的方法很难解释
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35.8 MB, 在所有 Java 提交中击败了56.71%的用户
     */
//    首先需要找到结束递归的条件，当root == null时结束递归，原因是剩下的树节点左右子树了
//    public TreeNode mirrorTree(TreeNode root){
//        if(root == null){
//            return null;//结束递归
//        }
//        TreeNode tmp = root.right;
//        root.right = mirrorTree(root.left);
//        root.left = mirrorTree(tmp);
//        return root;
//    }
    /**
     * 利用栈或队列辅助，先遍历所有的节点，然后交换节点.
     * 思想就是利用栈或队列循环读取root的所有节点，在读取的时候将左右节点互换
     * 执行用时：1 ms, 在所有 Java 提交中击败了8.92%的用户
     * 内存消耗：35.8 MB, 在所有 Java 提交中击败了68.79%的用户
     */
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null)
            return null;
//      初始化一个栈，存储的数据格式是TreeNode
        Stack<TreeNode> stack = new Stack<>();
//        将原始的父节点添加到栈中
        stack.add(root);
//        当栈中元素不为空时执行操作
        while(!stack.isEmpty()){
//           获得要删除的节点信息
            TreeNode node = stack.pop();
//            判断要删除的节点是否有左右子树，有的话加入，先加入左子树，然后加入右子树
            if(node.left != null){stack.add(node.left);}
            if(node.right!= null){stack.add(node.right);}
//            建立一个中介节点，获得左子树的值，然后左右子树交换
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }



}