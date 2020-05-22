import java.util.HashMap;

/**
 * @author wsh
 * @date 2020-02-16
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSumSolution {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int target = 6;
        int []result = twoSum(nums, target);
        System.out.println(result[0] + " ," + result[1]);
    }

    /**
     * 时间复杂度为O（n），空间复杂度为O（n）
     * 解题思路，遍历数组，从map中找到target-数组中的值，如果找到则返回结果，如果没有找到则将数组中的元素以及对应的下标放到map中
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int []nums, int target){
        HashMap<Integer, Integer> map = new HashMap();
        int[] result = new int[2];
        if(nums == null || nums.length <= 1){
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
           int num = nums[i];
           int subNum = target - num;
           if(map.containsKey(subNum)){
               result[0] = i;
               result[1] = map.get(subNum);
               return result;
           }else {
               map.put(num, i);
           }
        }
        return result;
    }

}
