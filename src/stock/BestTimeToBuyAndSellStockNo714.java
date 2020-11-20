package stock;

/**
 * @author wsh
 * @date 2020-11-19
 *
 * 交易有手续费
 */
public class BestTimeToBuyAndSellStockNo714 {
    public static int maxProfit(int[] prices, int fee) {
        int dp00 = 0;
        int dp01 = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++) {
            //记录上一次的dp00
            int temp = dp00;
            dp00 = Math.max(dp00, dp01 + prices[i]);
            dp01 = Math.max(dp01, temp - prices[i] - fee);
        }
        return dp00;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,3,2,8,4,9};
        System.out.println(maxProfit(prices, 2));
    }
}
