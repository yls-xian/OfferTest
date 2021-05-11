import sun.plugin.javascript.navig.Link;

import java.util.*;

/**
 * @author yulinsheng
 * @time 2021-05-06 11:22
 *
 *
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 *
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
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
 *   [20,9],
 *   [15,7]
 * ]
 */
public class Offer32_III {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right= new TreeNode(7);
        SolutionOffer32_III s1 = new SolutionOffer32_III();
        s1.levelOrder(root);

    }
}
class SolutionOffer32_III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        /***
         * 由于此题不仅仅是层序遍历的结果，而是层序遍历的同时改变层序遍历的方向，偶数层从右往左遍历，奇数层从左往右遍历
         * 方法1：
         * 因此我们首先考虑的是利用List存储结果，然后利用Collections.reverse()在偶数层反转写入到最终的结果。
         */
//        //初始化结果
//        List<List<Integer>> res = new ArrayList<>();
//        //初始化队列
//        Queue<TreeNode> queue = new LinkedList<>();
//        if(root!=null) queue.add(root);
//        //初始化层数为0
//        int count = 0;
//
//        while(!queue.isEmpty()){
//            //首先获得队列中的节点值
//            int size = queue.size();
//            //定义存储结果的list
//            List<Integer> list = new ArrayList<>();
//            //循环各个节点，将结果写入到list中
//            for(int i = 0;i < size;i++) {
//                TreeNode node = queue.poll();
//                list.add(node.val);
//                //取出节点后，将节点的叶子节点写入到队列中
//                if(node.left !=null)
//                    queue.add(node.left);
//                if(node.right != null)
//                    queue.add(node.right);
//            }
//            //循环完每层的节点后+1
//            count++;
//            //判断层数是否是奇数层还是偶数层
//            if(count%2==1){
//                res.add(list);
//            }
//            else{
//                Collections.reverse(list);
//                res.add(list);
//            }
//
//
//        }
//        //返回结果
//        return res;
        /**
         * 方法二，在插入节点时考虑，利用双端队列的属性，可以添加头可以添加尾
         * 执行用时：1 ms, 在所有 Java 提交中击败了99.89%的用户
         * 内存消耗：38.7 MB, 在所有 Java 提交中击败了41.05%的用户
         */
//        Queue<TreeNode> queue = new LinkedList<>();
//        List<List<Integer>> res = new ArrayList<>();
//        if(root!=null){queue.add(root);}
//
//        while(!queue.isEmpty()){
//            int size = queue.size();
//            LinkedList<Integer> tmp = new LinkedList<>();
//            for(int i =0;i < size;i++){
//                TreeNode node = queue.poll();
//                //根据结果的个数判断添加后面还是前面，第一层原始结果为0，加入到最后，从左往右。第二层结果为1，每次加入到头，从右往左。
//                if(res.size()%2==0){tmp.addLast(node.val);}
//                else tmp.addFirst(node.val);
//                if(node.left!=null)queue.add(node.left);
//                if(node.right!=null)queue.add(node.right);
//            }
//            res.add(tmp);
//        }
//        return res;
        /**
         * 方法二，代码简短、容易实现；但需要判断每个节点的所在层奇偶性，即冗余了 NN 次判断。
         * 通过将奇偶层逻辑拆分，可以消除冗余的判断
         * 方法三：就是对奇偶层分开操作，在奇数层操作完后马上进行偶数层操作，一旦不存在则返回。
         * 执行用时：1 ms, 在所有 Java 提交中击败了99.89%的用户
         * 内存消耗：38.6 MB, 在所有 Java 提交中击败了67.05%的用户
         */
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root!=null) deque.add(root);
        while(!deque.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            for(int i = deque.size();i > 0;i--){
                //从左向右
                TreeNode node = deque.removeFirst();
                tmp.add(node.val);
                //从左往右添加
                if(node.left!=null)deque.addLast(node.left);
                if(node.right!=null)deque.addLast(node.right);
            }
            res.add(tmp);
            if(deque.isEmpty())break;
            tmp = new ArrayList<>();
            for(int i  = deque.size();i > 0;i--){
                //从右向左取出节点
                TreeNode node = deque.removeLast();
                tmp.add(node.val);
                //从左往右添加
                if(node.right!=null)deque.addFirst(node.right);
                if(node.left!=null)deque.addFirst(node.left);
            }
            res.add(tmp);
        }
        return res;


    }
}

