package doublePointer.leftAndRight;

/**
 * @author wsh
 * @date 2020-11-16
 */
public class BinarySearch {

    public static Integer binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if(target == array[mid]) {
                return mid;
            }else if(target < array[mid]) {
                right = mid - 1;
            }else if(target > array[mid]) {
                left = mid + 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 5, 6, 7, 8, 10};
        System.out.println(binarySearch(array, 9));
    }
}
