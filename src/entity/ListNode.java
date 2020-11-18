package entity;

/**
 * @author wsh
 * @date 2020-02-25
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                "}";
    }
}
