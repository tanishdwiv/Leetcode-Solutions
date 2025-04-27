public class Solution {
    public String longestPalindrome(String s) {
//         int n = s.length(); 
//         if (n < 2) {
//             return s;
//         } 
//         String sub = s.substring(0, 1);
//         int curr = 1;
//  for (int i = 0; i < n; i++) {
//              int start = i, end = i;
//             while (start >= 0 && end < n && s.charAt(start) == s.charAt(end)) {
               
//                 if (end - start + 1 > curr) {
//                     sub = s.substring(start, end + 1);
//                     curr = end - start + 1;
//                 }
                
//                 start--;
//                 end++;
//             } 
//             start = i;
//             end = i + 1;
//             while (start >= 0 && end < n && s.charAt(start) == s.charAt(end)) {
                
//                 if (end - start + 1 > curr) {
//                     sub = s.substring(start, end + 1);
//                     curr = end - start + 1;
//                 }
              
//                 start--;
//                 end++;
//             }
//         }
//         return sub;

int len=s.length();
if(len==0)
return "";
int maxlen=1;int start=0;
for(int i=0;i<len;i++){
    for(int j=0;j<=1;j++){
     int low=i;
     int high=i+j;
     while(low>=0 && high<len && s.charAt(low)==s.charAt(high)){
        int currlen=high-low+1;
        if(currlen>maxlen){
            start=low;
            maxlen=currlen;
        }
        low--;
        high++;
     }

    }
}
return s.substring(start, Math.min(start + maxlen,len));

    }
}