package dynamicProgramming;

/**
 * @author wsh
 * @date 2021-04-21
 */
public class MinCostClimbingStairsNo746 {

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        //base case;
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return dp[cost.length - 1] >= dp[cost.length - 2] ? dp[cost.length - 2] : dp[cost.length - 1];
    }

    public static void main(String[] args) {
        MinCostClimbingStairsNo746 s = new MinCostClimbingStairsNo746();
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(s.minCostClimbingStairs(cost));
    }
}
