package TraverseTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yulinsheng
 * @time 2021-04-28 11:21
 */
public class InOrder {
}
class SolutionInorder{
    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        inorder(root,res);
//        return res;
//    }
//    public void inorder(TreeNode root,List<Integer> res){
//        if(root == null){
//            return;
//        }
//        inorder(root.left,res);
//        res.add(root.val);
//        inorder(root.right,res);
//    }

        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        TreeNode cur = root;//定义一个节点指向root的根节点
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty()||cur!=null){
            while(cur!=null){
                stack.push(cur);//将根节点写入
                cur = cur.left;//获得
            }
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.right!=null){
                cur = node.right;
            }
        }
        return res;
    }



}