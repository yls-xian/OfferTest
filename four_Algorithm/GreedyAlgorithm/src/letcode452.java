/**
 * @author yulinsheng
 * @time 2021-05-11 15:47
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。
 由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。
 在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足 xstart≤ x ≤ xend，则该气球会被引爆。
 可以射出的弓箭的数量没有限制。
 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。

 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。

 示例 1：

 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 输出：2
 解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
 示例 2：

 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 输出：4
 示例 3：

 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 输出：2
 示例 4：

 输入：points = [[1,2]]
 输出：1
 示例 5：

 输入：points = [[2,3],[2,3]]
 输出：1

 */
public class letcode452 {
    public static void main(String[] args) {
        int [][] points = new int [][]{{10,16},{2,8},{1,9},{7,12}};
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]>o2[1]){
                    return 1;
                }
                else if(o1[1]<o2[1]){
                    return -1;
                }
                else {
                    return 0;
                }
            }
        });
        for(int i = 0 ;i< points.length;i++){
            for(int j = 0;j < points[0].length;j++){
                System.out.print(points[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
class Solution452{
    public int findMinArrowShots(int[][] points) {
        /**
         * 贪心思想，
         * 最优解是在保证气球全部破裂的情况下射出的箭最少。
         * 子问题的最优解是，每次射箭尽可能多的射中气球。
         *
         * 思路首先是将气球坐标，排列好顺序。按照最右边坐标排列。为什么是右边界，因为第一箭肯定是右边界位置最靠左的那个。
         * 执行用时：21 ms, 在所有 Java 提交中击败了51.12%的用户
         * 内存消耗：45.8 MB, 在所有 Java 提交中击败了83.70%的用户
         *
         *
         */
        //特殊情况，当points的长度为0时，返回0
        if(points.length==0)
            return 0;
        //重写sort的comparator方法，对points排序，根据最右边元素值排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]>o2[1]){
                    return 1;
                }
                else if(o1[1]<o2[1]){
                    return -1;
                }
                else {
                    return 0;
                }
            }
        });
        //初始化最终的箭的个数
        int res = 1;
        //获得起点值，右边坐标最小的值
        int pos = points[0][1];
        for(int [] ballon : points){
            //一旦射的箭小于下一个元素的最左边边界，也就是说此时下一个气球没办法用当前的箭射破，此时我们需要增加新的箭。
            if(pos<ballon[0]){
                pos = ballon[1];
                res++;
            }
        }
        return res;



    }

}
