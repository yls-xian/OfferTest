import java.util.LinkedList;

/***
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead操作返回 -1 )
 *
 *
 * 利用栈实现队列，由于栈时先入后出的元素，而队列是先入先出的元素，因此我们利用栈实现队列是，需要利用
 * 两个栈实现。
 * 其中一个栈A存放队列的插入元素。
 * 另外一个栈在队列要取出的时候对栈A的元素进行反向操作，进而取出的元素就是队列中的第一个元素。

 * 执行用时：53 ms, 在所有 Java 提交中击败了96.47%的用户
 * 内存消耗：47.1 MB, 在所有 Java 提交中击败了28.42%的用户
 */
public class offer9 {
}


class CQueue {
    LinkedList<Integer> A,B;
    public CQueue() {
        //初始化两个栈
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    public void appendTail(int value) {
        A.addLast(value);

    }

    public int deleteHead() {
        //模拟队列删除，首先将A中的元素全部转移到B中，然后移动B的最后一个元素完成删除操作
        //第一种情况，如果原始的B中存在元素，直接返回即可
        if(!B.isEmpty()){return B.removeLast();}
        //第二种情况A中没有元素，之间返回-1
        if(A.isEmpty()){return -1;}
        //转移元素
        while(!A.isEmpty()){
            B.addLast(A.removeLast());
        }
        return B.removeLast();

    }
}