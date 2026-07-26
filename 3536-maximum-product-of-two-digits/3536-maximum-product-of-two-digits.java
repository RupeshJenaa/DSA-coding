class Solution {
    public int maxProduct(int n) {
        // idea is to get two maximum digits - either by list + sorting or code of getting second larget digit

        // List<Integer> digits = new ArrayList<>();
        // while(n > 0) {
        //     digits.add(n % 10);
        //     n /= 10;
        // }
        // digits.sort(Collections.reverseOrder());
        // return digits.get(0) * digits.get(1);

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        while(n > 0) {
            int digit = n % 10;
            if(digit > max1) {
                max2 = max1;
                max1 = digit;
            } else if(digit > max2) {
                max2 = digit;
            }
            n /= 10;
        }

        return max1 * max2;
    }
}