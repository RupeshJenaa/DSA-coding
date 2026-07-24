class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int weight: weights) {
            sum += weight;
            max = Math.max(max, weight);
        }

        int low = max;
        int high = sum;

        while(low <= high) {
            int mid = low + (high - low)/2;
            if(checkShipWeight(weights, mid, days)) {
                high = mid - 1; // if true move left side to find smaller weights
            } else low = mid + 1;
        }

        return low;
    }

    public boolean checkShipWeight(int[] arr, int maxWeight, int daysGiven) {
        int weights = 0;
        int daysTaken = 1;
        for(int i=0; i<arr.length; i++) {
            weights += arr[i];
            if(weights > maxWeight) {
                daysTaken++;
                weights = arr[i];
            }
        }
        if(daysTaken > daysGiven) return false;
        else return true;
    }
}