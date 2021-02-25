//Write a function to find the longest common prefix string amongst an array of 
//strings. 
//
// If there is no common prefix, return an empty string "". 
//
// 
// Example 1: 
//
// 
//Input: strs = ["flower","flow","flight"]
//Output: "fl"
// 
//
// Example 2: 
//
// 
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
// 
//
// 
// Constraints: 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] consists of only lower-case English letters. 
// 
// Related Topics String 
// 👍 3614 👎 2103


package leetcode.editor.en;
//Java：Longest Common Prefix
public class P14LongestCommonPrefix{
    public static void main(String[] args) {
        Solution solution = new P14LongestCommonPrefix().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

/*
    String Processing.
    方法：
    1. Horizontal Scanning  (使1=prefix，prefix比2更新prefix，prefix比3更新prefix...)
    2. Vertical Scanning (把1里的character依次提取，在其余string中试图寻找)
    3. Divide and Conquer (类似merge sort的代码结构)

    此外还可以使用binary search和trie。这里用2 vertical scanning。
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)   return "";

        //遍历第一个string
        for (int i = 0; i<strs[0].length(); i++){
            //捕捉当前char值
            char c = strs[0].charAt(i);
            //遍历其余每一个string
            for (int j = 1; j < strs.length; j++){
                //如果i已经超出该string的bounds 或者 该string在i的位置不是之前捕捉到的char值
                if (i >= strs[j].length() || strs[j].charAt(i) != c)
                    //即prefix只能取到此为止。直接return。
                    //提问：如果后面的符合标准呢？ --- 前面的不符合，已经不满足common prefix条件。
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}