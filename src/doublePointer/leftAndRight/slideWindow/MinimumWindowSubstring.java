package doublePointer.leftAndRight.slideWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wsh
 * @date 2020-11-16
 *
 * 使用滑动窗口找出最小覆盖字串
 */
public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] target = t.toCharArray();
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : target) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        //记录最小覆盖字符串的起始索引和长度
        int start = 0;
        int length = Integer.MAX_VALUE;
        while (right < sArray.length) {
            //c是移入窗口的字符
            char c = sArray[right];
            right++;
            //进行窗口内的数据更新
            if(need.containsKey(c)) {
                Integer update = window.get(c) == null ? 1 : window.get(c) + 1;
                window.put(c, update);
                if(window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            //判断左侧窗口是否要收缩
            while (valid == need.size()) {
                //在这里更新最小覆盖字串
                if(right - left < length) {
                    start = left;
                    length = right - left;
                }
                //d是将移出窗口的字符
                char d = sArray[left];
                //窗口左移
                left++;
                //进行窗口内的数据更新
                if(need.containsKey(d)) {
                    if(window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    Integer update = window.get(d) == null ? 0 : window.get(d) - 1;
                    window.put(d, update);
                }
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
    }

    public static void main(String[] args) {
        //"ADOBECODEBANC"
        //"ABC"
        String s = "aa";
        String t = "aaa";
        System.out.println(minWindow(s, t));
    }
}
