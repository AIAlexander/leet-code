package stock;

/**
 * @author wsh
 * @date 2020-11-19
 *
 * 只能完成2笔交易
 *
 * 状态转化方程:
 *
 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
 * i为天数，k为交易次数，0 or 1 表示是否持有股票
 *
 * Base case:
 * dp[-1][k][0] = 0,  dp[-1][k][1] = Min
 * dp[i][0][0] = 0,   dp[i][0][1] = Min
 *
 * 此题目根据公式：
 * dp[i][2][0] = max(dp[i-1][2][0], dp[i-1][2][1] + prices[i])
 * dp[i][2][1] = max(dp[i-1][2][1], dp[i-1][1][0] - prices[i])
 * dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
 * dp[i][1][1] = max(dp[i-1][1][1],  -prices[i])
 *
 */
public class BestTimeToBuyAndSellStockNo123 {

    public static int maxProfit(int[] prices) {
        int dpi20 = 0;
        int dpi21 = Integer.MIN_VALUE;
        int dpi10 = 0;
        int dpi11 = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++) {
            dpi20 = Math.max(dpi20, dpi21 + prices[i]);
            dpi21 = Math.max(dpi21, dpi10 - prices[i]);
            dpi10 = Math.max(dpi10, dpi11 + prices[i]);
            dpi11 = Math.max(dpi11, -prices[i]);
        }
        return dpi20;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,2,3,4,5};
        System.out.println(maxProfit(prices));
    }

}
