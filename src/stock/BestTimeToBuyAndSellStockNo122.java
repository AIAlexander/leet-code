package stock;

/**
 * @author wsh
 * @date 2020-11-19
 *
 * 完成多次交易
 *
 * 状态转化方程:
 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
 * i为天数，k为交易次数，0 or 1 表示是否持有股票
 *
 * 因为k为无穷大，不影响状态，因此不用记
 *
 * Base case:
 * dp[-1][k][0] = 0,  dp[-1][k][1] = Min
 * dp[i][0][0] = 0,   dp[i][0][1] = Min
 *
 * 此题的转换方程：
 * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
 * dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
 */
public class BestTimeToBuyAndSellStockNo122 {

    public static int maxProfit(int[] prices) {
        int dp00 = 0;
        int dp01 = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++) {
            //记录上一次的dp00
            int temp = dp00;
            dp00 = Math.max(dp00, dp01 + prices[i]);
            dp01 = Math.max(dp01, temp - prices[i]);
        }
        return dp00;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
