package bisectionMethod;

/**
 * @author wsh
 * @date 2020-11-19
 */
public class BisectionStructure {
//    public int binarySearch(int[] nums, int target) {
//        int left = 0; right = ....;
//        while (...) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] == target) {
//                ...
//            }else if(nums[mid] < target) {
//                left = ...;
//            }else if(nums[mid] > target) {
//                right = ...;
//            }
//        }
//        return ...;
//    }

    //查找一个数，使用左闭右开的搜索区间
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            }else if(nums[mid] < target) {
                left = mid + 1;
            }else if(nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    //查找最左边的数（存在多个target）
    public int leftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                //找到了结果不返回，锁定左侧边界
                right = mid - 1;
            }else if(nums[mid] < target) {
                left = mid + 1;
            }else if(nums[mid] > target) {
                right = mid - 1;
            }
        }
        //需要判断是left否越界
        if(left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    //查找最右边的数（存在多个target）
    public int rightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                left = mid + 1;
            }else if (nums[mid] < target) {
                left = mid + 1;
            }else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        //最后判断right是否越界
        if(right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }
}
