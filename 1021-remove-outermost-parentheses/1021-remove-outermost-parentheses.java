class Solution {
    public String removeOuterParentheses(String s) {
        // so this problem depends on to keep track of the nesting depth. the depth increases whenever '(' appears. so the outermost paranthesis means the paranthesis that are present in the root level (which means at depth = 0).

        StringBuilder ans = new StringBuilder();

        int depth = 0;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            // so if the ch is '(' , then if the depth is > 0 then add the ch into ans and increase the depth , i.e. we're moving to the next level.
            
            // else if the ch is ')', then dec. the depth because we're backtracking to previous depth level, and if the depth is still > 0 that means we have not reached to the root level.
            if(ch == '(') {
                if(depth > 0) ans.append(ch);
                depth++;
            } else {
                depth--;
                if(depth > 0) ans.append(ch);
            }
        }

        return ans.toString();
    }
}