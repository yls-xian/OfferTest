import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yulinsheng
 * @time 2021-05-06 10:37
 *
 *
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 * 例如:
 * 给定二叉树:[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class Offer32_I {
}


/**
 * 执行用时：1 ms, 在所有 Java 提交中击败了99.69%的用户
 * 内存消耗：38.5 MB, 在所有 Java 提交中击败了66.50%的用户
 */
class SolutionOffer32_I {
    public int[] levelOrder(TreeNode root) {
        //特殊情况处理，当root没有节点时返回空矩阵
        if(root == null){
            return new int [0];
        }
        //初始化队列，并将根节点添加到队列中
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //建立列表，可以不用考虑长度
        ArrayList<Integer> list = new ArrayList<>();
        //当队列不为空时，多次循环
        while(!queue.isEmpty()){
            //首先取出节点，由于队列是先入先出的情况，因此我们需要将左右节点依次写入。
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        int [] res = new int[list.size()];
        for(int i = 0;i < list.size();i++){
            res[i]  = list.get(i);
        }
        return res;

    }
}