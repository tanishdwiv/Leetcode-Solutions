class Solution {
    public int maxProfit(int[] prices) {
    
    //     if (prices.length == 0) return 0;

    //     // Initialize arrays for memoization
    //     int[] minPrice = new int[prices.length];
    //     int[] maxProfit = new int[prices.length];

    //     // Base case
    //     minPrice[0] = prices[0];
    //     maxProfit[0] = 0;

    //     // Fill the dp arrays
    //     for (int i = 1; i < prices.length; i++) {
    //         // Update the minimum price up to the current day
    //         minPrice[i] = Math.min(minPrice[i - 1], prices[i]);
    //         // Calculate the maximum profit up to the current day
    //         maxProfit[i] = Math.max(maxProfit[i - 1], prices[i] - minPrice[i]);
    //     }

    //     // The last element in maxProfit array will have the maximum profit
    //     return maxProfit[prices.length - 1];
    // }
// int[] memo=new int[prices.length];
// Arrays.fill(memo,-1);
// return solve(prices,0,memo);
//     }
//     int solve(int[] price,int index,int[] memo){
//         if(index>=price.length-1){
//             return 0;
//         }

//         if(memo[index]!=-1){
//             return memo[index];
//         }
        //we have two choices
        //buy 1 stock if i buy 
        // int profitifbuynow;
        // int maxpricefuture=0;
        // for(int i=index+1;i<price.length;i++){
        //     if(price[i]>maxpricefuture){
        //         maxpricefuture=price[i];
        //     }
        // }
        
        //      profitifbuynow=Math.max(0,maxpricefuture-price[index]);
        
        
        // int skipcurrentday=solve(price,index+1,memo);
        // return memo[index]= Math.max(profitifbuynow,skipcurrentday);

          
            int maxprofit=0;
            int minprice=Integer.MAX_VALUE;
            for(int currentprice:prices){
                minprice=Math.min(minprice,currentprice);
                maxprofit=Math.max(maxprofit,currentprice-minprice);

            }
            return maxprofit;
            
    }
}