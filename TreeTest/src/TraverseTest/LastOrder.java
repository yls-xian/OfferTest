package TraverseTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yulinsheng
 * @time 2021-04-28 11:25
 */
public class LastOrder {
}

class SolutionLastOrder{
    public List<Integer> lastorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        lastorder(root,res);
        return res;
    }
    public void lastorder(TreeNode root,List<Integer> res){
        if(root == null){
            return;
        }
        lastorder(root.left,res);
        lastorder(root.right,res);
        res.add(root.val);

    }
}