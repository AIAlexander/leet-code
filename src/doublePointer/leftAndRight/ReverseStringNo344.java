package doublePointer.leftAndRight;

/**
 * @author wsh
 * @date 2020-11-16
 *
 * 反转数组，使用左右双指针，相同的速度遍历，交换彼此
 */
public class ReverseStringNo344 {
    public static char[] reverseString(char[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
        return array;
    }

    public static void main(String[] args) {
        char[] array = new char[]{'h', 'e', 'l', 'l', 'o'};
        char[] result = reverseString(array);
        System.out.println(result);
    }
}
