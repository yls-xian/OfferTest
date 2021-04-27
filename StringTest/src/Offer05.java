/**
 * @author yulinsheng
 * @time 2021-04-22 10:09
 */


import java.util.Arrays;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *  示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class Offer05 {
    public static void main(String[] args) {
        Solution05 s1 = new Solution05();
        String s = "   ";
        String res = s1.replaceSpace(s);
        System.out.println(res);

    }
}
class Solution05 {
    public String replaceSpace(String s) {
        /**
        方法一；利用额外的存储空间存储字符串
         执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         内存消耗：36.6 MB, 在所有 Java 提交中击败了13.98%的用户
         */
//       利用StringBuilder建立一个新的String，由于String的不可变性
//        StringBuilder res = new StringBuilder();
//        int i = 0;
//        for(char c : s.toCharArray()){
//            if(c == ' '){
//                res.append("%20");
//            }
//            else{
//                res.append(c);
//            }
//        }
//        return res.toString();
        /**
         *  方法二
         *  调用字符串函数replace（orignal,target）。repalceAll是基于正则表达式替换的。
         *  利用repalceAll()方法  return s.replaceAll(" ","%20");
         *  执行用时：3 ms, 在所有 Java 提交中击败了15.99%的用户
         *  内存消耗：36.5 MB, 在所有 Java 提交中击败了25.24%的用户
         *  利用replace()方法，return s.replace(" ","%20");
         *  执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：36 MB, 在所有 Java 提交中击败了95.45%的用户
         */
        String res = s.replace(" ","%20");
        return res;
        /**
         * 方法三：字符串拼接，利用split，将字符串分割.这种会使得没有考虑全是空格的情况没有办法得到。(这种方法没有通过)
         */
//        String [] arr = s.split(" ");
//        String res = "";
//        for(int i = 0;i < arr.length;i++)
//        {
//            res += arr[i];
//            if(i < arr.length-1){
//                res += "%20";
//            }
//        }
//        return res;
    }
}