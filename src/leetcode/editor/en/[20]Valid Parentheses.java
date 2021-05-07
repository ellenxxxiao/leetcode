//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']
//', determine if the input string is valid. 
//
// An input string is valid if: 
//
// 
// Open brackets must be closed by the same type of brackets. 
// Open brackets must be closed in the correct order. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "()"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "()[]{}"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: s = "(]"
//Output: false
// 
//
// Example 4: 
//
// 
//Input: s = "([)]"
//Output: false
// 
//
// Example 5: 
//
// 
//Input: s = "{[]}"
//Output: true
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 104 
// s consists of parentheses only '()[]{}'. 
// 
// Related Topics String Stack 
// 👍 6700 👎 271


package src.leetcode.editor.en;

import java.util.Stack;

//Java：Valid Parentheses
/*
    Stack.

    思路：
    最经典的stack题型了！关于brackets的压弹栈操作。
    如果左半边来了，压入栈。如果右半边来了，且和顶端符号匹配，则弹栈。不匹配则false。
    如果右半边来的时候，栈为空，则false。
    结束后如果栈不为空，表示不是所有的左半边都被弹干净了，则false。
 */
class Solution {
        public boolean isValid(String s) {
            //定义一个栈
            Stack<Character> stack = new Stack<>();

            //遍历input string
            for (int i=0; i<s.length(); i++){
                //定义当前character
                char c = s.charAt(i);
                //左半边：直接压入栈。
                if (c == '(' || c == '[' || c == '{' ){
                    stack.push(c);
                }
                //右半边
                else{
                    //stack空
                    if (stack.empty())  return false;
                    //来)，有(，弹栈
                    else if (c == ')' && stack.peek() == '('){
                        stack.pop();
                    }
                    //来]，有[，弹栈
                    else if (c == ']' && stack.peek() == '['){
                        stack.pop();
                    }
                    //来}，有{，弹栈
                    else if (c == '}' && stack.peek() == '{'){
                        stack.pop();
                    }
                    //不能弹（没有对应左半边）则return false
                    else    return false;
                }
            }
            //遍历完成后，stack为空则证明括号全部成对。true。
            return stack.empty();
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}