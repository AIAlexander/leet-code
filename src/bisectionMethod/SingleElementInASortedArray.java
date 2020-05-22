package bisectionMethod;

/**
 * @author wsh
 * @date 2020-03-02
 */
public class SingleElementInASortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2, 4, 4, 8, 8, 9, 9};
        System.out.println(singleNonDuplicate(nums));
    }

    public static int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        return findNonDuplicateResult(nums, l, r);
    }

    public static int findNonDuplicateResult(int[] nums, int l, int r){
        if(l >= r){
            return 0;
        }
        int mid = l + (r - l) / 2;
        if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]){
            return nums[mid];
        }else {
           int result =  findNonDuplicateResult(nums, mid + 1, r);
           if(result != 0){
               return result;
           }
           result = findNonDuplicateResult(nums, l, mid - 1);
           if(result != 0){
                return result;
            }
        }
        return 0;
    }
}
