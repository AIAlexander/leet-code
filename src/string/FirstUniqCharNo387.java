package string;

import java.util.HashMap;

/**
 * @author wsh
 * @date 2021-04-26
 */
public class FirstUniqCharNo387 {

    //使用hashmap作为频数的计算
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0) {
            return -1;
        }
        HashMap<Character, Integer> h = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            h.put(s.charAt(i), h.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if(h.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqCharNo387 s = new FirstUniqCharNo387();
        System.out.println(s.firstUniqChar("aabbccd"));
    }
}
