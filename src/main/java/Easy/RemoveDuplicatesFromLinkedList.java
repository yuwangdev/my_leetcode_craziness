package Easy;

/**
 * Created by yuwang on 6/30/16.
 */
public class RemoveDuplicatesFromLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public class Solution {
        public ListNode deleteDuplicates(ListNode head) {

            if (head == null || head.next == null)
                return head;

            ListNode beforeHead = new ListNode(0);
            beforeHead.next = head;

            while (head != null && head.next != null) {
                if (head.val == head.next.val) {
                    head.next = head.next.next;
                } else {
                    head = head.next;
                }
            }
            return beforeHead.next;
        }
    }
}
