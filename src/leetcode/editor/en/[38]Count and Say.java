//The count-and-say sequence is a sequence of digit strings defined by the recur
//sive formula: 
//
// 
// countAndSay(1) = "1" 
// countAndSay(n) is the way you would "say" the digit string from countAndSay(n
//-1), which is then converted into a different digit string. 
// 
//
// To determine how you "say" a digit string, split it into the minimal number o
//f groups so that each group is a contiguous section all of the same character. T
//hen for each group, say the number of characters, then say the character. To con
//vert the saying into a digit string, replace the counts with a number and concat
//enate every saying. 
//
// For example, the saying and conversion for digit string "3322251": 
//
// Given a positive integer n, return the nth term of the count-and-say sequence
//. 
//
// 
// Example 1: 
//
// 
//Input: n = 1
//Output: "1"
//Explanation: This is the base case.
// 
//
// Example 2: 
//
// 
//Input: n = 4
//Output: "1211"
//Explanation:
//countAndSay(1) = "1"
//countAndSay(2) = say "1" = one 1 = "11"
//countAndSay(3) = say "11" = two 1's = "21"
//countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 30 
// 
// Related Topics String 
// 👍 256 👎 964


package src.leetcode.editor.en;
//Java：Count and Say
/*
    String, Recursion.

    思路：
    很明显的递归思想（因为下一个需要用上一个的结果计算）。
    base case 即 n==1，return “1“。
    recursive step 即 求得n-1时的字符串，数+拼接出n时的字符串，return。

 */
class Solution_1 {
    public String countAndSay(int n) {
        //base case
        if (n == 1)     return "1";

        //recursive step
        else{
            String res = countAndSay(n-1);
            String curr = "";
            //initialize count as 1. NOT ZERO because 不可能数出0.
            int count = 1;
            for (int i=0; i<res.length(); i++){
                //到尾部。直接拼接
                if (i == res.length()-1){
                    curr += Integer.toString(count) + res.charAt(i);
                }
                //前项后项相等，继续数。
                else if (res.charAt(i) == res.charAt(i+1)){
                    count ++;
                }
                //前项后项不等，拼接+重置计数器。
                else if (res.charAt(i) != res.charAt(i+1)){
                    curr += Integer.toString(count) + res.charAt(i);
                    //reset count
                    count = 1;
                }
            }
            return curr;
        }
    }
}

/*
    String. Iterative Approach.

    思路：
    这次采用循环，初始化答案为”1“，然后从n=2一路循环到指定n值。每个内循环都更新res。
 */
class Solution{
    public String countAndSay(int n){
        String res = "1";
        for (int i=1; i<n; i++){
            String temp = "";
            int count;
            //遍历上一个答案的
            for (int j=0; j<res.length(); j++){
                //重置count
                count = 1;
                //当 当前不是最后一位 且 前后两个item相等时
                while (j != res.length()-1 && res.charAt(j) == res.charAt(j+1)){
                    count++;
                    j++;
                }
                temp += Integer.toString(count) + res.charAt(j);
            }
            res = temp;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}