class Solution {
    public String removeDuplicates(String s) {
        StringBuilder result = new StringBuilder();

        char ch[] = s.toCharArray();

        for(char c : ch) {
            if(result.length() > 0 && result.charAt(result.length() - 1) == c) 
                result.deleteCharAt(result.length() - 1);
            else result.append(c);
        }

        return result.toString();
    }
}