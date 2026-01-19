public class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is the target
            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;  // Target in left half
                } else {
                    low = mid + 1;   // Target in right half
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;   // Target in right half
                } else {
                    high = mid - 1;  // Target in left half
                }
            }
        }

        // Target not found
        return -1;
    }

    // Example usage
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int index = sol.search(nums, target);
        System.out.println("Index of target: " + index);  // Output: 4
    }
}
