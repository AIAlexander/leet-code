package dynamicProgramming;

/**
 * @author wsh
 * @date 2021-04-21
 */
public class NumArrayNo303 {

    int[] sums;

    public NumArrayNo303(int[] nums) {
        sums = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                sums[i] = nums[i];
            }else {
                sums[i] = nums[i] + sums[i - 1];
            }
        }
    }

    public int sumRange(int left, int right) {
        return left == 0 ? sums[right] : sums[right] - sums[left - 1];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArrayNo303 n = new NumArrayNo303(nums);
        System.out.println(n.sumRange(2, 5));;
    }
}
