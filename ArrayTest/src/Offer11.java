/**
 * @author yulinsheng
 * @time 2021-04-27 18:40
 */

import java.util.Arrays;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 示例 1：
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * * 输入：[2,2,2,0,1]
 * 输出：0
 */
public class Offer11 {
}

class SolutionOffer11{
    public int minArray(int[] numbers) {
        /**
         * 思路分析，简单的思路时将数组排序，返回第一个值就是最小值
         * 利用了Arrays.sort()排序
         * 执行用时：1 ms, 在所有 Java 提交中击败了24.64%的用户
         * 内存消耗：38.2 MB, 在所有 Java 提交中击败了65.55%的用户
         */
        Arrays.sort(numbers);
        return numbers[0];
    }
}