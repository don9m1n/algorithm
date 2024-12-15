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

import java.math.BigDecimal;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        long sum = 0;
        long digit = 1;
        while (l1 != null) {
            sum += (digit * l1.val);
            l1 = l1.next;
            digit *= 10;
        }

        digit = 1;
        while (l2 != null) {
            sum += (digit * l2.val);
            l2 = l2.next;
            digit *= 10;
        }

        if (sum == 0) {
            return new ListNode(0);
        }

        BigDecimal total = new BigDecimal(sum);

        ListNode answer = new ListNode();
        ListNode dummy = answer;
        while (total.compareTo(BigDecimal.ZERO) > 0) {
            int num = total.remainder(BigDecimal.TEN).intValue();

            dummy.next = new ListNode(num);
            dummy = dummy.next;
            
            total = total.divideToIntegralValue(BigDecimal.TEN);
        }

        return answer.next;
    }
}