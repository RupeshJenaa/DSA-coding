class Solution {
    public String reverseParentheses(String s) {
        StringBuilder word = new StringBuilder();
        Stack <Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == ')') {
                StringBuilder reverseWord = new StringBuilder();
                while(st.peek() != '(') {
                    reverseWord.append(st.pop());
                }
                st.pop(); // to remove '('
                if(!st.isEmpty()) {
                    for(int j=0; j<reverseWord.length(); j++) {
                        st.push(reverseWord.charAt(j));
                    }
                } else {
                    for(int j=0; j<reverseWord.length(); j++) word.append(reverseWord.charAt(j));
                }
            }
            else if(ch == '(') st.push(ch);
            else st.push(ch);
        }

        if(word.length() == 0) {
            while(!st.isEmpty()) {
                word.append(st.pop());
            }
            return word.reverse().toString();
        } else if(!st.isEmpty()) {
            StringBuilder rem = new StringBuilder();
            while(!st.isEmpty()) {
                rem.append(st.pop());
            }
            return word.toString() + rem.reverse().toString();
        }
        else return word.toString();
    }
}