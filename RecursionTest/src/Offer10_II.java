/**
 * @author yulinsheng
 * @time 2021-04-27 18:29
 */

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

 */
public class Offer10_II {
}

class SolutionOffer10_II{
    public int numWays(int n) {
        /**
         * 思路分析 假设对于n阶台阶来说，有f(n)种跳法。
         * 当第一次跳为1阶台阶时，有f(n-1)种跳法。
         * 当第一次为2阶台阶时，有f(n-2)种跳法。
         * f(n) =  f(n - 1) + f(n - 2).与斐波那契数列求n项的值类似
         * 转换为 f(n+1) = f(n) + f(n - 1)
         * 不同之处在于初始条件不同
         * n = 0时 f(n) = 1
         * n = 1时f(n) = 1
         * n = 2时f(n) = 2
         *
         */
        int a = 1;
        int b = 1;
        int sum = 0;
        for(int i = 0;i < n;i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}