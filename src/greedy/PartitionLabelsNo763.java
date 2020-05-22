package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wsh
 * @date 2020-02-28
 *
 * 字符串 S 由小写字母组成。
 * 我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。
 * 返回一个表示每个字符串片段的长度的列表。
 *
 * 输入: S = "ababcbacadefegdehijhklij"
 * 输出: [9,7,8]
 * 解释:
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-labels
 *
 */
public class PartitionLabelsNo763 {

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels2(s));
    }

    /**
     * 使用map数据结构，但是时间复杂度较大
     * @param S
     * @return
     */
    public static List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if(S == null || S.length() == 0){
            return res;
        }
        Map<Character, Integer> map = new HashMap<>();
        int length = 0;
        int start = 0;
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), i);
        }
        for (int i = 0; i < S.length(); i++) {
            length = Math.max(length, map.get(S.charAt(i)));
            if(i == length){
                res.add(length - start + 1);
                start = i + 1;
            }

        }
        return res;
    }

    public static List<Integer> partitionLabels2(String S) {
        int[] lastIndexOfLetter = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastIndexOfLetter[convertNum(S.charAt(i))] = i;
        }
        List<Integer> res = new ArrayList<>();
        int firstIndex = 0;
        int lastIndex = 0;
        while(firstIndex < S.length()){
            lastIndex = firstIndex;
            for (int i = firstIndex; i <= lastIndex && i < S.length(); i++){
                int index = lastIndexOfLetter[convertNum(S.charAt(i))];
                if(index > lastIndex){
                    lastIndex = index;
                }
            }
            res.add(lastIndex - firstIndex + 1);
            firstIndex = lastIndex + 1;
        }
        return res;
    }

    private static int convertNum(char c){
        return c - 'a';
    }
}
