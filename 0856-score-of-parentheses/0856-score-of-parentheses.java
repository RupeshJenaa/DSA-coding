class Solution {
    public int scoreOfParentheses(String s) {
        // stack will store the scores based on the opening braces
        Stack<Integer> st = new Stack<>();
        st.push(0); // which will hold the total score at last.

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '(') st.push(0);
            else {
                int top = st.pop();
                if(top == 0) {
                    int score = 1;
                    int curr_score = st.pop() + score;
                    st.push(curr_score);
                } else {
                    int score = 2 * top; // rule of (A) is applied because if top is non-zero which means there is something inside it.
                    int curr_score = st.pop() + score;
                    st.push(curr_score);
                }
            }
        }

        return st.peek();
    }
}