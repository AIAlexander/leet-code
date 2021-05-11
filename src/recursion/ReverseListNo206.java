package recursion;

import entity.ListNode;

/**
 * @author wsh
 * @date 2021-04-19
 */
public class ReverseListNo206 {

    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        //递归找到最后的尾节点
        ListNode newNode = reverseList(head.next);
        //将原本后置的节点的next设成自己
        head.next.next = head;
        //自己的节点下一个节点设为空
        head.next = null;
        return newNode;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode newNode = reverseList(l1);
        System.out.println(newNode);
    }
}
