package doublePointer;

/**
 * @author wsh
 * @date 2020-02-25
 */
public class MergeSortedArrayNo88 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }

    /**
     * 需要从尾开始遍历，否则在 nums1 上归并得到的值会覆盖还未进行归并比较的值。
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int indexMerge = m + n - 1;
        while(index1 >= 0 || index2 >= 0){
            if(index1 < 0){
                nums1[indexMerge] = nums2[index2];
                indexMerge--;
                index2--;
            }
            else if(index2 < 0){
                nums1[indexMerge] = nums1[index1];
                indexMerge--;
                index1--;
            }
            else if(nums2[index2] > nums1[index1]){
                nums1[indexMerge] = nums2[index2];
                indexMerge--;
                index2--;
            }else if(nums2[index2] <= nums1[index1]){
                nums1[indexMerge] = nums1[index1];
                index1--;
                indexMerge--;
            }
        }
    }
}
