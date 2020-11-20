package stock;

/**
 * @author wsh
 * @date 2020-11-19
 *
 * 交易的时候有冷冻期，隔一天才可以购买
 */
public class BestTimeToBuyAndSellStockNo309 {

    public static int maxProfit(int[] prices) {
        int dp00 = 0;
        int dp01 = Integer.MIN_VALUE;
        int dpPre00 = 0;
        for (int i = 0; i < prices.length; i++) {
            int temp = dp00;
            dp00 = Math.max(dp00, dp01 + prices[i]);
            //表示如果要持有股票，只有两天前买
            dp01 = Math.max(dp01, dpPre00 - prices[i]);
            //dpPre00 是上一次的temp
            dpPre00 = temp;
        }
        return dp00;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,2,3,0,2};
        System.out.println(maxProfit(prices));
    }
}
