class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            else return a[0] - b[0];
        });
        int ans = 1;
        int[] prev = intervals[0];
        for(int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];

            // check overlapping or not and we have to check both wise
            // check if prev overlaps with curr else if curr overlaps with prev else no overlap

            // if curr gets overlapped by prev
            if((curr[0] >= prev[0]) && (prev[1] >= curr[1])){
                continue;
            } else if((prev[0] >= curr[0]) && (curr[1] >= prev[1])) // if prev gets overlapped by curr 
            {
                prev = curr;
                continue;
            } else {
                ans++;
                prev = curr;
            }
        }

        return ans;
    }
}