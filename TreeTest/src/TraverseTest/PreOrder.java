package TraverseTest;

/**
 * @author yulinsheng
 * @time 2021-04-28 11:01
 */

import java.util.*;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class PreOrder {

}

class SolutionPreOrder{
        public List<Integer> preorderTraversal(TreeNode root){
            /**
             * 第一种方法递归调用，前序遍历的顺序时根节点左子树右子树
             * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
             * 内存消耗：36.7 MB, 在所有 Java 提交中击败了57.41%的用户
              */
//            List<Integer> res = new ArrayList<>();
//            preorder(root,res);
//            return res;
//        }
////        定义递归函数，参数为树的根节点，以及最终存储数据的res.
//        public void preorder(TreeNode root,List<Integer> res){
////            定义出口，递归结束条件
//            if(root == null)
//                return;
//            res.add(root.val);//将节点的值加入到最终结果中
//            preorder(root.left,res);//循环左子树，并且每次将左子树的节点值加入到最后的结果中，直到叶子节点停止。
//            preorder(root.right,res);
//        }

            /**
             * 第二种方法迭代法，与递归等价.
             * 利用栈先进后出的原理。每次将元素先写入栈中，然后出栈写入结果中。
             */
            List<Integer> res = new ArrayList<>();//初始化结果
            if(root == null){
                return res;
            }//当节点为null时，返回最终的结果
            Stack<TreeNode> stack = new Stack<>();//初始化栈

            stack.push(root);//将根节点写入到栈中
            while(!stack.isEmpty()){//当栈中元素不为空时，提取数据
                TreeNode node = stack.pop();//将节点元素提取出来，后加入的先出来
                res.add(node.val);//将节点的元素值写入到最终的结果中
                //由于栈是先入后出的原因，因此我们需要将右子树的值写入到栈中，然后再写入左子树的值
               if(node.right != null){
                   stack.push(node.right);
               }
               if(node.left != null){
                   stack.push(node.left);
               }

            }
            return res;

        }

        }