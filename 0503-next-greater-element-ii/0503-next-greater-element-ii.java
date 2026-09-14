class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // the main twist is that the last element gets a chance to check the NGE among the previous value. That's why we've to store the previous elements in the stack to give the last element a chance. 
        Stack <Integer> st = new Stack<>();
        int[] ans = new int[nums.length];
        int n = nums.length;

        for(int i = n-2; i >= 0; i--) {
            st.push(nums[i]);
        }

        for(int i = n-1; i >= 0; i--) {
            while(!st.isEmpty() && nums[i] >= st.peek()) st.pop();
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i]);
        }

        return ans;
    }
}