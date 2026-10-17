class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int swaps = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // (value, idx) pair
        Integer[] afterSort = new Integer[n]; // to store the sorted array as per digits sum

        for(int i=0; i<n; i++) {
            afterSort[i] = nums[i];
            map.put(nums[i], i);
        }

        Arrays.sort(afterSort, (a, b) -> {
            int digsumA = digitSum(a);
            int digsumB = digitSum(b);

            if(digsumA != digsumB) {
                return Integer.compare(digsumA , digsumB); // sorted as per digit sum
            }
            return Integer.compare(a, b); // if equal then sorted as per smaller number
        });

        for(int i=0; i<n; i++) {
            int expectedValue = afterSort[i]; // the actual value that needs to be there
            int currentValue = nums[i]; // the value that is present originally

            if(expectedValue == currentValue) continue; // if they match just continue to next step
            else {
                // else swap the current value with expected value and update their indices in map.
                int expectedIdx = map.get(expectedValue);

                int temp = nums[i];
                nums[i] = nums[expectedIdx];
                nums[expectedIdx] = temp;

                swaps++;

                map.put(expectedValue, i);
                map.put(currentValue, expectedIdx);
            }
        }

        return swaps;
    }

    public int digitSum(int num) {
        int sum = 0;

        while(num != 0) {
            sum += (num % 10);
            num /= 10;
        }

        return sum;
    }
}