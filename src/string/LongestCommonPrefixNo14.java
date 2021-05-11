package string;

/**
 * @author wsh
 * @date 2021-04-26
 */
public class LongestCommonPrefixNo14 {


    //横向遍历，找到两个string的最长子序列，再用子序列找到下一个Stirng的最长子序列
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++) {
            prefix = longestCommonPrefix(strs[i], prefix);
            if(prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    //比较当前的最大子序列与strs，返回两者之间的最大子序列
    public String longestCommonPrefix(String strs, String prefix) {
        int length = Math.min(strs.length(), prefix.length());
        int index = 0;
        while (index < length && strs.charAt(index) == prefix.charAt(index)) {
            index++;
        }
        return strs.substring(0 ,index);
    }



    public static void main(String[] args) {
        LongestCommonPrefixNo14 l = new LongestCommonPrefixNo14();
        String s1 = new String("flower");
        String s2 = new String("flow");
        String s3 = new String("flo");
        String[] strs = new String[3];
        strs[0] = s1;
        strs[1] = s2;
        strs[2] = s3;
        System.out.println(l.longestCommonPrefix(strs));
    }
}
