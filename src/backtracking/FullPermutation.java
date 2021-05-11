package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wsh
 * @date 2020-11-17
 *
 * 利用回溯算法完成全排列
 */
public class FullPermutation {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //记录路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track, result);
        return result;
    }

    public static void backtrack(int[] nums, LinkedList<Integer> track,
                          List<List<Integer>> result) {
        if(track.size() == nums.length) {
            result.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //排除不合法的选择
            if(track.contains(nums[i])) {
                continue;
            }
            //做选择
            track.add(nums[i]);
            //进入下一层决策树
            backtrack(nums, track, result);
            //取消选择
            track.removeLast();
        }
    }



    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 5, 8, 9};
        List<List<Integer>> result = permute(nums);
        System.out.println(result.size());
        result.forEach(u -> System.out.println(u));
    }
}
