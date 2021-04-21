package dynamicProgramming;

/**
 * @author wsh
 * @date 2021-04-21
 *
 * base case ： f[0] = 1 f[1] = 1
 *
 * 状态转移方程：f[n] = f[n - 1] + f[n - 2]
 *
 */
public class ClimbStairsNo70 {

    public int climbStairs(int n) {
        //base case
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        //状态转移方程
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        ClimbStairsNo70 c = new ClimbStairsNo70();
        System.out.println(c.climbStairs(3));


    }
}
