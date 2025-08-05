class Solution {
    public boolean isPowerOfThree(int n) {
     
        double res = Math.log10(n) / Math.log10(3);
        if (res == (int) res) {
            return true;
        }
        return false;
            
    }
}