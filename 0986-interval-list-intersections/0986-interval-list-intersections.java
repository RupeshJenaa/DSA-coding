class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        // two pointers approach

        List<int[]> ans = new ArrayList<>();
        int m = firstList.length;
        int n = secondList.length;
        if(m == 0) return firstList;
        if(n == 0) return secondList;
        int i = 0; int j = 0;

        while(i < m && j < n) {
            int start1 = firstList[i][0];
            int end1 = firstList[i][1];
            int start2 = secondList[j][0];
            int end2 = secondList[j][1];
            // 1st step - check which interval of both lists occurs first
            if(start1 <= start2) {
                // 2nd step - check whether they overlap 
                if(end1 >= start2) {
                    // overlap then intersection is there
                    int s = Math.max(start1, start2);
                    int e = Math.min(end1, end2);
                    ans.add(new int[]{s, e});
                }
            } else {
                // the 2nd list's interval is smaller. so the overlap formula changes
                if(end2 >= start1) {
                    // overlap then intersection is there
                    int s = Math.max(start1, start2);
                    int e = Math.min(end1, end2);
                    ans.add(new int[]{s, e});
                }
            }

            // 3rd step (MOST IMP STEP) - which ptr moves forward
            // whichever interval finishes first
            if(end1 >= end2) j++;
            else i++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
}