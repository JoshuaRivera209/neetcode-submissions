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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        /*
            since we are working with 2 lists it might be easier to use a dummy node.
            this node will be a random null node at the beginning of the list.
            this should make it easier to construct the list because we will essentially
            be doing it from scratch instead of having to pick a list and edit it.

            when we return the head of the new list this would just be the .next pointer of the dummy
            since it'll be pointing at the head of the merged list.

            we can use a while loop to iterate through each list, checking the value at each iteration and adding to the merged list accordingly.

            conditions might look like this:
            if (list1.val < list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            if (list1 == null) {
                node.next = list2;
            } else {
                node.next = list1;
            }

            time complexity: O(n + m) where m is the length of the longer list
            space complexity: O(n + m) the length of both lists combined
        */
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (list1 != null & list2 != null) {
            if (list1.val < list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        if (list1 == null) {
            node.next = list2;
        } else {
            node.next = list1;
        }
        return dummy.next;
    }
}