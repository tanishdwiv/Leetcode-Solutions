class Solution {
    public int lengthOfLongestSubstring(String s) {
        //using sliding window
        // int n=s.length();
        // HashSet<Character> set=new HashSet<>();
        // int left=0;
        // int right=0;
        // int max=0;
        // while(right<n){
        //     //iam checking if it does not contains in the set ,if it doesnt than i will add that character and increase right pointer
        //     if(!set.contains(s.charAt(right))){
        //         set.add(s.charAt(right));
        //         right++; 
        //     max=Math.max(max,right-left);
        //     }
        //     else{
        //         //if it contains in the set....remove the left chararcter and decrese the window
        //         set.remove(s.charAt(left));
        //         left++;
        //  }
        // }
        // return max;



int left=0;
int right=0;
int n=s.length();
int max=0;
HashSet<Character> set=new HashSet<>();
while(right<n){
    if(!set.contains(s.charAt(right))){
        set.add(s.charAt(right));
        right++;
         max=Math.max(max,right-left);
    }
    else{
        set.remove(s.charAt(left));
        left++;
    }
}
return max;    
    }
}