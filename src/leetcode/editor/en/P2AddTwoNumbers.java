//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order, and each of their nodes contains a si
//ngle digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// 
// Example 1: 
//
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
// 
//
// Example 2: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
// 
//
// Example 3: 
//
// 
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
//Explanation: 9999999 + 9999 = 10009998.
//
// 
// Constraints: 
//
// 
// The number of nodes in each linked list is in the range [1, 100]. 
// 0 <= Node.val <= 9 
// It is guaranteed that the list represents a number that does not have leading
// zeros. 
// 
// Related Topics Linked List Math Recursion 
// 👍 10588 👎 2589


package leetcode.editor.en;

import java.util.List;

//Java：Add Two Numbers
public class P2AddTwoNumbers{
    public static void main(String[] args) {
        Solution solution = new P2AddTwoNumbers().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
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
    @Time complexity: O(max(M+N)). M -> len(l1), N -> len(l2).
    @Space complexity: O(max(M+N)).

    思路：
    因为是倒序给的linked list（从least sig位到most sig位），所以直接依次相加。
    有可能会有overflow造成的carry bit（进位），这个carry bit是1或0。
    故每位上的相加操作需要公式：leftNode.val + rightNode.val + carry bit。（最大值即：9+9+1 = 19）
    为方便开始追溯，需要一个dummy head，方便我们找到起点。dummyHead.next即为答案ListNode。

    注意：
    三种情况。
    1. 两个list不一样长。（一个会先走完）
    2. list为null。
    3. [9,9] 和 [1]。两位长和一位长，相加得三位长。
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //初始化
        ListNode dummyHead = new ListNode();    // dummyHead方便找到起点
        ListNode p = l1, q = l2, curr = dummyHead;
        int carryBit = 0;

        while (p != null || q != null){
            int pVal = (p == null) ? 0 : p.val;
            int qVal = (q == null) ? 0 : q.val;
            int res = pVal + qVal + carryBit;
            carryBit = res/10;
            curr.next = new ListNode(res%10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carryBit == 1){
            curr.next = new ListNode(1);
        }
        return dummyHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}