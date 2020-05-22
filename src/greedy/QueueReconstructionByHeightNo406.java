package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author wsh
 * @date 2020-02-26
 *
 * Suppose you have a random list of people standing in a queue.
 * Each person is described by a pair of integers (h, k),
 * where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h.
 * Write an algorithm to reconstruct the queue.
 *
 *
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
 */
public class QueueReconstructionByHeightNo406 {

    public static void main(String[] args) {
        int[][] people = new int[6][2];
        people[0] = new int[]{7, 0};
        people[1] = new int[]{4, 4};
        people[2] = new int[]{7, 1};
        people[3] = new int[]{5, 0};
        people[4] = new int[]{6, 1};
        people[5] = new int[]{5, 2};
        people = reconstructQueue(people);
        for (int i = 0; i < people.length; i++) {
            System.out.print("[");
            for (int j = 0; j < people[i].length; j++){
                System.out.print(people[i][j] + ",");
            }
            System.out.println("]");
        }
    }


    public static int[][] reconstructQueue(int[][] people) {
        //按照身高降序 K升序排序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        List<int[]> result = new ArrayList<>();
        //K值定义为 排在h前面且身高大于或等于h的人数
        //因为从身高降序开始插入，此时所有人身高都大于等于h
        //因此K值即为需要插入的位置
        for (int[] person : people) {
            result.add(person[1], person);
        }
        return result.toArray(new int[result.size()][]);
    }
}
