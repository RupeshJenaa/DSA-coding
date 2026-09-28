class Solution {
    public int maxDepth(String s) {
        Stack<Character> st = new Stack<>();
        int maxDepth = Integer.MIN_VALUE;
        int currDepth = 0;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') st.push(ch);
            else if(ch == ')') {
                currDepth = st.size();
                st.pop();
                maxDepth = Math.max(maxDepth, currDepth);
            }
            else continue;
        }

        return (maxDepth > 0) ? maxDepth : 0;
    }
}