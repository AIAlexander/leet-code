package string;

/**
 * @author wsh
 * @date 2021-04-26
 */
public class IsPalindromeNo125 {

    public boolean isPalindrome(String s) {
        StringBuilder temp = new StringBuilder();
        char[] chars = s.toUpperCase().toCharArray();
        for(char c : chars) {
            //判断是否为字母或者数字
            if(Character.isLetterOrDigit(c)) {
                temp.append(c);
            }
        }
        StringBuilder temp2 = new StringBuilder(temp).reverse();
        return temp2.toString().equals(temp.toString());
    }

    public static void main(String[] args) {
        IsPalindromeNo125 s = new IsPalindromeNo125();
        System.out.println(s.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
