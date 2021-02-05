//Given a sorted array of distinct integers and a target value, return the index
// if the target is found. If not, return the index where it would be if it were i
//nserted in order. 
//
// 
// Example 1: 
// Input: nums = [1,3,5,6], target = 5
//Output: 2
// Example 2: 
// Input: nums = [1,3,5,6], target = 2
//Output: 1
// Example 3: 
// Input: nums = [1,3,5,6], target = 7
//Output: 4
// Example 4: 
// Input: nums = [1,3,5,6], target = 0
//Output: 0
// Example 5: 
// Input: nums = [1], target = 0
//Output: 0
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums contains distinct values sorted in ascending order. 
// -104 <= target <= 104 
// 
// Related Topics Array Binary Search 
// 👍 3134 👎 285


package leetcode.editor.en;
//Java：Search Insert Position
public class P35SearchInsertPosition{
    public static void main(String[] args) {
        Solution solution = new P35SearchInsertPosition().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

/*
    Binary Search.

    思路：
    一个经典的binary search，最后return index：
        找到了，return mid；
        没找到，return lo （此时lo的位置是刚好需要insert的位置）。
    此处binary search使用递归。
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        return binarySearchRecursionAux(nums, target, lo, hi);
    }
    private int binarySearchRecursionAux(int[] lst, int target, int lo, int hi){
        int mid = (lo+hi)/2;
        if (lo>hi || lo<0)      return lo;
        if (lst[mid] == target)     return mid;
        if (lst[mid] > target)      return binarySearchRecursionAux(lst, target, lo, mid-1);
        else    return binarySearchRecursionAux(lst, target, mid+1, hi);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}