import java.util.ArrayList;
import java.util.List;

/**
 * @author wsh
 * @date 2020-02-17
 */
public class ReverseIntgerSolution {

    public static void main(String[] args) {
        System.out.println(reverse2(-1022213123));
    }

    public static int reverse(int x) {
        if(-10 < x && x < 10){
            return x;
        }
        if(x < -(int)Math.pow(2, 31) || x > ((int)Math.pow(2, 31) - 1) ){
            return 0;
        }
        boolean negative = false;
        Long sum = 0L;
        if(x < 0){
            x = Math.abs(x);
            negative = true;
        }
        int temp = x;
        int exp = 1;
        int length = 0;
        while (temp >= 10){
            temp = temp / (int)Math.pow(10, exp);
            length++;
        }
        int i = length;
        List<Long> list = new ArrayList<>();
        while (x > 0){
            int num = x % 10;
            list.add((long)num);
            x = x / 10;
        }
        for(int j = 0; j < list.size(); j++){
            sum = sum + list.get(j) * (int)Math.pow(10, list.size() - 1 - j);
        }
        if(sum < -(int)Math.pow(2, 31) || sum > ((int)Math.pow(2, 31) - 1) ){
            return 0;
        }
        if(negative){
            return sum.intValue() * (-1);
        }
        return sum.intValue();
    }

    public static int reverse2(int x){
        int sum = 0;
        while(x != 0){
            int num = sum * 10 + x % 10;
            if((num - x % 10) / 10!= sum){
                return 0;
            }
            sum = num;
            x = x / 10;
        }
        return sum;
    }
}
