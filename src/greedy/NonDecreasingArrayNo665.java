package greedy;

/**
 * @author wsh
 * @date 2020-02-27
 *
 *
 * 给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。
 *
 * 输入: [4,2,3]
 * 输出: True
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-decreasing-array
 */
public class NonDecreasingArrayNo665 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 3, 2, 4};
        System.out.println(checkPossibility(nums));
    }

    public static boolean checkPossibility(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            //通过比较找出不符合的数据
            if(nums[i] > nums[i + 1]){
                //i==0的情况是第一个数字不符合，比如： {4, 2, 3}，因此只要把不符合的数字变成下一个数字即可
                if(i == 0){
                    nums[i] = nums[i + 1];
                }
                //这种情况是中间某个数不符合，比如：{-1, 4, 2, 3},因为不符合后面的数字大于不符合前面的数字，因此
                else if(nums[i + 1] >= nums[i - 1]){
                    nums[i] = nums[i - 1];
                }else if(nums[i + 1] < nums[i - 1]){
                    nums[i + 1] = nums[i];
                }
                return isDecreasing(nums);
            }
        }
        return true;
    }

    private static boolean isDecreasing(int[] nums){
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i + 1]){
                return false;
            }
        }
        return true;
    }


}
