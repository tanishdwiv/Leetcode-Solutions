class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0)
        return 1;
        int start=9;
        int current=9;
        int ans=10;
        while(n>1 && start>0){
            current=current*start;
            ans=ans+current;
            n--;
            start--;
        }
        return ans;
        
    }
}