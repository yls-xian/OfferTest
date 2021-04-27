import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yulinsheng
 * @time 2021-04-24 11:12
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();//经常的删除和插入，LinkedList的时间复杂度为O(1).ArrayList不是
        queue.add(1);
        queue.add(2);
        queue.add(3);

        Integer temp = queue.peek();//获得出队的元素
        System.out.println(temp);

        Integer temp1 = queue.poll();//删除出队的元素 1 [2,3]
        System.out.println(temp1);
        System.out.println(queue.toString());

        System.out.println(queue.isEmpty());//判断队列是否为空


        System.out.println(queue.size());//判断队列的长度

        while(!queue.isEmpty()){
            int tmp = queue.poll();//遍历删除元素
            System.out.println(tmp);
        }
    }

}
