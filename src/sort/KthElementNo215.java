package sort;

import java.util.PriorityQueue;

/**
 * @author wsh
 * @date 2020-02-26
 *
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 */
public class KthElementNo215 {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 1, 5, 7, 6};
        int k = 2;

        System.out.println(findKthLargest2(nums, k));
    }


    /**
     * 使用堆解决Kth Element的问题
     * 使用优先级队列构建小顶堆，在队列添加元素的时候，只要队列的size大于k就移除队列最小的元素，
     * 这样最终会剩下k个元素，队列的第一个元素就是第k大的元素
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();   //小顶堆
        for (int num : nums) {
            priorityQueue.add(num);
            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();

    }


    /**
     * 使用快速选择，先将数组的元素进行排序。
     * 排序的方法是，先选一个pivot, 让i从0开始一个个找，找到第一个比pivot大的，让j从末尾开始一个个找，找到第一个比pivot小的，
     * 如果i < j，则更换i和j所指向的元素，并继续上面的过程，
     * 如果i >= j，则更换pivot，更换的pivot是在j+1之后，重复上面操作，最终k大的元素就是num[num.length - k];
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest2(int[] nums, int k) {
        k = nums.length - k;
        int l = 0, h = nums.length - 1;
        while (l < h) {
        int j = partition(nums, l, h);
         if (j == k) {
                break;
            } else if (j < k) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[k];
    }

    private static int partition(int[] a, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            while (a[++i] < a[l] && i < h) ;
            while (a[--j] > a[l] && j > l) ;
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, l, j);
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
