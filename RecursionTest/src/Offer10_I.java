/**
 * @author yulinsheng
 * @time 2021-04-27 18:06
 */

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * F(0) = 0,
 * F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer10_I {
}


class Solution10_I {
    /**
     * 解法1,不考虑输入数据越界问题。简单的递归调用即可。
     */
//    public int fib(int n) {
//        if(n == 0){
//            return 0;
//        }
//        if(n == 1){
//            return 1;
//        }
//        return fib(n-1)+fib(n-2);
//    }
    /**
     * 解法2，动态规划
     * f(n+1) = f(n)+f(n-1);这样每次仅仅只需要算一个信息即可。
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35 MB, 在所有 Java 提交中击败了95.67%的用户
     */

    public int fib(int n) {
        int a = 0;
        int b = 1;
        int sum = 0;
        for(int i = 0;i < n;i++){
            sum = (a + b) %(1000000007);
            a = b;
            b = sum;
        }
        return a;//为什么返回a,因为这里求得是f（n+1）的值，a的值代表f(n)
    }
}