package bisectionMethod;

/**
 * @author wsh
 * @date 2020-03-02
 *
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 输入: 4
 * 输出: 2
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SqrtXNo69 {

    public static void main(String[] args) {
        System.out.println(mySqrt2(8));
    }

    public static int mySqrt(int x) {
        long left = 0;
        long right = x;
        while (left <= right){
            Long mid = left + (right - left) / 2;
            if(mid * mid <= x && ((mid + 1) * (mid + 1) > x)){
                return mid.intValue();
            }else if(mid * mid > x){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return 0;
    }


    public static int mySqrt2(int x){
        int min = 0;
        int max = x;
        while (max - min > 1){
            int mid = (min + max) / 2;
            if(x / mid > mid){
                min = mid;
            }else{
                max = mid;
            }
        }
        return min;
    }


}
