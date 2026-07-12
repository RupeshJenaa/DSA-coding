class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] have = new int[26]; // counting the frequency of only "balloon" letters in the text.
        for(int i=0; i<text.length(); i++) {
            char ch = text.charAt(i);
            if(ch == 'b' || ch == 'a' || ch == 'l' || ch == 'o' || ch == 'n') {
                have[ch - 'a']++;
            }
        }
        // we'll find bottleneck (minimum) freq ratio between the freq of word "bottle" and the freq od "balloon" letters from the text given.
        
        // like even if we have 100 letters of b and l and if we have only 2 letters of a then we can only form 2 words of "balloon".
        
        int ans = Math.min(
        have['b' - 'a'] / 1,
        Math.min(Math.min(have['a' - 'a'] / 1,
        have['l' - 'a'] / 2),
        Math.min(have['o' - 'a'] / 2,
        have['n' - 'a'] / 1)));
        
        return ans;
    }
}