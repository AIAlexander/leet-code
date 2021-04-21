package dynamicProgramming;

/**
 * @author wsh
 * @date 2021-04-21
 *
 * 预约按摩师，要求按摩师不能选择相邻的预约时间
 * 要求按摩师选择的预约时间最大
 *
 * 动态规划
 * dp[i] 表示0到i的最长预约时间
 *
 * 状态方程： dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i])
 * 表示按摩师需要从dp[i -1]或者 dp[i - 2] + nums[i] 中取到最好的
 *
 */
public class Massage {

    public int massage(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        dp[0] = nums[0];
        //注意base case也需要进行计算
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        Massage m = new Massage();
        int[] nums = {2,1,4,5,3,1,1,3};
        System.out.println(m.massage(nums));
    }
}
