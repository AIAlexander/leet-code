package doublePointer.quickAndSlow;

import doublePointer.entity.ListNode;

/**
 * @author wsh
 * @date 2020-11-16
 */
public class RemoveNthNodeFromEndOfListNo19 {

    public static ListNode removeNthNodeFromEndOfList(ListNode head, Integer n) {
        ListNode slow, fast;
        slow = fast = head;
        //删除几个就让快指针先跑几个
        while(n-- > 0) {
            fast = fast.next;
        }
        if(fast == null) {
            return head.next;
        }
        while(fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //快慢以相同的速度跑，快指针跑完，慢指针就是需要删除的元素
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);

        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        System.out.println(removeNthNodeFromEndOfList(head, 2));
    }
}
