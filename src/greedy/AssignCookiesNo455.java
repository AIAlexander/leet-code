package greedy;

import java.util.Arrays;

/**
 * @author wsh
 * @date 2020-02-26
 *
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。
 * 如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 * 输入: [1,2,3], [1,1]
 *
 * 输出: 1
 *
 * 解释:
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/assign-cookies
 */
public class AssignCookiesNo455 {

    public static void main(String[] args) {
        int[] g = new int[]{1, 2};
        int[] s = new int[]{1, 2, 3};
        System.out.println(findContentChildren(g, s));
    }


    /**
     * 解题思路：
     * 局部的最优解就是最小的饼干满足最小胃口的孩子，因此先进行排序，然后拿最小尺寸的饼干满足孩子
     *
     * 假设在某次选择中，贪心策略选择给当前满足度最小的孩子分配第 m 个饼干，第 m 个饼干为可以满足该孩子的最小饼干。
     * 假设存在一种最优策略，可以给该孩子分配第 n 个饼干，并且 m < n。
     * 我们可以发现，经过这一轮分配，贪心策略分配后剩下的饼干一定有一个比最优策略来得大。
     * 因此在后续的分配中，贪心策略一定能满足更多的孩子。也就是说不存在比贪心策略更优的策略，即贪心策略就是最优策略。
     * @param g
     * @param s
     * @return
     */
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);     //孩子的胃口从小到大排序
        Arrays.sort(s);     //饼干的尺寸从小到大排序
        int i = 0;
        int j = 0;
        int count = 0;
        while(i != g.length && j != s.length){
            //饼干尺寸能够满足胃口
            if(s[j] >= g[i]){
                i++;
                j++;
                count++;
            }else{
                j++;
            }
        }
        return count;
    }
}
