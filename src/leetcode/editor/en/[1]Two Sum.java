//Given an array of integers nums and an integer target, return indices of the t
//wo numbers such that they add up to target. 
//
// You may assume that each input would have exactly one solution, and you may n
//ot use the same element twice. 
//
// You can return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Output: Because nums[0] + nums[1] == 9, we return [0, 1].
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
// 
//
// Example 3: 
//
// 
//Input: nums = [3,3], target = 6
//Output: [0,1]
// 
//
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 103 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// Only one valid answer exists. 
// 
// Related Topics Array Hash Table 
// 👍 18936 👎 675


package src.leetcode.editor.en;

import java.util.HashMap;

//Java：Two Sum
/**
    Brute-force approach.
    @Time complexity: O(N^2)
    @Space complexity: O(1)

    每一个数字和自己后面的所有数字依次凑凑试试，能否等于target。不和前面的比是因为已比过。直接可得双for loop嵌套。
 */
class Solution_1 {
    public int[] twoSum(int[] nums, int target) {
        for (int i=0; i<nums.length; i++){
            for (int j=i+1; j<nums.length; j++){
                if (nums[i]+nums[j] == target){
                    return new int[] { i, j };
                }
            }
        }
        // 全部loop完还是没有找到，raise exception
        throw new IllegalArgumentException("No two sum solution.");
    }
}


/**
    Two-pass Hash Table approach.
    @Time complexity: O(N)
    @Space complexity: O(N)

    使用一个hash map。
    first pass：读一次array内容，把每个值和对应index写入hash map中。
    second pass：再读一次array内容，找每个值complement是否存在于表中，如果存在，直接读出index。
 */
class Solution_2 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // first pass
        for(int i=0; i<nums.length; i++){
            // put in (value, index) pairs.
            map.put(nums[i], i);
        }
        for(int i=0; i<nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i){
                return new int[] { i, map.get(complement) };
            }
        }
        // 全部loop完还是没有找到，raise exception
        throw new IllegalArgumentException("No two sum solution.");
    }
}


/**
    One-pass Hash Table approach.
    @Time complexity: O(N) - 但是比上一种少一次遍历input array
    @Space complexity: O(N)

    使用一个hash map。
    Only pass：在写入的同时找complement。
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // Only pass
        for(int i=0; i<nums.length; i++){
            int complement = target - nums[i];
            // 不用check complement是不是自己，因为在当前时刻"自己"还没有放进去。
            if (map.containsKey(complement)){
                return new int[] {i, map.get(complement)};
            }
            // 如果没有找到complement，则put in (value, index) pairs，预备下一轮。
            map.put(nums[i], i);
        }
        // 全部loop完还是没有找到，raise exception
        throw new IllegalArgumentException("No two sum solution.");
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}