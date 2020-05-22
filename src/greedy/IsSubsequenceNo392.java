package greedy;

/**
 * @author wsh
 * @date 2020-02-27
 */
public class IsSubsequenceNo392 {

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgd";
        System.out.println(isSubsequence(s, t));
    }

    /**
     * 双指针
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
        if(s == null || t == null){
            return false;
        }
        int sIndex = 0;
        int tIndex = 0;
        while(sIndex < s.length() && tIndex < t.length()){
            if(s.charAt(sIndex) == t.charAt(tIndex)){
                sIndex++;
            }
            tIndex++;
        }
        return sIndex == s.length();
    }

    /**
     * 更好的解法：
     * 遍历每一个s，在t中使用indexOf来寻找，如果找不到返回-1，找到返回该字母的位置，并从该位置开始找下一个字母
     * 只要其中某一次返回-1，就说明不是子序列
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence2(String s, String t){
        if(s == null || t == null){
            return false;
        }
        char[] chars = s.toCharArray();
        int index = -1;
        for (char aChar : chars) {
            index = t.indexOf(aChar, index + 1);
            if(index == -1){
                return false;
            }
        }
        return true;
    }
}
