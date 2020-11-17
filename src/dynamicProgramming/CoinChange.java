package dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wsh
 * @date 2020-11-17
 */
public class CoinChange {

    //暴力解法，缺点：子问题的解决冗余，时间复杂度为指数级的
    public static int coinChange(List<Integer> coins, int amount) {
        if(amount == 0) {
            return 0;
        }
        if(amount < 0) {
            return -1;
        }
        Integer result = Integer.MAX_VALUE;
        for (Integer coin : coins) {
            int subResult = coinChange(coins, amount - coin);
            if(subResult == -1) {
                continue;
            }
            result = Math.min(result, subResult + 1);
        }
        return result;
    }
    //-----------------------------------------------------------------------------------

    //使用book备忘录式的解决问题
    public static int coinChangeBook(List<Integer> coins, int amount, Map<Integer, Integer> book) {
        if(amount == 0) {
            return 0;
        }
        if(amount < 0) {
            return -1;
        }
        if(book.containsKey(amount)) {
            return book.get(amount);
        }
        Integer result = Integer.MAX_VALUE;
        for (Integer coin : coins) {
            int subResult = coinChange(coins, amount - coin);
            if(subResult == -1) {
                continue;
            }
            result = Math.min(result, subResult + 1);
        }
        book.put(amount, result);
        return result;
    }

    public static int coinChangeNo2(List<Integer> coins, int amount) {
        Map<Integer, Integer> book = new HashMap<>();
        return coinChangeBook(coins, amount, book);
    }

    //-----------------------------------------------------------------------------------

    //dp[i] = n dp公式表示 凑够i元最小需要的数量
    public static int coinChangeNo3(List<Integer> coins, int amount) {
        //记录每个amount的最小需要的金币数量
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = i + 1;
        }
        //定义base情况
        dp[0] = 0;
        //计算每个amount最小的需要金币数量
        for (int i = 0; i <= amount; i++) {
            //解决子问题
            for (Integer coin : coins) {
                if(i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount];
    }


    public static void main(String[] args) {
        List<Integer> coins = new ArrayList<>();
        coins.add(1);
        coins.add(2);
        coins.add(5);

        System.out.println(coinChangeNo3(coins, 17));
    }
}
