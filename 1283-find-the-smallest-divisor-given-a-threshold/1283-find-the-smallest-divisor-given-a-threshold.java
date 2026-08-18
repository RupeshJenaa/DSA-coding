class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = nums[0];

        for(int num: nums) {
            max = Math.max(max, num);
        }
        int low = 1;
        int high = max;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(divided(nums, mid, threshold)) {
                high = mid - 1;
            } else low = mid + 1;
        }

        return low;
    }

    public boolean divided(int[] nums, int divisor, int threshold) {
        int sum = 0;
        for(int num: nums) {
            sum += (num + divisor - 1) / divisor;
        }
        if(sum > threshold) return false;
        else return true;
    }
}