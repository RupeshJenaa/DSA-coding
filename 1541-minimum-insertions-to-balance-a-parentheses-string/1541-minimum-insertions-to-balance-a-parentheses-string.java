class Solution {
    public int minInsertions(String s) {
        int need = 0; // keeps track of no. of closing prantheses required
        int ans = 0; // keeps track of balanced parantheses
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            // if before processing new "(" character , if need is odd which means the preious opening '(' didn't got two closing ')'.. so add 1 to ans and dec. the need by 1 because we imaginarily add one closing ) to ans, so we have to dec the need by 1 too.

            if(ch == '(') {
                if(need % 2 != 0) {
                    ans++;
                    need--;
                }   
                need += 2;
            }
            else {
                need--;
                if(need < 0) {
                    ans += 1;
                    need = 1;
                }
            }
        }

        return (ans + need);
    }
}