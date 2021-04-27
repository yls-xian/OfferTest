/**
 * @author yulinsheng
 * @time 2021-04-24 11:25
 */

import sun.awt.image.ImageWatched;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7

 */
public class Offer59_I {
    public static void main(String[] args) {

    }
}


class Solution59_I {
    public int[] maxSlidingWindow(int[] nums, int k) {

        /**
         * 方法1，暴力循环
         *
         * 执行用时：29 ms, 在所有 Java 提交中击败了25.50%的用户
         * 内存消耗：46.4 MB, 在所有 Java 提交中击败了77.69%的用户
         */
////      首先判断是否存在值，若不存在直接返回[0]
//        if(nums.length == 0){
//            return new int[0];
//        }
////       定义结果矩阵长度为数组长度 - k +  1
//        int [] res = new int [nums.length - k + 1];
////        单层循环，读取第一个数据
//        for(int i = 0;i <= nums.length - k;i++){
//            int max = nums[i];//定义值比较值，为了防止有负数，因此将数据定义为数组中的值
//            for(int j = i+1;j < i+k;j++){
//                //内层循环3次判断最大值
//                if(max < nums[j]){
//                    max = nums[j];
//                }
//
//            }
//            //将最大值写入到数组中
//            res[i] = max;
//        }
//        return res;

        /**
         * 利用栈操作，将数据删除。
         *
         */

        //特殊情况
        if(nums.length == 0 || k == 0) return new int[0];
        //建立一个双向队列
        Deque<Integer> deque = new LinkedList<>();
//      初始化结果数组
        int[] res = new int[nums.length - k + 1];
//        开始循环 i代表每次循环的k值，j代表每次循环的值。
        for(int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            //[1,3,-1,-3,5,3,6,7]  k = 3
            //开始i<0，需要将元素写入到队列中 栈中元素为1，此时i =
            // 删除 deque 中对应的 nums[i-1]
            if(i > 0 && deque.peekFirst() == nums[i - 1])
                deque.removeFirst();
            // 保持 deque 递减
            while(!deque.isEmpty() && deque.peekLast() < nums[j])
                deque.removeLast();
            deque.addLast(nums[j]);
            // 记录窗口最大值
            if(i >= 0)
                res[i] = deque.peekFirst();
        }
        return res;

    }
}
