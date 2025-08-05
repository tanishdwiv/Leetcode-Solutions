class Solution {
    public boolean isPowerOfTwo(int n) {
        double res = Math.log10(n) / Math.log10(2);
        if (res == (int) res) {
            return true;
        }
        return false;
    }
}