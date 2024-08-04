import java.util.logging.XMLFormatter;

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
class a02_add_two_numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead  = new ListNode(0);
        ListNode current = dummyHead;
        int jinwei = 0;

        while (l1 != null || l2 != null){
            int x =0;
            int y =0;
            if (l1 != null){
                x =l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                y =l2.val;
                l2 =l2.next;
            }

            int sum =jinwei + x +y;
            jinwei = sum/ 10;
            current.next =new ListNode(sum-jinwei*10);
            current =current.next;

        }
        if (jinwei != 0){
            current.next =new ListNode(jinwei);
        }



        return  dummyHead.next;

    }
}


class ListNode {
     int val;
     ListNode next;
      ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }