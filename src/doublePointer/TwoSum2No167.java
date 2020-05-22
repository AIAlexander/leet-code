package doublePointer;

/**
 * @author wsh
 * @date 2020-02-25
 *
 *
 * Given an array of integers that is already sorted in ascending order,
 * find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 *
 * Note:
 *
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 */
public class TwoSum2No167 {

    public static void main(String[] args) {

        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 14;

        int[] result = twoSum(numbers, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }


    /**
     * 如果两个指针指向元素的和 sum == target，那么得到要求的结果；
     * 如果 sum > target，移动较大的元素，使 sum 变小一些；
     * 如果 sum < target，移动较小的元素，使 sum 变大一些。
     * 数组中的元素最多遍历一次，时间复杂度为 O(N)。只使用了两个额外变量，空间复杂度为 O(1)。
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null){
            return null;
        }
        int tail = numbers.length - 1;
        for (int head = 0; head != tail; ){
            int sum = numbers[head] + numbers[tail];
            if(sum == target){
                return new int[]{head + 1, tail + 1};
            }
            else if(sum > target){
                tail--;
            }
            else{
                head++;
            }
        }
        return null;
    }
}
