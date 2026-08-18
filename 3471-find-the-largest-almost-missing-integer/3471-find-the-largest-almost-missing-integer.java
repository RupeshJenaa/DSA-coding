class Solution {
    public int largestInteger(int[] nums, int k) {
        int maxElementOnce = -1;
        int maxElement = -1;
        int n = nums.length;
        int first = nums[0];
        int last = nums[n-1];
        int[] freq = new int[51];
        for(int num: nums) {
            maxElement = Math.max(maxElement, num);
            freq[num]++;
        }

        for(int i=50; i>=1; i--) {
            if(freq[i] == 1) {
                maxElementOnce = i;
                break;
            }
        }

        if(k == 1) return maxElementOnce;
        else if(k == n) return maxElement;
        else if(k > 1 && k < n) {
            if(freq[first] == 1 && freq[last] == 1) return Math.max(first, last);
            else if(freq[first] == 1 && freq[last] > 1) return first;
            else if(freq[first] > 1 && freq[last] == 1) return last;
        }

        return -1;
    }
}