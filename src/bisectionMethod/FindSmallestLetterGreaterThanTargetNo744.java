package bisectionMethod;

/**
 * @author wsh
 * @date 2020-03-02
 *
 *
 * 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。
 *
 * 数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "a"
 * 输出: "c"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "d"
 * 输出: "f"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "k"
 * 输出: "c"
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target
 */
public class FindSmallestLetterGreaterThanTargetNo744 {

    public static void main(String[] args) {
        char[] letters = new char[]{'c', 'f', 'j'};
//        char[] letters = new char[]{'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n', 'n', 'n'};
        char target = 'n';
        System.out.println(nextGreatestLetter(letters, target));
    }

    /**
     * 使用二分法，要注意边界处理以及等于的情况
     * @param letters
     * @param target
     * @return
     */
    public static char nextGreatestLetter(char[] letters, char target) {
        if(letters == null || letters.length < 2){
            return ' ';
        }
        int l = 0;
        int r = letters.length - 1;
        if (target < letters[l] || target >= letters[r]){
            return letters[l];
        }

        while(r - l > 1){
            int mid = l + (r - l) / 2;
            if(letters[mid] > target){
                r = mid;
            }else{
                l = mid;
            }
        }
        return letters[r];
    }
}
