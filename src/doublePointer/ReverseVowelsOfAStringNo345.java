package doublePointer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author wsh
 * @date 2020-02-25
 *
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 */
public class ReverseVowelsOfAStringNo345 {

    public static void main(String[] args) {

        System.out.println(reverseVowels("hklklll"));
    }


    /**
     *
     * 使用双指针，一个指针指向开始位置0，一个指针指向末尾，
     * 如果头指针对应的元素是元音字母，但是尾指针对应的元素不是元音字母，就让尾指针减1
     * 如果尾指针对应的元素是元音字母，但是头指针对应的元素不是元音字母，就让头指针减1
     * 如果两个指针指向的都是元音字母，则进行交换
     *
     * 时间复杂度为 O(N)：只需要遍历所有元素一次
     * 空间复杂度 O(1)：只需要使用两个额外变量
     * @param s
     * @return
     */
    public static String reverseVowels(String s) {
        char[] charArray = s.toCharArray();
        int head = 0;
        int tail = charArray.length - 1;
        while (tail > head){
            if(isLetter(charArray[head]) && (!isLetter(charArray[tail]))){
                tail--;
            }else if(isLetter(charArray[tail]) && (!isLetter(charArray[head]))){
                head++;
            }else if(isLetter(charArray[head]) && isLetter(charArray[tail])){
                char temp = ' ';
                temp = charArray[head];
                charArray[head] = charArray[tail];
                charArray[tail] = temp;
                tail--;
                head++;
            }else {
                tail--;
                head++;
            }
        }
        return new String(charArray);
    }

    private static Boolean isLetter(char input){
        if(input == 'a' || input == 'e' || input == 'i' || input == 'o' || input == 'u' || input == 'A'
                || input == 'E' || input == 'I' || input == 'O' || input == 'U'){
            return true;
        }else{
            return  false;
        }
    }


    /**
     * 解法2：
     * 唯一的区别在于，此方法新开了一个存放结果的数组
     * 使用双指针，一个指针从头向尾遍历，一个指针从尾到头遍历，当两个指针都遍历到元音字符时，交换这两个元音字符。
     * 为了快速判断一个字符是不是元音字符，我们将全部元音字符添加到集合 HashSet 中，从而以 O(1) 的时间复杂度进行该操作。
     *
     * 时间复杂度为 O(N)：只需要遍历所有元素一次
     * 空间复杂度 O(1)：只需要使用两个额外变量
     */
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels2(String s) {
        if (s == null){
            return null;
        }
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!vowels.contains(ci)) {
                result[i++] = ci;
            } else if (!vowels.contains(cj)) {
                result[j--] = cj;
            } else {
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }
}
