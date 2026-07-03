class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low)/2;

            if(nums[mid] == target) return mid;
            // then we'll check in which half the target lies whether in low .. mid half or mid+1 .. high half accordingly we'll move the low and high pointers
            
            // searching in part-1
            else if(nums[low] <= nums[mid]) {
                // move the low and high if target lies in the left half
                if(nums[low] <= target && target <= nums[mid]) high = mid - 1;
                else low = mid + 1;
            } 

            // searching in part-2
            else {
                // move the low and high if target lies in the right half
                if(nums[mid+1] <= target && target <= nums[high]) low = mid + 1;
                else high = mid - 1;
            }
        }

        return -1; 
    }
}