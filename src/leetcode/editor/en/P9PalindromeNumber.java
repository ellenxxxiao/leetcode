//Given an integer x, return true if x is palindrome integer. 
//
// An integer is a palindrome when it reads the same backward as forward. For ex
//ample, 121 is palindrome while 123 is not. 
//
// 
// Example 1: 
//
// 
//Input: x = 121
//Output: true
// 
//
// Example 2: 
//
// 
//Input: x = -121
//Output: false
//Explanation: From left to right, it reads -121. From right to left, it becomes
// 121-. Therefore it is not a palindrome.
// 
//
// Example 3: 
//
// 
//Input: x = 10
//Output: false
//Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
// 
//
// Example 4: 
//
// 
//Input: x = -101
//Output: false
// 
//
// 
// Constraints: 
//
// 
// -231 <= x <= 231 - 1 
// 
//
// 
//Follow up: Could you solve it without converting the integer to a string? Rela
//ted Topics Math 
// 👍 2987 👎 1692


package leetcode.editor.en;
//Java：Palindrome Number
public class P9PalindromeNumber{
    public static void main(String[] args) {
        Solution solution = new P9PalindromeNumber().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /*
        String + pointer approach.

        思路：
        Palindrome是以中心点对称的。
        如果是偶数位数，如（1221），则以中心点的虚拟线为中轴对称（12|21）。
        如果是奇数位数，如（121），则以中间的数为中轴对称（1 2 1）。

        做法：
        拟两个pointer，L和R，分别起始于string的两端，往中间移动。
        示意图：L --→  ←-- R。
        在每个位置，验证当前位置的digit是否一致，一致的话则移动pointer继续对比。不一致直接退出，return false。
        终止条件：当L越过R（或者R越过L）。i.e. 两个pointer交叉相距至少一位。此时仍符合条件则return true。

        原因：
        如果是奇数位数的string，两个指针会有在某一时刻指向同一digit（中轴的那一位），所以是 i<=j。

     */
    class Solution_1 {
        public boolean isPalindrome(int x) {
            String s = Integer.toString(x);
            int i = 0, j = s.length() - 1;
            while (i <= j) {
                if (s.charAt(i) == s.charAt(j)) {
                    i++;
                    j--;
                } else return false;
            }
            return true;
        }
    }
    /*
        Reverse integer approach.

        思路：
        如果一个数字是palindrome number，那么它的reverse和它是相等的。故我们可以反转一个数字，看它是否和原来的相等。
        但是，int值是有范围的，反转一个int有可能造成溢出。例如，反转Integer.MAX_VALUE就会造成溢出。

        想解决这个问题，可以考虑采用另一做法。反转一个palindrome number的一半，它会等于这个palindrome number的另一半。
        例如，124421。反转下半截421，会得到和上半截相等的124。这样的反转没有overflow问题。
        为什么反转下半截而不是上半截？因为反转下半截更加容易。
            - 利用%取least significant位上的值；
            - 利用/10 实现除以10操作，/=10能砍掉这个数字的least significant位；
            - 利用*10让所有数字往左移一位（个位变十位，十位变百位的扩大significance）；
            - 利用+POP，把least significant位加回来。
        从least significant位开始依次反转，直到中间。在这个过程中上半截应该大于反转的下半截，可得终止条件。当上半截不再大于下半截，
        我们知道下半截已经反转完成。
     */
    class Solution {
        public boolean isPalindrome(int x) {
            int reversed = 0;

            //如果x以0结尾，或者x是负数，则不可能是palindrome number。想想就知道了。
            if((x%10 == 0 && x != 0) || x < 0)    return false;

            while (x > reversed){
                // reversed*10是整体左移一位，+x%10是加上新到的一位least significant位。
                reversed = reversed * 10 + x % 10;
                x /= 10;
            }
            //如果是奇数位数，那么在跳出循环时，反转过的下半截会比上半截多一位数。
            //此时直接reversed/10舍弃那一位数，比较即可。中间的那位数不重要，因为它被作为对称轴。
            return x == reversed || x == reversed/10;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
