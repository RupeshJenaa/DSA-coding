class Solution {
    public int minimumPushes(String word) {
        // int count = 0;
        // HashMap<Character,Integer> map = new HashMap<>();
        // for(int i=0; i<word.length(); i++) {
        //     char ch = word.charAt(i);
        //     map.put(ch, map.getOrDefault(ch, 0) + 1);
        // }
        // List<Integer> freqs = new ArrayList<>(map.values());
        // freqs.sort(Collections.reverseOrder());
        // int len = freqs.size();

        // // 1st condition - len is between 1-8 (cost_push = 1)
        // if(len <= 8) {
        //     for(int ele: freqs) {
        //         count += ele;
        //     }
        // }

        // // 2nd condition - len is between 9-16 (cost_push = 2)
        // // so here - count += (sum of first 8) + (sum of rem)*2
        // else if(len > 8 && len <= 16) {
        //     for(int i = 0; i < len; i++) {
        //         if(i <= 7) count += freqs.get(i);
        //         else count += freqs.get(i) * 2;
        //     }
        // }

        // // 3rd condition - len is between 17-24
        // else if(len > 16 && len <= 24) {
        //     for(int i = 0; i < len; i++) {
        //         if(i <= 7) count += freqs.get(i);
        //         else if(i <= 15) count += freqs.get(i) * 2;
        //         else count += freqs.get(i) * 3;
        //     }
        // }

        // //4th condition - len is 25-26
        // else {
        //     for(int i = 0; i < len; i++) {
        //         if(i <= 7) count += freqs.get(i);
        //         else if(i <= 15) count += freqs.get(i) * 2;
        //         else if(i <= 23) count += freqs.get(i) * 3;
        //         else count += freqs.get(i) * 4;
        //     }
        // }

        // return count;

        int count = 0;
        int[] freq = new int[26];
        Arrays.fill(freq, 0);
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            freq[ch - 'a']++;
        }
        Arrays.sort(freq); // ascending order
        int assigned_keypad_pos = 0; // for every 8 characters same push cost

        for(int i = 25; i >= 0; i--) {
            if(freq[i] == 0) break; // if once 0 is encountered then further elements have also 0 because sorted na 

            count += freq[i] * ((assigned_keypad_pos / 8) + 1);
            // / 8 -> gives keypad_pos and + 1 is to give push_cost of that respective keypad_pos
            assigned_keypad_pos++; // inc. the keypad_pos everytime
        }

        return count;
    }
}