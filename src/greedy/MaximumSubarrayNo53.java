package greedy;

/**
 * @author wsh
 * @date 2020-02-27
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 *
 */
public class MaximumSubarrayNo53 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    /**
     * 解题思路：
     * 遍历所有数字，并求总和，如果算出某个和小于0，就从新开始计算总和，并记录下来
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int result = nums[0];
        for (int num : nums) {
            if(sum > 0){
                sum += num;
            }else{
                sum = num;
            }
            result = Math.max(result, sum);
        }
        return result;
    }
}
