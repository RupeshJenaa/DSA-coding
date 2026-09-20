class Solution {
    public int reverseDegree(String s) {
        // HashMap<Character, Integer> map = new HashMap<>();
        int total = 0;
        // int pos = 26;
        // for(char c = 'a'; c <= 'z'; c++) {
        //     map.put(c, pos);
        //     pos--;
        // }

        for(int i=0; i<s.length(); i++) {
            // char ch = s.charAt(i);
            int index = s.charAt(i)-'a';
            int reverse = 26 - index;
            //total += (map.get(ch) * (i+1));
            total += reverse * (i+1);
        }

        return total;
    }
}