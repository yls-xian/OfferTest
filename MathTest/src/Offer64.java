/**
 * @author yulinsheng
 * @time 2021-04-19 21:47
 */

/**
 * 求 1+2+...+n ，要求不能使用乘除法、
 * for、while、if、else、switch、case等关键字
 * 及条件判断语句（A?B:C）。
 */
public class Offer64 {

}

class Solution64{
    int res = 0;
    public int sumNums(int n) {
        /**
         * 分析正常的，算法有三种，
         * 第一种利用乘除法
         * return (1+n)*n/2;
         * 第二种循环法
         * int res = 0;
         *  for(int i = 0;i < n;i++){
         *      res += i;
         *  }
         *  return res;
         *  第三种：递归
         *  if(n == 1)
         *  return 1;
         *  n += sumNums(n-1);
         *  return n ;
         *
         *  三种方法同样都是利用了上述不能采用的方法
         */
        /**
         * 考虑采用逻辑运算符，实现递归操作
         * 执行用时：1 ms, 在所有 Java 提交中击败了59.12%的用户
         * 内存消耗：35.7 MB, 在所有 Java 提交中击败了50.30%的用户
         */
        boolean x = n > 1 && sumNums(n - 1) > 0;//当为false时终止操作
            res += n;
        return res;

    }
}

