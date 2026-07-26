class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        max1 = nums[n-1];
        max2 = nums[n-2];
        max3 = nums[n-3];

        min1 = nums[0];
        min2 = nums[1];

        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }
}