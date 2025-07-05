// class Solution {
//     public int[] finalPrices(int[] prices) {
//         int[] arr=new int[prices.length];
//         arr[prices.length-1]=prices[prices.length-1];
//         for(int i=0;i<prices.length-1;i++){
//             for(int j=i+1;j<prices.length;j++){
//                 if(prices[j]<=prices[i]){
//                     arr[i]=prices[i]-prices[j];
//                     break;
//                 }
//                 else{
//                     arr[i]=prices[i];
//                 }
//             }
//         }
//         return arr;
//     }
// }
class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
  
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int idx = stack.pop(); // Found the discount
                prices[idx] = prices[idx] - prices[i]; 
            }
        
            stack.push(i);
        }

        return prices;
    }
}
