package houseRob;

/**
 * @author wsh
 * @date 2020-11-20
 */
public class HouseRobberNo198 {

    public static int rob(int[] nums) {
        int[] memo = new int[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        return subRob(nums, 0, memo);
    }

    public static int subRob(int[] nums, int start, int[] meno) {
        if(start >= nums.length) {
            return 0;
        }
        if(meno[start] != -1) {
            return meno[start];
        }
        int res = Math.max(subRob(nums, start + 1, meno),
                subRob(nums, start + 2, meno) + nums[start]);
        meno[start] = res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,7,9,3,100,5}));
    }
}
