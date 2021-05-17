/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */
public class Offer36 {
}
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
class Solution {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37.4 MB, 在所有 Java 提交中击败了97.86%的用户
     */
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if(root == null)return null;
        dfs(root);

        head.left = pre;//进行头尾节点的连接
        pre.right = head;
        return head;

    }
    void dfs(Node cur){
        //当便利到叶子节点时返回
        if(cur == null)return;
        //先遍历左子树
        dfs(cur.left);
        //当pre为空时，表示上一次迭代中cur为空，表示达到叶子节点的的左节点（不存在）此时该节点就是head节点
        if(pre == null){
            head = cur;
        }
        else{//其他的不是head节点的右边子链就是cur节点
            pre.right = cur;
        }
        //cur的左子链就是pre
        cur.left = pre;
        //当前pre值就是便利的cur节点
        pre = cur;
        //便利结束后便利右子树
        dfs(cur.right);
    }
}

