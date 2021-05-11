package string;

/**
 * @author wsh
 * @date 2021-04-26
 */
public class AddStringsNo415 {

    public String addStrings(String num1, String num2) {
        if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return "0";
        }

        //位数补齐
        while (num1.length() < num2.length()) {
            num1 = "0" + num1;
        }
        while (num1.length() > num2.length()) {
            num2 = "0" + num2;
        }

        StringBuilder result = new StringBuilder();
        int addNum = 0;
        for(int i = num1.length() - 1; i >= 0; i--) {
            int bitRes = (num1.charAt(i) - '0') + (num2.charAt(i) - '0') + addNum;
            if(bitRes >= 10) {
                bitRes = bitRes - 10;
                addNum = 1;
            }else {
                addNum = 0;
            }
            result.append(bitRes);
        }
        if(addNum == 1) {
            result.append(1);
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        AddStringsNo415 n = new AddStringsNo415();
        System.out.println(n.addStrings("1", "9"));
    }
}
