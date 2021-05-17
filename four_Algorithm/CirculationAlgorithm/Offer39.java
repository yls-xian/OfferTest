import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/***
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。

 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2

 * 限制：
 * 1 <= 数组长度 <= 50000
 */

public class Offer39 {
}
class Solution39 {
    public int majorityElement(int[] nums) {
        /**
         * 最简单的方法就是排序，返回最中间的元素就是超过一半的元素
         * 执行用时：2 ms, 在所有 Java 提交中击败了60.45%的用户
         * 内存消耗：44.4 MB, 在所有 Java 提交中击败了5.03%的用户
         */
//        Arrays.sort(nums);
//        return nums[nums.length/2];
        /**
         * 第二种方法利用Map记录每个数据出现的次数
         * 执行用时：16 ms, 在所有 Java 提交中击败了20.19%的用户
         * 内存消耗：43.8 MB, 在所有 Java 提交中击败了19.47%
         * 的用
         */
//        Map<Integer,Integer> map = new HashMap<>();
//        for(int i = 0;i < nums.length;i++){
//            if(map.containsKey(nums[i])){
//                map.put(nums[i],map.get(nums[i])+1);
//            }
//            else{
//                map.put(nums[i],1);
//            }
//        }
//        int num = 0;
//        for(Integer key:map.keySet()){
//            if(map.get(key) > nums.length/2){
//                num = key;
//                break;
//            }
//        }
//        return num;
        /***
         * 摩尔投票法：注意超过一半，此时那个超过一半的数字利用摩尔投票法与所有的其他数字抵消后还剩余1
         * 执行用时：1 ms, 在所有 Java 提交中击败了99.97%的用户
         * 内存消耗：41.3 MB, 在所有 Java 提交中击败了96.62%的用户
         */
        //初始化结果和选票值
        int res = 0,votes = 0;
        //循环读取数据
        for(int num : nums){
            //一旦选票值为零，则最终的结果就是当前循环的值
            if(votes==0){res = num;}
            //并且选票值+1
            if(num == res) {
                votes += 1;
            }
            else{
                votes -= 1;
            }
        }
        return res;

    }
}
