class Solution {
    public int minimumPushes(String word) {
        int count = 0;
        int len = word.length();

        // 1st condition - if word has less than or equal to 8 characters i.e. 1-8 (first 8 characters)
        if(len <= 8) count += len;

        // 2nd condition - if word has 9-16 characters (next 8 characters)
        else if(len > 8 && len <= 16) {
            int rem = len - 8;
            count += 8 + rem * 2;
        }

        // 3rd condition - if word has 17-24 characters
        else if(len > 16 && len <= 24) {
            int rem = len - 16;
            count += 8 + 16 + rem * 3;
        }

        // 4th condition - last 2 characters 25 & 26
        else {
            int rem = len - 24;
            count += 8 + 16 + 24 + rem * 4; 
        }

        return count;
    }
}