//Merge two sorted linked lists and return it as a sorted list. The list should 
//be made by splicing together the nodes of the first two lists. 
//
// 
// Example 1: 
//
// 
//Input: l1 = [1,2,4], l2 = [1,3,4]
//Output: [1,1,2,3,4,4]
// 
//
// Example 2: 
//
// 
//Input: l1 = [], l2 = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: l1 = [], l2 = [0]
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in both lists is in the range [0, 50]. 
// -100 <= Node.val <= 100 
// Both l1 and l2 are sorted in non-decreasing order. 
// 
// Related Topics Linked List Recursion 
// 👍 6002 👎 716


package src.leetcode.editor.en;
//Java：Merge Two Sorted Lists
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

/*
    Recursion.

    思路：
    合并两个sorted linked list，每次对比两个head，使更小的成为real head，然后call这个方法，
    pass新的头。
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)   return null;
        if (l1 == null)    return l2;
        if (l2 == null)    return l1;
        ListNode head = null;
        if (l1.val < l2.val){
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        }
        else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}