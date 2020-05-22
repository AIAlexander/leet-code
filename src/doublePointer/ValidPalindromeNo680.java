package doublePointer;

/**
 * @author wsh
 * @date 2020-02-25
 *
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 *
 * Input: "aba"
 * Output: True
 */
public class ValidPalindromeNo680 {

    public static void main(String[] args) {

        System.out.println(validPalindrome("abca"));

    }

    /**
     * 如果首尾相等，则首++，尾--
     * 如果首尾不相等，则判断（首++， 尾）是不是一个回文，或者判断（首， 尾--）是不是一个回文
     *
     * 时间复杂度O(n)
     * @param s
     * @return
     */
    public static boolean validPalindrome(String s) {
        int head = 0;
        int tail = s.length() - 1;
        while(head < tail){
            char headChar = s.charAt(head);
            char tailChar = s.charAt(tail);
            if(headChar == tailChar){
                head++;
                tail--;
            }
            else{
                String part = s.substring(head, tail);
                if(isPalindrome(part)){
                    return true;
                }
                part = s.substring(head + 1, tail + 1);
                if(isPalindrome(part)){
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String s){
        int head = 0;
        int tail = s.length() - 1;
        while (head <= tail){
            char headChar = s.charAt(head);
            char tailChar = s.charAt(tail);
            if(headChar == tailChar){
                head++;
                tail--;
            }else{
                return false;
            }
        }
        return true;
    }


    public static boolean validPalindrome2(String s){
        int i = 0;
        int j = s.length() - 1;
        while (i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return isValid(s, i + 1, j) || isValid(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }


    private static boolean isValid(String s, int i, int j){
        while (i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
