class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m * k > bloomDay.length) return -1;
        int min = bloomDay[0];
        int max = bloomDay[0];
        //int ans = -1;

        for(int bloom : bloomDay) {
            min = Math.min(min, bloom);
            max = Math.max(max, bloom);
        }
        int low = min;
        int high = max;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            int bouquets_made = noOfBouquets(bloomDay, mid, k);
            if(bouquets_made < m) low = mid + 1;
            //else if(bouquets_made > m) high = mid - 1;
            else {
                //ans = Math.min(ans, bouquets_made);
                high = mid - 1;
            }
        }

        //return ans;
        return low;
    }  

    public int noOfBouquets(int[] arr, int daysToWait, int adj) {
        int flowers = adj;
        int bouquets = 0;
        for(int i=0; i<arr.length; i++) {
            if(daysToWait >= arr[i]) {
                flowers--;
                if(flowers == 0) {
                    bouquets++;
                    flowers = adj;
                } else continue;
            } else flowers = adj;
        }

        return bouquets;
    }
}