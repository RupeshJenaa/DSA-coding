class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]); // sort the intervals by start (IMP STEP)

        int start1 = intervals[0][0];
        int end1 = intervals[0][1];

        for(int i=1; i<n; i++) {
            int start2 = intervals[i][0];
            int end2 = intervals[i][1];

            if(end1 >= start2) {
                // overlap -> so update the start1 & end1
                start1 = start1;
                end1 = Math.max(end1, end2);
                continue;
            } else {
                // non-overlap -> add the interval (start1, end1) into list & update the start1 & end1
                list.add(new int[]{start1, end1});
                start1 = start2;
                end1 = end2;
            }
        }
        list.add(new int[]{start1, end1}); // the last range that is to be added
        return list.toArray(new int[list.size()][]);
    }
}