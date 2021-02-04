//Given an array nums and a value val, remove all instances of that value in-pla
//ce and return the new length. 
//
// Do not allocate extra space for another array, you must do this by modifying 
//the input array in-place with O(1) extra memory. 
//
// The order of elements can be changed. It doesn't matter what you leave beyond
// the new length. 
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
//int len = removeElement(nums, val);
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
//Input: nums = [3,2,2,3], val = 3
//Output: 2, nums = [2,2]
//Explanation: Your function should return length = 2, with the first two elemen
//ts of nums being 2.
//It doesn't matter what you leave beyond the returned length. For example if yo
//u return 2 with nums = [2,2,3,3] or nums = [2,2,0,0], your answer will be accept
//ed.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,2,2,3,0,4,2], val = 2
//Output: 5, nums = [0,1,4,0,3]
//Explanation: Your function should return length = 5, with the first five eleme
//nts of nums containing 0, 1, 3, 0, and 4. Note that the order of those five elem
//ents can be arbitrary. It doesn't matter what values are set beyond the returned
// length.
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 50 
// 0 <= val <= 100 
// 
// Related Topics Array Two Pointers 
// 👍 1896 👎 3293


package leetcode.editor.en;
//Java：Remove Element
public class P27RemoveElement{
    public static void main(String[] args) {
        Solution solution = new P27RemoveElement().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

/*
    Array - Two pointers.
    思路：
    快、慢两个指针。
    快指针：遍历，负责发现新元素。
    慢指针：从头依次赋值，负责赋值（除sentinel以外的）。
    相当于快指针从头开始遍历，遇到sentinel值就跳过，其他值则赋到慢指针位置。
 */
class Solution_1 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)    return 0;
        int j = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i] != val){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}

/*
    思路：
    更高效的一种做法。上面那种做法，可以发现，每个循环，除非看到sentinel，否则都会swap。
    在sentinel较少的情况下，这种swapping不够efficient，是无用功。
    因此做以下这种情况。只在遇到sentinel的时候操作，把其放到末尾并砍掉，较为efficient。
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)    return 0;
        int n = nums.length, temp = Integer.MIN_VALUE;
        for (int i=0; i<n;){
            if (nums[i] == val){
                nums[i] = temp;
                nums[i] = nums[n-1];
                nums[n-1] = temp;
                n--;
            }
            else {
                i++;
            }
        }
        return n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}