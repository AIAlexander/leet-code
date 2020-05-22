package bisectionMethod;

/**
 * @author wsh
 * @date 2020-03-02
 *
 *
 * Input : [1,2,3,4,5]
 * key : 3
 * return the index : 2
 */
public class SimpleExample {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int target = 5;
        System.out.println(binarySearch(nums, target));
    }

    public static int binarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }


}
