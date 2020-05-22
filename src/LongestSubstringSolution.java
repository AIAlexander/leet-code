import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author wsh
 * @date 2020-02-17
 *
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 */
public class LongestSubstringSolution {
    public static void main(String[] args) {
        String a = "abcdbe";
        System.out.println(lengthOfLongestSubstring(a));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int left = 0;
        int right = 0;
        int n = s.length();
        boolean[] used = new boolean[128];
        int length = 0;
        while (right < n){
            if(!used[s.charAt(right)]){
                used[s.charAt(right)] = true;
                right++;
            }else{
                length = Math.max(length, right - left);
                while(left < right && s.charAt(left) != s.charAt(right)){
                    used[s.charAt(left)] = false;
                    left++;
                }
                left++;
                right++;
            }
        }
        length = Math.max(length, right - left);
        return length;
    }

}
