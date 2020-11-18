package doublePointer.quickAndSlow;

import entity.ListNode;

/**
 * @author wsh
 * @date 2020-11-16
 */
public class searchMidPointInListNo876 {

    public static ListNode searchMidPoint(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //当fast以2倍速度跑，fast跑完，slow就是中点
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

        System.out.println(searchMidPoint(head));
    }

}
