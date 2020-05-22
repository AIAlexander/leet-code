package offer;

import java.util.Arrays;

/**
 * @author wsh
 * @date 2020-02-27
 */
public class RepeatNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
    }

    public static int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length <= 0){
            return 0;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1]){
                return nums[i];
            }
        }
        return 0;
    }
}
