class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int totalTime = 0;
for (int i = 0; i < tickets.length; i++) {
    if (i <= k) {
        totalTime += Math.min(tickets[k], tickets[i]);
    } else {
        totalTime += Math.min(tickets[k] - 1, tickets[i]);
    }
}
return totalTime;
        
    }
}