class Solution {
    public long sumAndMultiply(int n) {
        String num = Integer.toString(n);
        String nonNum = "";
        for(int i=0; i<num.length(); i++) {
            char ch = num.charAt(i);
            if(ch == '0') continue;
            else nonNum += ch;
        }

        int x;
        if(nonNum == "") x = 0;
        else x = Integer.parseInt(nonNum);

        long sum = 0;
        int org = x;
        while(org != 0) {
            int rem = org % 10;
            sum += rem;
            org /= 10;
        }

        return (long)sum * (long)x;
    }
}