class Solution {
    public long repairCars(int[] ranks, int cars) {
        int min = ranks[0];
        for(int rank : ranks) {
            min = Math.min(min, rank);
        }
        long total_time = (long)min * cars * cars;
        long low = 1;
        long high = total_time;

        while(low <= high) {
            long mid = low + (high - low)/2; // time
            if(noOfCarsRepaired(mid, ranks, cars)) {
                high = mid - 1;
            } else low = mid + 1;
        }

        return low;
    }

    public boolean noOfCarsRepaired(long guessTime, int[] ranks, int cars) {
        long carsRepaired = 0;
        for(int rank : ranks) {
            carsRepaired += (long)Math.sqrt(guessTime / rank);

            if(carsRepaired >= cars) return true;
        }
        
        return false;
    }
}