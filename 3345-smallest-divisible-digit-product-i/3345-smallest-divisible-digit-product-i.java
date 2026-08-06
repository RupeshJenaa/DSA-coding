class Solution {
    public int smallestNumber(int n, int t) {
        int ans = -1;
        for(int i=n; i<=100; i++) {
            if(prodDivisble(i, t)) {
                ans = i;
                break;
            }
        }

        return ans;
    }

    public boolean prodDivisble(int num, int k) {
        int pro = 1;
        while(num != 0) {
            int rem = num % 10;
            pro *= rem;
            num /= 10;
        }

        if(pro % k == 0) return true;
        else return false;
    }
}