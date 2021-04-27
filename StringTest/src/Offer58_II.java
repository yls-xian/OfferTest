/**
 * @author yulinsheng
 * @time 2021-04-19 9:45
 */

import java.util.Scanner;

/**
 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 请定义一个函数实现字符串左旋转操作的功能。
 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer58_II {
    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();//自定义输入字符串
        System.out.println(s.reverseLeftWords(s1,2));

    }
}

class Solution{
    public String reverseLeftWords(String s,int n){


        //方法1
        /**
         通过字符串自带的切分函数substring(),将原始字符串切分，然后拼接。
         时间复杂度O（N）
         空间复杂度O（N）
         显示详情
         执行用时：0 ms,在所有 Java 提交中击败了100.00%的用户
         内存消耗：38 MB,在所有 Java 提交中击败了92.09%的用户
         */
//        String a = s.substring(0,n);//开始要旋转的字符串，根据例子可知，为前n个字符，由于字符是从0开始的，左闭右开的原则，最后n的位置没有取到
//        String b = s.substring(n,s.length());//剩下的字符串值
//        return b + a;





        //方法2
        /**
        将字符串转换为char类型的数组，利用String.toCharArray()。
         读取数据，将数据放入新的char[]中，最后利用字符串的构造器String(char [] )返回字符串
         时间复杂度O（N）遍历s的时间
         空间复杂度O（N）
         执行用时：2 ms, 在所有 Java 提交中击败了41.90%的用户
         内存消耗：38.1 MB,在所有 Java 提交中击败了83.37%的用户
         难点：数组的索引下标，后面的需要是剩下的值
         */
//        char [] str = s.toCharArray();
//        char [] res = new char [str.length];
//        for(int i = n;i < str.length;i++){
//            res[i-n] = str[i];
//        }
//        for(int i = 0;i < n;i++){
//            res[str.length-n+i] = str[i];
//        }
//        return new String(res);





        //方法2改写，利用string.charAt方法,此时不用考虑新的元素的索引问题
        /**
         执行用时：70 ms, 在所有 Java 提交中击败了5.44%的用户
         内存消耗：39.1 MB, 在所有 Java 提交中击败了5.01%的用户
         */
//        String res = "";
//        int length = s.length();
//        for(int i = n;i < length;i++){
//            res += s.charAt(i);
//        }
//        for(int i = 0;i < n;i++){
//            res += s.charAt(i);
//        }

        //可以利用取余的方法简化
//            for(int i = n;i < n + s.length();i++){
//                res += s.charAt(i % s.length());
//            }
//        return res;



        //方法3，利用StringBuilder的append方法
        /**
         类似方法2的改写，仅仅使用的StringBuilder来存储结果
         执行用时：5 ms, 在所有 Java 提交中击败了22.46%的用户
         内存消耗：38.3 MB, 在所有 Java 提交中击败了49.74%的用户，对于其中的索引可以利用求余的方法简化计算
         */
        StringBuilder res = new StringBuilder();
//        for(int i = n;i < s.length();i++){
//            res.append(s.charAt(i));
//        }
//        for(int i = 0;i < n;i++){
//            res.append(s.charAt(i));
//        }

        //简化求余
        for(int i = n ;i < n + s.length();i++){
            res.append(s.charAt(i % s.length()));//
        }
        return res.toString();//将StringBuilder转换为String类型




    }
}