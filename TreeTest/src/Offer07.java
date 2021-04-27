import sun.reflect.generics.tree.Tree;

import java.util.HashMap;

/**
 * @author yulinsheng
 * @time 2021-04-22 20:53
 */

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class Offer07 {
}


class Solution07{

    /**
     * 根据给出的前序遍历和中序遍历的结果，对应树的构建。
     *
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     *
     *   3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     *    可以得到前序遍历的第一个元素是根节点的值
     *    根据根节点的值可以将中序遍历划分 [左子树 根节点 右子树]  【1 1 3】
     *    根据中序遍历中左右子树的长度1 3,可以焕发前序遍历为 [根节点 左子树 右子树] 【 1 1 3 】
     *
     *    通过上述过程可以确定根节点，左子树的根节点（前序遍历左子树的第一个节点） 右子树的根节点（前序遍历右子树的第一个节点）
     *
     *
     *    首先第一步获得根节点的值（前序遍历的第一个值）
     *    然后根据根节点的值将中序遍历中的左右子树分开
     *    此时我们可以通过计算中序遍历左右子树的长度，进而获得前序遍历中左子树的边界和右子树的起点。
     *
     *    需要递推的参数，根节点的前序索引root,
     *    中序遍历的左子树left 中序遍历的右子树right。结束递归的条件是left > right。表示已经越过了最后的叶子节点
     *
     */
    HashMap<Integer,Integer> map = new HashMap<>();//标记中序遍历
    int [] preorder;//保留先序遍历
    public TreeNode buildTree(int [] preorder,int [] inorder){
        this.preorder = preorder;
        //将中序遍历的值放在map中，方便递归时获取左子树与右子树的数量及根的索引
        for(int i = 0;i < inorder.length;i++){
            map.put(inorder[i],i);
        }

//        调用递归 初始 root 为 0
        return recur(0,0,inorder.length-1);
    }
//    定义索引值，初始的root为前序遍历的第一个参数，left 为中序遍历的第一个索引0，right为中序遍历的最后一个值inorder.length-1

    TreeNode recur(int pre_root,int in_left,int in_right){
//        当左右索引值超过预期时结束递归。（原因是左边的索引值一直小于等于右边的索引值）
        if(in_left > in_right){
            return null;
        }//结束递归的条件

//        首先建立根节点，前序遍历的第一个元素（0）
        TreeNode root = new TreeNode(preorder[pre_root]);//获得root节点

//        根据上述根节点获得map中，中序遍历根节点的索引值
        int idx = map.get(preorder[pre_root]);//获得中序遍历中根节点所在的索引，方便获取左子树的数量

//        利用递归获得前序遍历中的下一个左树节点（pre_root+1）一直到根节点的前一个节点停止
        root.left = recur(pre_root+1,in_left,idx-1);
//        利用递归获得前序遍历中的下一个右数节点（idx+1）一直到节点末尾
        root.right = recur(pre_root+(idx-in_left)+1,idx+1,in_right);
//        最后返回root
        return root;
    }

}


