/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        /*
            think of it from a physical point of view.

            go to each node and flip the pointer so its pointing at the one before it.
            make sure to save the one in front so you dont lose the connection to it which would make it so you cant iterate.
            you can save the one in front by making a temp variable (do this first).
            temp = curr.next
            // flip the pointer
            curr.next = prev
            // move the previous one forward
            prev = curr
            // re-establish the bridge to allow iteration
            curr = temp

            once we reach the end we can just return the prev node cause that will be equal to the head of the newly reversed linked list
        */
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
