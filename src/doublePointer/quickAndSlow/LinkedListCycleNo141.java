package doublePointer.quickAndSlow;

import entity.ListNode;

/**
 * @author wsh
 * @date 2020-02-25
 *
 * Given a linked list, determine if it has a cycle in it.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position
 * (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 */
public class LinkedListCycleNo141 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(1);

        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;


        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head){
        if(head == null){
            return false;
        }
        if(head.next == null){
            return false;
        }
        ListNode l1 = head.next;
        ListNode l2 = head.next.next;
        while(l1 != null && l2 != null && l2.next != null){
            if(l1 == l2){
                return true;
            }else{
                l1 = l1.next;
                l2 = l2.next.next;
            }
        }
        return false;
    }
}
