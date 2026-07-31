class Solution {
    public int minimumPushes(String word) {
        int count = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        List<Integer> freqs = new ArrayList<>(map.values());
        freqs.sort(Collections.reverseOrder());
        int len = freqs.size();

        // 1st condition - len is between 1-8 (cost_push = 1)
        if(len <= 8) {
            for(int ele: freqs) {
                count += ele;
            }
        }

        // 2nd condition - len is between 9-16 (cost_push = 2)
        // so here - count += (sum of first 8) + (sum of rem)*2
        else if(len > 8 && len <= 16) {
            for(int i = 0; i < len; i++) {
                if(i <= 7) count += freqs.get(i);
                else count += freqs.get(i) * 2;
            }
        }

        // 3rd condition - len is between 17-24
        else if(len > 16 && len <= 24) {
            for(int i = 0; i < len; i++) {
                if(i <= 7) count += freqs.get(i);
                else if(i <= 15) count += freqs.get(i) * 2;
                else count += freqs.get(i) * 3;
            }
        }

        //4th condition - len is 25-26
        else {
            for(int i = 0; i < len; i++) {
                if(i <= 7) count += freqs.get(i);
                else if(i <= 15) count += freqs.get(i) * 2;
                else if(i <= 23) count += freqs.get(i) * 3;
                else count += freqs.get(i) * 4;
            }
        }

        return count;
    }
}