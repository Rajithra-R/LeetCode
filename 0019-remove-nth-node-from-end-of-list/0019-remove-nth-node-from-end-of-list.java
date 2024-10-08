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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int count = 0;
        ListNode cur = head;
        while(cur != null)
        {
            cur = cur.next;
            count++;
        }
        
        if(count > 1)
        {
            if( n == count)
            {
                return head.next;
            }
        {
        for(int i=0;i<count-n-1;i++)
        {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
        }
        }
        
      //  else if(count == 1 && n == 1)
       // {
            return null;
       // }
    
    }
}