package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wsh
 * @date 2020-11-16
 *
 * 斐波那契数列，自顶向下地使用备忘录地形式动态规划解决问题
 */
public class FibExample {

    public static int fib(int n) {
        Map<Integer, Integer> book = new HashMap<>();
        if(n < 1) return 0;
        //设置备忘录
        for(int i = 0; i <= n; i++) {
            //初始化备忘录
            book.put(i, 0);
        }
        return bookCal(book, n);
    }

    public static int bookCal(Map<Integer, Integer> book, int n) {
        if(n == 1 || n == 2) {
            return 1;
        }
        if(!book.get(n).equals(0)) {
            return book.get(n);
        }
        book.put(n, bookCal(book, n - 1) + bookCal(book, n - 2));
        return book.get(n);
    }

    // ---------------------------------------------------------

    //方式二：自底向上动态规划
    public static int fibNew(int n) {
        Map<Integer, Integer> dp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            dp.put(i, 0);
        }
        dp.put(1, 1);
        dp.put(2, 1);
        for (int i = 3; i <= n; i++) {
            dp.put(i, dp.get(i - 1) + dp.get(i - 2));
        }
        return dp.get(n);
    }

    public static void main(String[] args) {
        System.out.println(fibNew(3));
    }
}
