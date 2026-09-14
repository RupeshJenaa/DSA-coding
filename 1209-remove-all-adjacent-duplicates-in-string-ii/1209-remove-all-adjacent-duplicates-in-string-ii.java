class Pair {
    char ch;
    int count;

    Pair(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}
class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder res = new StringBuilder();
        Stack<Pair> st = new Stack<>();
        int len = s.length();

        for(int i=0; i<len; i++) {
            char cha = s.charAt(i);
            if(st.isEmpty() || st.peek().ch != cha) st.push(new Pair(cha, 1));
            else {
                st.peek().count++;

                if(st.peek().count == k) st.pop();
            }
        }

        // build the result
        while(!st.isEmpty()) {
            Pair p = st.peek();
            for(int i=0; i<p.count; i++) res.append(p.ch);
            st.pop();
        }

        return res.reverse().toString();
    }
}