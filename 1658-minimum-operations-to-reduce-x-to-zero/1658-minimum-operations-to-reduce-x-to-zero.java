class Solution {
    public int minOperations(int[] nums, int x) {
        // so the best approach is to use reverse method - to find total sum & to keep the sum of (x - total) by finding longest subarray length of sum (x - total). Longest because we have to remove minimum no. of elements

        // step 1 - total sum
        int total = totalSum(nums);

        // step 2 - find the elements to keep
        int toKeep = total - x;
        if(toKeep < 0) return -1;
        else if(toKeep == 0) return nums.length;

        // step 3 - find the longest subarray of length toKeep
        int maxLen = longestSubarray(nums, toKeep);

        // step 4 - min operations is nums.length - maxLen
        if(maxLen == Integer.MIN_VALUE) return -1;
        else return (nums.length - maxLen);
    }
    public int totalSum(int[] nums) {
        int sum = 0;

        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
        }

        return sum;
    }

    public int longestSubarray(int[] nums, int target) {
        int maxLen = Integer.MIN_VALUE;
        int l = 0;
        int r = 0;
        int sum = 0;

        while(r < nums.length) {
            sum += nums[r];

            while(sum > target) {
                sum -= nums[l];
                l++;
            }
            if(sum == target) maxLen = Math.max(maxLen, (r - l + 1));
            r++;
        }

        return maxLen;
    }
}