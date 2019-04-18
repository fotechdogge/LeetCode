/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 /**
 * 2. Add Two Numbers
 * Accepted	2 ms	40.9 MB
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;

        if (node1 == null || node2 == null) return new ListNode(0);

        ListNode node3 = new ListNode(0);
        ListNode temp = node3;
        int carry = 0;

        boolean loop = true;
        {
            int sum = node1.val + node2.val + carry;
            carry = sum / 10;
            temp.val = (carry > 0) ? sum - 10 : sum;
            node1 = node1.next;
            node2 = node2.next;
        }
        while (loop) {


            if (node1 != null && node2 != null) {

                int sum = node1.val + node2.val + carry;
                carry = sum / 10;
                temp = (temp.next = new ListNode((carry > 0) ? sum - 10 : sum));
                node1 = node1.next;
                node2 = node2.next;

            } else if (node1 == null && node2 == null) {
                if (carry > 0) temp.next = new ListNode(carry);
                loop = false;
            } else {

                if (node1 != null) {
                    int sum = node1.val + carry;
                    carry = sum / 10;
                    temp = (temp.next = new ListNode((carry > 0) ? sum - 10 : sum));
                    node1 = node1.next;
                    node2 = null;

                }

                if (node2 != null) {
                    int sum = node2.val + carry;
                    carry = sum / 10;
                    temp = (temp.next = new ListNode((carry > 0) ? sum - 10 : sum));
                    node1 = null;
                    node2 = node2.next;
                }

            }
        }
        return node3;
    }
}
