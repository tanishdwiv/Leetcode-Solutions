class Solution {
    public int minimumDeviation(int[] nums) {
        int min=Integer.MAX_VALUE;
        
        PriorityQueue<Integer> maxheap=new PriorityQueue<>((a,b)->b-a);
        for(int num:nums){
            if(num%2==0){
                maxheap.offer(num);
                min=Math.min(min,num);
                 }
                 else{
                    maxheap.offer(num*2);
                    min=Math.min(min,num*2);
                 }
        }

                 int minimumdeviation=Integer.MAX_VALUE;
                 while(!maxheap.isEmpty()){
                    int n=maxheap.poll();
                    minimumdeviation=Math.min(minimumdeviation,n-min);
                    if(n%2==0){
                        maxheap.offer(n/2);
                        min=Math.min(min,n/2);
                    }
                    else{
                        break;
                    }
                 }
        
        return minimumdeviation;
    }
}