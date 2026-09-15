class Solution {
    public String removeKdigits(String num, int k) {
        // PSE concept with twist
        StringBuilder ans = new StringBuilder();
        Stack<Character> st = new Stack<>();
        int len = num.length();

        if(len == k) return "0";
        st.push(num.charAt(0));
        for(int i=1; i<len; i++) {
            char ch = num.charAt(i);
            int numm = ch - '0';
            // just add the smaller elements in stack
            while(!st.isEmpty() && k > 0 && numm < st.peek() - '0') {
                st.pop();
                k--;
            }
            st.push(ch);
        }

        // if k is still positive then remove from top
        while(k > 0) {
            st.pop();
            k--;
        }

        while(!st.isEmpty()) { 
            ans.append(st.pop());
        }
        ans.reverse();

        // removal of leading zeroes
        for(int i=0; i<ans.length(); i++) {
            while(ans.length() > 0 && ans.charAt(0) == '0') ans.deleteCharAt(0);
        }

        if (ans.length() == 0) return "0";
        
        return ans.toString();
    }
}