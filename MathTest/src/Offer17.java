/**
 * @author yulinsheng
 * @time 2021-04-20 18:21
 */

import com.sun.org.apache.xpath.internal.operations.String;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 */
public class Offer17 {
}


class Solution17{
    public int[] printNumbers(int n) {

        /**
         * 思路分析:输出的是一个数组，首先需要确定数组的长度，根据n的值判断长度为10^n-1。（此时没有考虑数据越界的问题）
         * 然后输出结果，需要注意的是数组的索引是从0开始，而输出的结果是从1开始，因此需要对应索引。
         *
         *
         *
         * 执行用时：1 ms, 在所有 Java 提交中击败了99.99%的用户
         * 内存消耗：46.2 MB, 在所有 Java 提交中击败了92.43%的用户
         */
        int len = (int)Math.pow(10,n);
        int [] res = new int [len - 1 ] ;
        for(int i = 1;i < len;i++){
            res[i-1] = i;
        }
        return res;
        /**
         * 考虑数据越界的问题，因为int类型的数据有个最大值限制
         */




    }
}