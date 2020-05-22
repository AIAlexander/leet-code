package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wsh
 * @date 2020-02-26
 *
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。
 * 由于它是水平的，所以y坐标并不重要，因此只要知道开始和结束的x坐标就足够了。开始坐标总是小于结束坐标。平面内最多存在104个气球。
 *
 * 一支弓箭可以沿着x轴从不同点完全垂直地射出。
 * 在坐标x处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。
 * 可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 *
 * 输入:
 * [[10,16], [2,8], [1,6], [7,12]]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 对于该样例，我们可以在x = 6（射爆[2,8],[1,6]两个气球）和 x = 11（射爆另外两个气球）。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons
 */
public class MinimumNumbersOfArrowsToBrustBallons {

    public static void main(String[] args) {
        int[][] points = new int[4][2];
        points[0] = new int[]{10, 16};
        points[1] = new int[]{2, 8};
        points[2] = new int[]{1, 6};
        points[3] = new int[]{7, 12};
        System.out.println(findMinArrowShots(points));
    }

    /**
     * 方法：贪心算法
     * 贪心算法一般用来解决需要 “找到要做某事的最小数量” 或 “找到在某些情况下适合的最大物品数量” 的问题，且提供的是无序的输入。
     *
     * 贪心算法的思想是每一步都选择最佳解决方案，最终获得全局最佳的解决方案。
     *
     *
     * 让我们根据气球的结束坐标进行排序，然后一个个进行检查
     *
     * 这代表了我们可以跟踪气球的结束坐标，若下个气球开始坐标在当前气球的结束坐标前，则我们可以用一支箭一起引爆；
     * 若下个气球的开始坐标在当前气球的结束坐标后，则我们必须增加箭的数量。并跟踪下个气球的结束坐标。
     *
     * @param points
     * @return
     */
    public static int findMinArrowShots(int[][] points) {
        if(points.length == 0){
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int minArrow = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if(points[i][0] <= end){
                continue;
            }
            end = points[i][1];
            minArrow++;
        }
        return minArrow;
    }
}
