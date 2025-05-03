class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n=g.length;
        int m=s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int left=0,right=0;
        while(left<m && right<n){
            if(s[left]>=g[right]){
                right++;//moving to next child
            }
            left++;//moving to next cookie  
        }
    return right;
        
    }
}
//here left is cookie and right is child
//tc-o(nlogn+mlogm+n)