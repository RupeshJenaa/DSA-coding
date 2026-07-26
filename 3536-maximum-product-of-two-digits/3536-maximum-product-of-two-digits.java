class Solution {
    public int maxProduct(int n) {
        List<Integer> digits = new ArrayList<>();
        while(n > 0) {
            digits.add(n % 10);
            n /= 10;
        }
        digits.sort(Collections.reverseOrder());
        return digits.get(0) * digits.get(1);
    }
}