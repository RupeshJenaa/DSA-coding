class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 1;
        int high = position[position.length - 1] - position[0];

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(ballsPlaced(position, mid, m)) low = mid + 1;
            else high = mid - 1;
        }

        return high;
    }

    public boolean ballsPlaced(int[] arr, int force, int m) {
        int totalBalls = 1;
        int ball = arr[0];
        for(int i=1; i<arr.length; i++) {
            if(Math.abs(ball - arr[i]) >= force) {
                // place the ball2
                totalBalls++;
                ball = arr[i];
            }

            if(totalBalls >= m) return true;
        }
        return false;
    }
}