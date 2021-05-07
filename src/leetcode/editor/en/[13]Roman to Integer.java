//Roman numerals are represented by seven different symbols: I, V, X, L, C, D an
//d M. 
//
// 
//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// For example, 2 is written as II in Roman numeral, just two one's added togeth
//er. 12 is written as XII, which is simply X + II. The number 27 is written as XX
//VII, which is XX + V + II. 
//
// Roman numerals are usually written largest to smallest from left to right. Ho
//wever, the numeral for four is not IIII. Instead, the number four is written as 
//IV. Because the one is before the five we subtract it making four. The same prin
//ciple applies to the number nine, which is written as IX. There are six instance
//s where subtraction is used: 
//
// 
// I can be placed before V (5) and X (10) to make 4 and 9. 
// X can be placed before L (50) and C (100) to make 40 and 90. 
// C can be placed before D (500) and M (1000) to make 400 and 900. 
// 
//
// Given a roman numeral, convert it to an integer. 
//
// 
// Example 1: 
//
// 
//Input: s = "III"
//Output: 3
// 
//
// Example 2: 
//
// 
//Input: s = "IV"
//Output: 4
// 
//
// Example 3: 
//
// 
//Input: s = "IX"
//Output: 9
// 
//
// Example 4: 
//
// 
//Input: s = "LVIII"
//Output: 58
//Explanation: L = 50, V= 5, III = 3.
// 
//
// Example 5: 
//
// 
//Input: s = "MCMXCIV"
//Output: 1994
//Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 15 
// s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M'). 
// It is guaranteed that s is a valid roman numeral in the range [1, 3999]. 
// 
// Related Topics Math String 
// 👍 2895 👎 3917


package src.leetcode.editor.en;

import java.util.HashMap;

//Java：Roman to Integer
/*
    String & Math.

    思路：
    不是很精致的一种做法。写了一个helper method用来帮助char对应numeric value，然后用while循环遍历input string。
    CASE ①：如果是六种特殊情况，用两位char算出答案，i+=2让下一回合直接从第三个char开始；
    CASE ②：如果不是六种特殊情况，则只map一位的值，i++让下一回合看下一个。
    如果已经是最后一位char，一定是CASE ②，这里handle的很丑。
 */
class Solution_1 {
    public int romanToInt(String s) {
        int val, i = 0, res = 0;
        char curr, next;
        boolean caseI, caseX, caseC;

        while (i <= s.length()-1){
            caseI = false;
            caseX = false;
            caseC = false;
            curr = s.charAt(i);
            if (i != s.length()-1) {
                next = s.charAt(i+1);
                // I can be placed before V (5) and X (10) to make 4 and 9.
                caseI = curr == 'I' && (next == 'V' || next == 'X');
                // X can be placed before L (50) and C (100) to make 40 and 90.
                caseX = curr == 'X' && (next == 'L' || next == 'C');
                // C can be placed before D (500) and M (1000) to make 400 and 900.
                caseC = curr == 'C' && (next == 'D' || next == 'M');
            }
            if (caseI || caseX || caseC) {
                val = toNum(s.charAt(i+1)) - toNum(curr);
                i += 2;
            }
            else {
                val = toNum(curr);
                i++;
            }
            res += val;
        }

        return res;
    }

    int toNum(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}

/*
    思路：
    用HashMap实现char <-> numeric value，取代method，避免method call消耗的资源。
    从左往右读取数值，若后一位比前一位大，则做减法，否则加法。
 */
class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };
        int res = 0;
        for (int i=0; i<s.length();){
            if (i+1 < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                res += map.get(s.charAt(i+1)) - map.get(s.charAt(i));
                i += 2;
            }
            else{
                res += map.get(s.charAt(i));
                i ++;
            }
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}