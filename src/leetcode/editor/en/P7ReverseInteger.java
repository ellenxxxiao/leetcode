//Given a signed 32-bit integer x, return x with its digits reversed. If reversi
//ng x causes the value to go outside the signed 32-bit integer range [-231, 231 -
// 1], then return 0. 
//
// Assume the environment does not allow you to store 64-bit integers (signed or
// unsigned). 
//
// 
// Example 1: 
// Input: x = 123
//Output: 321
// Example 2: 
// Input: x = -123
//Output: -321
// Example 3: 
// Input: x = 120
//Output: 21
// Example 4: 
// Input: x = 0
//Output: 0
// 
// 
// Constraints: 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics Math 
// 👍 4259 👎 6578


package leetcode.editor.en;
//Java：Reverse Integer
public class P7ReverseInteger{
    public static void main(String[] args) {
        Solution solution = new P7ReverseInteger().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /*
        Math.
        思路：
        常规思路是反转string然后cast type，但这一做法没有考虑到对overflow的处理。题目要求，当输入overflow时，return 0。

        做法：
        我们想要reverse一个数字，就要取它的least significant位（POP），然后把它"放"到新数的most significant位（PUSH）。
        说到POP和PUSH操作，很容易联想到栈（stack）的数据结构；但我们可以通过数学方法来巧妙避免使用auxiliary data structure。
        - 利用%取least significant位上的值；
        - 利用/10 实现除以10操作，/=10能砍掉这个数字的least significant位；
        - 利用*10让所有数字往左移一位（个位变十位，十位变百位的扩大significance）；
        - 利用+POP，把least significant位加回来。

        注意：
        一定要在计算结果前考虑overflow。在正确排除overflow可能性后，才能把值assign到int variable上；否则会直接溢出，导致随机数字的出现，
        因而错误。
     */
    class Solution {
        public int reverse(int x) {
            int res = 0;
            int pop;
            while (x != 0){
                //取least significant位
                pop = x%10;
                //更新x为取least sig位后的值
                x = x/10;
                //int型变量数值范围[-2147483648, 2147483647]
                //必须在实际运算以前检查overflow
                //考虑除了least significant位以外的数字。
                //如果大于MAX_VALUE/10 或 等于MAX_VALUE/10但least significant位大于7
                //如果小于MIN_VALUE/10 或 等于MIN_VALUE/10但least significant位小于-8
                //则都是overflow，return 0
                if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && pop > 7)) return 0;
                else if (res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10 && pop < -8)) return 0;

                //运算。整体前移一位+末位
                res = res*10+pop;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}