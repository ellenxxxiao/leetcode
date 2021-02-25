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

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

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
        假定s[i:j]都是unique的，我们只需要查询下一位(即s.charAt(j))是不是在s[i:j]里unique。

    做法：
        使用一个HashMap记录每个character的最新位置index。
        用i,j框住一个window。i表示左边框，j表示右边框。初始化i，j位置都为0。
        右移j，看新框住的char是否unique。
            --> 是：把新框住的char放进map，继续右移j，更新最大length
            --> 否：右移i位置，至repeated character的后面（如果可以）。

    注意：
        要防止i左移（回退）。例：abaab。i指向第三个a时，j指向b。b已在map里（因为第二个b已经被记录），此时i被告知应该移动到map.get(b)+1位。
        然而map.get(b)+1等于2（starting from index 0），小于i此时已在的位置3（第三个a），我们不能让i回退，故保留位置，i=3。
 */
    class Solution_2{
        public int lengthOfLongestSubstring(String s) {
            int maxLength = 0;
            HashMap<Character, Integer> map = new HashMap<>();
                if(!(s.length()==0 || s == null)){
                    for (int i=0, j=0; j<s.length(); j++){
                        if (map.containsKey(s.charAt(j))){
                            // 防止i回退
                            i = Math.max(map.get(s.charAt(j))+1, i);
                        }
                        map.put(s.charAt(j), j);
                        maxLength = Math.max(maxLength, j-i+1);
                    }
                }
            return maxLength;
        }
    }

    /**
     Queue Approach.
     @Time Complexity:
     @Space Complexity:

     思路：
     利用queue的先进先出特性。依次将所有char放入queue，如果queue中已有该char，则持续弹出queue中char，直到queue中没有该char。
     清理掉queue中的duplicate后，把该char加入queue中，更新max length。

     原理：
     如果遇到duplicate，说明此时已有的最长substring已走到尽头，此时要从不重复的那个char开始重新找，故一直弹出直至消除所有duplicate。

     */
    class Solution{
        public int lengthOfLongestSubstring(String s) {
            int maxLength = 0;
            // 用linked list实现queue
            Queue<Character> queue = new LinkedList<>();
            for (Character c: s.toCharArray()){
                while (queue.contains(c)){
                    queue.poll();
                }
                queue.add(c);
                maxLength = Math.max(maxLength, queue.size());
            }
            return maxLength;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}