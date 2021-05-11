/**
 * @author yulinsheng
 * @time 2021-05-11 16:58
 */

/**
 * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class letcode121 {
}
class Solution121 {
    public int maxProfit(int[] prices) {
        /**
         * 第一种方法，暴力列举，两次循环获得最大利润值。
         * 超时了
         */
        int res = 0;
        for(int i = 0;i < prices.length-1;i++){
            for(int j = i+1;j < prices.length;j++)
            if(res < (prices[j]-prices[i])){
                res = prices[j] - prices[i];
            }
        }
        return res;

    }
}
