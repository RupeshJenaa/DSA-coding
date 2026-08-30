class Solution {
    public int minimumDeletions(int[] nums) {
        // three ways - remove both from the front, remove both from the back & remove one from front and another from back.

        int len = nums.length;
        int minIdx = 0;
        int min = nums[0];
        int maxIdx = 0;
        int max = nums[0];

        if(len == 1) return len;

        for(int i=0; i<len; i++) {
            if(nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            } else if(min > nums[i]) {
                min = nums[i];
                minIdx = i;
            }
        }
        System.out.print(minIdx + " " + maxIdx);

        int frontOnlyMoves = Math.max(minIdx, maxIdx) + 1;
        int backOnlyMoves = len - Math.min(minIdx, maxIdx);
        int fromFront = Math.min(minIdx, maxIdx) + 1;
        int fromBack = len - Math.max(minIdx, maxIdx);
        int totalMoves = fromFront + fromBack;

        int minMoves = Math.min(totalMoves, Math.min(frontOnlyMoves, backOnlyMoves));

        return minMoves;
    }
}