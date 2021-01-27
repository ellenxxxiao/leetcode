//Given a string s, find the length of the longest substring without repeating c
//haracters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// Example 4: 
//
// 
//Input: s = ""
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 104 
// s consists of English letters, digits, symbols and spaces. 
// 
// Related Topics Hash Table Two Pointers String Sliding Window 
// 👍 12853 👎 670


package leetcode.editor.en;

import java.util.HashSet;

//Java：Longest Substring Without Repeating Characters
public class P3LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

/**
    Brute-force approach.
    @Time complexity: O(N^3)
    @Space complexity:

    对input string的每一个substring都进行检查，检查其是否有重复字母。在符合条件（i.e.没有重复字母）的substring中，取长度最长的。
    太慢了太慢了！！！！！报Time Limit Exceeded了！
*/
class Solution_1 {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for(int i=0; i<s.length(); i++){
            for(int j=i; j<=s.length(); j++){
                if (checkAllUnique(s, i, j)){
                    maxLength = Math.max(maxLength, j-i);
                }
            }
        }
        return maxLength;
    }

    private boolean checkAllUnique(String s, int left, int right){
        HashSet<Character> set = new HashSet<Character>();
        for (int i=left; i<right; i++){
            Character character = s.charAt(i);
            if (set.contains(character)){
                return false;
            }
            set.add(character);
        }
        return true;
    }
}

/**
    Sliding Window Approach. A sliding window is an abstract concept commonly used in array/string problems.
    @Time Complexity:
    @Space Complexity:

    思路：在Brute Force算法中，我们对每一个substring都进行了uniqueness check。其实这是不必要的。
        假定s[i:j]都是unique的，我们只需要查询下一位(即s[j])是不是在s[i:j]里unique。

    做法：
        用i,j框住一个window。初始化i，j位置都为0。
        右移j，看新框住的char是否unique。是：继续右移j。否：尝试更新最大length。
            **因为如果不再unique，证明从i起始的unique substring已到尽头，此时为该substring最大length。
        左移i，

 */
    class Solution{
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        return maxLength;
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}