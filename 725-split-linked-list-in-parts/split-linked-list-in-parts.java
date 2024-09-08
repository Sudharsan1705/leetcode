/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        int val = size / k;
        int rem = size % k;
        ListNode res[] = new ListNode[k];
        int count = 0, in = 0;
        while (head != null) {
            count = val + (rem > 0 ? 1 : 0);
            rem--;
            res[in++] = head;
            ListNode prev = null;
            while (count-- > 0) {
                prev = head;
                head = head.next;
            }
            if (prev != null) {
                prev.next = null;
            }
        }
        return res;
    }
}