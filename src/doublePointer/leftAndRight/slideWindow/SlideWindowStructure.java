package doublePointer.leftAndRight.slideWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wsh
 * @date 2020-11-16
 */
public class SlideWindowStructure {

    public static String minWindow(String s, String t) {
        boolean needShrink = false;
        char[] sArray = s.toCharArray();
        char[] target = t.toCharArray();
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : target) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < sArray.length) {
            //c是移入窗口的字符
            char c = sArray[right];
            right++;
            //进行窗口内的数据更新

            //debug 输出的位置
            System.out.printf("left: %d, right: %d", left, right);

            //判断左侧窗口是否要收缩
            while (needShrink) {
                //d是将移出窗口的字符
                char d = sArray[left];
                //窗口左移
                left++;
                //进行窗口内的数据更新

            }
        }

        return null;
    }
}
