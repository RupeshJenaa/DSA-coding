class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int n = nums.length;
        int[] result = new int[n];

        list1.add(nums[0]);
        list2.add(nums[1]);

        for(int i=2; i<n; i++) {
            if(list1.get(list1.size() - 1) > list2.get(list2.size() - 1)) list1.add(nums[i]);
            else list2.add(nums[i]);
        }

        int idx = 0;
        for(int i=0; i<list1.size(); i++) {
            result[idx++] = list1.get(i);
        }

        for(int i=0; i<list2.size(); i++) {
            result[idx++] = list2.get(i);
        }

        return result;
    }
}