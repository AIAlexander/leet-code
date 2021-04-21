package dynamicProgramming;

/**
 * @author wsh
 * @date 2021-04-21
 *
 * 用动态规划考虑
 * 状态描述：dp[i]表示数组从0到i的最大连续和
 * 因此第 i + 1的最大值应该看之前的值是不是小于0，如果小于0就抛弃；如果大于0就加上之前的和
 * 所以状态方程为：
 *      dp[i] = num[i]                  if dp[i - 1] < 0
 *      dp[i] = num[i] + dp[i - 1]      if dp[i - 1] >= 0
 */
public class MaxSubArrayNo53 {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        //base case
        dp[0] = nums[0];
        int maxSum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            dp[i] = dp[i -1] < 0 ? nums[i] : nums[i] + dp[i - 1];
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaxSubArrayNo53 m = new MaxSubArrayNo53();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(m.maxSubArray(nums));
    }
}
