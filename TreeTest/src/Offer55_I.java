/**
 * @author yulinsheng
 * @time 2021-04-19 15:45
 */

import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;
import sun.awt.image.ImageWatched;
import sun.reflect.generics.tree.Tree;

import java.util.*;


/**
 输入一棵二叉树的根节点，求该树的深度。
 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。

 */

/*
    数的遍历方式：DFS（深度优先搜索）、BFS(广度优先搜索)
    DFS:先序遍历、中序遍历、后序遍历
    BFS:层序遍历（按照层遍历）
 */

    //树的求法一般是利用递归的方法做
public class Offer55_I {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(9);
        t1.right = new TreeNode(20);
        t1.right.left = new TreeNode(15);
        t1.right.left =new TreeNode(7);
        Solution s1 = new Solution();
        System.out.println(s1.maxDepth(t1));

    }
}



class Solution{
    public int maxDepth(TreeNode root){
        if(root == null)
            return 0;//判断是否是空树

        /**
         第一种方法，分析树的深度和左子树的深度已经右子树的深度之间的关系
        树的深度 = max(左子树的深度，右子树的深度) + 1
         执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         内存消耗：38.2 MB, 在所有 Java 提交中击败了85.77%的用户
         */
//        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;



        /**
         * 方法二：
         层序遍历，每遍历一层，计数器+1
         执行用时：1 ms, 在所有 Java 提交中击败了21.74%的用户
         内存消耗：38.1 MB, 在所有 Java 提交中击败了96.29%的用户
         */
//        首先创建队列
        Deque<TreeNode> deque = new LinkedList<>();
//        将节点写入到队列中
        deque.push(root);
//        初始化层值为0
        int count = 0;
//        判断队列是否为空
        while(!deque.isEmpty()){
//            获得队列的长度
            int size = deque.size();
//            循环删除数据
            while(size-- > 0){
                TreeNode cur = deque.pop();//删除元素
//                一旦节点的左右子树不为零，加入到原始的队列中
                if(cur.left != null){
                    deque.addLast(cur.left);
                }
                if(cur.right != null){
                    deque.addLast(cur.right);
                }
            }
//            循环一次后层数+1,然后判断左右子树节点
            count++;
        }

        return count;
    }

}