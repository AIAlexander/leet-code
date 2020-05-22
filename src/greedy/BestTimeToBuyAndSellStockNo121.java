package greedy;

/**
 * @author wsh
 * @date 2020-02-27
 *
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 */
public class BestTimeToBuyAndSellStockNo121 {

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    /**
     * 使用贪心算法，遍历每天的价格，找到最小价格，如果最小价格小于其他价格，就计算最大的profit
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int minPrice = prices[0];
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if(minPrice > prices[i]){
                minPrice = prices[i];
            }else {
                profit = Math.max(profit, prices[i] - minPrice);
            }
        }
        return profit;
    }
}
