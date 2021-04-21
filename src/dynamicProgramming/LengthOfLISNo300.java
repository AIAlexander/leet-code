package dynamicProgramming;

/**
 * @author wsh
 * @date 2021-04-21
 */
public class LengthOfLISNo300 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }
        int max = 1;
        for (int d : dp) {
            max = Math.max(d, max);
        }
        return max;
    }

    public static void main(String[] args) {
        LengthOfLISNo300 s = new LengthOfLISNo300();
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(s.lengthOfLIS(nums));
    }
}
