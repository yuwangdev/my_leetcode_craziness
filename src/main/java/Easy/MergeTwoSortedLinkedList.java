package Easy;

/**
 * Created by yuwang on 6/30/16.
 */
public class MergeTwoSortedLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;


        ListNode beforeTheRealHead = new ListNode(0);
        ListNode pointer = beforeTheRealHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pointer.next = l1;
                l1 = l1.next;
            } else {
                pointer.next = l2;
                l2 = l2.next;
            }
            pointer = pointer.next;
        }
        // merge remain
        while (l1 != null) {
            pointer.next = l1;
            pointer = pointer.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            pointer.next = l2;
            pointer = pointer.next;
            l2 = l2.next;
        }
        return beforeTheRealHead.next;
    }
}
