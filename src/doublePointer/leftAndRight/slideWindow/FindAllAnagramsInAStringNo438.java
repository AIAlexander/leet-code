package doublePointer.leftAndRight.slideWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wsh
 * @date 2020-11-16
 */
public class FindAllAnagramsInAStringNo438 {

    public static List<Integer> findAnagrams(String s, String p) {
        char[] sArray = s.toCharArray();
        char[] target = p.toCharArray();
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : target) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        List<Integer> result = new ArrayList<>();
        //窗口扩大
        while (right < sArray.length) {
            //窗口扩大移动进去的元素
            char c = sArray[right];
            //窗口右移
            right++;
            //更新相关的数据
            if(need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            //窗口收缩
            while(right - left >= target.length) {
                if(need.size() == valid) {
                    result.add(left);
                }
                //窗口缩小移动出去的元素
                char d = sArray[left];
                //窗口左移
                left++;
                //更新相关的数据
                if(need.containsKey(d)) {
                    if(window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "baa";
        String t = "aa";
        System.out.println(findAnagrams(s, t));
    }
}
