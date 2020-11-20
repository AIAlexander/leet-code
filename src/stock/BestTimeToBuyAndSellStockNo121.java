package stock;

/**
 * @author wsh
 * @date 2020-11-19
 *
 * 完成一次交易
 */
public class BestTimeToBuyAndSellStockNo121 {

    public static int buyAndSellStock(int[] stock) {
        int dp00 = 0;
        int dp01 = Integer.MIN_VALUE;
        for (int i = 0; i < stock.length; i++) {
            dp00 = Math.max(dp00, dp01 + stock[i]);
            dp01 = Math.max(dp01, -stock[i]);
        }
        return dp00;
    }

    public static void main(String[] args) {
        int[] stock = new int[]{1,100,5,100,6,4};
        System.out.println(buyAndSellStock(stock));
    }
}
