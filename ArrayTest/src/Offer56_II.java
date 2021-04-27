/**
 * @author yulinsheng
 * @time 2021-04-20 11:17
 */

import java.util.*;

/**
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。
 * 请找出那个只出现一次的数字。
 */
public class Offer56_II {
}

class Solution56 {
    public int singleNumber(int[] nums) {

        /**
         * 方法一:
         * 利用Map的（key,value）值，找到value值为1的key值输出。思路简单明确
         */

////        初始化一个map值
//       Map<Integer,Integer> map = new HashMap<>();
////       循环将数据放入到map中
//       for(int i = 0;i < nums.length;i++){
////           首先判断key值中是否存在数组值，不存在的话，放入并将value值置为1
//           if(!map.containsKey(nums[i])){
//               map.put(nums[i],1);
//           }
////           存在的话将原始的value值+1
//           else{
//               map.put(nums[i],map.get(nums[i])+1);
//           }
//       }
////       循环读取，map中的entry，判断value值是否等于1，等于的话返回key值
//       for(Map.Entry<Integer,Integer> entry : map.entrySet()){
//           if(entry.getValue() == 1){
//               return entry.getKey();
//           }
//       }
//
//    return -1;
//    }


        /**
         * 方法二：
         * 利用存储数据的二进制位，计算各个二进制为求和对3取余，最终得到的二进制数就是出现一次的数字
         * 思路太复杂，左右移动没搞懂
         */
//      初始化结果为0

        //最终的结果值
        int res = 0;
        //int类型有32位，统计每一位1的个数
        for (int i = 0; i < 32; i++) {
            //统计第i位中1的个数
            int oneCount = 0;
            for (int j = 0; j < nums.length; j++) {

                // 每次右移获得当前位置上的值
                oneCount += (nums[j] >>> i) & 1;
            }
            //如果1的个数不是3的倍数，说明那个只出现一次的数字
            //的二进制位中在这一位是1，获得
            if (oneCount % 3 == 1)
                res |= 1 << i;
        }
        return res;


    }
}