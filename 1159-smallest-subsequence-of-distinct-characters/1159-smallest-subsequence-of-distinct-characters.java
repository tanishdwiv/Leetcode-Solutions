class Solution {
     public String smallestSubsequence(String s) {
        int[] freq = new int[26];       
        boolean[] seen = new boolean[26]; 

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            freq[c - 'a']--; 

            if (seen[c - 'a']) continue; 

          
            while (!stack.isEmpty() &&
                   c < stack.peek() &&              
                   freq[stack.peek() - 'a'] > 0) {  

                seen[stack.pop() - 'a'] = false; 
            }

          
            stack.push(c);
            seen[c - 'a'] = true;
        }

     
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }

}