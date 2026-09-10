class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[')
                st.push(ch);
            else {
                if(!st.empty()) {
                    if(st.peek() == '(' && ch == ')')
                        st.pop();
                    else if(st.peek() == '{' && ch == '}')
                        st.pop();
                    else if(st.peek() == '[' && ch == ']')
                        st.pop();
                    else return false;
                } else return false;
            }
        }
        if(st.empty()) return true;
        else return false;
    }
}