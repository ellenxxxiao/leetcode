//Given a sorted array nums, remove the duplicates in-place such that each eleme
//nt appears only once and returns the new length. 
//
// Do not allocate extra space for another array, you must do this by modifying 
//the input array in-place with O(1) extra memory. 
//
// Clarification: 
//
// Confused why the returned value is an integer but your answer is an array? 
//
// Note that the input array is passed in by reference, which means a modificati
//on to the input array will be known to the caller as well. 
//
// Internally you can think of this: 
//
// 
//// nums is passed in by reference. (i.e., without making a copy)
//int len = removeDuplicates(nums);
//
//// any modification to nums in your function would be known by the caller.
//// using the length returned by your function, it prints the first len element
//s.
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//} 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,2]
//Output: 2, nums = [1,2]
//Explanation: Your function should return length = 2, with the first two elemen
//ts of nums being 1 and 2 respectively. It doesn't matter what you leave beyond t
//he returned length.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,0,1,1,1,2,2,3,3,4]
//Output: 5, nums = [0,1,2,3,4]
//Explanation: Your function should return length = 5, with the first five eleme
//nts of nums being modified to 0, 1, 2, 3, and 4 respectively. It doesn't matter 
//what values are set beyond the returned length.
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 3 * 104 
// -104 <= nums[i] <= 104 
// nums is sorted in ascending order. 
// 
// Related Topics Array Two Pointers 
// 👍 3465 👎 6386


package leetcode.editor.en;
//Java：Remove Duplicates from Sorted Array
public class P26RemoveDuplicatesFromSortedArray{
    public static void main(String[] args) {
        Solution solution = new P26RemoveDuplicatesFromSortedArray().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

/*
    Array, Pointer.

    思路：
    用两个pointer，一个快pointer一个慢pointer。
    快pointer：无条件遍历array的pointer。
    慢pointer：按条件移动的pointer。
    此处，慢pointer标记unique item的位置，在快pointer指向新发现的item时，与之互换位置。标记新的unique item。
    因为慢pointer只会右移，所以不会洗掉此前已正确放置的元素，此外这种放置一定是有顺序的，因为快pointer会按顺序发现新的unique item。
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)   return 0;
        int j = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}