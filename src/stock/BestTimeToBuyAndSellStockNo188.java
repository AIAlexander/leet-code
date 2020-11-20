package stock;

/**
 * @author wsh
 * @date 2020-11-19
 *
 * 完成k次交易
 *
 * 状态转化方程:
 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
 * i为天数，k为交易次数，0 or 1 表示是否持有股票
 *
 * 此题不需要转化，直接遍历即可
 */
public class BestTimeToBuyAndSellStockNo188 {

    public static int buyAndSellStock(int[] prices, int k) {
        //交易次数不能够超出天数的一半
        if(k > prices.length / 2) {
            k = prices.length / 2;
        }
        int[][][] dp = new int[prices.length][k + 1][2];
        for (int i = 0; i < prices.length; i++) {
            for (int k1 = k; k1 >= 1; k1--) {
                if(i == 0) {
                    dp[i][k1][0] = 0;
                    dp[i][k1][1] = -prices[i];
                }else{
                    dp[i][k1][0] = Math.max(dp[i-1][k1][0], dp[i-1][k1][1] + prices[i]);
                    dp[i][k1][1] = Math.max(dp[i-1][k1][1], dp[i-1][k1 - 1][0] - prices[i]);
                }
            }
        }
        return dp[prices.length - 1][k][0];
    }

    public static void main(String[] args) {
        int[] stock = new int[]{3,2,6,5,0,3};
        System.out.println(buyAndSellStock(stock, 2));
    }
}
