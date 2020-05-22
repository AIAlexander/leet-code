import sun.jvm.hotspot.debugger.Page;

/**
 * @author wsh
 * @date 2020-02-17
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        System.out.println(convert2(s, numRows));
    }

    /**
     * 方法1：
     * 容器中的下标按顺序变化，根据字符串的下标来计算该放在哪个容器中
     * @param s
     * @param numRows
     * @return
     */
    public static String convert1(String s, int numRows) {
        if(numRows < 2){
            return s;
        }
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }
        int mod = 2 * numRows - 2;
        for (int i = 0; i < s.length(); i++) {
            int modNum = i % mod;
            if(modNum < numRows){
                sb[modNum].append(s.charAt(i));
            }else{
                int index = 2 * (numRows - 1) - modNum;
                sb[index].append(s.charAt(i));
            }
        }
        String result = "";
        for (int i = 0; i < sb.length; i++) {
            result  = result + sb[i];
        }
        return result;
    }

    /**
     * 方法2：
     * 字符串的下标按顺序变化，根据容器的下标计算放哪一个字符串
     * @param s
     * @param numRows
     * @return
     */
    public static String convert2(String s, int numRows){
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i = 0; i < sb.length; i++){
            sb[i] = new StringBuilder();
        }
        int i = 0;
        while(i < len){
            for(int idx = 0; idx < numRows && i < len; idx++){
                // vertically down
                sb[idx].append(c[i++]);
            }
            for(int idx = numRows - 2; idx >= 1 && i < len; idx--) {
                // obliquely up
                sb[idx].append(c[i++]);
            }
        }
        for (int idx = 1; idx < sb.length; idx++) {
            sb[0].append(sb[idx]);
        }
        return sb[0].toString();
    }
}
