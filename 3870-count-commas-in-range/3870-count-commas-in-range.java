class Solution {
    public int countCommas(int n) {
        if(n < 1000) return 0;
        int required = n - 1000; // because from 1000-10⁵ only one comma is there 
        
        return required + 1;
    }
}