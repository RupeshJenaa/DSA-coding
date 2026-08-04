class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int start = nums[0];
        int end = nums[0];

        for(int ele: nums) {
            start = Math.min(start, ele);
            end = Math.max(ele, end);
            set.add(ele);
        }

        for(int i = start; i <= end; i++) {
            if(set.contains(i)) continue;
            ans.add(i);
        }

        return ans;
    }
}