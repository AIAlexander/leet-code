package doublePointer.leftAndRight.slideWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wsh
 * @date 2020-11-16
 *
 * 字符串排列，使用滑动窗口
 */
public class PermutationInStringNo567 {

    public static boolean checkInclusion(String s1, String s2) {
        char[] sArray = s1.toCharArray();
        char[] target = s2.toCharArray();
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : target) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        //窗口扩大
        while(right < sArray.length) {
            //需要移入窗口的元素
            char c = sArray[right];
            //窗口向右滑动
            right++;
            //更新数据
            if(need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            //窗口收缩条件
            while (right - left >= target.length) {
                if(valid == need.size()) {
                    return true;
                }
                //移除窗口的元素
                char d = sArray[left];
                //窗口向左滑动
                left++;
                //更新数据
                if(need.containsKey(d)) {
                    if(window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //"abcdxabcde"
        //"abcdeabcdx"
        String s1 = "aacdxabcde";
        String s2 = "aacdeabcdx";
        System.out.println(checkInclusion(s1, s2));
    }

}
