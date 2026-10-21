class Solution {
    public int minOperations(String s) {
        int ans = 0;
        if(checkSorted(s)) return 0; // check for sorted string

        // check for impossible sorting
        if(s.length() == 2) return -1;

        // find min_char and max_char
        char min_char = s.charAt(0);
        char max_char = s.charAt(s.length() - 1);

        for(int i=0; i<s.length(); i++) {
            if(min_char - 'a' > s.charAt(i) - 'a') min_char = s.charAt(i);
            if(max_char - 'a' < s.charAt(i) - 'a') max_char = s.charAt(i);
        }

        // if either min and max char is present at their respective extremes. satisfies the condition of both the characters are at their extreme pos.
        // if(min_char == s.charAt(0) || max_char == s.charAt(s.length() - 1)) return 1;

        // if both the min and max are not at their extremes
        if(min_char != s.charAt(0) && max_char != s.charAt(s.length() - 1)) {
            // check the middle characters
            for(int i=1; i<s.length()-1; i++) {
                // if either min or max is present in the middle then return 2.
                if(s.charAt(i) == min_char || s.charAt(i) == max_char) return 2;
            }

            return 3;
        }
        
        return 1;
    }

    public boolean checkSorted(String s) {
        boolean sorted = true;

        for(int i=0; i<s.length()-1; i++) {
            if(s.charAt(i) > s.charAt(i+1)){
                sorted = false;
                break;
            }
        }
        if(sorted) return true;
        else return false;
    }
}