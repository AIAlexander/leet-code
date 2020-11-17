package doublePointer.leftAndRight.slideWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wsh
 * @date 2020-11-16
 */
public class LongestSubstringWithoutRepeatingCharactersNo3 {

    public static int lengthOfLongestSubstring(String s) {
        char[] sArray = s.toCharArray();
        int left = 0, right = 0;
        int length = 0;
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        //窗口扩大
        while(right < sArray.length) {
            //窗口扩大需要处理的元素
            char c = sArray[right];
            //窗口右移
            right++;
            //更新数据
            window.put(c, window.getOrDefault(c, 0) + 1);

            //窗口收缩
            while(window.get(c) > 1) {
                char d = sArray[left];
                left++;
                window.put(d, window.getOrDefault(d, 0) - 1);
            }
            length = Math.max(length, right - left);
        }
        return length;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
