import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yulinsheng
 * @time 2021-05-06 10:56
 */
public class Offer32_II {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right= new TreeNode(7);
        SolutionOffer32_II s1 = new SolutionOffer32_II();
        s1.levelOrder(root);

    }
}


class SolutionOffer32_II {
    public List<List<Integer>> levelOrder(TreeNode root) {
        /**
         * 与原始返回的结果不相同的是，返回每层节点的分开。
         * 执行用时：1 ms, 在所有 Java 提交中击败了94.52%的用户
         * 内存消耗：38.7 MB, 在所有 Java 提交中击败了48.48%的用户
         */

        //初始化结果，List嵌套
        List<List<Integer>> res = new ArrayList<>();
        //初始化队列，写入节点数据
        Queue<TreeNode> queue = new LinkedList<>();
        if(root!=null)//当root存在节点时写入队列中，如果不存在直接返回初始化的res
        queue.add(root);
        //当队列不为空时，循环获取数据
        while(!queue.isEmpty()){
            //首先获得每一层的节点个数
            int size = queue.size();

            //初始化每层的结果存储
            List<Integer> arr = new ArrayList<>();
            for(int i = 0;i < size;i++){
                //取出一个节点，并写入到每层的结果中，一旦节点值达到临界值就返回新的每层结果
                TreeNode node = queue.poll();
                arr.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            //将每层的结果写入到最终的结果中
            res.add(arr);

        }
        return res;
    }
}