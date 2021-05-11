package string;

/**
 * @author wsh
 * @date 2021-04-26
 */
public class LengthOfLastWordNo58 {

    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        String[] s1 = s.split(" ");
        if(s1.length == 0) {
            return 0;
        }
        return s1[s1.length - 1].length();
    }

    public static void main(String[] args) {
        LengthOfLastWordNo58 l = new LengthOfLastWordNo58();
        System.out.println(l.lengthOfLastWord("    "));
    }
}
