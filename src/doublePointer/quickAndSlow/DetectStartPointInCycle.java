package doublePointer.quickAndSlow;

import entity.ListNode;

/**
 * @author wsh
 * @date 2020-11-16
 *
 * 在一个列表环中找到起始点
 */
public class DetectStartPointInCycle {

    public static ListNode detectStartPoint(ListNode head) {
        ListNode slow, fast;
        fast = slow = head;
        //先找到快慢指针的相遇点
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            //找到相遇点
            if(fast == slow) {
                break;
            }
        }
        //让慢指针从head中出发
        slow = head;
        //快慢指针以相同速度跑，相遇点即为环的起始点
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);

        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l2;

        ListNode result = detectStartPoint(head);
        System.out.println(result);
    }
}
