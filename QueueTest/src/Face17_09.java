/**
 * @author yulinsheng
 * @time 2021-05-07 19:48
 */

import java.util.*;

/**
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 *
 * 示例 1:
 *
 * 输入: k = 5
 *
 * 输出: 9
 */
public class Face17_09 {
    public static void main(String[] args) {
        SolutionFace17_09 s1 = new SolutionFace17_09();
        s1.getKthMagicNumber(5);
//        System.out.println(s1.getKthMagicNumber(3));
    }
}
class SolutionFace17_09 {
    public int getKthMagicNumber(int k) {
        /**
         * 三指针法，同时定义三个指针，比较指针值的大小，主要每次需要与原始的结果想乘比较。
         * 执行用时：1 ms, 在所有 Java 提交中击败了40.30%的用户
         * 内存消耗：35.2 MB, 在所有 Java 提交中击败了78.01%的用户
         */
//        int o = 0,p = 0,q = 0;
//        int [] res = new int [k+1];
//        res[0] = 1;
//        for(int i = 1;i < k;i++){
//            res[i] = Math.min(res[o]*3,Math.min(res[p]*5,res[q]*7)) ;
//            if(res[i] == res[o]*3 ) {o++;}
//
//            if(res[i] == res[p]*5) {p++;}
//
//            if(res[i] == res[q]*7) {q++;}
//        }
//        return res[k-1];
        /**
         *利用优先级队列
         * 执行用时：9 ms, 在所有 Java 提交中击败了6.50%的用户
         * 内存消耗：35.8 MB, 在所有 Java 提交中击败了10.40%的用户
         */
        Set<Long> values = new HashSet<>();
        Queue<Long>queue= new PriorityQueue<>();
        //写入1到队列中
        queue.add(1L);
        while(true){
            //取出队列中的元素，并判断set中是否存在，不存在写入set中，利用队列自动排序
            Long value = queue.poll();
            if(!values.contains(value)){
                values.add(value);
                queue.add(value * 3);
                queue.add(value * 5);
                queue.add(value * 7);
            }
            if (values.size() == k) {
                return value.intValue();
            }
        }


    }
}