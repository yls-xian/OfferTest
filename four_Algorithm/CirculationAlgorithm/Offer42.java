/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释:连续子数组[4,-1,2,1] 的和最大，为6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Offer42 {
}
class Solution42 {
    public int maxSubArray(int[] nums) {
        /**
         * 思路分析1；暴力破解，多次循环获得最终值,超时
         */
        //初始化最大值为Integer.MIN_VALUE
//        int max = Integer.MIN_VALUE;
//        //第一层循环
//        for(int i = 0;i < nums.length;i++){
//            //定义每一层循环的和
//            int sum = 0;
//            for(int j = i;j < nums.length;j++){
//                sum += nums[j];
//
//                //求取每层和的最大值
//                if(sum > max){
//                    max = sum;
//                }
//
//            }
//        }
//        return max;
        /**
         * 利用贪心算法，
         * 总体问题找到子数组和的最大值
         * 子问题是尽量保证
         */
//        int max = nums[0],sum = nums[0];
//        for(int i = 1;i < nums.length;i++){
//            sum = Math.max(sum,sum+nums[i]);
//            max = Math.max(max,sum);
//        }
//        return max;
//    }
    /**
     * 动态规划，动态规划列表dp,dp[i]代表以元素num[i]为结尾的连续子数组的最大和
     * 若dp[i-1]<0说明前面的元素对dp[i]产生了负贡献，即dp[i-1]+nums[i]还不如num[i]大
     * 初始状态dp[0] = nums[0]
     * 最终的结果返回dp[i]中的最大值
     * 执行用时：1 ms, 在所有 Java 提交中击败了98.43%的用户
     * 内存消耗：44.6 MB, 在所有 Java 提交中击败了96.44%的用户
     */
    int [] dp = new int [nums.length];
    dp[0] = nums[0];
    int res = nums[0];
    for(int i = 1;i < nums.length;i++){
        if(dp[i-1]<0){
        dp[i] = nums[i];
        }
        else{
            dp[i] = nums[i]+dp[i-1];
        }
        res = Math.max(res,dp[i]);
    }
    return res;
    }

}