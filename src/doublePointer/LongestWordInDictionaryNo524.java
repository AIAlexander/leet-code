package doublePointer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wsh
 * @date 2020-02-25
 *
 * Given a string and a string dictionary,
 * find the longest string in the dictionary that can be formed by deleting some characters of the given string.
 * If there are more than one possible results, return the longest word with the smallest lexicographical order.
 * If there is no possible result, return the empty string.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting

 */
public class LongestWordInDictionaryNo524 {

    public static void main(String[] args) {

        String s = "bab";
        List<String> d = new ArrayList<>();
        d.add("ba");
        d.add("ab");
        d.add("c");
//        d.add("plea");
        System.out.println(findLongestWord(s, d));


    }

    /**
     * 遍历字典里的所有字符串，字典字符串从0开始，字符串也从0开始，
     * 如果两个字符串相等，则都加一，
     * 不相等，则字符串加一
     * 如果最终字典字符串的下标和长度相等，则说明匹配成功
     * @param s
     * @param d
     * @return
     */
    public static String findLongestWord(String s, List<String> d) {
        if(d == null || d.size() <= 0){
            return "";
        }
        int max = 0;
        String result = "";
        for (int i = 0; i < d.size(); i++) {
            String word = d.get(i);
            int wordIndex = 0;
            int sIndex = 0;
            while(wordIndex < word.length() && sIndex < s.length()){
                if(s.charAt(sIndex) == word.charAt(wordIndex)){
                    wordIndex++;
                    sIndex++;
                }else{
                    sIndex++;
                }
            }
            if(wordIndex == word.length()){
                if(word.length() == max){
                    if(word.compareTo(result) < 0){
                        result = word;
                    }
                }
                if(word.length() > max){
                    max = word.length();
                    result = word;
                }
            }
        }
        return result;
    }
}
