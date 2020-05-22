package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wsh
 * @date 2020-02-26
 *
 * Given a collection of intervals,
 * find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 *
 *
 * Input: [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 *
 * Input: [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 * 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 */
public class NonOverlappingIntervalsNo435 {

    public static void main(String[] args) {
        int[][] intervals = new int[4][2];
        intervals[0] = new int[]{1, 2};
        intervals[1] = new int[]{2, 3};
        intervals[2] = new int[]{3, 4};
        intervals[3] = new int[]{3, 5};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    /**
     * 贪心算法，按照起点排序：选择结尾最短的，后面才可能连接更多的区间（如果两个区间有重叠，应该保留结尾小的）
     * 把问题转化为最多能保留多少个区间，使他们互不重复，则按照终点排序，
     * 每个区间的结尾很重要，结尾越小，则后面越有可能容纳更多的区间。
     * @param intervals
     * @return
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        //先将区间根据结束区间从小到大排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        //初始化，end为第一个区间的结束值
        int end = intervals[0][1];
        //初始化，组成无重叠的区间的最大值
        int num = 1;
        //从第二个开始遍历所有区间
        for (int i = 1; i < intervals.length; i++) {
            //如果某个区间的开始值小于无重叠区间的结束值，则说明该区间可以删除
            if(intervals[i][0] < end){
                continue;
            }
            //如果不是，则说明它能够组成无重叠的区间
            num++;
            //并且更新无重叠区间的结束值
            end = intervals[i][1];
        }
        //删除的区间数量 = 所有区间的数量 - 能够组成无重叠的区间的数量
        return intervals.length - num;
    }
}
