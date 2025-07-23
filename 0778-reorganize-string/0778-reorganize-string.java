class Solution {
    public String reorganizeString(String s) {
        
         int[] frequencies=new int[26];
         
        for (char ch : s.toCharArray()) {
          ++frequencies[ch-'a'];
}

PriorityQueue<Character> maxheap=new PriorityQueue<>((a,b)->frequencies[b-'a']-frequencies[a-'a']);
for(char ch='a';ch<='z';ch++){
    if(frequencies[ch-'a']>0){
        maxheap.offer(ch);
    }
}
 char[] result = new char[s.length()];
int index=0;
while (!maxheap.isEmpty()) {
    char current = maxheap.poll();
    int freq = frequencies[current-'a'];

    while (freq-- != 0) {
       result[index] = current;
        index += 2;

        if (index >= s.length()) {
            index = 1; 
        }
    }
    
}
for (int i = 1; i < result.length; i++) {
            if (result[i] == result[i - 1]) {
                return ""; // we cant reorganize
            }
        }
return new String(result);
    }
}