class Solution {
    public int totalMoney(int n) {
        
        int totalMoney = 0;
        int amountToDeposit = 1; // This is the money we put in each day.

        // We loop from the first day up to the n-th day.
        for (int day = 1; day <= n; day++) {
            
            // Add today's deposit to our total.
            totalMoney += amountToDeposit;

            // Now, we get ready for tomorrow.
            
            // Is tomorrow a new Monday? The 7th, 14th, 21st days are Sundays.
            // So if today is a Sunday, we have to use the "Monday Reset Rule".
            if (day % 7 == 0) { 
                // The amount to deposit tomorrow will be $1 more than last Monday's amount.
                // Last Monday's amount was (amountToDeposit - 6). So we add 1 to that.
                amountToDeposit = (amountToDeposit - 6) + 1;
            } else {
                // If it's not a Monday tomorrow, just use the "Daily Rule".
                amountToDeposit++;
            }
        }
        
        return totalMoney;
    }
}