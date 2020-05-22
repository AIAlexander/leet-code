import sun.jvm.hotspot.debugger.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wsh
 * @date 2020-02-16
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbersSolution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(6);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(9);

        ListNode r1 = new ListNode(4);
        ListNode r2 = new ListNode(7);



        l1.next = l2;
        l2.next = l3;

        r1.next = r2;



        ListNode result = addTwoNumbers(l1, r1);

        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        int carry = 0;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            int val = sum % 10;
            carry = sum / 10;
            ListNode temp = new ListNode(val);
            current.next = temp;
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null && l2 == null){
            int sum = l1.val + carry;
            int val = sum % 10;
            carry = sum / 10;
            ListNode temp = new ListNode(val);
            current.next = temp;
            current = current.next;
            l1 = l1.next;
        }
        while(l1 == null && l2 != null){
            int sum = l2.val + carry;
            int val = sum % 10;
            carry = sum / 10;
            ListNode temp = new ListNode(val);
            current.next = temp;
            current = current.next;
            l2 = l2.next;
        }
        if(l1 == null && l2 == null && carry == 1){
            ListNode temp = new ListNode(1);
            current.next = temp;
            current = current.next;
        }
        return result.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
