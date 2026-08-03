class Solution {
    public int splitArray(int[] nums, int k) {
        int max = nums[0];
        int sum = 0;
        for(int num: nums) {
            max = Math.max(max, num);
            sum += num;
        }
        
        int low = max;
        int high = sum;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(totalSubbarrays(nums, mid, k)) {
                // move left side for minimum answer
                high = mid - 1;
            } else low = mid + 1;
        }

        return low;
    }

    public boolean totalSubbarrays(int[] arr, int max_sum, int k) {
        int subarrays = 1;
        int curr_sum = 0;

        for(int i=0; i<arr.length; i++) {
            curr_sum += arr[i];
            if(curr_sum > max_sum) {
                // when curr_sum exceeds then create a new subarray
                subarrays++;
                curr_sum = arr[i];
            }
        }

        if(subarrays <= k) return true;
        else return false;
    }
} 