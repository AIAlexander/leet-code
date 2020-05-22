package doublePointer;

/**
 * @author wsh
 * @date 2020-02-25
 *
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-square-numbers
 */
public class SumOfSquareNumberNo633 {


    public static void main(String[] args) {

        System.out.println(judgeSquareSum(25));
    }

    /**
     * 本题和 167. Two Sum II - Input array is sorted 类似。本题同样可以使用双指针得到两个数，使其平方和为 target。
     *
     * 本题的关键是右指针的初始化，实现剪枝，从而降低时间复杂度。设右指针为 x，左指针固定为 0，为了使 02 + x2 的值尽可能接近 target，我们可以将 x 取为 sqrt(target)。
     *
     * 因为最多只需要遍历一次 0~sqrt(target)，所以时间复杂度为 O(sqrt(target))。又因为只使用了两个额外的变量，因此空间复杂度为 O(1)。
     * @param c
     * @return
     */
    public static boolean judgeSquareSum(int c) {
        if(c < 0){
            return false;
        }
        int head = 0;
        int tail = (int)Math.sqrt(c);
        while(tail >= head){
            int sum = head * head + tail * tail;
            if(sum == c){
                return true;
            }else if(sum < c){
                head++;
            }else{
                tail--;
            }
        }
        return false;
    }

}
