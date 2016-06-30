package Easy;

/**
 * Created by yuwang on 6/30/16.
 */
public class IntersectionOfLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;
        int lenA = length(headA);
        int lenB = length(headB);
        int diff = Math.abs(lenA - lenB);

        if (lenA > lenB) {

            while (diff > 0) {  // 注意: 不能等于0,否则就多移动了一位
                headA = headA.next;
                diff--;
            }


        } else {

            while (diff > 0) {
                headB = headB.next;
                diff--;
            }

        }


        while (headA != null && headB != null) {
            if (headA.next == headB.next) return headA.next;
            headA = headA.next;
            headB = headB.next;

        }


        return null;
    }

    private int length(ListNode n) {
        if (n == null) return 0;
        int length = 0;
        while (n != null) {
            length++;
            n = n.next;
        }
        return length;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
