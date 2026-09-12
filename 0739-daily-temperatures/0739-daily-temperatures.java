class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // NGE concept with a twist
        //HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        ans[n-1] = 0;
        //map.put(temperatures[n-1], n-1);
        //st.push(temperatures[n-1]);
        st.push(n-1);

        for(int i=n-2; i>=0; i--) {
            //while(!st.isEmpty() && temperatures[i] >= st.peek()) st.pop();
            while(!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]) st.pop();

            //ans[i] = st.isEmpty() ? 0 : map.get(st.peek()) - i;
            ans[i] = st.isEmpty() ? 0 : st.peek() - i;

            //st.push(temperatures[i]);
            //map.put(temperatures[i], i);
            st.push(i);
        }

        return ans;
    }
}