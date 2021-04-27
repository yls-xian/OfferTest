/**
 * @author yulinsheng
 * @time 2021-04-21 10:43
 */

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 */
public class Offer04 {

}


class Solution04{
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        /**
         * 方法一暴力循环，直接进行两层循环查找元素
         * 执行用时：1 ms, 在所有 Java 提交中击败了9.47%的用户
         * 内存消耗：44.3 MB, 在所有 Java 提交中击败了35.98%的用户
         *
         *
         * 需要注意的是数组本身为空，或者数组的长度为0的情况
         */
//        if(matrix == null || matrix.length == 0 || matrix[0].length == 0 ) //特殊条件，数组为空，或者长度为0时
//            return false;
//        int lenn = matrix.length;//获取数组的长度n*m
//        int lenm = matrix[0].length;
//        for(int i = 0;i < lenn;i++){//两次循环
//            for(int j = 0;j < lenm;j++){
//                if(matrix[i][j] == target){
//                    return true;
//                }
//            }
//        }
//        return false;

        /**
         * 方法二：线性查找，降低时间复杂度
         * [
         *   [1,   4,  7, 11, 15],
         *   [2,   5,  8, 12, 19],
         *   [3,   6,  9, 16, 22],
         *   [10, 13, 14, 17, 24],
         *   [18, 21, 23, 26, 30]
         * ]
         *      分析，如上述矩阵所示，如何快速的查找到需要的元素。
         *      观察四个角的元素，
         *      左上角，右走和下走元素都增大不可以。
         *      左下角，上走减小，右走增大可以。
         *      右上角，下走增大，左走减小可以。
         *      右下角，上走减小，左走减小不可以。
         *      因此我们可以使用左下角元素，或右上角元素为起始值判断。
         */
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0 ) //特殊条件，数组为空，或者长度为0时
            return false;
        int rows = matrix.length;//获取数组的长度n*m,行列值
        int columns = matrix[0].length;
        int n = rows - 1;  //定义初始值，左下角元素
        int m = 0;
        while(n >= 0 && m < columns){
//          一旦相等返回true
            if(matrix[n][m]==target){
                return true;
            }
//          判断元素处于上半部分还是下半部分
            else if(matrix[n][m]>target){
                n--;
            }
            else if(matrix[n][m]<target){
                m++;
            }

        }
        return false;



    }
}