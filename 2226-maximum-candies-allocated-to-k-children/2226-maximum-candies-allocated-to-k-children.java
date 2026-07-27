class Solution {
    public int maximumCandies(int[] candies, long k) {
        int low = 1;
        int max = candies[0];
        for(int candy : candies) max = Math.max(max, candy);
        int high = max;

        while(low <= high) {
            int mid = low + (high - low)/2;
            if(allocateFixedCandies(candies, mid, k)) {
                low = mid + 1;
            } else high = mid - 1;
        }

        return high;
    }

    public boolean allocateFixedCandies(int[] arr, int fixed, long k) {
        long children = 0;
        for(int candy : arr) {
            // each child can get candies from the same pile if afforded just like koko eating bananas but here no need to be use the remaining unused candies which cannot be afforded

            children += (long)candy/fixed;
        }

        if(children >= k) return true;
        else return false;
    }
}