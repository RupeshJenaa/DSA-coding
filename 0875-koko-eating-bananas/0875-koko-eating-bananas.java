class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // so this is a story based BS question. 
        int low = 1; // koko can eat atleast 1 banana minimum.. if 0 then she'll never eat
        int high = piles[0]; // maximum she can eat in an hour is max(piles) because if she eats 1100 in an hour then also it doesn't matter because rest of the time is going to be waste. (so maximum possible ans rakhibara achi high re)
        for(int pile: piles) {
            high = Math.max(high, pile);
        }
        int min = Integer.MAX_VALUE;

        while(low <= high) {
            int mid = low + (high - low)/2;;
            long hoursTaken = findHours(piles, mid); // step 3 
            if(hoursTaken <= h) {
                if(min > mid) min = mid;
                high = mid - 1;
            } else low = mid + 1;
        }

        return min;
    }

    public long findHours(int[] arr, int k) {
        long hours = 0;
        for(int ele: arr) {
            if(k >= ele) hours++;
            else {
                hours += (ele / k);
                if(ele % k != 0) hours++;
            }
        }

        return hours;
    }
}