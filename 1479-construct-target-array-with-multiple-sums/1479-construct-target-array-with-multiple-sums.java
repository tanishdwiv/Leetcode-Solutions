class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> maxheap=new PriorityQueue<>((a,b)->b-a);
        long sum=0;
        for(int num:target){
             sum=sum+num;
            maxheap.offer(num);
        }
        while(maxheap.peek()!=1){
            int curr=maxheap.poll();
            sum-=curr;
            
             if(sum==1)
             return true;

            else if(sum==0 || sum>=curr || curr%sum==0){
                return false;
            }
            curr%=sum;
            sum=sum+curr;
            maxheap.offer(curr);
        }
        return true;
        
    }
}