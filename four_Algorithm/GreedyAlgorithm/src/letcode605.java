import java.util.Arrays;

/**
 * @author yulinsheng
 * @time 2021-05-11 18:31
 */
public class letcode605 {
    public static void main(String[] args) {
        int [] flowerbed = new int []{1,0,0,0,1};
        Solution605 s1 = new Solution605();
        s1.canPlaceFlowers(flowerbed, 2);


    }
}

class Solution605 {
    /**
     * 贪心算法，最优解是每隔一个种上了一朵花，种尽可能多的花。
     * 子问题是每次尽量种花就可以了。
     * 第一种方法分情况讨论，单独一个[0]的情况，最开头[0,0]的情况，最后[0,0]的情况。中间[0,0,0]的情况
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.90%的用户
     * 内存消耗：39.6 MB, 在所有 Java 提交中击败了91.08%的用户
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

//        int res = 0;
//        //[1][0]的情况
//        if(flowerbed.length==1){
//            if(flowerbed[0]==0){
//                res++;
//
//            }
//            return res >= n;
//
//        }
//        //[0,0]开头的情况
//        if(flowerbed[0]==0&&flowerbed[1]==0){
//            flowerbed[0]=1;
//            res++;
//        }
//        //结尾是[0,0]的情况
//        if(flowerbed[flowerbed.length-1]==0&&flowerbed[flowerbed.length-2]==0){
//            flowerbed[flowerbed.length-1]=1;
//            res++;
//        }
//        //中间[0,0,0]的情况
//        for(int i = 1;i < flowerbed.length - 2;i++){
//            if(flowerbed[i] == 0 && flowerbed[i+1] == 0 && flowerbed[i-1] == 0){
//                flowerbed[i] = 1;
//                res++;
//            }
//        }
//        return res>=n;
        /**
         * 方法二对上述方法进行优化,在分别在前后位置上添加一个[0]
         * 执行用时：1 ms, 在所有 Java 提交中击败了99.90%的用户
         * 内存消耗：39.7 MB, 在所有 Java 提交中击败了88.00%的用户
         */
        int [] new_flowerbed = new int [flowerbed.length+2];
        //复制数组在前后分别+0
        for(int i = 0;i < flowerbed.length;i++){
            new_flowerbed[i+1]=flowerbed[i];
        }
        int res = 0;
        //循环数组，此时不需要考虑前后[0,0]问题
        for(int i = 1;i < new_flowerbed.length-1;i++) {
            if (new_flowerbed[i - 1] == 0 && new_flowerbed[i + 1] == 0)
            {
                new_flowerbed[i] = 1;
                res++;
            }
        }
        return res>=n;
    }


    }
