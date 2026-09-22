class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // MAIN idea is to insert first by maintaining sorted order & then merge
        List<int[]> newIntervals = new ArrayList<>();
        List<int[]> ans = new ArrayList<>();
        boolean inserted = false;
        int n = intervals.length;
        for(int i=0; i<n; i++) {
            if(inserted == false && intervals[i][0] >= newInterval[0]) {
                newIntervals.add(newInterval);
                inserted = true;
            }
            newIntervals.add(intervals[i]);
        }
        if(inserted == false) newIntervals.add(newInterval); // edge case

        int len = newIntervals.size();
        int start1 = newIntervals.get(0)[0];
        int end1 = newIntervals.get(0)[1];

        for(int i=1; i<len; i++) {
            int start2 = newIntervals.get(i)[0];
            int end2 = newIntervals.get(i)[1];

            // if they overlap
            if(end1 >= start2) {
                start1 = start1;
                end1 = Math.max(end1, end2);
            } else {
                // they don't overlap
                ans.add(new int[]{start1, end1});
                start1 = start2;
                end1 = end2;
            }
        }
        // add the last interval into ans
        ans.add(new int[]{start1, end1});

        return ans.toArray(new int[ans.size()][]);
    }
}