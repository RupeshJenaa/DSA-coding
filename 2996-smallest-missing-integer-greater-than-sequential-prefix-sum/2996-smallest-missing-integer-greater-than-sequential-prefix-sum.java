class Solution {
    public int missingInteger(int[] nums) {
        if(nums.length == 1) return nums[0]+1;
        HashSet<Integer> set = new HashSet<>();
        int prefixSum = nums[0];
        int total = 0;

        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
            total += nums[i];
        }

        for(int i=1; i<nums.length; i++) {
            //freq[nums[i]--]++;
            if(nums[i-1] + 1 == nums[i]) prefixSum += nums[i];
            else break;
        }

        if(!set.contains(prefixSum)) return prefixSum;

        int ans = -1;
        for(int i=prefixSum; i <= total; i++) {
            if(!set.contains(i) && i >= prefixSum) {
                ans = i;
                break;
            }
        }

        return ans;
    }
}