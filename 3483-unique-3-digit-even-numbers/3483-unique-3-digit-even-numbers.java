class Solution {
    public int totalNumbers(int[] digits) {
        HashSet<Integer> set = new HashSet<>();
        //String number = "";
        //int count = 0;
        for(int i=0; i<digits.length; i++) {
            if(digits[i] == 0) continue; // not be leading zeros.
            for(int j=0; j<digits.length; j++) {
                for(int k=0; k<digits.length; k++) {
                    if(i == j || j == k || i == k) continue; // Each copy of a digit can only be used once per number.
                    // number = "" + digits[i] + digits[j] + digits[k];
                    // int digit = Integer.valueOf(number);
                    int digit = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if(digit % 2 == 0 && !set.contains(digit)) {
                        set.add(digit);
                        //count++;
                    }
                }
            }
        }
        return set.size();
    }
}