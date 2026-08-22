class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int pro = 1;
        int org = n;

        while(n != 0) {
            int rem = n % 10;
            sum += rem;
            pro *= rem;
            n /= 10;
        }
        int total = sum + pro;
        return org % total == 0;
    }
}